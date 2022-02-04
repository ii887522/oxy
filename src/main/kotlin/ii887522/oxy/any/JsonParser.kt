package ii887522.oxy.any

import ii887522.oxy.collection.ArrayList
import ii887522.oxy.collection.HashMap
import ii887522.oxy.collection.ArrayStack
import ii887522.oxy.struct.*

/**
 * It is a parser used to convert JSON tokens received from the JSON lexer into an object. Each token contains information about the type of the contained
 * value and the contained value itself if it is exists.
 */
class JsonParser {
  private enum class State {
    INITIAL, KEY, COMMA, LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET, COLON, LEFT_CURLY_BRACKET, RIGHT_CURLY_BRACKET, VALUE
  }

  private var state = State.INITIAL
  private val results = ArrayStack<Holder<Any?>>()
  private val keys = ArrayStack<String>()
  private val leftBrackets = ArrayStack<Char>()

  private fun preRun() {
    state = State.INITIAL
    results.clear()
    keys.clear()
    leftBrackets.clear()
  }

  private fun putCurrentResultIntoPrevResult() {
    val result = results.pop().value
    when (val prevResult = results.peek().value) {
      is ArrayList<*> -> (prevResult as ArrayList<Any?>).append(result)
      is HashMap<*, *> -> {
        if (keys.size == 0) throw IllegalArgumentException("JSON string or file should contains zero or one top level pair of brackets only!")
        (prevResult as HashMap<String, Any?>)[keys.pop()] = result
      }
    }
  }

  private fun runLeftSquareBracketWhenInitial() {
    state = State.LEFT_SQUARE_BRACKET
    results.push(Holder(ArrayList<Any?>()))
    leftBrackets.push('[')
  }

  private fun runLeftCurlyBracketWhenInitial() {
    state = State.LEFT_CURLY_BRACKET
    results.push(Holder(HashMap<String, Any?>()))
    leftBrackets.push('{')
  }

  private fun runValueWhenInitial(token: ValueJsonToken) {
    state = State.VALUE
    results.push(Holder(token.value))
  }

  private fun runWhenInitial(token: JsonToken) {
    when (token) {
      is KeyJsonToken -> throw IllegalArgumentException("JSON string or file should not starts with a key!")
      is CommaJsonToken -> throw IllegalArgumentException("JSON string or file should not starts with a comma!")
      is LeftSquareBracketJsonToken -> runLeftSquareBracketWhenInitial()
      is RightSquareBracketJsonToken -> throw IllegalArgumentException("JSON string or file should not starts with a right square bracket!")
      is ColonJsonToken -> throw IllegalArgumentException("JSON string or file should not starts with a colon!")
      is LeftCurlyBracketJsonToken -> runLeftCurlyBracketWhenInitial()
      is RightCurlyBracketJsonToken -> throw IllegalArgumentException("JSON string or file should not starts with a right curly bracket!")
      is ValueJsonToken -> runValueWhenInitial(token)
      else -> throw IllegalArgumentException("The type of the token received is unsupported!")
    }
  }

  private fun runWhenKey(token: JsonToken) {
    when (token) {
      is KeyJsonToken -> throw IllegalArgumentException("Key should not be immediately followed by another key!")
      is CommaJsonToken -> throw IllegalArgumentException("Key should not be immediately followed by a comma!")
      is LeftSquareBracketJsonToken -> throw IllegalArgumentException("Key should not be immediately followed by a left square bracket!")
      is RightSquareBracketJsonToken -> throw IllegalArgumentException("Key should not be immediately followed by a right square bracket!")
      is ColonJsonToken -> state = State.COLON
      is LeftCurlyBracketJsonToken -> throw IllegalArgumentException("Key should not be immediately followed by a left curly bracket!")
      is RightCurlyBracketJsonToken -> throw IllegalArgumentException("Key should not be immediately followed by a right curly bracket!")
      is ValueJsonToken -> throw IllegalArgumentException("Key should not be immediately followed by a value!")
      else -> throw IllegalArgumentException("The type of the token received is unsupported!")
    }
  }

