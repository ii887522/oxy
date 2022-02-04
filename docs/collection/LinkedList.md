# LinkedList
A `LinkedList` is a collection of items of type `T` linearly placed together without any gaps. It can be either sorted or unsorted and can have duplicate items. It does not place any restrictions on the `LinkedList` when accessing it. The index of the `LinkedList` starts from 0.

`T`: The type of the items stored in the `LinkedList`.

## Table of contents
- [size](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#size)
- [get](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#get)
- [set](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#set)
- [append](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#append)
- [prepend](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#prepend)
- [insert](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#insert)
- [remove](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#remove)
- [removeBack](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#removeBack)
- [removeFront](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#removeFront)
- [clear](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#clear)
- [swap](https://github.com/ii887522/oxy/tree/master/docs/collection/LinkedList.md#swap)

## **size**
```kotlin
val size: Int
```
It retrieves the number of items stored in the `LinkedList`.

It returns the number of items stored in the `LinkedList`.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.append(0)
numbers.append(1)
numbers.append(2)
assertEquals(3, numbers.size)
```
<br />

## **get**
```kotlin
fun get(index: Int): T
```
It retrieves an item at index `index` stored in the `LinkedList`.

`index`: It must be between 0 and the number of items stored in the `LinkedList` - 1.

It returns the item at index `index` stored in the `LinkedList`.

It throws `IllegalArgumentException` if `index` is less than 0 or `index` is greater than or equal to the number of items stored in the `LinkedList`.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.append(0)
numbers.append(1)
numbers.append(2)
assertThrows(IllegalArgumentException::class.java) { numbers[-1] }
assertThrows(IllegalArgumentException::class.java) { numbers[3] }
assertEquals(0, numbers[0])
assertEquals(1, numbers[1])
assertEquals(2, numbers[2])
assertEquals(3, numbers.size)
```
<br />

## **set**
```kotlin
fun set(index: Int, item: T)
```
It replaces an item at index `index` stored in the `LinkedList` based on the `item` given.

`index`: It must be between 0 and the number of items stored in the `LinkedList` - 1.

`item`: It replaces the item at index `index` stored in the `LinkedList`.

It throws `IllegalArgumentException` if `index` is less than 0 or `index` is greater than or equal to the number of items in the `LinkedList`.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.append(0)
numbers.append(1)
numbers.append(2)
assertThrows(IllegalArgumentException::class.java) { numbers[-1] = 3 }
assertThrows(IllegalArgumentException::class.java) { numbers[3] = 3 }
numbers[0] = 3
numbers[1] = 4
numbers[2] = 5
val numberIterator = numbers.iterator()
assertTrue(numberIterator.hasNext())
assertEquals(3, numberIterator.next())
assertTrue(numberIterator.hasNext())
assertEquals(4, numberIterator.next())
assertTrue(numberIterator.hasNext())
assertEquals(5, numberIterator.next())
```
<br />

## **append**
```kotlin
fun append(item: T)
```
It adds the `item` given at the end of the `LinkedList`.

`item`: It will be added to the end of the `LinkedList`.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.append(0)
val numberIterator = numbers.iterator()
assertTrue(numberIterator.hasNext())
assertEquals(0, numberIterator.next())
assertFalse(numberIterator.hasNext())
assertEquals(1, numbers.size)
```
<br />

## **prepend**
```kotlin
fun prepend(item: T)
```
It adds the `item` given at the start of the `LinkedList`.

`item`: It will be added to the start of the `LinkedList`.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.prepend(0)
val numberIterator = numbers.iterator()
assertTrue(numberIterator.hasNext())
assertEquals(0, numberIterator.next())
assertFalse(numberIterator.hasNext())
assertEquals(1, numbers.size)
```
<br />

## **insert**
```kotlin
fun insert(index: Int, item: T)
```
It adds the `item` given at index `index` of the `LinkedList`.

`index`: It must be between 0 and the number of items stored in the `LinkedList`.

`item`: It will be added to the `LinkedList` at index `index`.

It throws `IllegalArgumentException` if `index` is less than 0 or `index` is greater than the number of items in the `LinkedList`.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.append(0)
numbers.append(1)
numbers.append(2)
numbers.insert(0, 3)
numbers.insert(4, 4)
numbers.insert(1, 5)
numbers.insert(2, 6)
numbers.insert(3, 7)
run {
  val numberIterator = numbers.iterator()
  assertTrue(numberIterator.hasNext())
  assertEquals(3, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(5, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(6, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(7, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(0, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(1, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(2, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(4, numberIterator.next())
  assertFalse(numberIterator.hasNext())
  assertEquals(8, numbers.size)
}
```
<br />

## **remove**
```kotlin
fun remove(index: Int): T
```
It removes an item at index `index` stored in the `LinkedList`.

`index`: It must be between 0 and the number of items stored in the `LinkedList` - 1.

It returns the item that will be removed from the `LinkedList`.

It throws `IllegalStateException` If this method is called when the `LinkedList` is empty.

It throws `IllegalArgumentException` If `index` is less than 0 or `index` is greater than or equal to the number of items in the `LinkedList`.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.append(0)
numbers.append(1)
numbers.append(2)
numbers.append(3)
numbers.append(4)
numbers.append(5)
numbers.append(6)
numbers.append(7)
numbers.append(8)
numbers.append(9)
numbers.append(10)
numbers.append(11)
numbers.append(12)
numbers.append(13)
numbers.append(14)
numbers.append(15)
assertEquals(0, numbers.remove(0))
assertEquals(15, numbers.remove(14))
assertEquals(2, numbers.remove(1))
assertEquals(4, numbers.remove(2))
assertEquals(6, numbers.remove(3))
assertEquals(11, numbers.size)
```
<br />

## **removeBack**
```kotlin
fun removeBack(): T
```
It removes the item that is at the end of the `LinkedList`.

It returns the item that will be removed from the `LinkedList`.

It throws `IllegalStateException` If this method is called when the `LinkedList` is empty.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.append(0)
numbers.append(1)
numbers.append(2)
numbers.append(3)
numbers.append(4)
numbers.append(5)
assertEquals(5, numbers.removeBack())
assertEquals(4, numbers.removeBack())
assertEquals(3, numbers.removeBack())
assertEquals(2, numbers.removeBack())
assertEquals(1, numbers.removeBack())
assertEquals(0, numbers.removeBack())
assertFalse(numbers.iterator().hasNext())
assertEquals(0, numbers.size)
```
<br />

## **removeFront**
```kotlin
fun removeFront(): T
```
It removes the item that is at the start of the `LinkedList`.

It returns the item that will be removed from the `LinkedList`.

It throws `IllegalStateException` If this method is called when the `LinkedList` is empty.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.append(0)
numbers.append(1)
numbers.append(2)
numbers.append(3)
numbers.append(4)
numbers.append(5)
assertEquals(0, numbers.removeFront())
assertEquals(1, numbers.removeFront())
assertEquals(2, numbers.removeFront())
assertEquals(3, numbers.removeFront())
assertEquals(4, numbers.removeFront())
assertEquals(5, numbers.removeFront())
assertFalse(numbers.iterator().hasNext())
assertEquals(0, numbers.size)
```
<br />

## **clear**
```kotlin
fun clear()
```
It removes all items stored in the `LinkedList`.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.append(0)
numbers.clear()
assertEquals(0, numbers.size)
```
<br />

## **swap**
```kotlin
fun swap(left: Int, right: Int)
```
It exchanges the positions of two items stored in the `LinkedList` based on `left` and `right` given.

`left`: It must be between 0 and the number of items stored in the `LinkedList` - 1. It must be less than or equal to `right`.

`right`: It must be between 0 and the number of items stored in the `LinkedList` - 1. It must be greater than or equal to `left`.

It throws `IllegalArgumentException` if `left` is less than 0 or `left` is greater than or equal to the number of items stored in the `LinkedList`.

It throws `IllegalArgumentException` if `right` is less than 0 or `right` is greater than or equal to the number of items stored in the `LinkedList`.

It throws `IllegalArgumentException` if `left` is greater than `right`.

### **Example usage:**
```kotlin
val numbers = LinkedList<Int>()
numbers.append(0)
numbers.append(1)
numbers.append(2)
numbers.append(3)
numbers.append(4)
numbers.swap(0, 2)
run {
  val numberIterator = numbers.iterator()
  assertTrue(numberIterator.hasNext())
  assertEquals(2, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(1, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(0, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(3, numberIterator.next())
  assertTrue(numberIterator.hasNext())
  assertEquals(4, numberIterator.next())
  assertFalse(numberIterator.hasNext())
}
```
<br />
