# Stack
A `Stack` is a collection of items of type `T` linearly placed together without any gaps. It can be either sorted or unsorted and can have duplicate items. However, users are only allowed to add, remove, get or set the item that is at the end of the `Stack`.

`T`: The type of the items stored in the `Stack`.

## Table of contents
- [push](https://github.com/ii887522/oxy/tree/master/docs/collection/Stack.md#push)
- [pop](https://github.com/ii887522/oxy/tree/master/docs/collection/Stack.md#pop)
- [setEnd](https://github.com/ii887522/oxy/tree/master/docs/collection/Stack.md#setEnd)
- [peek](https://github.com/ii887522/oxy/tree/master/docs/collection/Stack.md#peek)

## **push**
```kotlin
fun push(item: T)
```
It adds the `item` to the end of the `Stack`.

`item`: It will be added to the end of the `Stack`.

## **pop**
```kotlin
fun pop(): T
```
It removes the item that is at the end of the `Stack`.

It returns the item that is at the end of the `Stack` before being removed.

It throws `IllegalStateException` If this method is called when the `Stack` is empty.

## **setEnd**
```kotlin
fun setEnd(item: T)
```
It updates the `item` to the end of the `Stack`.

`item`: It will be assigned to the end of the `Stack`.

## **peek**
```kotlin
fun peek(): T
```
It gets the item that is at the end of the `Stack`.

It returns the item that is at the end of the `Stack`.

It throws `IllegalStateException` If this method is called when the `Stack` is empty.
