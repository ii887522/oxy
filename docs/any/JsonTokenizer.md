# JsonTokenizer

## Table of contents
- [tokenize](https://github.com/ii887522/oxy/tree/master/docs/any/JsonTokenizer.md#tokenize)

## **tokenize**
```kotlin
fun Any?.tokenize(): Array<JsonToken>
```
It converts the object into an array of JSON tokens.

It returns an array of JSON tokens that is converted from the object.

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
assertArrayEquals(
  arrayOf(
    LeftCurlyBracketJsonToken,
    KeyJsonToken("certPath"),
    ColonJsonToken,
    StringJsonToken("test/cert.pem"),
    CommaJsonToken,
    KeyJsonToken("keyPath"),
    ColonJsonToken,
    StringJsonToken("test/key.pem"),
    CommaJsonToken,
    KeyJsonToken("routes"),
    ColonJsonToken,
    LeftSquareBracketJsonToken,
    LeftCurlyBracketJsonToken,
    KeyJsonToken("hostname"),
    ColonJsonToken,
    StringJsonToken("example.dynv6.net"),
    CommaJsonToken,
    KeyJsonToken("target"),
    ColonJsonToken,
    StringJsonToken("http://localhost:1024"),
    CommaJsonToken,
    RightCurlyBracketJsonToken,
    CommaJsonToken,
    LeftCurlyBracketJsonToken,
    KeyJsonToken("hostname"),
    ColonJsonToken,
    StringJsonToken("www.example.dynv6.net"),
    CommaJsonToken,
    KeyJsonToken("target"),
    ColonJsonToken,
    StringJsonToken("http://localhost:1024"),
    CommaJsonToken,
    RightCurlyBracketJsonToken,
    CommaJsonToken,
    LeftCurlyBracketJsonToken,
    KeyJsonToken("hostname"),
    ColonJsonToken,
    StringJsonToken("abcdefg.dynv6.net"),
    CommaJsonToken,
    KeyJsonToken("targetHostname"),
    ColonJsonToken,
    StringJsonToken("localhost"),
    CommaJsonToken,
    KeyJsonToken("targetPort"),
    ColonJsonToken,
    NumberJsonToken(1025f),
    CommaJsonToken,
    KeyJsonToken("targetScheme"),
    ColonJsonToken,
    StringJsonToken("http"),
    CommaJsonToken,
    RightCurlyBracketJsonToken,
    CommaJsonToken,
    LeftCurlyBracketJsonToken,
    KeyJsonToken("hostname"),
    ColonJsonToken,
    StringJsonToken("www.abcdefg.dynv6.net"),
    CommaJsonToken,
    KeyJsonToken("target"),
    ColonJsonToken,
    NullJsonToken,
    CommaJsonToken,
    RightCurlyBracketJsonToken,
    CommaJsonToken,
    RightSquareBracketJsonToken,
    CommaJsonToken,
    RightCurlyBracketJsonToken
  ),
  document.tokenize()
)
```
