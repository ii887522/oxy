package ii887522.oxy.collection

import ii887522.oxy.any.COLLECTION_GROWTH_FACTOR
import ii887522.oxy.functions.swap
import ii887522.oxy.struct.Holder
import java.lang.System.arraycopy
import java.util.Arrays.fill

/**
 * An `ArrayList` is a collection of items of type `T` linearly placed together without any gaps. It can be either sorted or unsorted and can have duplicate items.
 * It does not place any restrictions on the `ArrayList` when accessing it. The index of the `ArrayList` starts from 0.
 *
 * @param T The type of the items stored in the `ArrayList`.
 * @param initialCapacity The initial size of the internal backing array used to maintain items. It must be at least 4.
 * @throws IllegalArgumentException If `initialCapacity` is less than 4.
*/
class ArrayList<T> @JvmOverloads constructor(initialCapacity: Int = 32) : List<T> {
  private val currentItems: Holder<Array<T?>>
  private val nextItems: Holder<Array<T?>>

  /**
   * It retrieves the number of items stored in the `ArrayList`.
   *
   * @return The number of items stored in the `ArrayList`.
   */
  override var size = 0
    private set

  private var migratedItemCount = 0

  init {
    if (initialCapacity < 4) throw IllegalArgumentException("initialCapacity must be at least 4!")
    currentItems = Holder(arrayOfNulls<Any>(initialCapacity) as Array<T?>)
    nextItems = Holder(arrayOfNulls<Any>(0) as Array<T?>)
  }

  /**
   * It retrieves an item at index `index` stored in the `ArrayList`.
   *
   * @param index It must be between 0 and the number of items stored in the `ArrayList` - 1.
   * @return The item at index `index` stored in the `ArrayList`.
   * @throws IllegalArgumentException If `index` is less than 0 or `index` is greater than or equal to the number of items stored in the `ArrayList`.
   */
  override fun get(index: Int): T {
    if (index < 0 || index >= size) throw IllegalArgumentException("index must be between 0 and the number of items in this ArrayList (exclusive)!")
    return currentItems.value[index] ?: nextItems.value[index]!!
  }

  /**
   * It replaces an item at index `index` stored in the `ArrayList` based on the `item` given.
   *
   * @param index It must be between 0 and the number of items stored in the `ArrayList` - 1.
   * @param item It replaces the item at index `index` stored in the `ArrayList`.
   * @throws IllegalArgumentException If `index` is less than 0 or `index` is greater than or equal to the number of items in the `ArrayList`.
   */
  override fun set(index: Int, item: T) {
    if (index < 0 || index >= size) throw IllegalArgumentException("index must be between 0 and the number of items in this ArrayList (exclusive)!")
    if (currentItems.value[index] !== null) currentItems.value[index] = item
    else nextItems.value[index] = item
  }

  /**
   * It adds the `item` given at the end of the `ArrayList`.
   *
   * @param item It will be added to the end of the `ArrayList`.
   */
  override fun append(item: T) {
    if (size == currentItems.value.size) grow()
    if (size < nextItems.value.size) nextItems.value[size] = item
    else currentItems.value[size] = item
    ++size
    if (nextItems.value.isNotEmpty() && size > nextItems.value.size) migrateItemsAfterAdd()
  }

  /**
   * It adds the `item` given at the start of the `ArrayList`.
   *
   * @param item It will be added to the start of the `ArrayList`.
   */
  override fun prepend(item: T) = insert(0, item)

  /**
   * It adds the `item` given at index `index` of the `ArrayList`.
   *
   * @param index It must be between 0 and the number of items stored in the `ArrayList`.
   * @param item It will be added to the `ArrayList` at index `index`.
   * @throws IllegalArgumentException if `index` is less than 0 or `index` is greater than the number of items in the `ArrayList`.
   */
  override fun insert(index: Int, item: T) {
    if (index < 0 || index > size) throw IllegalArgumentException("index must be between 0 and the number of items in this ArrayList (inclusive)!")
    if (index == size) {
      append(item)
      return
    }
    if (size == currentItems.value.size) grow()
    if (index >= nextItems.value.size) insertOutsideNextItems(index, item)
    else insertInsideNextItems(index, item)
    ++size
    if (nextItems.value.isNotEmpty() && size > nextItems.value.size) migrateItemsAfterAdd()
  }

