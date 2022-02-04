package ii887522.oxy.collection

import java.lang.Math.random

/**
 * A `List` is a collection of items of type `T` linearly placed together without any gaps. It can be either sorted or unsorted and can have duplicate items.
 * It does not place any restrictions on the `List` when accessing it. The index of the `List` starts from 0.
 *
 * @param T The type of the items stored in the `List`.
 */
interface List<T> : Collection, Iterable<T> {
  /**
   * It retrieves an item at index `index` stored in the `List`.
   *
   * @param index It must be between 0 and the number of items stored in the `List` - 1.
   * @return The item at index `index` stored in the `List`.
   * @throws IllegalArgumentException If `index` is less than 0 or `index` is greater than or equal to the number of items stored in the `List`.
   */
  operator fun get(index: Int): T

  /**
   * It replaces an item at index `index` stored in the `List` based on the `item` given.
   *
   * @param index It must be between 0 and the number of items stored in the `List` - 1.
   * @param item It replaces the item at index `index` stored in the `List`.
   * @throws IllegalArgumentException If `index` is less than 0 or `index` is greater than or equal to the number of items in the `List`.
   */
  operator fun set(index: Int, item: T)

  /**
   * It adds the `item` given at the end of the `List`.
   *
   * @param item It will be added to the end of the `List`.
   */
  fun append(item: T)

  /**
   * It adds multiple `items` given at the end of the `List`.
   *
   * @param items It will be added to the end of the `List`.
   */
  fun appendBulk(vararg items: T) {
    for (item in items) append(item)
  }

  /**
   * It adds the `item` given at the start of the `List`.
   *
   * @param item It will be added to the start of the `List`.
   */
  fun prepend(item: T)

  /**
   * It adds multiple `items` given at the start of the `List`.
   *
   * @param items It will be added to the start of the `List`.
   */
  fun prependBulk(vararg items: T) {
    for (i in items.lastIndex downTo 0) prepend(items[i])
  }

  /**
   * It adds the `item` given at index `index` of the `List`.
   *
   * @param index It must be between 0 and the number of items stored in the `List`.
   * @param item It will be added to the `List` at index `index`.
   * @throws IllegalArgumentException if `index` is less than 0 or `index` is greater than the number of items in the `List`.
   */
  fun insert(index: Int, item: T)

  /**
   * It removes an item at index `index` stored in the `List`.
   *
   * @param index It must be between 0 and the number of items stored in the `List` - 1.
   * @return The item that will be removed from the `List`.
   * @throws IllegalStateException If this method is called when the `List` is empty.
   * @throws IllegalArgumentException If `index` is less than 0 or `index` is greater than or equal to the number of items in the `List`.
   */
  fun remove(index: Int): T

  /**
   * It removes the item that is at the end of the `List`.
   *
   * @return The item that will be removed from the `List`.
   * @throws IllegalStateException If this method is called when the `List` is empty.
   */
  fun removeBack(): T

  /**
   * It removes the item that is at the start of the `List`.
   *
   * @return The item that will be removed from the `List`.
   * @throws IllegalStateException If this method is called when the `List` is empty.
   */
  fun removeFront(): T

  /**
   * It rearranges all the items stored in the `List` randomly.
   */
  fun shuffle() {
    for (i in 0 until size - 1) swap(i, i + 1 + (random() * (size - i - 1)).toInt())
  }

  /**
   * It exchanges the positions of two items stored in the `List` based on `left` and `right` given.
   *
   * @param left It must be between 0 and the number of items stored in the `List` - 1. It must be less than or equal to `right`.
   * @param right It must be between 0 and the number of items stored in the `List` - 1. It must be greater than or equal to `left`.
   * @throws IllegalArgumentException if `left` is less than 0 or `left` is greater than or equal to the number of items stored in the `List`.
   * @throws IllegalArgumentException if `right` is less than 0 or `right` is greater than or equal to the number of items stored in the `List`.
   * @throws IllegalArgumentException if `left` is greater than `right`.
   */
  fun swap(left: Int, right: Int)
}
