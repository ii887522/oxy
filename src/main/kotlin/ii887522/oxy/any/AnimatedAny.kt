package ii887522.oxy.any

import ii887522.oxy.struct.IntPtr
import ii887522.oxy.struct.IntRange
import ii887522.oxy.functions.clamp

class AnimatedAny<T : Calculatable<T>>(value: T, duration: Int /* animation duration */, private val onAnimationEnd: () -> Unit = { }) {
  var start = value
    private set

  var now = value
    private set

  var end = value
    private set

  private val elapsedTime = IntPtr()
  private val elapsedTimeRange = IntRange(0, duration)

  fun set(value: T) {
    start = now
    end = value
    elapsedTime.value = 0
  }

  fun teleport(value: T) {
    start = now
    now = value
    end = value
    elapsedTime.value = elapsedTimeRange.max
  }

  fun step(dt: Int) {
    if (elapsedTime.value == elapsedTimeRange.max) return
    elapsedTime.value += dt
    clamp(elapsedTime, elapsedTimeRange)
    now = start + (end - start) * (elapsedTime.value.toFloat() / elapsedTimeRange.max)
    if (elapsedTime.value == elapsedTimeRange.max) onAnimationEnd()
  }
}
