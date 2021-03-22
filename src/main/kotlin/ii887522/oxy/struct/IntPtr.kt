package ii887522.oxy.struct

import ii887522.oxy.any.Calculatable

data class IntPtr(var value: Int = 0) : Calculatable<IntPtr> {
  override fun plus(that: IntPtr) = IntPtr(value + that.value)
  override fun minus(that: IntPtr) = IntPtr(value - that.value)
  override fun times(that: IntPtr) = IntPtr(value * that.value)
  override fun div(that: IntPtr) = IntPtr(value / that.value)
  override fun plus(that: Number) = IntPtr(value + that.toInt())
  override fun minus(that: Number) = IntPtr(value - that.toInt())
  override fun times(that: Number) = IntPtr((value * that.toFloat()).toInt())
  override fun div(that: Number) = IntPtr((value / that.toFloat()).toInt())
}
