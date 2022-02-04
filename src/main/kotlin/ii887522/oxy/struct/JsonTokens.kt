package ii887522.oxy.struct

sealed class JsonToken
data class CharJsonToken(var value: Char = ' ') : JsonToken()
sealed class ValueJsonToken(open val value: Any? = null) : JsonToken()
data class KeyJsonToken(var value: String = "") : JsonToken()
data class StringJsonToken(override var value: String = "") : ValueJsonToken(value)
object CommaJsonToken : JsonToken()
object LeftSquareBracketJsonToken : JsonToken()
object RightSquareBracketJsonToken : JsonToken()
object ColonJsonToken : JsonToken()
object LeftCurlyBracketJsonToken : JsonToken()
object RightCurlyBracketJsonToken : JsonToken()
object NullJsonToken : ValueJsonToken(null)
sealed class BoolJsonToken(override var value: Boolean = false) : ValueJsonToken(value)
object TrueJsonToken : BoolJsonToken(true)
object FalseJsonToken : BoolJsonToken(false)

data class SignJsonToken(var value: Value = Value.POSITIVE) : JsonToken() {
  enum class Value {
    POSITIVE, NEGATIVE
  }
}

data class DigitJsonToken(var value: Value = Value.ZERO) : JsonToken() {
  enum class Value {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
  }
}

data class PositiveIntJsonToken(var value: Int = 0, var leadingZeroCount: Int = 0) : JsonToken()
data class IntJsonToken(var value: Int = 0, var leadingZeroCount: Int = 0) : JsonToken()
data class NumberJsonToken(override var value: Float = 0f) : ValueJsonToken(value)
