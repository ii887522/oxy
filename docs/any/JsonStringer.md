# JsonStringer

## Table of contents
- [stringify](https://github.com/ii887522/oxy/tree/master/docs/any/JsonStringer.md#stringify)

## **stringify**
```kotlin
fun Array<out JsonToken>.stringify(): String
```
It converts the array of JSON tokens into a JSON string.

It returns a JSON string that is converted from the JSON tokens.

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
      "targetScheme": "http",
      "targetHostname": "localhost",
      "targetPort": 1025.0
    },
    {
      "hostname": "www.abcdefg.dynv6.net",
      "target": null
    }
  ]
}
""".filter { !it.isWhitespace() },
  arrayOf(
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
  ).stringify()
)
```
<br />
