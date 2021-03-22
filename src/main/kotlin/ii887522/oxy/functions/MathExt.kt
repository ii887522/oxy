package ii887522.oxy.functions

import ii887522.oxy.struct.IntPtr
import ii887522.oxy.struct.IntRange

fun clamp(valuePtr: IntPtr, range: IntRange) {
  if (valuePtr.value < range.min) valuePtr.value = range.min
  else if (valuePtr.value > range.max) valuePtr.value = range.max
}

infix fun Int.isOverlapX(xRange: IntRange) = this >= xRange.min && this < xRange.max
infix fun Int.isOverlapY(yRange: IntRange) = this >= yRange.min && this < yRange.max

fun min(l: Int, r: Int) = if (l < r) l else r
fun max(l: Int, r: Int) = if (l > r) l else r