  private fun grow() {
    nextItems.value = arrayOfNulls<Any>((currentItems.value.size * COLLECTION_GROWTH_FACTOR).toInt()) as Array<T?>
    swap(currentItems, nextItems)
    migratedItemCount = 0
  }

  private fun insertOutsideNextItems(index: Int, item: T) {
    arraycopy(currentItems.value, index, currentItems.value, index + 1, size - index)
    currentItems.value[index] = item
  }

  private fun insertInsideNextItemsOutsideMigratedItems(index: Int, item: T) {
    if (size >= nextItems.value.size) arraycopy(nextItems.value, index, nextItems.value, index + 1, nextItems.value.size - index - 1)
    else arraycopy(nextItems.value, index, nextItems.value, index + 1, size - index)
    nextItems.value[index] = item
  }

  private fun insertInsideNextItemsInsideMigratedItems(index: Int, item: T) {
    arraycopy(nextItems.value, migratedItemCount, nextItems.value, migratedItemCount + 1, nextItems.value.size - migratedItemCount - 1)
    nextItems.value[migratedItemCount] = currentItems.value[migratedItemCount - 1]
    arraycopy(currentItems.value, index, currentItems.value, index + 1, migratedItemCount - index - 1)
    currentItems.value[index] = item
  }

  private fun insertInsideNextItems(index: Int, item: T) {
    if (size >= nextItems.value.size) {
      arraycopy(currentItems.value, nextItems.value.size, currentItems.value, nextItems.value.size + 1, size - nextItems.value.size)
      currentItems.value[nextItems.value.size] = nextItems.value[nextItems.value.size - 1]
    }
    if (index >= migratedItemCount) insertInsideNextItemsOutsideMigratedItems(index, item)
    else insertInsideNextItemsInsideMigratedItems(index, item)
  }

  private val migrateItemCountWhenNotFull get() = (1f / (COLLECTION_GROWTH_FACTOR - 1f)).toInt()
  private val migrateItemCount get() = if (size == currentItems.value.size) nextItems.value.size - migratedItemCount else migrateItemCountWhenNotFull

  private fun migrateItemsAfterAdd() {
    val count = migrateItemCount
    arraycopy(nextItems.value, migratedItemCount, currentItems.value, migratedItemCount, count)
    migratedItemCount += count
  }

  /**
   * It removes an item at index `index` stored in the `ArrayList`.
   *
   * @param index It must be between 0 and the number of items stored in the `ArrayList` - 1.
   * @return The item that will be removed from the `ArrayList`.
   * @throws IllegalStateException If this method is called when the `ArrayList` is empty.
   * @throws IllegalArgumentException If `index` is less than 0 or `index` is greater than or equal to the number of items in the `ArrayList`.
   */
  override fun remove(index: Int): T {
    if (size == 0) throw IllegalStateException("remove() method must not be called when this ArrayList is empty!")
    if (index < 0 || index >= size) throw IllegalArgumentException("index must be between 0 and the number of items in this ArrayList (exclusive)!")
    if (index == size - 1) return removeBack()
    val item = get(index)
    if (index >= nextItems.value.size) removeOutsideNextItems(index)
    else removeInsideNextItems(index)
    if (nextItems.value.isNotEmpty() && size > nextItems.value.size) unmigrateItemsAfterRemove()
    --size
    return item
  }

  /**
   * It removes the item that is at the end of the `ArrayList`.
   *
   * @return The item that will be removed from the `ArrayList`.
   * @throws IllegalStateException If this method is called when the `ArrayList` is empty.
   */
  override fun removeBack(): T {
    if (size == 0) throw IllegalStateException("removeBack() method must not be called when this ArrayList is empty!")
    val item = get(size - 1)
    if (nextItems.value.isNotEmpty() && size > nextItems.value.size) unmigrateItemsAfterRemove()
    --size
    return item
  }

  /**
   * It removes the item that is at the start of the `ArrayList`.
   *
   * @return The item that will be removed from the `ArrayList`.
   * @throws IllegalStateException If this method is called when the `ArrayList` is empty.
   */
  override fun removeFront(): T {
    if (size == 0) throw IllegalStateException("removeFront() method must not be called when this ArrayList is empty!")
    return remove(0)
  }

