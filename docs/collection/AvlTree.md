# AvlTree
It is a binary search tree that automatically balances itself when operations such as insertions and deletions are applied to maintain the efficiency of all the operations supported in the tree. It allows the user to access objects in the tree in any way. Objects with duplicate keys in the tree are not supported. All objects in the tree must have unique keys. If the user performs an inorder traversal of the tree, then all objects retrieved from the tree are sorted in ascending order by key only.

## Table of contents
- [size](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#size)
- [keys](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#keys)
- [putBulk](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#putBulk)
- [set](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#set)
- [get](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#get)
- [min](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#min)
- [max](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#max)
- [removeBulk](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#removeBulk)
- [remove](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#remove)
- [toArrayPreorder](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#toArrayPreorder)
- [toArrayInorder](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#toArrayInorder)
- [toArrayPostorder](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#toArrayPostorder)
- [clear](https://github.com/ii887522/oxy/tree/master/docs/collection/AvlTree.md#clear)

## **size**
```kotlin
val size: Int
```
It retrieves the number of items stored in the `AvlTree`.

It returns the number of items stored in the `AvlTree`.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
assertEquals(0, tree.size)
```
<br />

## **keys**
```kotlin
val keys: List<K>
```
It retrieves all keys that have been stored in the `AvlTree`.

It returns keys that are contained inside the `AvlTree`.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree[0f] = "a"
tree[1f] = "b"
tree[2f] = "c"
assertArrayEquals(arrayOf(0f, 1f, 2f), tree.keys.toArray())
```
<br />

## **putBulk**
```kotlin
fun putBulk(vararg array: Pair<out K, out V>)
```
It allows the user to insert multiple objects at once and update multiple objects by their respective key.

`array`: The array which contains multiple objects with key and value pair to be inserted and updated.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree.putBulk(
  Pair(0f, "a"),
  Pair(1f, "b"),
  Pair(2f, "c"),
  Pair(3f, "d"),
  Pair(4f, "e"),
  Pair(5f, "f"),
  Pair(6f, "g"),
  Pair(7f, "h"),
  Pair(8f, "i"),
  Pair(9f, "j"),
  Pair(10f, "k"),
  Pair(11f, "l"),
  Pair(12f, "m"),
  Pair(13f, "n"),
  Pair(14f, "o"),
  Pair(15f, "p"),
  Pair(16f, "q"),
  Pair(17f, "r"),
  Pair(18f, "s"),
  Pair(19f, "t"),
  Pair(20f, "u"),
  Pair(21f, "v"),
  Pair(22f, "w"),
  Pair(23f, "x"),
  Pair(24f, "y"),
  Pair(25f, "z"),
  Pair(26f, "aa"),
  Pair(27f, "ab"),
  Pair(28f, "ac"),
  Pair(29f, "ad"),
  Pair(30f, "ae"),
  Pair(31f, "af")
)
assertEquals("a", tree[0f])
assertEquals("b", tree[1f])
assertEquals("c", tree[2f])
assertEquals("d", tree[3f])
assertEquals("e", tree[4f])
assertEquals("f", tree[5f])
assertEquals("g", tree[6f])
assertEquals("h", tree[7f])
assertEquals("i", tree[8f])
assertEquals("j", tree[9f])
assertEquals("k", tree[10f])
assertEquals("l", tree[11f])
assertEquals("m", tree[12f])
assertEquals("n", tree[13f])
assertEquals("o", tree[14f])
assertEquals("p", tree[15f])
assertEquals("q", tree[16f])
assertEquals("r", tree[17f])
assertEquals("s", tree[18f])
assertEquals("t", tree[19f])
assertEquals("u", tree[20f])
assertEquals("v", tree[21f])
assertEquals("w", tree[22f])
assertEquals("x", tree[23f])
assertEquals("y", tree[24f])
assertEquals("z", tree[25f])
assertEquals("aa", tree[26f])
assertEquals("ab", tree[27f])
assertEquals("ac", tree[28f])
assertEquals("ad", tree[29f])
assertEquals("ae", tree[30f])
assertEquals("af", tree[31f])
assertEquals(32, tree.size)
```
<br />

## **set**
```kotlin
fun set(key: K, value: V)
```
It allows the user to insert an object with a new `key` and update an existing object by `key`.

`key`: The key used to identify an object to be inserted or updated.

`value`: The new value in an object to be inserted or replaces the old value of an existing object.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree[0f] = "a"
assertEquals("a", tree[0f])
assertEquals(1, tree.size)
```
<br />

## **get**
```kotlin
fun get(key: K): V?
```
It retrieves the value of an existing object by `key`.

`key`: The key used to identify an existing object to be retrieved from.

It returns the value of the requested object or null if the object identified by the given `key` is not found.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree[0f] = "a"
assertEquals("a", tree[0f])
```
<br />

## **min**
```kotlin
fun min(): Pair<K, V>?
```
It retrieves the minimum object where the minimum is determined by the minimum key in the tree.

It returns the requested object or null if the tree does not contain any objects.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree[2f] = "a"
tree[1f] = "b"
tree[0f] = "c"
tree[3f] = "d"
tree[4f] = "e"
assertEquals(Pair(0f, "c"), tree.min())
```
<br />

## **max**
```kotlin
fun max(): Pair<K, V>?
```
It retrieves the maximum object where the maximum is determined by the maximum key in the tree.

It returns the requested object or null if the tree does not contain any objects.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree[2f] = "a"
tree[1f] = "b"
tree[0f] = "c"
tree[3f] = "d"
tree[4f] = "e"
assertEquals(Pair(0f, "c"), tree.max())
```
<br />

## **removeBulk**
```kotlin
fun removeBulk(vararg keys: K)
```
It removes multiple objects by their respective `key`. No objects will be removed from the tree if all the `key` received is not found in the tree.

`keys`: The keys used to identify multiple objects in the tree.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree[0f] = "a"
tree[1f] = "b"
tree[2f] = "c"
tree[3f] = "d"
tree[4f] = "e"
tree[5f] = "f"
tree[6f] = "g"
tree[7f] = "h"
tree[8f] = "i"
tree[9f] = "j"
tree[10f] = "k"
tree[11f] = "l"
tree[12f] = "m"
tree[13f] = "n"
tree[14f] = "o"
tree[15f] = "p"
tree[16f] = "q"
tree[17f] = "r"
tree[18f] = "s"
tree[19f] = "t"
tree[20f] = "u"
tree[21f] = "v"
tree[22f] = "w"
tree[23f] = "x"
tree[24f] = "y"
tree[25f] = "z"
tree[26f] = "aa"
tree[27f] = "ab"
tree[28f] = "ac"
tree[29f] = "ad"
tree[30f] = "ae"
tree[31f] = "af"
tree.removeBulk(
  0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f, 11f, 12f, 13f, 14f, 15f, 16f, 17f, 18f, 19f, 20f, 21f, 22f, 23f, 24f, 25f, 26f, 27f, 28f, 29f, 30f, 31f
)
assertNull(tree[0f])
assertNull(tree[1f])
assertNull(tree[2f])
assertNull(tree[3f])
assertNull(tree[4f])
assertNull(tree[5f])
assertNull(tree[6f])
assertNull(tree[7f])
assertNull(tree[8f])
assertNull(tree[9f])
assertNull(tree[10f])
assertNull(tree[11f])
assertNull(tree[12f])
assertNull(tree[13f])
assertNull(tree[14f])
assertNull(tree[15f])
assertNull(tree[16f])
assertNull(tree[17f])
assertNull(tree[18f])
assertNull(tree[19f])
assertNull(tree[20f])
assertNull(tree[21f])
assertNull(tree[22f])
assertNull(tree[23f])
assertNull(tree[24f])
assertNull(tree[25f])
assertNull(tree[26f])
assertNull(tree[27f])
assertNull(tree[28f])
assertNull(tree[29f])
assertNull(tree[30f])
assertNull(tree[31f])
assertEquals(0, tree.size)
```
<br />

## **remove**
```kotlin
fun remove(key: K): V?
```
It removes an existing object by `key`. No objects will be removed from the tree if the `key` received is not found in the tree.

`key`: The key used to identify an existing object in the tree.

It returns the existing object that is removed from the tree.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree[0f] = "e"
tree[8f] = "f"
tree[16f] = "g"
tree[-8f] = "h"
tree[-16f] = "i"
tree[4f] = "j"
tree[24f] = "k"
tree[20f] = "l"
tree[-12f] = "m"
tree[-14f] = "n"
tree[-13f] = "o"
tree[-10f] = "p"
tree[-11f] = "q"
tree[-11.5f] = "r"
tree[-10.5f] = "s"
tree[-11.75f] = "t"
tree[-11.625f] = "u"
tree[-20f] = "v"
tree[-18f] = "w"
tree[-13.5f] = "x"
tree[-13.25f] = "y"
tree[18f] = "z"
tree[2f] = "aa"
tree[6f] = "ab"
tree[10f] = "ac"
tree[12f] = "ad"
tree[14f] = "ae"
tree[17f] = "af"
tree[19f] = "ag"
tree[22f] = "ah"
tree[26f] = "ai"
tree[15f] = "aj"
assertEquals("e", tree.remove(0f))
assertNull(tree[0f])
assertEquals("f", tree[8f])
assertEquals("g", tree[16f])
assertEquals("h", tree[-8f])
assertEquals("i", tree[-16f])
assertEquals("j", tree[4f])
assertEquals("k", tree[24f])
assertEquals("l", tree[20f])
assertEquals("m", tree[-12f])
assertEquals("n", tree[-14f])
assertEquals("o", tree[-13f])
assertEquals("p", tree[-10f])
assertEquals("q", tree[-11f])
assertEquals("r", tree[-11.5f])
assertEquals("s", tree[-10.5f])
assertEquals("t", tree[-11.75f])
assertEquals("u", tree[-11.625f])
assertEquals("v", tree[-20f])
assertEquals("w", tree[-18f])
assertEquals("x", tree[-13.5f])
assertEquals("y", tree[-13.25f])
assertEquals("z", tree[18f])
assertEquals("aa", tree[2f])
assertEquals("ab", tree[6f])
assertEquals("ac", tree[10f])
assertEquals("ad", tree[12f])
assertEquals("ae", tree[14f])
assertEquals("af", tree[17f])
assertEquals("ag", tree[19f])
assertEquals("ah", tree[22f])
assertEquals("ai", tree[26f])
assertEquals("aj", tree[15f])
assertEquals(31, tree.size)
assertEquals("f", tree.remove(8f))
```
<br />

## **toArrayPreorder**
```kotlin
fun toArrayPreorder(): Array<Pair<K, V>>
```
It allows the user to convert the tree into an array by performing a preorder traversal of the tree and retrieves each object visited and stored them in an array and returns it.

It returns an array that contains objects from the tree.

### **Example usage:**
```kotlin
val tree = AvlTree<Int, String>()
tree[1] = "a"
tree[0] = "b"
tree[2] = "c"
tree[3] = "d"
tree[4] = "e"
assertArrayEquals(arrayOf(Pair(1, "a"), Pair(0, "b"), Pair(3, "d"), Pair(2, "c"), Pair(4, "e")), tree.toArrayPreorder())
```
<br />

## **toArrayInorder**
```kotlin
fun toArrayInorder(): Array<Pair<K, V>>
```
It allows the user to convert the tree into an array by performing an inorder traversal of the tree and retrieves each object visited and stored them in an array and returns it.

It returns an array that contains objects from the tree sorted in ascending order by key.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree[1f] = "a"
tree[0f] = "b"
tree[2f] = "c"
tree[3f] = "d"
tree[4f] = "e"
assertArrayEquals(arrayOf(Pair(0f, "b"), Pair(1f, "a"), Pair(2f, "c"), Pair(3f, "d"), Pair(4f, "e")), tree.toArrayInorder())
```
<br />

## **toArrayPostorder**
```kotlin
fun toArrayPostorder(): Array<Pair<K, V>>
```
It allows the user to convert the tree into an array by performing a postorder traversal of the tree and retrieves each object visited and stored them in an array and returns it.

It returns an array that contains objects from the tree.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree[1f] = "a"
tree[0f] = "b"
tree[2f] = "c"
tree[3f] = "d"
tree[4f] = "e"
assertArrayEquals(arrayOf(Pair(0f, "b"), Pair(2f, "c"), Pair(4f, "e"), Pair(3f, "d"), Pair(1f, "a")), tree.toArrayPostorder())
```
<br />

## **clear**
```kotlin
fun clear()
```
It removes all items stored in the `AvlTree`.

### **Example usage:**
```kotlin
val tree = AvlTree<Float, String>()
tree[1f] = "a"
tree.clear()
assertEquals(0, tree.size)
```
<br />
