package ii887522.oxy.any

import ii887522.oxy.collection.ArrayList
import ii887522.oxy.collection.HashMap
import ii887522.oxy.functions.toArray
import ii887522.oxy.struct.*

private fun ArrayList<*>.tokenize(): Array<JsonToken> {
  val tokens = ArrayList<JsonToken>()
  tokens.append(LeftSquareBracketJsonToken)
  for (item in this) tokens.appendBulk(*item.tokenize(), CommaJsonToken)
  tokens.append(RightSquareBracketJsonToken)
  return tokens.toArray()
}

private fun HashMap<String, Any?>.tokenize(): Array<JsonToken> {
  val tokens = ArrayList<JsonToken>()
  tokens.append(LeftCurlyBracketJsonToken)
  for (item in toArray()) tokens.appendBulk(KeyJsonToken(item.key), ColonJsonToken, *item.value.tokenize(), CommaJsonToken)
  tokens.append(RightCurlyBracketJsonToken)
  return tokens.toArray()
}

/**
 * It converts the object into an array of JSON tokens.
 *
 * @return An array of JSON tokens that is converted from the object.
 */
internal fun Any?.tokenize(): Array<JsonToken> {
  val tokens = ArrayList<JsonToken>()
  when (this) {
    is Boolean -> tokens.append(if (this) TrueJsonToken else FalseJsonToken)
    is Float -> tokens.append(NumberJsonToken(this))
    is String -> tokens.append(StringJsonToken(this))
    is ArrayList<*> -> tokens.appendBulk(*tokenize())
    is HashMap<*, *> -> tokens.appendBulk(*(this as HashMap<String, Any?>).tokenize())
    else -> {
      if (this === null) tokens.append(NullJsonToken)
      else throw IllegalArgumentException("The data type of this is unsupported!")
    }
  }
  return tokens.toArray()
}
