# MathExt

## Table of contents
- [clamp](https://github.com/ii887522/oxy/tree/master/docs/functions/MathExt.md#clamp)
- [isOverlap](https://github.com/ii887522/oxy/tree/master/docs/functions/MathExt.md#isOverlap)
- [toSeconds](https://github.com/ii887522/oxy/tree/master/docs/functions/MathExt.md#toSeconds)
- [isOdd](https://github.com/ii887522/oxy/tree/master/docs/functions/MathExt.md#isOdd)
- [isEven](https://github.com/ii887522/oxy/tree/master/docs/functions/MathExt.md#isEven)
- [isPrime](https://github.com/ii887522/oxy/tree/master/docs/functions/MathExt.md#isPrime)
- [nextPrime](https://github.com/ii887522/oxy/tree/master/docs/functions/MathExt.md#nextPrime)
- [isPowerOfTwo](https://github.com/ii887522/oxy/tree/master/docs/functions/MathExt.md#isPowerOfTwo)
- [size](https://github.com/ii887522/oxy/tree/master/docs/functions/MathExt.md#size)
- [asFractionToFloat](https://github.com/ii887522/oxy/tree/master/docs/functions/MathExt.md#asFractionToFloat)

## **clamp**
```kotlin
fun clamp(value: Int, range: IntRange): Int
```
It constrains the `value` given in the `range` and returns the result.

`value`: The value to be constrained.

`range`: The range the constrained value can be in.

It returns the constrained value.

### **Example usage:**
```kotlin
assertEquals(1, clamp(0, IntRange(1, 3)))
```
<br />

## **isOverlap**
```kotlin
infix fun Int.isOverlap(range: IntRange): Boolean
```
It checks whether the value is in the given `range`.

`range`: The range to be checked with.

It returns true if the value is in the given `range`, false otherwise.

### **Example usage:**
```kotlin
assertFalse(0 isOverlap IntRange(1, 3))
```
<br />

## **toSeconds**
```kotlin
fun toSeconds(nanoseconds: Long): Float
```
It converts nanoseconds into seconds.

`nanoseconds`: The value to be converted.

It returns the received value in terms of seconds.

### **Example usage:**
```kotlin
assertEquals(1f, toSeconds(1e+9.toLong()))
```
<br />

## **isOdd**
```kotlin
val Int.isOdd: Boolean
```
It checks whether the value is an odd number.

It returns true if the value is an odd number, false otherwise.

### **Example usage:**
```kotlin
assertFalse(0.isOdd)
```
<br />

## **isEven**
```kotlin
val Int.isEven: Boolean
```
It checks whether the value is an even number.

It returns true if the value is an even number, false otherwise.

### **Example usage:**
```kotlin
assertTrue(0.isEven)
```
<br />

## **isPrime**
```kotlin
val Int.isPrime: Boolean
```
It checks whether the value is a prime number.

It returns true if the value is a prime number, false otherwise.

### **Example usage:**
```kotlin
assertFalse(0.isPrime)
```
<br />

## **nextPrime**
```kotlin
val Int.nextPrime: Int
```
It finds out the next prime number after the given value.

It returns the next prime number immediately after the given value.

### **Example usage:**
```kotlin
assertEquals(2, 0.nextPrime)
```
<br />

## **isPowerOfTwo**
```kotlin
val Int.isPowerOfTwo: Boolean
```
It checks whether the value is equal to 2 to the power of n where n is an integer.

It returns true if the value is equal to 2 to the power of n where n is an integer, false otherwise.

### **Example usage:**
```kotlin
assertTrue(1.isPowerOfTwo)
```
<br />

## **size**
```kotlin
val Int.size: Int
```
It retrieves the number of digits in the value.

It returns the number of digits in the value.

### **Example usage:**
```kotlin
assertEquals(1, 0.size)
```
<br />

## **asFractionToFloat**
```kotlin
fun Int.asFractionToFloat(leadingZeroCount: Int = 0): Float
```
It treats the value as a fraction and converts it into a floating point number.

`leadingZeroCount`: The number of zeros before the value itself.

It returns the floating point number after treated the value as a fraction.

### **Example usage:**
```kotlin
assertEquals(.00321f, 321.asFractionToFloat(2))
```
<br />
