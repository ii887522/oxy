package ii887522.oxy.collection

import ii887522.oxy.functions.toArray
import ii887522.oxy.struct.Pair
import kotlin.math.max

/**
 * It is a binary search tree that automatically balances itself when operations such as insertions and deletions are applied to maintain the efficiency of all the
 * operations supported in the tree. It allows the user to access objects in the tree in any way. Objects with duplicate keys in the tree are not supported. All
 * objects in the tree must have unique keys. If the user performs an inorder traversal of the tree, then all objects retrieved from the tree are sorted in
 * ascending order by key only.
 */
class AvlTree<K : Comparable<K>, V> : Tree<K, V> {
  private var root: Node<K, V>? = null

  /**
   * It retrieves the number of items stored in the `AvlTree`.
   *
   * @return The number of items stored in the `AvlTree`.
   */
  override var size = 0
    private set

  /**
   * It retrieves all keys that have been stored in the `AvlTree`.
   *
   * @return Keys that are contained inside the `AvlTree`.
   */
  override val keys: List<K> get() {
    val result = ArrayList<K>(max(size, 4))
    for (item in toArrayInorder()) result.append(item.key)
    return result
  }

  /**
   * It allows the user to insert multiple objects at once and update multiple objects by their respective key.
   *
   * @param array The array which contains multiple objects with key and value pair to be inserted and updated.
   */
  override fun putBulk(vararg array: Pair<out K, out V>) {
    for (item in array) set(item.key, item.value)
  }

  /**
   * It allows the user to insert an object with a new `key` and update an existing object by `key`.
   *
   * @param key The key used to identify an object to be inserted or updated.
   * @param value The new value in an object to be inserted or replaces the old value of an existing object.
   */
  override fun set(key: K, value: V) {
    if (root !== null) putFrom(root!!, key, value)
    else addWhenEmpty(key, value)
  }

  private fun putFrom(from: Node<K, V>, key: K, value: V) = when {
    key < from.key -> insertLeft(from, key, value)
    key > from.key -> insertRight(from, key, value)
    else -> from.value = value
  }

  private fun addWhenEmpty(key: K, value: V) {
    root = Node(key, value)
    ++size
  }

  private fun insertLeft(from: Node<K, V>, key: K, value: V) {
    if (from.left !== null) putFrom(from.left!!, key, value)
    else {
      from.left = Node(key, value)
      from.left?.parent = from
      ++size
    }
    from.leftHeight = if (from.left !== null) max(from.left?.leftHeight ?: 0, from.left?.rightHeight ?: 0) + 1 else 0
    if (from.leftHeight - from.rightHeight <= 1) return
    if (from.left!!.leftHeight > from.left!!.rightHeight) rotateRight(from)
    else flipRight(from)
  }

  private fun insertRight(from: Node<K, V>, key: K, value: V) {
    if (from.right !== null) putFrom(from.right!!, key, value)
    else {
      from.right = Node(key, value)
      from.right!!.parent = from
      ++size
    }
    from.rightHeight = if (from.right !== null) max(from.right?.leftHeight ?: 0, from.right?.rightHeight ?: 0) + 1 else 0
    if (from.rightHeight - from.leftHeight <= 1) return
    if (from.right!!.rightHeight > from.right!!.leftHeight) rotateLeft(from)
    else flipLeft(from)
  }

  /**
   * It retrieves the value of an existing object by `key`.
   *
   * @param key The key used to identify an existing object to be retrieved from.
   * @return The value of the requested object or null if the object identified by the given `key` is not found.
   */
  override fun get(key: K): V? = if (root !== null) getNodeFrom(root!!, key)?.value else null

  private tailrec fun getNodeFrom(from: Node<K, V>, key: K): Node<K, V>? = when {
    key < from.key -> if (from.left !== null) getNodeFrom(from.left!!, key) else null
    key > from.key -> if (from.right !== null) getNodeFrom(from.right!!, key) else null
    else -> from
  }

  /**
   * It retrieves the minimum object where the minimum is determined by the minimum key in the tree.
   *
   * @return The requested object or null if the tree does not contain any objects.
   */
  override fun min(): Pair<K, V>? {
    if (root === null) return null
    val result = minNodeFrom(root!!)
    return Pair(result.key, result.value)
  }

  private fun minNodeFrom(from: Node<K, V>): Node<K, V> {
    var result = from
    while (result.left !== null) result = result.left!!
    return result
  }

  /**
   * It retrieves the maximum object where the maximum is determined by the maximum key in the tree.
   *
   * @return The requested object or null if the tree does not contain any objects.
   */
  override fun max(): Pair<K, V>? {
    if (root === null) return null
    val result = maxNodeFrom(root!!)
    return Pair(result.key, result.value)
  }

  private fun maxNodeFrom(from: Node<K, V>): Node<K, V> {
    var result = from
    while (result.right !== null) result = result.right!!
    return result
  }

