# ArrayStack
An `ArrayStack` is a collection of items of type `T` linearly placed together without any gaps. It can be either sorted or unsorted and can have duplicate items. However, users are only allowed to add, remove, get or set the item that is at the end of the `ArrayStack`.

`T`: The type of the items stored in the `ArrayStack`.

## Table of contents
- [size](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayStack.md#size)
- [push](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayStack.md#push)
- [pop](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayStack.md#pop)
- [setEnd](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayStack.md#setEnd)
- [peek](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayStack.md#peek)
- [clear](https://github.com/ii887522/oxy/tree/master/docs/collection/ArrayStack.md#clear)

## **size**
```kotlin
val size: Int
```
It retrieves the number of items stored in the `ArrayStack`.

It returns the number of items stored in the `ArrayStack`.

### **Example usage:**
```kotlin
val numbers = ArrayStack<Int>()
assertEquals(0, numbers.size)
```
<br />

## **push**
```kotlin
fun push(item: T)
```
It adds the `item` to the end of the `ArrayStack`.

`item`: It will be added to the end of the `ArrayStack`.

### **Example usage:**
```kotlin
val numbers = ArrayStack<Int>()
numbers.push(0)
assertEquals(1, numbers.size)
```
<br />

## **pop**
```kotlin
fun pop(): T
```
It removes the item that is at the end of the `ArrayStack`.

It returns the item that is at the end of the `ArrayStack` before being removed.

It throws `IllegalStateException` if this method is called when the `ArrayStack` is empty.

### **Example usage:**
```kotlin
val numbers = ArrayStack<Int>()
assertThrows(IllegalStateException::class.java) {
  numbers.pop()
}
```
<br />

## **setEnd**
```kotlin
fun setEnd(item: T)
```
It updates the `item` to the end of the `ArrayStack`.

`item`: It will be assigned to the end of the `ArrayStack`.

### **Example usage:**
```kotlin
val numbers = ArrayStack<Int>()
numbers.push(0)
numbers.push(1)
numbers.push(2)
numbers.setEnd(3)
assertEquals(3, numbers.pop())
assertEquals(2, numbers.size)
```
<br />

## **peek**
```kotlin
fun peek(): T
```
It gets the item that is at the end of the `ArrayStack`.

It returns the item that is at the end of the `ArrayStack`.

It throws `IllegalStateException` if this method is called when the `ArrayStack` is empty.

### **Example usage:**
```kotlin
val numbers = ArrayStack<Int>()
numbers.push(0)
numbers.push(1)
numbers.push(2)
assertEquals(3, numbers.size)
assertEquals(2, numbers.peek())
```
<br />

## **clear**
```kotlin
fun clear()
```
It removes all items stored in the `ArrayStack`.

### **Example usage:**
```kotlin
val numbers = ArrayStack<Int>()
numbers.clear()
assertEquals(0, numbers.size)
```
<br />