  private fun runKeyWhenComma(token: KeyJsonToken) {
    state = State.KEY
    keys.push(token.value)
  }

  private fun runLeftSquareBracketWhenComma() {
    state = State.LEFT_SQUARE_BRACKET
    results.push(Holder(ArrayList<Any?>()))
    leftBrackets.push('[')
  }

  private fun runRightSquareBracketWhenComma() {
    state = State.RIGHT_SQUARE_BRACKET
    if (results.size > 1) putCurrentResultIntoPrevResult()
    if (leftBrackets.pop() != '[') throw IllegalArgumentException("Left bracket and right bracket do not match with each other!")
  }

  private fun runLeftCurlyBracketWhenComma() {
    state = State.LEFT_CURLY_BRACKET
    results.push(Holder(HashMap<String, Any?>()))
    leftBrackets.push('{')
  }

  private fun runRightCurlyBracketWhenComma() {
    state = State.RIGHT_CURLY_BRACKET
    if (results.size > 1) putCurrentResultIntoPrevResult()
    if (leftBrackets.pop() != '{') throw IllegalArgumentException("Left bracket and right bracket do not match with each other!")
  }

  private fun runValueWhenComma(token: ValueJsonToken) {
    state = State.VALUE
    val result = results.peek().value
    if (result !is ArrayList<*>) throw IllegalArgumentException("Comma should not be immediately followed by a value in this context!")
    (result as ArrayList<Any?>).append(token.value)
  }

  private fun runWhenComma(token: JsonToken) {
    when (token) {
      is KeyJsonToken -> runKeyWhenComma(token)
      is CommaJsonToken -> throw IllegalArgumentException("Comma should not be immediately followed by another comma!")
      is LeftSquareBracketJsonToken -> runLeftSquareBracketWhenComma()
      is RightSquareBracketJsonToken -> runRightSquareBracketWhenComma()
      is ColonJsonToken -> throw IllegalArgumentException("Comma should not be immediately followed by a colon!")
      is LeftCurlyBracketJsonToken -> runLeftCurlyBracketWhenComma()
      is RightCurlyBracketJsonToken -> runRightCurlyBracketWhenComma()
      is ValueJsonToken -> runValueWhenComma(token)
      else -> throw IllegalArgumentException("The type of the token received is unsupported!")
    }
  }

  private fun runLeftSquareBracketWhenLeftSquareBracket() {
    state = State.LEFT_SQUARE_BRACKET
    results.push(Holder(ArrayList<Any?>()))
    leftBrackets.push('[')
  }

  private fun runRightSquareBracketWhenLeftSquareBracket() {
    state = State.RIGHT_SQUARE_BRACKET
    if (results.size > 1) putCurrentResultIntoPrevResult()
    leftBrackets.pop()
  }

  private fun runLeftCurlyBracketWhenLeftSquareBracket() {
    state = State.LEFT_CURLY_BRACKET
    results.push(Holder(HashMap<String, Any?>()))
    leftBrackets.push('{')
  }

  private fun runValueWhenLeftSquareBracket(token: ValueJsonToken) {
    state = State.VALUE
    (results.peek().value as ArrayList<Any?>).append(token.value)
  }

  private fun runWhenLeftSquareBracket(token: JsonToken) {
    when (token) {
      is KeyJsonToken -> throw IllegalArgumentException("Left square bracket should not be immediately followed by a key!")
      is CommaJsonToken -> throw IllegalArgumentException("Left square bracket should not be immediately followed by a comma!")
      is LeftSquareBracketJsonToken -> runLeftSquareBracketWhenLeftSquareBracket()
      is RightSquareBracketJsonToken -> runRightSquareBracketWhenLeftSquareBracket()
      is ColonJsonToken -> throw IllegalArgumentException("Left square bracket should not be immediately followed by a colon!")
      is LeftCurlyBracketJsonToken -> runLeftCurlyBracketWhenLeftSquareBracket()
      is RightCurlyBracketJsonToken -> throw IllegalArgumentException("Left square bracket should not be immediately followed by a right curly bracket!")
      is ValueJsonToken -> runValueWhenLeftSquareBracket(token)
      else -> throw IllegalArgumentException("The type of the token received is unsupported!")
    }
  }

