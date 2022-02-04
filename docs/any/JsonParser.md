# JsonParser
It is a parser used to convert JSON tokens received from the JSON lexer into an object. Each token contains information about the type of the contained value and the contained value itself if it is exists.

## Table of contents
- [run](https://github.com/ii887522/oxy/tree/master/docs/any/JsonParser.md#run)

## **run**
```kotlin
fun run(vararg tokens: JsonToken): Any?
```
It converts JSON `tokens` received into an object.

`tokens`: The JSON tokens to be converted.

It returns an object that is converted from the JSON `tokens` given.

### **Example usage:**
```kotlin
val document = JsonParser().run(
  LeftCurlyBracketJsonToken,
  KeyJsonToken("keyPath"),
  ColonJsonToken,
  StringJsonToken("test/key.pem"),
  CommaJsonToken,
  KeyJsonToken("certPath"),
  ColonJsonToken,
  StringJsonToken("test/cert.pem"),
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
  RightCurlyBracketJsonToken,
  CommaJsonToken,
  LeftCurlyBracketJsonToken,
  KeyJsonToken("hostname"),
  ColonJsonToken,
  StringJsonToken("abcdefg.dynv6.net"),
  CommaJsonToken,
  KeyJsonToken("targetScheme"),
  ColonJsonToken,
  StringJsonToken("http"),
  CommaJsonToken,
  KeyJsonToken("targetHostname"),
  ColonJsonToken,
  StringJsonToken("localhost"),
  CommaJsonToken,
  KeyJsonToken("targetPort"),
  ColonJsonToken,
  NumberJsonToken(1025f),
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
  RightCurlyBracketJsonToken,
  RightSquareBracketJsonToken,
  RightCurlyBracketJsonToken
)
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
