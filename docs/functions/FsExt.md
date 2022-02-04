# FsExt

## Table of contents
- [fileName](https://github.com/ii887522/oxy/tree/master/docs/functions/FsExt.md#fileName)
- [hasFileWithExtension](https://github.com/ii887522/oxy/tree/master/docs/functions/FsExt.md#hasFileWithExtension)
- [read](https://github.com/ii887522/oxy/tree/master/docs/functions/FsExt.md#read)
- [write](https://github.com/ii887522/oxy/tree/master/docs/functions/FsExt.md#write)

## **fileName**
```kotlin
val String.fileName: String
```
It returns the file name with its extension name from the value.

It returns the file name from the value.

### **Example usage:**
```kotlin
assertEquals("SDL2.dll", "SDL2-2.0.12/lib/x86/SDL2.dll".fileName)
```
<br />

## **hasFileWithExtension**
```kotlin
fun String.hasFileWithExtension(extensionName: String): Boolean
```
It checks whether the directory where its path is given has at least one file with an `extensionName` that is received from the parameter.

`extensionName`: The extension name used during checking. The name must not start with .

It returns true if there is at least one file with an `extensionName` that is coming from the parameter, false otherwise.

### **Example usage:**
```kotlin
assertFalse("src/test/resources/a".hasFileWithExtension("txt"))
```
<br />

## **read**
```kotlin
fun String.read(): String
```
It returns the content that is stored in the file where its path is given.

It returns the file content without newline character(s).

It throws `java.io.IOException` If any error occurred while trying to read the file where its path is given.

### **Example usage:**
```kotlin
assertEquals(
      """{
  "keyPath": "test/key.pem",
  "certPath": "test/cert.pem",
  "routes": [
    {
      "hostname": "example.dynv6.net",
      "target": "http://localhost:1024"
    },
    {
      "hostname": "www.example.dynv6.net",
      "target": "http://localhost:1024"
    },
    {
      "hostname": "abcdefg.dynv6.net",
      "target": "http://localhost:1025"
    },
    {
      "hostname": "www.abcdefg.dynv6.net",
      "target": "http://localhost:1025"
    }
  ]
}
""".filter { it != '\n' },
  "src/test/resources/reverse_proxy.config.json".read()
)
```
<br />

## **write**
```kotlin
fun String.write(content: String)
```
It stores the `content` received into the file where its path is given.

`content`: The file content to be stored.

### **Example usage:**
```kotlin
"src/test/resources/reverse_proxy.config.json".write(
  """{
  "keyPath": "test/key.pem",
  "certPath": "test/cert.pem",
  "routes": [
    {
      "hostname": "example.dynv6.net",
      "target": "http://localhost:1024"
    },
    {
      "hostname": "www.example.dynv6.net",
      "target": "http://localhost:1024"
    },
    {
      "hostname": "abcdefg.dynv6.net",
      "target": "http://localhost:1025"
    },
    {
      "hostname": "www.abcdefg.dynv6.net",
      "target": "http://localhost:1025"
    }
  ]
}
"""
)
```
<br />
