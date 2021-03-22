package ii887522.oxy.struct

import ii887522.oxy.any.Calculatable

data class FloatVector(val x: Float = .0f, val y: Float = .0f) : Calculatable<FloatVector> {
  override fun plus(that: FloatVector) = FloatVector(x + that.x, y + that.y)
  override fun minus(that: FloatVector) = FloatVector(x - that.x, y - that.y)
  override fun times(that: FloatVector) = FloatVector(x * that.x, y * that.y)
  override fun div(that: FloatVector) = FloatVector(x / that.x, y / that.y)
  override fun plus(that: Number) = FloatVector(x + that.toFloat(), y + that.toFloat())
  override fun minus(that: Number) = FloatVector(x - that.toFloat(), y - that.toFloat())
  override fun times(that: Number) = FloatVector(x * that.toFloat(), y * that.toFloat())
  override fun div(that: Number) = FloatVector(x / that.toFloat(), y / that.toFloat())
  fun toIntVector() = IntVector(x.toInt(), y.toInt())
}
