package ii887522.oxy.collection

/**
 * A `Collection` is a data structure that contains multiple items of any data type that can be manipulated in any way.
 */
interface Collection {
  /**
   * It retrieves the number of items stored in the `Collection`.
   *
   * @return The number of items stored in the `Collection`.
   */
  val size: Int

  /**
   * It removes all items stored in the `Collection`.
   */
  fun clear()
}
