# ArrayList
An `ArrayList` is a collection of items of type `T` linearly placed together without any gaps. It can be either sorted or unsorted and can have duplicate items. It does not place any restrictions on the `ArrayList` when accessing it. The index of the `ArrayList` starts from 0.

```kotlin
class ArrayList<T> @JvmOverloads constructor(initialCapacity: Int = 32) : List<T>
```
`T`: The type of the items stored in the `ArrayList`.

`initialCapacity`: The initial size of the internal backing array used to maintain items. It must be at least 4.

It throws `IllegalArgumentException` if `initialCapacity` is less than 4.

## Table of contents
- [size](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#size)
- [get](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#get)
- [set](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#set)
- [appendBulk](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#appendBulk)
- [append](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#append)
- [prependBulk](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#prependBulk)
- [prepend](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#prepend)
- [insert](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#insert)
- [remove](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#remove)
- [removeBack](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#removeBack)
- [removeFront](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#removeFront)
- [clear](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#clear)
- [shuffle](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#shuffle)
- [swap](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayList.md#swap)

## **size**
```kotlin
val size: Int
```
It retrieves the number of items stored in the `ArrayList`.

It returns the number of items stored in the `ArrayList`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
assertEquals(0, numbers.size)
```
<br />

## **get**
```kotlin
fun get(index: Int): T
```
It retrieves an item at index `index` stored in the `ArrayList`.

`index`: It must be between 0 and the number of items stored in the `ArrayList` - 1.

It returns the item at index `index` stored in the `ArrayList`.

It throws `IllegalArgumentException` if `index` is less than 0 or `index` is greater than or equal to the number of items stored in the `ArrayList`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
numbers.append(0)
assertEquals(0, numbers[0])
```
<br />

## **set**
```kotlin
fun set(index: Int, item: T)
```
It replaces an item at index `index` stored in the `ArrayList` based on the `item` given.

`index`: It must be between 0 and the number of items stored in the `ArrayList` - 1.

`item`: It replaces the item at index `index` stored in the `ArrayList`.

It throws `IllegalArgumentException` if `index` is less than 0 or `index` is greater than or equal to the number of items in the `ArrayList`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
numbers.append(0)
numbers[0] = 45
assertEquals(45, numbers[0])
```
<br />

## **appendBulk**
```kotlin
fun appendBulk(vararg items: T)
```
It adds multiple `items` given at the end of the `List`.

`items`: It will be added to the end of the `List`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
numbers.appendBulk(
  0,
  1,
  2,
  3,
  4,
  5,
  6,
  7,
  8,
  9,
  10,
  11,
  12,
  13,
  14,
  15,
  16,
  17,
  18,
  19,
  20,
  21,
  22,
  23,
  24,
  25,
  26,
  27,
  28,
  29,
  30,
  31,
  32,
  33,
  34,
  35,
  36,
  37,
  38,
  39,
  40,
  41,
  42,
  43,
  44
)
assertEquals(0, numbers[0])
assertEquals(1, numbers[1])
assertEquals(2, numbers[2])
assertEquals(3, numbers[3])
assertEquals(4, numbers[4])
assertEquals(5, numbers[5])
assertEquals(6, numbers[6])
assertEquals(7, numbers[7])
assertEquals(8, numbers[8])
assertEquals(9, numbers[9])
assertEquals(10, numbers[10])
assertEquals(11, numbers[11])
assertEquals(12, numbers[12])
assertEquals(13, numbers[13])
assertEquals(14, numbers[14])
assertEquals(15, numbers[15])
assertEquals(16, numbers[16])
assertEquals(17, numbers[17])
assertEquals(18, numbers[18])
assertEquals(19, numbers[19])
assertEquals(20, numbers[20])
assertEquals(21, numbers[21])
assertEquals(22, numbers[22])
assertEquals(23, numbers[23])
assertEquals(24, numbers[24])
assertEquals(25, numbers[25])
assertEquals(26, numbers[26])
assertEquals(27, numbers[27])
assertEquals(28, numbers[28])
assertEquals(29, numbers[29])
assertEquals(30, numbers[30])
assertEquals(31, numbers[31])
assertEquals(32, numbers[32])
assertEquals(33, numbers[33])
assertEquals(34, numbers[34])
assertEquals(35, numbers[35])
assertEquals(36, numbers[36])
assertEquals(37, numbers[37])
assertEquals(38, numbers[38])
assertEquals(39, numbers[39])
assertEquals(40, numbers[40])
assertEquals(41, numbers[41])
assertEquals(42, numbers[42])
assertEquals(43, numbers[43])
assertEquals(44, numbers[44])
```
<br />

## **append**
```kotlin
fun append(item: T)
```
It adds the `item` given at the end of the `ArrayList`.

`item`: It will be added to the end of the `ArrayList`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>(16)
numbers.append(0)
assertEquals(0, numbers[0])
```
<br />

## **prependBulk**
```kotlin
fun prependBulk(vararg items: T)
```
It adds multiple `items` given at the start of the `List`.

`items`: It will be added to the start of the `List`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
numbers.prependBulk(
  0,
  1,
  2,
  3,
  4,
  5,
  6,
  7,
  8,
  9,
  10,
  11,
  12,
  13,
  14,
  15,
  16,
  17,
  18,
  19,
  20,
  21,
  22,
  23,
  24,
  25,
  26,
  27,
  28,
  29,
  30,
  31,
  32,
  33,
  34,
  35,
  36,
  37,
  38,
  39,
  40,
  41,
  42,
  43,
  44
)
assertEquals(0, numbers[0])
assertEquals(1, numbers[1])
assertEquals(2, numbers[2])
assertEquals(3, numbers[3])
assertEquals(4, numbers[4])
assertEquals(5, numbers[5])
assertEquals(6, numbers[6])
assertEquals(7, numbers[7])
assertEquals(8, numbers[8])
assertEquals(9, numbers[9])
assertEquals(10, numbers[10])
assertEquals(11, numbers[11])
assertEquals(12, numbers[12])
assertEquals(13, numbers[13])
assertEquals(14, numbers[14])
assertEquals(15, numbers[15])
assertEquals(16, numbers[16])
assertEquals(17, numbers[17])
assertEquals(18, numbers[18])
assertEquals(19, numbers[19])
assertEquals(20, numbers[20])
assertEquals(21, numbers[21])
assertEquals(22, numbers[22])
assertEquals(23, numbers[23])
assertEquals(24, numbers[24])
assertEquals(25, numbers[25])
assertEquals(26, numbers[26])
assertEquals(27, numbers[27])
assertEquals(28, numbers[28])
assertEquals(29, numbers[29])
assertEquals(30, numbers[30])
assertEquals(31, numbers[31])
assertEquals(32, numbers[32])
assertEquals(33, numbers[33])
assertEquals(34, numbers[34])
assertEquals(35, numbers[35])
assertEquals(36, numbers[36])
assertEquals(37, numbers[37])
assertEquals(38, numbers[38])
assertEquals(39, numbers[39])
assertEquals(40, numbers[40])
assertEquals(41, numbers[41])
assertEquals(42, numbers[42])
assertEquals(43, numbers[43])
assertEquals(44, numbers[44])
```
<br />

## **prepend**
```kotlin
fun prepend(item: T)
```
It adds the `item` given at the start of the `ArrayList`.

`item`: It will be added to the start of the `ArrayList`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
numbers.prepend(0)
assertEquals(0, numbers[0])
assertEquals(1, numbers.size)
```
<br />

## **insert**
```kotlin
fun insert(index: Int, item: T)
```
It adds the `item` given at index `index` of the `ArrayList`.

`index`: It must be between 0 and the number of items stored in the `ArrayList`.

`item`: It will be added to the `ArrayList` at index `index`.

It throws `IllegalArgumentException` if `index` is less than 0 or `index` is greater than the number of items in the `ArrayList`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
numbers.insert(0, 0)
assertEquals(0, numbers[0])
assertEquals(1, numbers.size)
```
<br />

## **remove**
```kotlin
fun remove(index: Int): T
```
It removes an item at index `index` stored in the `ArrayList`.

`index`: It must be between 0 and the number of items stored in the `ArrayList` - 1.

It returns the item that will be removed from the `ArrayList`.

It throws `IllegalStateException` if this method is called when the `ArrayList` is empty.

It throws `IllegalArgumentException` if `index` is less than 0 or `index` is greater than or equal to the number of items in the `ArrayList`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
assertThrows(IllegalStateException::class.java) { numbers.remove(0) }
```
<br />

## **removeBack**
```kotlin
fun removeBack(): T
```
It removes the item that is at the end of the `ArrayList`.

It returns the item that will be removed from the `ArrayList`.

It throws `IllegalStateException` if this method is called when the `ArrayList` is empty.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
assertThrows(IllegalStateException::class.java) { numbers.removeBack() }
```
<br />

### **removeFront**
```kotlin
fun removeFront(): T
```
It removes the item that is at the start of the `ArrayList`.

It returns the item that will be removed from the `ArrayList`.

It throws `IllegalStateException` if this method is called when the `ArrayList` is empty.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
assertThrows(IllegalStateException::class.java) { numbers.removeFront() }
```
<br />

## **clear**
```kotlin
fun clear()
```
It removes all items stored in the `ArrayList`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
numbers.clear()
assertEquals(0, numbers.size)
```
<br />

## **shuffle**
```kotlin
fun shuffle()
```
It rearranges all the items stored in the `List` randomly.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
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
numbers.append(16)
numbers.append(17)
numbers.append(18)
numbers.append(19)
numbers.append(20)
numbers.append(21)
numbers.append(22)
numbers.append(23)
numbers.append(24)
numbers.append(25)
numbers.append(26)
numbers.append(27)
numbers.append(28)
numbers.append(29)
numbers.append(30)
numbers.append(31)
numbers.append(32)
numbers.append(33)
numbers.append(34)
numbers.append(35)
numbers.append(36)
numbers.append(37)
numbers.append(38)
numbers.append(39)
numbers.append(40)
numbers.append(41)
numbers.append(42)
numbers.append(43)
numbers.append(44)
numbers.shuffle()
```
<br />

## **swap**
```kotlin
fun swap(left: Int, right: Int)
```
It exchanges the positions of two items stored in the `ArrayList` based on `left` and `right` given.

`left`: It must be between 0 and the number of items stored in the `ArrayList` - 1. It must be less than or equal to `right`.

`right`: It must be between 0 and the number of items stored in the `ArrayList` - 1. It must be greater than or equal to `left`.

It throws `IllegalArgumentException` if `left` is less than 0 or `left` is greater than or equal to the number of items stored in the `ArrayList`.

It throws `IllegalArgumentException` if `right` is less than 0 or `right` is greater than or equal to the number of items stored in the `ArrayList`.

It throws `IllegalArgumentException` if `left` is greater than `right`.

### **Example usage:**
```kotlin
val numbers = ArrayList<Int>()
numbers.append(0)
numbers.append(1)
numbers.append(2)
numbers.append(3)
numbers.swap(0, 2)
assertEquals(2, numbers[0])
assertEquals(1, numbers[1])
assertEquals(0, numbers[2])
assertEquals(3, numbers[3])
assertEquals(4, numbers.size)
```
<br />
