package ii887522.oxy.struct

import ii887522.oxy.any.Calculatable

data class FloatPtr(var value: Float = .0f) : Calculatable<FloatPtr> {
  override fun plus(that: FloatPtr) = FloatPtr(value + that.value)
  override fun minus(that: FloatPtr) = FloatPtr(value - that.value)
  override fun times(that: FloatPtr) = FloatPtr(value * that.value)
  override fun div(that: FloatPtr) = FloatPtr(value / that.value)
  override fun plus(that: Number) = FloatPtr(value + that.toFloat())
  override fun minus(that: Number) = FloatPtr(value - that.toFloat())
  override fun times(that: Number) = FloatPtr(value * that.toFloat())
  override fun div(that: Number) = FloatPtr(value / that.toFloat())
}
