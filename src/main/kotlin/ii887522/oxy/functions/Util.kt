package ii887522.oxy.functions

import ii887522.oxy.any.JsonParser
import ii887522.oxy.any.lex
import ii887522.oxy.any.stringify
import ii887522.oxy.any.tokenize
import ii887522.oxy.struct.Holder
import java.lang.String.format
import kotlin.math.ceil

private const val SECONDS_PER_MINUTE = 60

/**
 * It exchanges objects that are held by both holders.
 *
 * @param left The first holder where its object will be exchanged.
 * @param right The second holder where its object will be exchanged.
 */
fun <T> swap(left: Holder<T>, right: Holder<T>) {
  val aux = left.value
  left.value = right.value
  right.value = aux
}

/**
 * It converts `seconds` into a time with a format like 'mmm:ss'.
 *
 * @param seconds The value to be converted.
 * @return The received value in terms of time with a format like 'mmm:ss'.
 */
fun formatTime(seconds: Float): String {
  val ceiledSeconds = ceil(seconds).toInt()
  return "${ceiledSeconds / SECONDS_PER_MINUTE}:${format("%02d", ceiledSeconds % SECONDS_PER_MINUTE)}"
}

/**
 * It converts the JSON string into an object that can be accessed easily.
 *
 * @return An object that is converted from the JSON string.
 */
fun String.asJsonStringToObject() = JsonParser().run(*lex())

/**
 * It converts the object into a JSON string that can be saved into a text file easily.
 *
 * @return A JSON string that is converted from an object.
 */
fun Any?.toJsonString() = tokenize().stringify()
