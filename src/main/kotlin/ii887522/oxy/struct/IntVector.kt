package ii887522.oxy.struct

import ii887522.oxy.any.Calculatable

data class IntVector(val x: Int = 0, val y: Int = 0) : Calculatable<IntVector> {
  override fun plus(that: IntVector) = IntVector(x + that.x, y + that.y)
  override fun minus(that: IntVector) = IntVector(x - that.x, y - that.y)
  override fun times(that: IntVector) = IntVector(x * that.x, y * that.y)
  override fun div(that: IntVector) = IntVector(x / that.x, y / that.y)
  override fun plus(that: Number) = IntVector(x + that.toInt(), y + that.toInt())
  override fun minus(that: Number) = IntVector(x - that.toInt(), y - that.toInt())
  override fun times(that: Number) = IntVector((x * that.toFloat()).toInt(), (y * that.toFloat()).toInt())
  override fun div(that: Number) = IntVector((x / that.toFloat()).toInt(), (y / that.toFloat()).toInt())
  fun toFloatVector() = FloatVector(x.toFloat(), y.toFloat())
}