  private fun runCommaWhenRightSquareBracket() {
    state = State.COMMA
    if (leftBrackets.size == 0) throw IllegalArgumentException("An attempt to make multiple top level objects in JSON string or file is prohibited!")
  }

  private fun runRightSquareBracketWhenRightSquareBracket() {
    state = State.RIGHT_SQUARE_BRACKET
    if (results.size > 1) putCurrentResultIntoPrevResult()
    if (leftBrackets.size == 0) throw IllegalArgumentException("Left and right brackets in the JSON string or file are not balanced!")
    if (leftBrackets.pop() != '[') throw IllegalArgumentException("Left bracket and right bracket do not match with each other!")
  }

  private fun runRightCurlyBracketWhenRightSquareBracket() {
    state = State.RIGHT_CURLY_BRACKET
    if (results.size > 1) putCurrentResultIntoPrevResult()
    if (leftBrackets.size == 0) throw IllegalArgumentException("Left and right brackets in the JSON string or file are not balanced!")
    if (leftBrackets.pop() != '{') throw IllegalArgumentException("Left bracket and right bracket do not match with each other!")
  }

  private fun runWhenRightSquareBracket(token: JsonToken) {
    when (token) {
      is KeyJsonToken -> throw IllegalArgumentException("Right square bracket should not be immediately followed by a key!")
      is CommaJsonToken -> runCommaWhenRightSquareBracket()
      is LeftSquareBracketJsonToken -> throw IllegalArgumentException("Right square bracket should not be immediately followed by a left square bracket!")
      is RightSquareBracketJsonToken -> runRightSquareBracketWhenRightSquareBracket()
      is ColonJsonToken -> throw IllegalArgumentException("Right square bracket should not be immediately followed by a colon!")
      is LeftCurlyBracketJsonToken -> throw IllegalArgumentException("Right square bracket should not be immediately followed by a left curly bracket!")
      is RightCurlyBracketJsonToken -> runRightCurlyBracketWhenRightSquareBracket()
      is ValueJsonToken -> throw IllegalArgumentException("Right square bracket should not be immediately followed by a value!")
      else -> throw IllegalArgumentException("The type of the token received is unsupported!")
    }
  }

  private fun runLeftSquareBracketWhenColon() {
    state = State.LEFT_SQUARE_BRACKET
    results.push(Holder(ArrayList<Any?>()))
    leftBrackets.push('[')
  }

  private fun runLeftCurlyBracketWhenColon() {
    state = State.LEFT_CURLY_BRACKET
    results.push(Holder(HashMap<String, Any?>()))
    leftBrackets.push('{')
  }

  private fun runValueWhenColon(token: ValueJsonToken) {
    state = State.VALUE
    (results.peek().value as HashMap<String, Any?>)[keys.pop()] = token.value
  }

  private fun runWhenColon(token: JsonToken) {
    when (token) {
      is KeyJsonToken -> throw IllegalArgumentException("Colon should not be immediately followed by a key!")
      is CommaJsonToken -> throw IllegalArgumentException("Colon should not be immediately followed by a comma!")
      is LeftSquareBracketJsonToken -> runLeftSquareBracketWhenColon()
      is RightSquareBracketJsonToken -> throw IllegalArgumentException("Colon should not be immediately followed by a right square bracket!")
      is ColonJsonToken -> throw IllegalArgumentException("Colon should not be immediately followed by another colon!")
      is LeftCurlyBracketJsonToken -> runLeftCurlyBracketWhenColon()
      is RightCurlyBracketJsonToken -> throw IllegalArgumentException("Colon should not be immediately followed by another right curly bracket!")
      is ValueJsonToken -> runValueWhenColon(token)
      else -> throw IllegalArgumentException("The type of the token received is unsupported!")
    }
  }

