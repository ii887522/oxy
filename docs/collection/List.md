# List
A `List` is a collection of items of type `T` linearly placed together without any gaps. It can be either sorted or unsorted and can have duplicate items. It does not place any restrictions on the `List` when accessing it. The index of the `List` starts from 0.

`T`: The type of the items stored in the `List`.

## Table of contents
- [get](https://github.com/ii887522/oxy/tree/master/docs/collection/List.md#get)
- [set](https://github.com/ii887522/oxy/tree/master/docs/collection/List.md#set)
- [append](https://github.com/ii887522/oxy/tree/master/docs/collection/List.md#append)
- [appendBulk](https://github.com/ii887522/oxy/tree/master/docs/collection/List.md#appendBulk)
- [prepend](https://github.com/ii887522/oxy/tree/master/docs/collection/List.md#prepend)
- [prependBulk](https://github.com/ii887522/oxy/tree/master/docs/collection/List.md#prependBulk)
- [insert](https://github.com/ii887522/oxy/tree/master/docs/collection/List.md#insert)
- [remove](https://github.com/ii887522/oxy/tree/master/docs/collection/List.md#remove)
- [removeBack](https://github.com/ii887522/oxy/tree/master/docs/collection/List.md#removeBack)
- [removeFront](https://github.com/ii887522/oxy/tree/master/docs/collection/List.md#removeFront)

## **get**
```kotlin
operator fun get(index: Int): T
```
It retrieves an item at index `index` stored in the `List`.

`index`: It must be between 0 and the number of items stored in the `List` - 1.

It returns the item at index `index` stored in the `List`.

It throws `IllegalArgumentException` if `index` is less than 0 or `index` is greater than or equal to the number of items stored in the `List`.

## **set**
```kotlin
operator fun set(index: Int, item: T)
```
It replaces an item at index `index` stored in the `List` based on the `item` given.

`index`: It must be between 0 and the number of items stored in the `List` - 1.

`item`: It replaces the item at index `index` stored in the `List`.

It throws `IllegalArgumentException` If `index` is less than 0 or `index` is greater than or equal to the number of items in the `List`.

## **append**
```kotlin
fun append(item: T)
```
It adds the `item` given at the end of the `List`.

`item`: It will be added to the end of the `List`.

## **appendBulk**
```kotlin
fun appendBulk(vararg items: T)
```
It adds multiple `items` given at the end of the `List`.

`items`: It will be added to the end of the `List`.

## **prepend**
```kotlin
fun prepend(item: T)
```
It adds the `item` given at the start of the `List`.

`item`: It will be added to the start of the `List`.

## **prependBulk**
```kotlin
fun prependBulk(vararg items: T)
```
It adds multiple `items` given at the start of the `List`.

`items`: It will be added to the start of the `List`.

## **insert**
```kotlin
fun insert(index: Int, item: T)
```
It adds the `item` given at index `index` of the `List`.

`index`: It must be between 0 and the number of items stored in the `List`.

`item`: It will be added to the `List` at index `index`.

It throws `IllegalArgumentException` if `index` is less than 0 or `index` is greater than the number of items in the `List`.

## **remove**
```kotlin
fun remove(index: Int): T
```
It removes an item at index `index` stored in the `List`.

`index`: It must be between 0 and the number of items stored in the `List` - 1.

It returns the item that will be removed from the `List`.

It throws `IllegalStateException` if this method is called when the `List` is empty.

It throws `IllegalArgumentException` if `index` is less than 0 or `index` is greater than or equal to the number of items in the `List`.

## **removeBack**
```kotlin
fun removeBack(): T
```
It removes the item that is at the end of the `List`.

It returns the item that will be removed from the `List`.

It throws IllegalStateException If this method is called when the `List` is empty.

## **removeFront**
```kotlin
fun removeFront(): T
```
It removes the item that is at the start of the `List`.

It returns the item that will be removed from the `List`.

It throws `IllegalStateException` If this method is called when the `List` is empty.

## **shuffle**
```kotlin
fun shuffle()
```
It rearranges all the items stored in the `List` randomly.

## **swap**
```kotlin
fun swap(left: Int, right: Int)
```
It exchanges the positions of two items stored in the `List` based on `left` and `right` given.

`left`: It must be between 0 and the number of items stored in the `List` - 1. It must be less than or equal to `right`.

`right`: It must be between 0 and the number of items stored in the `List` - 1. It must be greater than or equal to `left`.

It throws `IllegalArgumentException` if `left` is less than 0 or `left` is greater than or equal to the number of items stored in the `List`.

It throws `IllegalArgumentException` if `right` is less than 0 or `right` is greater than or equal to the number of items stored in the `List`.

It throws `IllegalArgumentException` if `left` is greater than `right`.
