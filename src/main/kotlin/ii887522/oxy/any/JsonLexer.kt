package ii887522.oxy.any

import ii887522.oxy.collection.ArrayList
import ii887522.oxy.functions.asFractionToFloat
import ii887522.oxy.functions.toArray
import ii887522.oxy.struct.*
import java.lang.IllegalArgumentException

private fun String.toCharTokens() = Array(length) { CharJsonToken(this[it]) }

// <string> ::= "\"" <characters> "\"" | "\"" "\""
private fun Array<out JsonToken>.plusStringTokens(): Array<JsonToken> {
  val tokens = ArrayList<JsonToken>()
  val string = StringBuilder()
  var hasFoundDoubleQuote = false
  for (token in this) {
    if (token is CharJsonToken) {
      if (token.value == '"') {
        hasFoundDoubleQuote = if (hasFoundDoubleQuote) {
          tokens.append(StringJsonToken(string.toString()))
          string.clear()
          false
        } else true
      } else if (hasFoundDoubleQuote) string.append(token.value)
      else tokens.append(token)
    } else tokens.append(token)
  }
  if (hasFoundDoubleQuote) tokens.append(CharJsonToken('"'))
  return tokens.toArray()
}

// <key> ::= <string>
private fun Array<out JsonToken>.plusKeyTokens(): Array<JsonToken> {
  val tokens = ArrayList<JsonToken>()
  var candidate: String? = null
  for (token in this) {
    if (token is StringJsonToken) candidate = token.value
    else if (token is CharJsonToken) {
      if (candidate !== null) {
        tokens.append(if (token.value == ':') KeyJsonToken(candidate) else StringJsonToken(candidate))
        candidate = null
      }
      tokens.append(token)
    }
  }
  if (candidate !== null) tokens.append(StringJsonToken(candidate))
  return tokens.toArray()
}

private fun Array<out JsonToken>.plusTokens(selector: String, replacement: JsonToken): Array<JsonToken> {
  val tokens = ArrayList<JsonToken>()
  var index = 0
  loop@ while (index != size) {
    if (this[index] is CharJsonToken) {
      for (i in selector.indices) {
        if (index == size) {
          tokens.appendBulk(*selector.substring(0, i).toCharTokens())
          break@loop
        }
        val token = this[index]
        ++index
        if (token is CharJsonToken && token.value == selector[i]) continue
        tokens.appendBulk(*selector.substring(0, i).toCharTokens())
        tokens.append(token)
        continue@loop
      }
      tokens.append(replacement)
    } else {
      tokens.append(this[index])
      ++index
    }
  }
  return tokens.toArray()
}

private inline fun Array<out JsonToken>.plusTokens(getToken: (token: JsonToken) -> JsonToken): Array<JsonToken> {
  val tokens = ArrayList<JsonToken>()
  for (token in this) tokens.append(getToken(token))
  return tokens.toArray()
}

// <comma> ::= ","
private fun Array<out JsonToken>.plusCommaTokens() = plusTokens { if (it is CharJsonToken && it.value == ',') CommaJsonToken else it }

// <left-square-bracket> ::= "["
private fun Array<out JsonToken>.plusLeftSquareBracketTokens() = plusTokens { if (it is CharJsonToken && it.value == '[') LeftSquareBracketJsonToken else it }

// <right-square-bracket> ::= "]"
private fun Array<out JsonToken>.plusRightSquareBracketTokens() = plusTokens { if (it is CharJsonToken && it.value == ']') RightSquareBracketJsonToken else it }

// <colon> ::= ":"
private fun Array<out JsonToken>.plusColonTokens() = plusTokens { if (it is CharJsonToken && it.value == ':') ColonJsonToken else it }

// <left-curly-bracket> ::= "{"
private fun Array<out JsonToken>.plusLeftCurlyBracketTokens() = plusTokens { if (it is CharJsonToken && it.value == '{') LeftCurlyBracketJsonToken else it }

// <right-curly-bracket> ::= "}"
private fun Array<out JsonToken>.plusRightCurlyBracketTokens() = plusTokens { if (it is CharJsonToken && it.value == '}') RightCurlyBracketJsonToken else it }

// <sign> ::= "+" | "-"
private fun Array<out JsonToken>.plusSignTokens() = plusTokens {
  if (it is CharJsonToken) {
    when (it.value) {
      '+' -> SignJsonToken(SignJsonToken.Value.POSITIVE)
      '-' -> SignJsonToken(SignJsonToken.Value.NEGATIVE)
      else -> it
    }
  } else it
}

// <digit> ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
private fun Array<out JsonToken>.plusDigitTokens() = plusTokens { if (it is CharJsonToken && it.value in '0'..'9') it.value.toDigitJsonToken() else it }

private fun Char.toDigitJsonToken() = when (this) {
  '0' -> DigitJsonToken(DigitJsonToken.Value.ZERO)
  '1' -> DigitJsonToken(DigitJsonToken.Value.ONE)
  '2' -> DigitJsonToken(DigitJsonToken.Value.TWO)
  '3' -> DigitJsonToken(DigitJsonToken.Value.THREE)
  '4' -> DigitJsonToken(DigitJsonToken.Value.FOUR)
  '5' -> DigitJsonToken(DigitJsonToken.Value.FIVE)
  '6' -> DigitJsonToken(DigitJsonToken.Value.SIX)
  '7' -> DigitJsonToken(DigitJsonToken.Value.SEVEN)
  '8' -> DigitJsonToken(DigitJsonToken.Value.EIGHT)
  '9' -> DigitJsonToken(DigitJsonToken.Value.NINE)
  else -> throw IllegalArgumentException("This character must be between '0' and '9' (inclusive)!")
}

