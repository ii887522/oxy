package ii887522.oxy.collection

import ii887522.oxy.any.COLLECTION_GROWTH_FACTOR
import ii887522.oxy.functions.nextPrime
import ii887522.oxy.struct.Pair
import java.util.Arrays.fill
import kotlin.math.max

/**
 * A `HashMap` is a collection of items with key of type `K` and value of type `V`. It can be either sorted or unsorted but cannot have items with same keys
 * although items can have same values. It does not place any restrictions on the `HashMap` when accessing it.
 *
 * @param K The type of the key of the items stored in `Map`.
 * @param V The type of the value of the items stored in `Map`.
 * @param initialCapacity The initial size of the internal backing array used to maintain items. It must be at least 4.
 * @throws IllegalArgumentException If `initialCapacity` is less than 4.
*/
class HashMap<K, V> @JvmOverloads constructor(initialCapacity: Int = 32) : Map<K, V> {
  private var values: Array<LinkedList<Pair<K, V>>>

  /**
   * It retrieves the number of items stored in the `HashMap`.
   *
   * @return The number of items stored in the `HashMap`.
   */
  override var size = 0
    private set

  /**
   * It retrieves all keys that have been stored in the `HashMap`.
   *
   * @return Keys that are contained inside the `HashMap`.
   */
  override val keys: List<K> get() {
    val result = ArrayList<K>(max(size, 4))
    for (list in values) {
      for (item in list) result.append(item.key)
    }
    return result
  }

  init {
    if (initialCapacity < 4) throw IllegalArgumentException("Capacity must be at least 4!")
    values = Array((initialCapacity shl 1).nextPrime) { LinkedList() }
  }

  /**
   * It inserts or updates an item stored in the `HashMap` based on the `key` and `value` given.
   *
   * @param key It will be used for finding this item in the future.
   * @param value It will be inserted or updated to the `HashMap`.
   */
  override fun set(key: K, value: V) {
    val hashCode = key.hashCode() and 0x7fffffff
    for (item in values[hashCode % values.size]) {
      if (!item.key?.equals(key)!!) continue
      item.value = value
      return
    }
    if (size shl 1 >= values.size) grow()
    values[hashCode % values.size].append(Pair(key, value))
    ++size
  }

  private fun grow() {
    val map = HashMap<K, V>((size * COLLECTION_GROWTH_FACTOR).toInt())
    for (list in values) {
      for (item in list) map[item.key] = item.value
    }
    values = map.values
  }

  /**
   * It removes an item stored in the `HashMap` with the matching `key`.
   *
   * @param key It will be used to remove a matching item.
   * @return A value that is belongs to the item with the matching `key`. `null` if the `key` does not match any item.
   */
  override fun remove(key: K): V? {
    val hashCode = key.hashCode() and 0x7fffffff
    val items = values[hashCode % values.size].iterator()
    while (items.hasNext()) {
      val item = items.next()
      if (!item.key?.equals(key)!!) continue
      val result = item.value
      items.remove()
      --size
      return result
    }
    return null
  }

  /**
   * Retrieves a value that is belongs to the item with the matching `key` in the `HashMap`.
   *
   * @param key It will be used to retrieve a matching item.
   * @return A value that is belongs to the item with the matching `key`. `null` if the `key` does not match any item.
   */
  override fun get(key: K): V? {
    val hashCode = key.hashCode() and 0x7fffffff
    for (item in values[hashCode % values.size]) {
      if (item.key?.equals(key) == true) return item.value
    }
    return null
  }

  /**
   * It removes all items stored in the `HashMap`.
   */
  override fun clear() {
    fill(values, LinkedList<Pair<K, V>>())
    size = 0
  }

  override fun hashCode(): Int {
    var result = values.contentHashCode()
    result = 31 * result + size
    return result
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as HashMap<*, *>

    if (!values.contentEquals(other.values)) return false
    if (size != other.size) return false

    return true
  }
}
