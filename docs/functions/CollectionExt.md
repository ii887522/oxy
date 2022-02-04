# CollectionExt

## Table of contents
- [swap](https://github.com/ii887522/oxy/tree/master/docs/functions/CollectionExt.md#swap)
- [sort](https://github.com/ii887522/oxy/tree/master/docs/functions/CollectionExt.md#sort)
- [List\<T\>.toArray](https://github.com/ii887522/oxy/tree/master/docs/functions/CollectionExt.md#listttoArray)
- [Map<K, V>.toArray](https://github.com/ii887522/oxy/tree/master/docs/functions/CollectionExt.md#mapk-vtoarray)

## **swap**
```kotlin
fun <T> Array<T>.swap(leftIndex: Int, rightIndex: Int)
```
It exchanges objects that are inside the array.

`leftIndex`: The index which identifies the left object to be moved.

`rightIndex`: The index which identifies the right object to be moved.

### **Example usage:**
```kotlin
val array = arrayOf(0, 1)
array.swap(0, 1)
assertArrayEquals(arrayOf(1, 0), array)
```
<br />

## **sort**
```kotlin
inline fun <reified T : Comparable<T>> Array<T>.sort(compare: (left: T, right: T) -> Boolean = { left, right -> left > right })
```
It sorts the array by using tim sort.

`compare`: The function used to determine whether the positions of both elements should be swapped during sorting. If the function returns true, both elements will be swapped, otherwise nothing happens.

### **Example usage:**
```kotlin
val numbers = arrayOf(2, 1, 0)
numbers.sort()
assertArrayEquals(arrayOf(0, 1, 2), numbers)
```
<br />

## **List\<T\>.toArray**
```kotlin
inline fun <reified T> List<T>.toArray(): Array<T>
```
It copies the items in the `List` and converts it into a fixed size array.

It returns the fixed size array that contains all the items stored in the `List`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Pair<Int, String>>()
numbers.append(Pair(0, "a"))
numbers.append(Pair(1, "b"))
numbers.append(Pair(2, "c"))
assertArrayEquals(arrayOf(Pair(0, "a"), Pair(1, "b"), Pair(2, "c")), numbers.toArray())
```
<br />

## **Map<K, V>.toArray**
```kotlin
inline fun <reified K : Comparable<K>, reified V> Map<K, V>.toArray(): Array<Pair<K, V>>
```
It copies the items in the `Map` and converts it into a fixed size array that is sorted by keys.

It returns the fixed size sorted array that contains all the items stored in the `Map`.

### **Example usage:**
```kotlin
val map = HashMap<String, Int>(4)
map["a"] = 0
map["b"] = 1
map["c"] = 2
assertArrayEquals(arrayOf(Pair("a", 0), Pair("b", 1), Pair("c", 2)), map.toArray())
```
<br />