  private fun removeOutsideNextItems(index: Int) = arraycopy(currentItems.value, index + 1, currentItems.value, index, size - index - 1)

  private fun removeInsideNextItemsOutsideMigratedItems(index: Int) {
    if (size <= nextItems.value.size) arraycopy(nextItems.value, index + 1, nextItems.value, index, size - index - 1)
    else {
      arraycopy(nextItems.value, index + 1, nextItems.value, index, nextItems.value.size - index - 1)
      nextItems.value[nextItems.value.size - 1] = currentItems.value[nextItems.value.size]
      arraycopy(currentItems.value, nextItems.value.size + 1, currentItems.value, nextItems.value.size, size - nextItems.value.size - 1)
    }
  }

  private fun removeInsideNextItemsInsideMigratedItems(index: Int) {
    if (size == currentItems.value.size) arraycopy(currentItems.value, index + 1, currentItems.value, index, size - index - 1)
    else {
      arraycopy(currentItems.value, index + 1, currentItems.value, index, migratedItemCount - index - 1)
      currentItems.value[migratedItemCount - 1] = nextItems.value[migratedItemCount]
      arraycopy(nextItems.value, migratedItemCount + 1, nextItems.value, migratedItemCount, nextItems.value.size - migratedItemCount - 1)
      nextItems.value[nextItems.value.size - 1] = currentItems.value[nextItems.value.size]
      arraycopy(currentItems.value, nextItems.value.size + 1, currentItems.value, nextItems.value.size, size - nextItems.value.size - 1)
    }
  }

  private fun removeInsideNextItems(index: Int) {
    if (index >= migratedItemCount) removeInsideNextItemsOutsideMigratedItems(index)
    else removeInsideNextItemsInsideMigratedItems(index)
  }

  private val unmigrateItemCount
    get() = migrateItemCountWhenNotFull +
      if (size == currentItems.value.size) nextItems.value.size - (currentItems.value.size - nextItems.value.size) * migrateItemCountWhenNotFull else 0

  private fun unmigrateItemsAfterRemove() {
    val count = unmigrateItemCount
    migratedItemCount -= count
    arraycopy(currentItems.value, migratedItemCount, nextItems.value, migratedItemCount, count)
    fill(currentItems.value, migratedItemCount, migratedItemCount + count, null)
  }

  /**
   * It removes all items stored in the `ArrayList`.
   */
  override fun clear() {
    fill(currentItems.value, null)
    fill(nextItems.value, null)
    size = 0
    migratedItemCount = 0
  }

  /**
   * It exchanges the positions of two items stored in the `ArrayList` based on `left` and `right` given.
   *
   * @param left It must be between 0 and the number of items stored in the `ArrayList` - 1. It must be less than or equal to `right`.
   * @param right It must be between 0 and the number of items stored in the `ArrayList` - 1. It must be greater than or equal to `left`.
   * @throws IllegalArgumentException if `left` is less than 0 or `left` is greater than or equal to the number of items stored in the `ArrayList`.
   * @throws IllegalArgumentException if `right` is less than 0 or `right` is greater than or equal to the number of items stored in the `ArrayList`.
   * @throws IllegalArgumentException if `left` is greater than `right`.
   */
  override fun swap(left: Int, right: Int) {
    if (left < 0 || left >= size) throw IllegalArgumentException("left must be between 0 and the number of items stored in the ArrayList - 1!")
    if (right < 0 || right >= size) throw IllegalArgumentException("right must be between 0 and the number of items stored in the ArrayList - 1!")
    if (left > right) throw IllegalArgumentException("left must be less than or equal to right!")
    val aux = get(left)
    set(left, get(right))
    set(right, aux)
  }

  override fun iterator() = object : Iterator<T> {
    private var i = 0

    override fun hasNext() = i != size

    override fun next(): T {
      val item = get(i)
      ++i
      return item
    }
  }

  override fun hashCode(): Int {
    var result = currentItems.hashCode()
    result = 31 * result + nextItems.hashCode()
    result = 31 * result + size
    return result
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as ArrayList<T>

    if (currentItems != other.currentItems) return false
    if (nextItems != other.nextItems) return false
    if (size != other.size) return false

    return true
  }
}