  private fun runKeyWhenLeftCurlyBracket(token: KeyJsonToken) {
    state = State.KEY
    keys.push(token.value)
  }

  private fun runRightCurlyBracketWhenLeftCurlyBracket() {
    state = State.RIGHT_CURLY_BRACKET
    if (results.size > 1) putCurrentResultIntoPrevResult()
    leftBrackets.pop()
  }

  private fun runWhenLeftCurlyBracket(token: JsonToken) {
    when (token) {
      is KeyJsonToken -> runKeyWhenLeftCurlyBracket(token)
      is CommaJsonToken -> throw IllegalArgumentException("Left curly bracket should not be immediately followed by a comma!")
      is LeftSquareBracketJsonToken -> throw IllegalArgumentException("Left curly bracket should not be immediately followed by a left square bracket!")
      is RightSquareBracketJsonToken -> throw IllegalArgumentException("Left curly bracket should not be immediately followed by a right square bracket!")
      is ColonJsonToken -> throw IllegalArgumentException("Left curly bracket should not be immediately followed by a colon!")
      is LeftCurlyBracketJsonToken -> throw IllegalArgumentException("Left curly bracket should not be immediately followed by a left curly bracket!")
      is RightCurlyBracketJsonToken -> runRightCurlyBracketWhenLeftCurlyBracket()
      is ValueJsonToken -> throw IllegalArgumentException("Left curly bracket should not be immediately followed by a value!")
      else -> throw IllegalArgumentException("The type of the token received is unsupported!")
    }
  }

  private fun runCommaWhenRightCurlyBracket() {
    state = State.COMMA
    if (leftBrackets.size == 0) throw IllegalArgumentException("An attempt to make multiple top level objects in JSON string or file is prohibited!")
  }

  private fun runRightSquareBracketWhenRightCurlyBracket() {
    state = State.RIGHT_SQUARE_BRACKET
    if (results.size > 1) putCurrentResultIntoPrevResult()
    if (leftBrackets.size == 0) throw IllegalArgumentException("Left and right brackets in the JSON string or file are not balanced!")
    if (leftBrackets.pop() != '[') throw IllegalArgumentException("Left bracket and right bracket do not match with each other!")
  }

  private fun runRightCurlyBracketWhenRightCurlyBracket() {
    state = State.RIGHT_CURLY_BRACKET
    if (results.size > 1) putCurrentResultIntoPrevResult()
    if (leftBrackets.size == 0) throw IllegalArgumentException("Left and right brackets in the JSON string or file are not balanced!")
    if (leftBrackets.pop() != '{') throw IllegalArgumentException("Left bracket and right bracket do not match with each other!")
  }

  private fun runWhenRightCurlyBracket(token: JsonToken) {
    when (token) {
      is KeyJsonToken -> throw IllegalArgumentException("Right curly bracket should not be immediately followed by a key!")
      is CommaJsonToken -> runCommaWhenRightCurlyBracket()
      is LeftSquareBracketJsonToken -> throw IllegalArgumentException("Right curly bracket should not be immediately followed by a left square bracket!")
      is RightSquareBracketJsonToken -> runRightSquareBracketWhenRightCurlyBracket()
      is ColonJsonToken -> throw IllegalArgumentException("Right curly bracket should not be immediately followed by a colon!")
      is LeftCurlyBracketJsonToken -> throw IllegalArgumentException("Right curly bracket should not be immediately followed by a left curly bracket!")
      is RightCurlyBracketJsonToken -> runRightCurlyBracketWhenRightCurlyBracket()
      is ValueJsonToken -> throw IllegalArgumentException("Right curly bracket should not be immediately followed by a value!")
      else -> throw IllegalArgumentException("The type of the token received is unsupported!")
    }
  }

