package ii887522.oxy.collection

/**
 * A `LinkedList` is a collection of items of type `T` linearly placed together without any gaps. It can be either sorted or unsorted and can have duplicate items.
 * It does not place any restrictions on the `LinkedList` when accessing it. The index of the `LinkedList` starts from 0.
 *
 * @param T The type of the items stored in the `LinkedList`.
*/
class LinkedList<T> : List<T> {
  private var front: Node<T>? = null
  private var back: Node<T>? = null

  /**
   * It retrieves the number of items stored in the `LinkedList`.
   *
   * @return The number of items stored in the `LinkedList`.
   */
  override var size = 0
    private set

  /**
   * It retrieves an item at index `index` stored in the `LinkedList`.
   *
   * @param index It must be between 0 and the number of items stored in the `LinkedList` - 1.
   * @return The item at index `index` stored in the `LinkedList`.
   * @throws IllegalArgumentException If `index` is less than 0 or `index` is greater than or equal to the number of items stored in the `LinkedList`.
   */
  override fun get(index: Int): T {
    if (index < 0 || index >= size) throw IllegalArgumentException("index must be between 0 and the number of items in this LinkedList (exclusive)!")
    return getNode(index).value
  }

  private fun getNode(index: Int): Node<T> {
    var result = front
    for (j in 0 until index) {
      if (result !== null) result = result.next
    }
    return result!!
  }

  /**
   * It replaces an item at index `index` stored in the `LinkedList` based on the `item` given.
   *
   * @param index It must be between 0 and the number of items stored in the `LinkedList` - 1.
   * @param item It replaces the item at index `index` stored in the `LinkedList`.
   * @throws IllegalArgumentException If `index` is less than 0 or `index` is greater than or equal to the number of items in the `LinkedList`.
   */
  override fun set(index: Int, item: T) {
    if (index < 0 || index >= size) throw IllegalArgumentException("index must be between 0 and the number of items in this LinkedList (exclusive)!")
    getNode(index).value = item
  }

  private fun addWhenEmpty(item: T) {
    back = Node(item)
    front = back
  }

  /**
   * It adds the `item` given at the end of the `LinkedList`.
   *
   * @param item It will be added to the end of the `LinkedList`.
   */
  override fun append(item: T) {
    if (front === null && back === null) addWhenEmpty(item)
    else appendWhenExist(item)
    ++size
  }

  private fun appendWhenExist(item: T) {
    back?.next = Node(item)
    back?.next?.prev = back
    back = back?.next
  }

  /**
   * It adds the `item` given at the start of the `LinkedList`.
   *
   * @param item It will be added to the start of the `LinkedList`.
   */
  override fun prepend(item: T) {
    if (front === null && back === null) addWhenEmpty(item)
    else prependWhenExist(item)
    ++size
  }

  private fun prependWhenExist(item: T) {
    front?.prev = Node(item)
    front?.prev?.next = front
    front = front?.prev
  }

  /**
   * It adds the `item` given at index `index` of the `LinkedList`.
   *
   * @param index It must be between 0 and the number of items stored in the `LinkedList`.
   * @param item It will be added to the `LinkedList` at index `index`.
   * @throws IllegalArgumentException if `index` is less than 0 or `index` is greater than the number of items in the `LinkedList`.
   */
  override fun insert(index: Int, item: T) {
    if (index < 0 || index > size) throw IllegalArgumentException("index must be between 0 and the number of items in this LinkedList (inclusive)!")
    if (index == 0) {
      prepend(item)
      return
    }
    if (index == size) {
      append(item)
      return
    }
    ++size
    val chosenNextNode = getNode(index)
    val node = Node(item)
    node.next = chosenNextNode
    node.prev = chosenNextNode.prev
    node.next?.prev = node
    node.prev?.next = node
  }

  /**
   * It removes an item at index `index` stored in the `LinkedList`.
   *
   * @param index It must be between 0 and the number of items stored in the `LinkedList` - 1.
   * @return The item that will be removed from the `LinkedList`.
   * @throws IllegalStateException If this method is called when the `LinkedList` is empty.
   * @throws IllegalArgumentException If `index` is less than 0 or `index` is greater than or equal to the number of items in the `LinkedList`.
   */
  override fun remove(index: Int): T {
    if (size == 0) throw IllegalStateException("remove() method must not be called when this LinkedList is empty!")
    if (index < 0 || index >= size) throw IllegalArgumentException("index must be between 0 and the number of items in this LinkedList (exclusive)!")
    if (index == 0) return removeFront()
    if (index == size - 1) return removeBack()
    --size
    val chosenNode = getNode(index)
    val item = chosenNode.value
    chosenNode.next?.prev = chosenNode.prev
    chosenNode.prev?.next = chosenNode.next
    return item!!
  }

  private fun removeWhenOnlyOne(): T {
    val item = back?.value
    front = null
    back = null
    return item!!
  }

