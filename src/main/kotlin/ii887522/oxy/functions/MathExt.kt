package ii887522.oxy.functions

import ii887522.oxy.struct.IntRange
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * It constrains the `value` given in the `range` and returns the result.
 *
 * @param value The value to be constrained.
 * @param range The range the constrained value can be in.
 * @return The constrained value.
 */
fun clamp(value: Int, range: IntRange) = when {
  value < range.min -> range.min
  value > range.max -> range.max
  else -> value
}

/**
 * It checks whether the value is in the given `range`.
 *
 * @param range The range to be checked with.
 * @return true if the value is in the given `range`, false otherwise.
 */
infix fun Int.isOverlap(range: IntRange) = this >= range.min && this <= range.max

/**
 * It converts nanoseconds into seconds.
 *
 * @param nanoseconds The value to be converted.
 * @return The received value in terms of seconds.
 */
fun toSeconds(nanoseconds: Long) = nanoseconds * 1e-9f

/**
 * It checks whether the value is an odd number.
 *
 * @return true if the value is an odd number, false otherwise.
 */
val Int.isOdd get() = this and 1 == 1

/**
 * It checks whether the value is an even number.
 *
 * @return true if the value is an even number, false otherwise.
 */
val Int.isEven get() = this and 1 == 0

/**
 * It checks whether the value is a prime number.
 *
 * @return true if the value is a prime number, false otherwise.
 */
val Int.isPrime get(): Boolean {
  if (this <= 1) return false
  if (this == 2) return true
  if (isEven) return false
  if (this < 9) return true
  val sqrtOfThis = sqrt(this.toFloat()).toInt()
  if (sqrtOfThis * sqrtOfThis == this) return false
  if (this < 15) return true
  for (i in 3..sqrtOfThis step 2) {
    if (this / i * i == this) return false
  }
  return true
}

/**
 * It finds out the next prime number after the given value.
 *
 * @return The next prime number immediately after the given value.
 */
val Int.nextPrime get(): Int {
  if (this < 2) return 2
  var result = this + if (isEven) 1 else 2
  while (!result.isPrime) result += 2
  return result
}

/**
 * It checks whether the value is equal to 2 to the power of n where n is an integer.
 *
 * @return true if the value is equal to 2 to the power of n where n is an integer, false otherwise.
 */
val Int.isPowerOfTwo get() = this and (this - 1) == 0

/**
 * It retrieves the number of digits in the value.
 *
 * @return The number of digits in the value.
 */
val Int.size get() = if (this == 0) 1 else log10(toFloat()).toInt() + 1

/**
 * It treats the value as a fraction and converts it into a floating point number.
 *
 * @param leadingZeroCount The number of zeros before the value itself.
 * @return The floating point number after treated the value as a fraction.
 */
fun Int.asFractionToFloat(leadingZeroCount: Int = 0) = if (this == 0) 0f else this / 10f.pow(size + leadingZeroCount)