  private fun runCommaWhenValue() {
    state = State.COMMA
    if (leftBrackets.size == 0) throw IllegalArgumentException("An attempt to make multiple top level objects in JSON string or file is prohibited!")
  }

  private fun runRightSquareBracketWhenValue() {
    state = State.RIGHT_SQUARE_BRACKET
    if (results.size > 1) putCurrentResultIntoPrevResult()
    if (leftBrackets.size == 0) throw IllegalArgumentException("Left and right brackets in the JSON string or file are not balanced!")
    if (leftBrackets.pop() != '[') throw IllegalArgumentException("Left bracket and right bracket do not match with each other!")
  }

  private fun runRightCurlyBracketWhenValue() {
    state = State.RIGHT_CURLY_BRACKET
    if (results.size > 1) putCurrentResultIntoPrevResult()
    if (leftBrackets.size == 0) throw IllegalArgumentException("Left and right brackets in the JSON string or file are not balanced!")
    if (leftBrackets.pop() != '{') throw IllegalArgumentException("Left bracket and right bracket do not match with each other!")
  }

  private fun runWhenValue(token: JsonToken) {
    when (token) {
      is KeyJsonToken -> throw IllegalArgumentException("Value should not be immediately followed by a key!")
      is CommaJsonToken -> runCommaWhenValue()
      is LeftSquareBracketJsonToken -> throw IllegalArgumentException("Value should not be immediately followed by a left square bracket!")
      is RightSquareBracketJsonToken -> runRightSquareBracketWhenValue()
      is ColonJsonToken -> throw IllegalArgumentException("Null should not be immediately followed by a colon!")
      is LeftCurlyBracketJsonToken -> throw IllegalArgumentException("Null should not be immediately followed by a left curly bracket!")
      is RightCurlyBracketJsonToken -> runRightCurlyBracketWhenValue()
      is ValueJsonToken -> throw IllegalArgumentException("Value should not be immediately followed by another value!")
      else -> throw IllegalArgumentException("The type of the token received is unsupported!")
    }
  }

  private fun run(token: JsonToken) {
    when (state) {
      State.INITIAL -> runWhenInitial(token)
      State.KEY -> runWhenKey(token)
      State.COMMA -> runWhenComma(token)
      State.LEFT_SQUARE_BRACKET -> runWhenLeftSquareBracket(token)
      State.RIGHT_SQUARE_BRACKET -> runWhenRightSquareBracket(token)
      State.COLON -> runWhenColon(token)
      State.LEFT_CURLY_BRACKET -> runWhenLeftCurlyBracket(token)
      State.RIGHT_CURLY_BRACKET -> runWhenRightCurlyBracket(token)
      State.VALUE -> runWhenValue(token)
    }
  }

  private fun postRun() {
    when (state) {
      State.KEY -> throw IllegalArgumentException("JSON string or file should not ends with a key!")
      State.COMMA -> throw IllegalArgumentException("JSON string or file should not ends with a comma!")
      State.LEFT_SQUARE_BRACKET -> throw IllegalArgumentException("JSON string or file should not ends with a left square bracket!")
      State.COLON -> throw IllegalArgumentException("JSON string or file should not ends with a colon!")
      State.LEFT_CURLY_BRACKET -> throw IllegalArgumentException("JSON string or file should not ends with a left curly bracket!")
      else -> { }
    }
    if (keys.size != 0) throw IllegalArgumentException("JSON string or file contains a key without an associated value!")
    if (leftBrackets.size != 0) throw IllegalArgumentException("Left and right brackets in the JSON string or file are not balanced!")
  }

  /**
   * It converts JSON `tokens` received into an object.
   *
   * @param tokens The JSON tokens to be converted.
   * @return An object that is converted from the JSON `tokens` given.
   */
  fun run(vararg tokens: JsonToken): Any? {
    preRun()
    for (token in tokens) run(token)
    postRun()
    return if (results.size != 0) results.pop().value else null
  }
}
