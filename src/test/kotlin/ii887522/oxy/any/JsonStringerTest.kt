package ii887522.oxy.any

import ii887522.oxy.struct.*
import org.junit.Assert.assertEquals
import org.junit.Test

class JsonStringerTest {
  @Test fun `test stringify`() {
    assertEquals("", arrayOf<JsonToken>().stringify())
    assertEquals(",", arrayOf(CommaJsonToken).stringify())
    assertEquals("[", arrayOf(LeftSquareBracketJsonToken).stringify())
    assertEquals("]", arrayOf(RightSquareBracketJsonToken).stringify())
    assertEquals(":", arrayOf(ColonJsonToken).stringify())
    assertEquals("{", arrayOf(LeftCurlyBracketJsonToken).stringify())
    assertEquals("}", arrayOf(RightCurlyBracketJsonToken).stringify())
    assertEquals("null", arrayOf(NullJsonToken).stringify())
    assertEquals("true", arrayOf(TrueJsonToken).stringify())
    assertEquals("false", arrayOf(FalseJsonToken).stringify())
    assertEquals("0.0", arrayOf(NumberJsonToken(0f)).stringify())
    assertEquals("1.0", arrayOf(NumberJsonToken(1f)).stringify())
    assertEquals("2.0", arrayOf(NumberJsonToken(2f)).stringify())
    assertEquals("3.0", arrayOf(NumberJsonToken(3f)).stringify())
    assertEquals("4.0", arrayOf(NumberJsonToken(4f)).stringify())
    assertEquals("5.0", arrayOf(NumberJsonToken(5f)).stringify())
    assertEquals("6.0", arrayOf(NumberJsonToken(6f)).stringify())
    assertEquals("7.0", arrayOf(NumberJsonToken(7f)).stringify())
    assertEquals("8.0", arrayOf(NumberJsonToken(8f)).stringify())
    assertEquals("9.0", arrayOf(NumberJsonToken(9f)).stringify())
    assertEquals("9.0,9.0", arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(9f)).stringify())
    assertEquals(
      "9.0,8.0,7.0", arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(7f)).stringify()
    )
    assertEquals(
      "9.0,8.0,7.1", arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(7.1f)).stringify()
    )
    assertEquals(
      "9.0,8.0,7.2", arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(7.2f)).stringify()
    )
    assertEquals(
      "9.0,8.0,-7.2", arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(-7.2f)).stringify()
    )
    assertEquals(
      ",9.0,8.0,-7.2",
      arrayOf(CommaJsonToken, NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(-7.2f)).stringify()
    )
    assertEquals(
      ",9.0,8.0,-7.2,",
      arrayOf(
        CommaJsonToken,
        NumberJsonToken(9f),
        CommaJsonToken,
        NumberJsonToken(8f),
        CommaJsonToken,
        NumberJsonToken(-7.2f),
        CommaJsonToken
      ).stringify()
    )
    assertEquals(
      ",9.0,8.0,-70.2,",
      arrayOf(
        CommaJsonToken,
        NumberJsonToken(9f),
        CommaJsonToken,
        NumberJsonToken(8f),
        CommaJsonToken,
        NumberJsonToken(-70.2f),
        CommaJsonToken
      ).stringify()
    )
    assertEquals(
      ",9.0,8.0,-701.2,",
      arrayOf(
        CommaJsonToken,
        NumberJsonToken(9f),
        CommaJsonToken,
        NumberJsonToken(8f),
        CommaJsonToken,
        NumberJsonToken(-701.2f),
        CommaJsonToken
      ).stringify()
    )
    assertEquals(
      ",9.0,8.0,-701.02,",
      arrayOf(
        CommaJsonToken,
        NumberJsonToken(9f),
        CommaJsonToken,
        NumberJsonToken(8f),
        CommaJsonToken,
        NumberJsonToken(-701.02f),
        CommaJsonToken
      ).stringify()
    )
    assertEquals(
      ",9.0,8.0,-701.021,",
      arrayOf(
        CommaJsonToken,
        NumberJsonToken(9f),
        CommaJsonToken,
        NumberJsonToken(8f),
        CommaJsonToken,
        NumberJsonToken(-701.021f),
        CommaJsonToken
      ).stringify()
    )
    assertEquals("\"\"", arrayOf(StringJsonToken("")).stringify())
    assertEquals("\"a\"", arrayOf(StringJsonToken("a")).stringify())
    assertEquals(
      """{
  "javascript.validate.enable": false,
  "standard.usePackageJson": true,
  "standard.engine": "ts-standard",
  "standard.validate": ["javascript"]
}
""".filter { !it.isWhitespace() },
      arrayOf(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("javascript.validate.enable"),
        ColonJsonToken,
        FalseJsonToken,
        CommaJsonToken,
        KeyJsonToken("standard.usePackageJson"),
        ColonJsonToken,
        TrueJsonToken,
        CommaJsonToken,
        KeyJsonToken("standard.engine"),
        ColonJsonToken,
        StringJsonToken("ts-standard"),
        CommaJsonToken,
        KeyJsonToken("standard.validate"),
        ColonJsonToken,
        LeftSquareBracketJsonToken,
        StringJsonToken("javascript"),
        RightSquareBracketJsonToken,
        RightCurlyBracketJsonToken
      ).stringify()
    )
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
  }
}
