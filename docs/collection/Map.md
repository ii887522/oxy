# Map
A `Map` is a collection of items with key of type `K` and value of type `V`. It can be either sorted or unsorted but cannot have items with same keys although items can have same values. It does not place any restrictions on the `Map` when accessing it.

`K`: The type of the key of the items stored in `Map`.

`V`: The type of the value of the items stored in `Map`.

## Table of contents
- [keys](https://github.com/ii887522/oxy/tree/master/docs/collection/Map.md#keys)
- [set](https://github.com/ii887522/oxy/tree/master/docs/collection/Map.md#set)
- [remove](https://github.com/ii887522/oxy/tree/master/docs/collection/Map.md#remove)
- [get](https://github.com/ii887522/oxy/tree/master/docs/collection/Map.md#get)

## **keys**
```kotlin
val keys: List<K>
```
It retrieves all keys that have been stored in the `Map`.

It returns keys that are contained inside the `Map`.

## **set**
```kotlin
operator fun set(key: K, value: V)
```
It inserts or updates an item stored in the `Map` based on the `key` and `value` given.

`key`: It will be used for finding this item in the future.

`value`: It will be inserted or updated to the `Map`.

It throws `IllegalStateException` if this method is called when a new item is going to be inserted and the `Map` is full.

## **remove**
```kotlin
fun remove(key: K): V?
```
It removes an item stored in the `Map` with the matching `key`.

`key`: It will be used to remove a matching item.

It returns a value that is belongs to the item with the matching `key`. `null` if the `key` does not match any item.

It throws `IllegalStateException`if this method is called when this `Map` is empty.

## **get**
```kotlin
operator fun get(key: K): V?
```
Retrieves a value that is belongs to the item with the matching `key` in the `Map`.

`key`: It will be used to retrieve a matching item.

It returns a value that is belongs to the item with the matching `key`. `null` if the `key` does not match any item.
