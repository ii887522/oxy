# StringExt

## Table of contents
- [substring](https://github.com/ii887522/oxy/tree/master/docs/functions/StringExt.md#substring)
- [isUint](https://github.com/ii887522/oxy/tree/master/docs/functions/StringExt.md#isUint)

## **substring**
```kotlin
fun String.substring(startText: String, endText: String): String
```
It returns a substring from the original string received which starts from the start text given and ends with a text which immediately precedes the end text given.

`startText`: The start text included in the original string.

`endText`: The end text included in the original string.

It returns the substring requested.

### **Example usage:**
```kotlin
assertEquals("SDL2-2.0.12/", "SDL2-2.0.12/lib/x86/SDL2.dll".substring("SDL", "l"))
```
<br />

## **isUint**
```kotlin
val String.isUint: Boolean
```
It checks whether the value given is actually an unsigned integer which is converted to a string.

It returns true if the value is an unsigned integer which is converted to a string, false otherwise.

### **Example usage:**
```kotlin
assertFalse("/".isUint)
```
<br />