  /**
   * It removes multiple objects by their respective `key`. No objects will be removed from the tree if all the `key` received is not found in the tree.
   *
   * @param keys The keys used to identify multiple objects in the tree.
   */
  override fun removeBulk(vararg keys: K) {
    for (key in keys) remove(key)
  }

  /**
   * It removes an existing object by `key`. No objects will be removed from the tree if the `key` received is not found in the tree.
   *
   * @param key The key used to identify an existing object in the tree.
   * @return The existing object that is removed from the tree.
   */
  override fun remove(key: K): V? {
    if (root === null) return null
    val target = getNodeFrom(root!!, key)
    if (target === null) return null
    val alternate = when {
      target.left !== null -> maxNodeFrom(target.left!!)
      target.right !== null -> minNodeFrom(target.right!!)
      else -> null
    }
    val startNodeToRefresh = when {
      alternate === null -> target.parent
      alternate.parent === target -> alternate
      else -> alternate.parent
    }
    if (alternate !== null) {
      if (alternate.parent !== target) {
        if (alternate.left !== null) alternate.left?.parent = alternate.parent
        else if (alternate.right !== null) alternate.right?.parent = alternate.parent
        if (alternate.parent?.left === alternate) alternate.parent?.left = alternate.right
        else if (alternate.parent?.right === alternate) alternate.parent?.right = alternate.left
      }
      if (target.left !== alternate) alternate.left = target.left
      if (target.right !== alternate) alternate.right = target.right
      alternate.parent = target.parent
    }
    if (target.left !== alternate && target.left !== null) target.left?.parent = alternate
    if (target.right !== alternate && target.right !== null) target.right?.parent = alternate
    if (target.parent !== null) {
      if (target.parent?.left === target) target.parent?.left = alternate
      else target.parent?.right = alternate
    } else root = alternate
    target.left = null
    target.right = null
    target.parent = null
    refresh(startNodeToRefresh)
    --size
    return target.value
  }

  private fun refresh(start: Node<K, V>?) {
    var current = start
    while (current !== null) {
      current.leftHeight = if (current.left !== null) max(current.left?.leftHeight ?: 0, current.left?.rightHeight ?: 0) + 1 else 0
      current.rightHeight = if (current.right !== null) max(current.right?.leftHeight ?: 0, current.right?.rightHeight ?: 0) + 1 else 0
      if (current.leftHeight - current.rightHeight > 1) {
        if (current.left!!.leftHeight > current.left!!.rightHeight) rotateRight(current)
        else flipRight(current)
      } else if (current.rightHeight - current.leftHeight > 1) {
        if (current.right!!.rightHeight > current.right!!.leftHeight) rotateLeft(current)
        else flipLeft(current)
      }
      current = current.parent
    }
  }

  private fun rotateRight(from: Node<K, V>) {
    val fromParent = from.parent
    val isFromParentLeft = fromParent?.left === from
    if (fromParent !== null) {
      if (isFromParentLeft) fromParent.left = from.left
      else fromParent.right = from.left
    } else root = from.left
    val node = from.left?.right
    from.left = node
    from.parent = when {
      fromParent === null -> root
      isFromParentLeft -> fromParent.left
      else -> fromParent.right
    }
    from.leftHeight = if (from.left !== null) max(from.left?.leftHeight ?: 0, from.left?.rightHeight ?: 0) + 1 else 0
    from.parent?.right = from
    from.parent?.parent = fromParent
    from.parent?.rightHeight = max(from.leftHeight, from.rightHeight) + 1
    if (node !== null) node.parent = from
  }

  private fun flipRight(from: Node<K, V>) {
    val fromParent = from.parent
    val isFromParentLeft = fromParent?.left === from
    if (fromParent !== null) {
      if (isFromParentLeft) fromParent.left = from.left?.right
      else fromParent.right = from.left?.right
    } else root = from.left?.right
    val leftNode = from.left?.right?.left
    val rightNode = from.left?.right?.right
    from.left = rightNode
    from.parent = when {
      fromParent === null -> root
      isFromParentLeft -> fromParent.left
      else -> fromParent.right
    }
    from.leftHeight = if (rightNode !== null) max(rightNode.leftHeight, rightNode.rightHeight) + 1 else 0
    from.parent?.left = from.parent?.parent
    from.parent?.right = from
    from.parent?.parent = fromParent
    from.parent?.left?.right = leftNode
    from.parent?.left?.parent = from.parent
    from.parent?.left?.rightHeight = if (leftNode !== null) max(leftNode.leftHeight, leftNode.rightHeight) + 1 else 0
    from.parent?.leftHeight = max(from.parent?.left?.leftHeight ?: 0, from.parent?.left?.rightHeight ?: 0) + 1
    from.parent?.rightHeight = max(from.leftHeight, from.rightHeight) + 1
    if (leftNode !== null) leftNode.parent = from.parent?.left
    if (rightNode !== null) rightNode.parent = from
  }

