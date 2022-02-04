package ii887522.oxy.any

import ii887522.oxy.struct.*

private fun JsonToken.stringify() = when (this) {
  is KeyJsonToken -> "\"$value\""
  is CommaJsonToken -> ","
  is LeftSquareBracketJsonToken -> "["
  is RightSquareBracketJsonToken -> "]"
  is ColonJsonToken -> ":"
  is LeftCurlyBracketJsonToken -> "{"
  is RightCurlyBracketJsonToken -> "}"
  is NullJsonToken -> "null"
  is TrueJsonToken -> "true"
  is FalseJsonToken -> "false"
  is NumberJsonToken -> "$value"
  is StringJsonToken -> "\"$value\""
  else -> throw IllegalArgumentException("The type of this token is unsupported!")
}

/**
 * It converts the array of JSON tokens into a JSON string.
 *
 * @return A JSON string that is converted from the JSON tokens.
 */
fun Array<out JsonToken>.stringify(): String {
  val result = StringBuilder()
  for (token in this) result.append(token.stringify())
  return result.toString()
}
