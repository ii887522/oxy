package ii887522.oxy.collection

/**
 * A `Map` is a collection of items with key of type `K` and value of type `V`. It can be either sorted or unsorted but cannot have items with same keys although
 * items can have same values. It does not place any restrictions on the `Map` when accessing it.
 *
 * @param K The type of the key of the items stored in `Map`.
 * @param V The type of the value of the items stored in `Map`.
 */
interface Map<K, V> : Collection {
  /**
   * It retrieves all keys that have been stored in the `Map`.
   *
   * @return Keys that are contained inside the `Map`.
   */
  val keys: List<K>

  /**
   * It inserts or updates an item stored in the `Map` based on the `key` and `value` given.
   *
   * @param key It will be used for finding this item in the future.
   * @param value It will be inserted or updated to the `Map`.
   * @throws IllegalStateException If this method is called when a new item is going to be inserted and the `Map` is full.
   */
  operator fun set(key: K, value: V)

  /**
   * It removes an item stored in the `Map` with the matching `key`.
   *
   * @param key It will be used to remove a matching item.
   * @return A value that is belongs to the item with the matching `key`. `null` if the `key` does not match any item.
   * @throws IllegalStateException If this method is called when this `Map` is empty.
   */
  fun remove(key: K): V?

  /**
   * Retrieves a value that is belongs to the item with the matching `key` in the `Map`.
   *
   * @param key It will be used to retrieve a matching item.
   * @return A value that is belongs to the item with the matching `key`. `null` if the `key` does not match any item.
   */
  operator fun get(key: K): V?
}