private val DigitJsonToken.intValue get() = when (value) {
  DigitJsonToken.Value.ZERO -> 0
  DigitJsonToken.Value.ONE -> 1
  DigitJsonToken.Value.TWO -> 2
  DigitJsonToken.Value.THREE -> 3
  DigitJsonToken.Value.FOUR -> 4
  DigitJsonToken.Value.FIVE -> 5
  DigitJsonToken.Value.SIX -> 6
  DigitJsonToken.Value.SEVEN -> 7
  DigitJsonToken.Value.EIGHT -> 8
  DigitJsonToken.Value.NINE -> 9
}

// <positive-integer> ::= <digit> <positive-integer> | <digit>
private fun Array<out JsonToken>.plusPositiveIntTokens(): Array<JsonToken> {
  val tokens = ArrayList<JsonToken>()
  var positiveInt = 0
  var leadingZeroCount = 0
  var canAddPositiveIntToken = false
  for (token in this) {
    if (token is DigitJsonToken) {
      val oldPositiveInt = positiveInt
      positiveInt = oldPositiveInt * 10 + token.intValue
      if (positiveInt == oldPositiveInt) ++leadingZeroCount
      canAddPositiveIntToken = true
    } else {
      if (canAddPositiveIntToken) {
        tokens.append(PositiveIntJsonToken(positiveInt, leadingZeroCount))
        positiveInt = 0
        leadingZeroCount = 0
        canAddPositiveIntToken = false
      }
      tokens.append(token)
    }
  }
  if (canAddPositiveIntToken) tokens.append(PositiveIntJsonToken(positiveInt, leadingZeroCount))
  return tokens.toArray()
}

// <integer> ::= <sign> <positive-integer> | <positive-integer>
private fun Array<out JsonToken>.plusIntTokens(): Array<JsonToken> {
  val tokens = ArrayList<JsonToken>()
  var signJsonToken: SignJsonToken? = null
  for (token in this) {
    when (token) {
      is SignJsonToken -> signJsonToken = token
      is PositiveIntJsonToken -> {
        tokens.append(IntJsonToken(if (signJsonToken?.value == SignJsonToken.Value.NEGATIVE) -token.value else token.value, token.leadingZeroCount))
        signJsonToken = null
      }
      else -> {
        if (signJsonToken !== null) {
          tokens.append(signJsonToken)
          signJsonToken = null
        }
        tokens.append(token)
      }
    }
  }
  if (signJsonToken !== null) tokens.append(signJsonToken)
  return tokens.toArray()
}

// <number> ::= <integer> "." <integer> | "." <integer> | <integer> "." | <integer>
private fun Array<out JsonToken>.plusNumberTokens(): Array<JsonToken> {
  val tokens = ArrayList<JsonToken>()
  var number = 0f
  var canAddNumberToken = false
  var hasFoundDot = false
  for (token in this) {
    when (token) {
      is IntJsonToken -> {
        if (hasFoundDot) {
          if (number < 0) number -= token.value.asFractionToFloat(token.leadingZeroCount)
          else number += token.value.asFractionToFloat(token.leadingZeroCount)
        } else number = token.value.toFloat()
        canAddNumberToken = true
      }
      is CharJsonToken -> {
        if (token.value == '.') {
          canAddNumberToken = true
          hasFoundDot = true
        } else {
          if (canAddNumberToken) {
            tokens.append(NumberJsonToken(number))
            number = 0f
            canAddNumberToken = false
            hasFoundDot = false
          }
          tokens.append(token)
        }
      }
      else -> {
        if (canAddNumberToken) {
          tokens.append(NumberJsonToken(number))
          number = 0f
          canAddNumberToken = false
          hasFoundDot = false
        }
        tokens.append(token)
      }
    }
  }
  if (canAddNumberToken) tokens.append(NumberJsonToken(number))
  return tokens.toArray()
}

/**
 * It assumes that the value is a JSON string and converts it into an array of JSON tokens to be consumed by JSON parser later. Each token contains information
 * about the type of the contained value and the contained value itself if it is exists.
 *
 * @return An array of JSON tokens to be consumed by the next processor.
 */
fun String.lex() =
  filter { !it.isWhitespace() }
    .toCharTokens()
    .plusStringTokens()
    .plusKeyTokens()
    .plusCommaTokens()
    .plusLeftSquareBracketTokens()
    .plusRightSquareBracketTokens()
    .plusColonTokens()
    .plusLeftCurlyBracketTokens()
    .plusRightCurlyBracketTokens()
    .plusTokens("null", NullJsonToken)  // <null> ::= "n" "u" "l" "l"
    .plusTokens("true", TrueJsonToken)  // <true> ::= "t" "r" "u" "e"
    .plusTokens("false", FalseJsonToken)  // <false> ::= "f" "a" "l" "s" "e"
    .plusSignTokens()
    .plusDigitTokens()
    .plusPositiveIntTokens()
    .plusIntTokens()
    .plusNumberTokens()
