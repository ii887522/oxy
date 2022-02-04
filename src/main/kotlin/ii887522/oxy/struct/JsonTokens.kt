package ii887522.oxy.struct

internal sealed class JsonToken
internal data class CharJsonToken(var value: Char = ' ') : JsonToken()
internal sealed class ValueJsonToken(open val value: Any? = null) : JsonToken()
internal data class KeyJsonToken(var value: String = "") : JsonToken()
internal data class StringJsonToken(override var value: String = "") : ValueJsonToken(value)
internal object CommaJsonToken : JsonToken()
internal object LeftSquareBracketJsonToken : JsonToken()
internal object RightSquareBracketJsonToken : JsonToken()
internal object ColonJsonToken : JsonToken()
internal object LeftCurlyBracketJsonToken : JsonToken()
internal object RightCurlyBracketJsonToken : JsonToken()
internal object NullJsonToken : ValueJsonToken(null)
internal sealed class BoolJsonToken(override var value: Boolean = false) : ValueJsonToken(value)
internal object TrueJsonToken : BoolJsonToken(true)
internal object FalseJsonToken : BoolJsonToken(false)

internal data class SignJsonToken(var value: Value = Value.POSITIVE) : JsonToken() {
  enum class Value {
    POSITIVE, NEGATIVE
  }
}

internal data class DigitJsonToken(var value: Value = Value.ZERO) : JsonToken() {
  enum class Value {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
  }
}

internal data class PositiveIntJsonToken(var value: Int = 0, var leadingZeroCount: Int = 0) : JsonToken()
internal data class IntJsonToken(var value: Int = 0, var leadingZeroCount: Int = 0) : JsonToken()
internal data class NumberJsonToken(override var value: Float = 0f) : ValueJsonToken(value)