  private fun rotateLeft(from: Node<K, V>) {
    val fromParent = from.parent
    val isFromParentRight = fromParent?.right === from
    if (fromParent !== null) {
      if (isFromParentRight) fromParent.right = from.right
      else fromParent.left = from.right
    } else root = from.right
    val node = from.right?.left
    from.right = node
    from.parent = when {
      fromParent === null -> root
      isFromParentRight -> fromParent.right
      else -> fromParent.left
    }
    from.rightHeight = if (from.right !== null) max(from.right?.leftHeight ?: 0, from.right?.rightHeight ?: 0) + 1 else 0
    from.parent?.left = from
    from.parent?.parent = fromParent
    from.parent?.leftHeight = max(from.leftHeight, from.rightHeight) + 1
    if (node !== null) node.parent = from
  }

  private fun flipLeft(from: Node<K, V>) {
    val fromParent = from.parent
    val isFromParentRight = fromParent?.right === from
    if (fromParent !== null) {
      if (isFromParentRight) fromParent.right = from.right?.left
      else fromParent.left = from.right?.left
    } else root = from.right?.left
    val leftNode = from.right?.left?.left
    val rightNode = from.right?.left?.right
    from.right = leftNode
    from.parent = when {
      fromParent === null -> root
      isFromParentRight -> fromParent.right
      else -> fromParent.left
    }
    from.rightHeight = if (leftNode !== null) max(leftNode.leftHeight, leftNode.rightHeight) + 1 else 0
    from.parent?.left = from
    from.parent?.right = from.parent?.parent
    from.parent?.parent = fromParent
    from.parent?.right?.left = rightNode
    from.parent?.right?.parent = from.parent
    from.parent?.right?.leftHeight = if (rightNode !== null) max(rightNode.leftHeight, rightNode.rightHeight) + 1 else 0
    from.parent?.leftHeight = max(from.leftHeight, from.rightHeight) + 1
    from.parent?.rightHeight = max(from.parent?.right?.leftHeight ?: 0, from.parent?.right?.rightHeight ?: 0) + 1
    if (leftNode !== null) leftNode.parent = from
    if (rightNode !== null) rightNode.parent = from.parent?.right
  }

  /**
   * It allows the user to convert the tree into an array by performing a preorder traversal of the tree and retrieves each object visited and stored them in an
   * array and returns it.
   *
   * @return An array that contains objects from the tree.
   */
  override fun toArrayPreorder() = if (root !== null) toArrayPreorderFrom(root!!) else arrayOf()

  private fun toArrayPreorderFrom(from: Node<K, V>): Array<Pair<K, V>> {
    val result = ArrayList<Pair<K, V>>()
    result.append(Pair(from.key, from.value))
    if (from.left !== null) result.appendBulk(*toArrayPreorderFrom(from.left!!))
    if (from.right !== null) result.appendBulk(*toArrayPreorderFrom(from.right!!))
    return result.toArray()
  }

  /**
   * It allows the user to convert the tree into an array by performing an inorder traversal of the tree and retrieves each object visited and stored them in an
   * array and returns it.
   *
   * @return An array that contains objects from the tree sorted in ascending order by key.
   */
  override fun toArrayInorder() = if (root !== null) toArrayInorderFrom(root!!) else arrayOf()

  private fun toArrayInorderFrom(from: Node<K, V>): Array<Pair<K, V>> {
    val result = ArrayList<Pair<K, V>>()
    if (from.left !== null) result.appendBulk(*toArrayInorderFrom(from.left!!))
    result.append(Pair(from.key, from.value))
    if (from.right !== null) result.appendBulk(*toArrayInorderFrom(from.right!!))
    return result.toArray()
  }

  /**
   * It allows the user to convert the tree into an array by performing a postorder traversal of the tree and retrieves each object visited and stored them in an
   * array and returns it.
   *
   * @return An array that contains objects from the tree.
   */
  override fun toArrayPostorder() = if (root !== null) toArrayPostorderFrom(root!!) else arrayOf()

  private fun toArrayPostorderFrom(from: Node<K, V>): Array<Pair<K, V>> {
    val result = ArrayList<Pair<K, V>>()
    if (from.left !== null) result.appendBulk(*toArrayPostorderFrom(from.left!!))
    if (from.right !== null) result.appendBulk(*toArrayPostorderFrom(from.right!!))
    result.append(Pair(from.key, from.value))
    return result.toArray()
  }

  /**
   * It removes all items stored in the `AvlTree`.
   */
  override fun clear() {
    root = null
    size = 0
  }

  override fun hashCode(): Int {
    var result = root?.hashCode() ?: 0
    result = 31 * result + size
    return result
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as AvlTree<*, *>

    if (root != other.root) return false
    if (size != other.size) return false

    return true
  }

  private data class Node<K, V>(val key: K, var value: V) {
    var left: Node<K, V>? = null
    var right: Node<K, V>? = null
    var parent: Node<K, V>? = null
    var leftHeight = 0
    var rightHeight = 0
  }
}
