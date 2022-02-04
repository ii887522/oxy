package ii887522.oxy.collection

/**
 * An `ArrayStack` is a collection of items of type `T` linearly placed together without any gaps. It can be either sorted or unsorted and can have duplicate items.
 * However, users are only allowed to add, remove, get or set the item that is at the end of the `ArrayStack`.
 *
 * @param T The type of the items stored in the `ArrayStack`.
*/
class ArrayStack<T> : Stack<T> {
  private val items = ArrayList<T>()

  /**
   * It retrieves the number of items stored in the `ArrayStack`.
   *
   * @return the number of items stored in the `ArrayStack`.
   */
  override val size get() = items.size

  /**
   * It adds the `item` to the end of the `ArrayStack`.
   *
   * @param item It will be added to the end of the `ArrayStack`.
   */
  override fun push(item: T) = items.append(item)

  /**
   * It removes the item that is at the end of the `ArrayStack`.
   *
   * @return The item that is at the end of the `ArrayStack` before being removed.
   * @throws IllegalStateException If this method is called when the `ArrayStack` is empty.
   */
  override fun pop(): T {
    if (items.size == 0) throw IllegalStateException("pop() method must not be called when this ArrayStack is empty!")
    return items.remove(items.size - 1)
  }

  /**
   * It updates the `item` to the end of the `ArrayStack`.
   *
   * @param item It will be assigned to the end of the `ArrayStack`.
   */
  override fun setEnd(item: T) {
    if (items.size == 0) throw IllegalStateException("setEnd() method must not be called when this ArrayStack is empty!")
    items[items.size - 1] = item
  }

  /**
   * It gets the item that is at the end of the `ArrayStack`.
   *
   * @return The item that is at the end of the `ArrayStack`.
   * @throws IllegalStateException If this method is called when the `ArrayStack` is empty.
   */
  override fun peek(): T {
    if (items.size == 0) throw IllegalStateException("peek() method must not be called when this ArrayStack is empty!")
    return items[items.size - 1]
  }

  /**
   * It removes all items stored in the `ArrayStack`.
   */
  override fun clear() = items.clear()

  override fun hashCode(): Int {
    return items.hashCode()
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as ArrayStack<*>

    if (items != other.items) return false

    return true
  }
}
