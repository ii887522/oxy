package ii887522.oxy.collection

import ii887522.oxy.struct.Pair

/**
 * It is a binary search tree that allows the user to access objects in the tree in any way. Objects with duplicate keys in the tree are not supported. All
 * objects in the tree must have unique keys. If the user performs an inorder traversal of the tree, then all objects retrieved from the tree are sorted in ascending
 * order by key only.
 */
interface Tree<K : Comparable<K>, V> : Map<K, V> {
  /**
   * It allows the user to insert multiple objects at once and update multiple objects by their respective key.
   *
   * @param array The array which contains multiple objects with key and value pair to be inserted and updated.
   */
  fun putBulk(vararg array: Pair<out K, out V>)

  /**
   * It retrieves the minimum object where the minimum is determined by the minimum key in the tree.
   *
   * @return The requested object or null if the tree does not contain any objects.
   */
  fun min(): Pair<K, V>?

  /**
   * It retrieves the maximum object where the maximum is determined by the maximum key in the tree.
   *
   * @return The requested object or null if the tree does not contain any objects.
   */
  fun max(): Pair<K, V>?

  /**
   * It removes multiple objects by their respective `key`. No objects will be removed from the tree if all the `key` received is not found in the tree.
   *
   * @param keys The keys used to identify multiple objects in the tree.
   */
  fun removeBulk(vararg keys: K)

  /**
   * It allows the user to convert the tree into an array by performing a preorder traversal of the tree and retrieves each object visited and stored them in an
   * array and returns it.
   *
   * @return An array that contains objects from the tree.
   */
  fun toArrayPreorder(): Array<Pair<K, V>>

  /**
   * It allows the user to convert the tree into an array by performing an inorder traversal of the tree and retrieves each object visited and stored them in an
   * array and returns it.
   *
   * @return An array that contains objects from the tree sorted in ascending order by key.
   */
  fun toArrayInorder(): Array<Pair<K, V>>

  /**
   * It allows the user to convert the tree into an array by performing a postorder traversal of the tree and retrieves each object visited and stored them in an
   * array and returns it.
   *
   * @return An array that contains objects from the tree.
   */
  fun toArrayPostorder(): Array<Pair<K, V>>
}
