package ii887522.oxy.collection

/**
 * A `Stack` is a collection of items of type `T` linearly placed together without any gaps. It can be either sorted or unsorted and can have duplicate items.
 * However, users are only allowed to add, remove, get or set the item that is at the end of the `Stack`.
 *
 * @param T The type of the items stored in the `Stack`.
 */
interface Stack<T> : Collection {
  /**
   * It adds the `item` to the end of the `Stack`.
   *
   * @param item It will be added to the end of the `Stack`.
   */
  fun push(item: T)

  /**
   * It removes the item that is at the end of the `Stack`.
   *
   * @return The item that is at the end of the `Stack` before being removed.
   * @throws IllegalStateException If this method is called when the `Stack` is empty.
   */
  fun pop(): T

  /**
   * It updates the `item` to the end of the `Stack`.
   *
   * @param item It will be assigned to the end of the `Stack`.
   */
  fun setEnd(item: T)

  /**
   * It gets the item that is at the end of the `Stack`.
   *
   * @return The item that is at the end of the `Stack`.
   * @throws IllegalStateException If this method is called when the `Stack` is empty.
   */
  fun peek(): T
}
