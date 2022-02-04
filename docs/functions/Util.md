# Util

## Table of contents
- [swap](https://github.com/ii887522/oxy/tree/master/docs/functions/Util.md#swap)
- [formatTime](https://github.com/ii887522/oxy/tree/master/docs/functions/Util.md#formatTime)
- [asJsonStringToObject](https://github.com/ii887522/oxy/tree/master/docs/functions/Util.md#asJsonStringToObject)
- [toJsonString](https://github.com/ii887522/oxy/tree/master/docs/functions/Util.md#toJsonString)

## **swap**
```kotlin
fun <T> swap(left: Holder<T>, right: Holder<T>)
```
It exchanges objects that are held by both holders.

`left`: The first holder where its object will be exchanged.

`right`: The second holder where its object will be exchanged.

### **Example usage:**
```kotlin
val a = Holder(0)
val b = Holder(1)
swap(a, b)
assertEquals(1, a.value)
assertEquals(0, b.value)
```
<br />

## **formatTime**
```kotlin
fun formatTime(seconds: Float): String
```
It converts `seconds` into a time with a format like 'mmm:ss'.

`seconds`: The value to be converted.

It returns the received value in terms of time with a format like 'mmm:ss'.

### **Example usage:**
```kotlin
assertEquals("1:29", formatTime(89f))
```
<br />

## **asJsonStringToObject**
```kotlin
fun String.asJsonStringToObject(): Any?
```
It converts the JSON string into an object that can be accessed easily.

It returns an object that is converted from the JSON string.

### **Example usage:**
```kotlin
val document = """{
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
      "targetScheme": "http",
      "targetHostname": "localhost",
      "targetPort": 1025
    },
    {
      "hostname": "www.abcdefg.dynv6.net",
      "target": null
    }
  ]
}
""".asJsonStringToObject()
assertTrue(document is HashMap<*, *>)
assertEquals(3, (document as HashMap<String, Any?>).size)
assertEquals("test/key.pem", document["keyPath"])
assertEquals("test/cert.pem", document["certPath"])
assertTrue(document["routes"] is ArrayList<*>)
assertEquals(4, (document["routes"] as ArrayList<*>).size)
assertTrue((document["routes"] as ArrayList<*>)[0] is HashMap<*, *>)
assertEquals(2, ((document["routes"] as ArrayList<*>)[0] as HashMap<String, Any?>).size)
assertEquals("example.dynv6.net", ((document["routes"] as ArrayList<*>)[0] as HashMap<String, Any?>)["hostname"])
assertEquals("http://localhost:1024", ((document["routes"] as ArrayList<*>)[0] as HashMap<String, Any?>)["target"])
assertTrue((document["routes"] as ArrayList<*>)[1] is HashMap<*, *>)
assertEquals(2, ((document["routes"] as ArrayList<*>)[1] as HashMap<String, Any?>).size)
assertEquals("www.example.dynv6.net", ((document["routes"] as ArrayList<*>)[1] as HashMap<String, Any?>)["hostname"])
assertEquals("http://localhost:1024", ((document["routes"] as ArrayList<*>)[1] as HashMap<String, Any?>)["target"])
assertTrue((document["routes"] as ArrayList<*>)[2] is HashMap<*, *>)
assertEquals(4, ((document["routes"] as ArrayList<*>)[2] as HashMap<String, Any?>).size)
assertEquals("abcdefg.dynv6.net", ((document["routes"] as ArrayList<*>)[2] as HashMap<String, Any?>)["hostname"])
assertEquals("http", ((document["routes"] as ArrayList<*>)[2] as HashMap<String, Any?>)["targetScheme"])
assertEquals("localhost", ((document["routes"] as ArrayList<*>)[2] as HashMap<String, Any?>)["targetHostname"])
assertEquals(1025f, ((document["routes"] as ArrayList<*>)[2] as HashMap<String, Any?>)["targetPort"])
assertTrue((document["routes"] as ArrayList<*>)[3] is HashMap<*, *>)
assertEquals(2, ((document["routes"] as ArrayList<*>)[3] as HashMap<String, Any?>).size)
assertEquals("www.abcdefg.dynv6.net", ((document["routes"] as ArrayList<*>)[3] as HashMap<String, Any?>)["hostname"])
assertNull(((document["routes"] as ArrayList<*>)[3] as HashMap<String, Any?>)["target"])
```
<br />

## **toJsonString**
```kotlin
fun Any?.toJsonString(): String
```
It converts the object into a JSON string that can be saved into a text file easily.

It returns a JSON string that is converted from an object.

### **Example usage:**
```kotlin
val document = HashMap<String, Any?>()
document["keyPath"] = "test/key.pem"
document["certPath"] = "test/cert.pem"
document["routes"] = ArrayList<Any?>()
(document["routes"] as ArrayList<Any?>).append(HashMap<String, Any?>())
((document["routes"] as ArrayList<Any?>)[0] as HashMap<String, Any?>)["hostname"] = "example.dynv6.net"
((document["routes"] as ArrayList<Any?>)[0] as HashMap<String, Any?>)["target"] = "http://localhost:1024"
(document["routes"] as ArrayList<Any?>).append(HashMap<String, Any?>())
((document["routes"] as ArrayList<Any?>)[1] as HashMap<String, Any?>)["hostname"] = "www.example.dynv6.net"
((document["routes"] as ArrayList<Any?>)[1] as HashMap<String, Any?>)["target"] = "http://localhost:1024"
(document["routes"] as ArrayList<Any?>).append(HashMap<String, Any?>())
((document["routes"] as ArrayList<Any?>)[2] as HashMap<String, Any?>)["hostname"] = "abcdefg.dynv6.net"
((document["routes"] as ArrayList<Any?>)[2] as HashMap<String, Any?>)["targetScheme"] = "http"
((document["routes"] as ArrayList<Any?>)[2] as HashMap<String, Any?>)["targetHostname"] = "localhost"
((document["routes"] as ArrayList<Any?>)[2] as HashMap<String, Any?>)["targetPort"] = 1025f
(document["routes"] as ArrayList<Any?>).append(HashMap<String, Any?>())
((document["routes"] as ArrayList<Any?>)[3] as HashMap<String, Any?>)["hostname"] = "www.abcdefg.dynv6.net"
((document["routes"] as ArrayList<Any?>)[3] as HashMap<String, Any?>)["target"] = null
assertEquals(
      """{
  "certPath": "test/cert.pem",
  "keyPath": "test/key.pem",
  "routes": [
    {
      "hostname": "example.dynv6.net",
      "target": "http://localhost:1024",
    },
    {
      "hostname": "www.example.dynv6.net",
      "target": "http://localhost:1024",
    },
    {
      "hostname": "abcdefg.dynv6.net",
      "targetHostname": "localhost",
      "targetPort": 1025.0,
      "targetScheme": "http",
    },
    {
      "hostname": "www.abcdefg.dynv6.net",
      "target": null,
    },
  ],
}
""".filter { !it.isWhitespace() },
  document.toJsonString()
)
```
<br />
