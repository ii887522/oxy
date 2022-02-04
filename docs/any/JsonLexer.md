# JsonLexer

## Table of contents
- [lex](https://github.com/ii887522/oxy/tree/master/docs/any/JsonLexer.md#lex)

## **lex**
```kotlin
fun String.lex(): Array<JsonToken>
```
It assumes that the value is a JSON string and converts it into an array of JSON tokens to be consumed by JSON parser later. Each token contains information about the type of the contained value and the contained value itself if it is exists.

It returns an array of JSON tokens to be consumed by the next processor.

### **Example usage:**
```kotlin
assertArrayEquals(
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
  ),
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
          "targetPort": 1025
        },
        {
          "hostname": "www.abcdefg.dynv6.net",
          "target": null
        }
      ]
    }
    """.lex()
)
```
<br />
