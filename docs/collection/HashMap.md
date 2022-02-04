# HashMap
A `HashMap` is a collection of items with key of type `K` and value of type `V`. It can be either sorted or unsorted but cannot have items with same keys although items can have same values. It does not place any restrictions on the `HashMap` when accessing it.

```kotlin
class HashMap<K, V> @JvmOverloads constructor(initialCapacity: Int = 32) : Map<K, V>
```
`K`: The type of the key of the items stored in `Map`.

`V`: The type of the value of the items stored in `Map`.

`initialCapacity`: The initial size of the internal backing array used to maintain items. It must be at least 4.

It throws `IllegalArgumentException` if `initialCapacity` is less than 4.

## Table of contents
- [size](https://github.com/ii887522/oxy/tree/master/docs/collection/HashMap.md#size)
- [keys](https://github.com/ii887522/oxy/tree/master/docs/collection/HashMap.md#keys)
- [set](https://github.com/ii887522/oxy/tree/master/docs/collection/HashMap.md#set)
- [remove](https://github.com/ii887522/oxy/tree/master/docs/collection/HashMap.md#remove)
- [get](https://github.com/ii887522/oxy/tree/master/docs/collection/HashMap.md#get)
- [clear](https://github.com/ii887522/oxy/tree/master/docs/collection/HashMap.md#clear)

## **size**
```kotlin
val size: Int
```
It retrieves the number of items stored in the `HashMap`.

It returns the number of items stored in the `HashMap`.

### **Example usage:**
```kotlin
val map = HashMap<String, Int>(4)
assertEquals(0, map.size)
```
<br />

## **keys**
```kotlin
val keys: List<K>
```
It retrieves all keys that have been stored in the `HashMap`.

It returns keys that are contained inside the `HashMap`.

### **Example usage:**
```kotlin
val keys = HashMap<String, Int>(4).keys.toArray()
keys.sort()
assertArrayEquals(arrayOf(), keys)
```
<br />

## **set**
```kotlin
fun set(key: K, value: V)
```
It inserts or updates an item stored in the `HashMap` based on the `key` and `value` given.

`key`: It will be used for finding this item in the future.

`value`: It will be inserted or updated to the `HashMap`.

### **Example usage:**
```kotlin
val map = HashMap<String, Int>(4)
map["a"] = 0
assertEquals(0, map["a"]!!.toInt())
assertEquals(1, map.size)
```
<br />

## **remove**
```kotlin
fun remove(key: K): V?
```
It removes an item stored in the `HashMap` with the matching `key`.

`key`: It will be used to remove a matching item.

It returns a value that is belongs to the item with the matching `key`. `null` if the `key` does not match any item.

### **Example usage:**
```kotlin
val map = HashMap<String, Int>(4)
map["a"] = 0
map["b"] = 1
map["c"] = 2
map["d"] = 3
assertEquals(1, map.remove("b")!!.toInt())
assertEquals(3, map.remove("d")!!.toInt())
assertEquals(0, map.remove("a")!!.toInt())
assertEquals(1, map.size)
assertNull(map.remove("e"))
assertEquals(2, map.remove("c")!!.toInt())
assertEquals(0, map.size)
```
<br />

## **get**
```kotlin
fun get(key: K): V?
```
Retrieves a value that is belongs to the item with the matching `key` in the `HashMap`.

`key`: It will be used to retrieve a matching item.

It returns a value that is belongs to the item with the matching `key`. `null` if the `key` does not match any item.

### **Example usage:**
```kotlin
val map = HashMap<String, Int>(4)
map["a"] = 0
assertEquals(0, map["a"]!!.toInt())
```
<br />

## **clear**
```kotlin
fun clear()
```
It removes all items stored in the `HashMap`.

### **Example usage:**
```kotlin
val map = HashMap<String, Int>(4)
map["a"] = 1
map.clear()
assertEquals(0, map.size)
```
<br />