  /**
   * It removes the item that is at the end of the `LinkedList`.
   *
   * @return The item that will be removed from the `LinkedList`.
   * @throws IllegalStateException If this method is called when the `LinkedList` is empty.
   */
  override fun removeBack(): T {
    if (size == 0) throw IllegalStateException("removeBack() method must not be called when this LinkedList is empty!")
    --size
    return if (front === back) removeWhenOnlyOne() else removeBackWhenMultiple()
  }

  private fun removeBackWhenMultiple(): T {
    back = back?.prev
    val item = back?.next?.value
    back?.next = null
    return item!!
  }

  /**
   * It removes the item that is at the start of the `LinkedList`.
   *
   * @return The item that will be removed from the `LinkedList`.
   * @throws IllegalStateException If this method is called when the `LinkedList` is empty.
   */
  override fun removeFront(): T {
    if (size == 0) throw IllegalStateException("removeFront() method must not be called when this LinkedList is empty!")
    --size
    return if (front === back) removeWhenOnlyOne() else removeFrontWhenMultiple()
  }

  private fun removeFrontWhenMultiple(): T {
    front = front?.next
    val item = front?.prev?.value
    front?.prev = null
    return item!!
  }

  /**
   * It removes all items stored in the `LinkedList`.
   */
  override fun clear() {
    front = null
    back = null
    size = 0
  }

  /**
   * It exchanges the positions of two items stored in the `LinkedList` based on `left` and `right` given.
   *
   * @param left It must be between 0 and the number of items stored in the `LinkedList` - 1. It must be less than or equal to `right`.
   * @param right It must be between 0 and the number of items stored in the `LinkedList` - 1. It must be greater than or equal to `left`.
   * @throws IllegalArgumentException if `left` is less than 0 or `left` is greater than or equal to the number of items stored in the `LinkedList`.
   * @throws IllegalArgumentException if `right` is less than 0 or `right` is greater than or equal to the number of items stored in the `LinkedList`.
   * @throws IllegalArgumentException if `left` is greater than `right`.
   */
  override fun swap(left: Int, right: Int) {
    if (left < 0 || left >= size) throw IllegalArgumentException("left must be between 0 and the number of items stored in the LinkedList - 1!")
    if (right < 0 || right >= size) throw IllegalArgumentException("right must be between 0 and the number of items stored in the LinkedList - 1!")
    if (left > right) throw IllegalArgumentException("left must be less than or equal to right!")
    if (left == right) return
    val leftNode = getNode(left)
    val rightNode = getNode(right)
    val leftAux = leftNode.prev
    val rightAux = leftNode.next
    if (left + 1 == right) {
      if (leftNode.prev != null) leftNode.prev?.next = rightNode
      else front = rightNode
      leftNode.prev = rightNode
      leftNode.next = rightNode.next
      if (rightNode.next != null) rightNode.next?.prev = leftNode
      else back = leftNode
      rightNode.prev = leftAux
      rightNode.next = leftNode
    } else {
      if (leftNode.prev != null) leftNode.prev?.next = rightNode
      else front = rightNode
      leftNode.next?.prev = rightNode
      leftNode.next = rightNode.next
      leftNode.prev = rightNode.prev
      rightNode.prev?.next = leftNode
      if (rightNode.next != null) rightNode.next?.prev = leftNode
      else back = leftNode
      rightNode.next = rightAux
      rightNode.prev = leftAux
    }
  }

  override fun iterator() = object : MutableIterator<T> {
    private var prev: Node<T>? = null
    private var current = front

    override fun hasNext() = current !== null

    override fun next(): T {
      val item = current?.value
      prev = current
      current = current?.next
      return item!!
    }

    override fun remove() {
      if (prev?.prev === null) {
        removeFront()
        prev = null
        return
      }
      if (prev?.next === null) {
        removeBack()
        prev = null
        return
      }
      --size
      prev?.next?.prev = prev?.prev
      prev?.prev?.next = prev?.next
      prev = prev?.prev
    }
  }

  override fun hashCode(): Int {
    var result = front?.hashCode() ?: 0
    result = 31 * result + (back?.hashCode() ?: 0)
    result = 31 * result + size
    return result
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as LinkedList<*>

    if (front != other.front) return false
    if (back != other.back) return false
    if (size != other.size) return false

    return true
  }

  private data class Node<T>(var value: T) {
    var prev: Node<T>? = null
    var next: Node<T>? = null

    override fun hashCode(): Int {
      var result = value?.hashCode() ?: 0
      result = 31 * result + (prev?.hashCode() ?: 0)
      result = 31 * result + (next?.hashCode() ?: 0)
      return result
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) return true
      if (javaClass != other?.javaClass) return false

      other as Node<*>

      if (value != other.value) return false
      if (prev != other.prev) return false
      if (next != other.next) return false

      return true
    }
  }
}
