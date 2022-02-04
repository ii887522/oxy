package ii887522.oxy.functions

/**
 * It returns a substring from the original string received which starts from the start text given and ends with a text which immediately precedes the end text given.
 *
 * @param startText The start text included in the original string.
 * @param endText The end text included in the original string.
 * @return The substring requested.
 */
fun String.substring(startText: String, endText: String): String {
  val startTextIndex = indexOf(startText)
  return substring(startTextIndex, indexOf(endText, startTextIndex))
}

/**
 * It checks whether the value given is actually an unsigned integer which is converted to a string.
 *
 * @return true if the value is an unsigned integer which is converted to a string, false otherwise.
 */
val String.isUint get(): Boolean {
  for (ch in this) {
    if (ch !in '0'..'9') return false
  }
  return true
}
