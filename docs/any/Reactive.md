# Reactive
It is a wrapper over the value so that changes to the value can be notified to all the watchers subscribed to this wrapper. It is used to establish component communications through the value in the wrapper to reduce coupling between components.

## Table of contents
- [value](https://github.com/ii887522/oxy/tree/master/docs/any/Reactive.md#value)
- [plusAssign](https://github.com/ii887522/oxy/tree/master/docs/any/Reactive.md#plusAssign)

## **value**
```kotlin
var value: T
```

### **Example usage:**
```kotlin
val n = Reactive(0)
n.value = 1
assertEquals(1, n.value)
```
<br />

## **plusAssign**
```kotlin
operator fun plusAssign(onValueChange: (oldValue: T, newValue: T) -> Unit)
```
It registers a handler that processes the changes of the value so that the component which watches this object can be notified.

`onValueChange`: The handler that processes the changes of the value.

### **Example usage:**
```kotlin
val n = Reactive(0)
n.value = 1
assertEquals(1, n.value)
var count = 0
n += { _, newValue -> count += newValue }
n.value = 2
assertEquals(2, n.value)
assertEquals(2, count)
```
<br />
