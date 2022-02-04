package ii887522.oxy.any

import ii887522.oxy.collection.ArrayList
import ii887522.oxy.struct.*
import ii887522.oxy.collection.HashMap
import org.junit.Assert.*
import org.junit.Test

class JsonParserTest {
  @Test fun `test run`() {
    val parser = JsonParser()
    assertNull(parser.run())
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(KeyJsonToken("a"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(CommaJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(RightSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(ColonJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(RightCurlyBracketJsonToken)
    }
    assertNull(parser.run(NullJsonToken))
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(CharJsonToken('a'))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), KeyJsonToken("c"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), CommaJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), LeftSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), RightSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), LeftCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), RightCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), FalseJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), CharJsonToken('b'))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken, TrueJsonToken, CommaJsonToken, KeyJsonToken("c"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken, TrueJsonToken, CommaJsonToken, CommaJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken, TrueJsonToken, CommaJsonToken, LeftSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken, TrueJsonToken, CommaJsonToken, RightSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("b"),
        ColonJsonToken,
        LeftSquareBracketJsonToken,
        NumberJsonToken(0f),
        CommaJsonToken,
        RightSquareBracketJsonToken
      )
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken, TrueJsonToken, CommaJsonToken, ColonJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken, TrueJsonToken, CommaJsonToken, LeftCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("b"),
        ColonJsonToken,
        LeftSquareBracketJsonToken,
        TrueJsonToken,
        CommaJsonToken,
        RightCurlyBracketJsonToken
      )
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken, TrueJsonToken, CommaJsonToken, NumberJsonToken(1f))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, TrueJsonToken, CommaJsonToken, NumberJsonToken(1f))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken, TrueJsonToken, CommaJsonToken, CharJsonToken('c'))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, KeyJsonToken("c"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, CommaJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, ColonJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, RightCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, NumberJsonToken(2f))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, CharJsonToken('d'))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken, KeyJsonToken("ca"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken, CommaJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken, LeftSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken, ColonJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken, LeftCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken, RightCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken, NumberJsonToken(21f))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken, CharJsonToken('e'))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("cb"), ColonJsonToken, KeyJsonToken("db"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("cb"), ColonJsonToken, CommaJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("cb"), ColonJsonToken, LeftSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("cb"), ColonJsonToken, RightSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("cb"), ColonJsonToken, ColonJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("cb"), ColonJsonToken, LeftCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("cb"), ColonJsonToken, RightCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("cb"), ColonJsonToken, NumberJsonToken(22f))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("cb"), ColonJsonToken, CharJsonToken('f'))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("db"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, CommaJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, LeftSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, RightSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, ColonJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, LeftCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, NumberJsonToken(32f))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, CharJsonToken('g'))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken, KeyJsonToken("dba"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken, CommaJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken, LeftSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("dba.a"),
        ColonJsonToken,
        LeftCurlyBracketJsonToken,
        KeyJsonToken("dba-a"),
        ColonJsonToken,
        LeftCurlyBracketJsonToken,
        RightCurlyBracketJsonToken,
        RightSquareBracketJsonToken
      )
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken, ColonJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken, LeftCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken, RightCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(
        LeftSquareBracketJsonToken,
        LeftCurlyBracketJsonToken,
        KeyJsonToken("dba+a"),
        ColonJsonToken,
        LeftCurlyBracketJsonToken,
        RightCurlyBracketJsonToken,
        RightCurlyBracketJsonToken
      )
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken, NumberJsonToken(320f))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken, CharJsonToken('h'))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, NumberJsonToken(320.1f), KeyJsonToken("dba*a"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, NumberJsonToken(320.1f), CommaJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, NumberJsonToken(320.1f), LeftSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(
        LeftSquareBracketJsonToken,
        LeftCurlyBracketJsonToken,
        KeyJsonToken("dba/a"),
        ColonJsonToken, NumberJsonToken(320.1f),
        RightSquareBracketJsonToken
      )
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, NumberJsonToken(320.1f), ColonJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, NumberJsonToken(320.1f), LeftCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, NumberJsonToken(320.1f), RightCurlyBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(
        LeftSquareBracketJsonToken,
        LeftCurlyBracketJsonToken,
        KeyJsonToken("dba_a"),
        ColonJsonToken,
        NumberJsonToken(320.1f),
        RightCurlyBracketJsonToken
      )
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, NumberJsonToken(320.1f), StringJsonToken("a"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, NumberJsonToken(320.1f), CharJsonToken('i'))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("key"))
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftCurlyBracketJsonToken, KeyJsonToken("key"), ColonJsonToken, StringJsonToken("b"), CommaJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("key"),
        ColonJsonToken,
        StringJsonToken("b"),
        CommaJsonToken,
        KeyJsonToken("key0"),
        ColonJsonToken,
        LeftSquareBracketJsonToken
      )
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("key"),
        ColonJsonToken,
        StringJsonToken("b"),
        CommaJsonToken,
        KeyJsonToken("key0"),
        ColonJsonToken,
        LeftSquareBracketJsonToken,
        RightSquareBracketJsonToken,
        CommaJsonToken,
        KeyJsonToken("key_1"),
        ColonJsonToken
      )
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("key"),
        ColonJsonToken,
        StringJsonToken("b"),
        CommaJsonToken,
        KeyJsonToken("key0"),
        ColonJsonToken,
        LeftSquareBracketJsonToken,
        RightSquareBracketJsonToken,
        CommaJsonToken,
        KeyJsonToken("key_1"),
        ColonJsonToken,
        LeftCurlyBracketJsonToken
      )
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("key"),
        ColonJsonToken,
        StringJsonToken("b"),
        CommaJsonToken,
        KeyJsonToken("key0"),
        ColonJsonToken,
        LeftSquareBracketJsonToken,
        RightSquareBracketJsonToken,
        CommaJsonToken,
        KeyJsonToken("key_1"),
        ColonJsonToken,
        LeftCurlyBracketJsonToken,
        KeyJsonToken("key-2"),
        ColonJsonToken,
        StringJsonToken("c"),
        RightCurlyBracketJsonToken,
        RightCurlyBracketJsonToken,
        CommaJsonToken,
        LeftSquareBracketJsonToken,
        RightSquareBracketJsonToken
      )
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, RightSquareBracketJsonToken, CommaJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, RightSquareBracketJsonToken, RightSquareBracketJsonToken)
    }
    assertThrows(IllegalArgumentException::class.java) {
      parser.run(LeftSquareBracketJsonToken, RightSquareBracketJsonToken, RightSquareBracketJsonToken, RightSquareBracketJsonToken)
    }
  }

  @Test fun `test run when input contains one object`() {
    val document =
      JsonParser().run(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken, TrueJsonToken, CommaJsonToken, RightCurlyBracketJsonToken)
    assertTrue(document is HashMap<*, *>)
    assertEquals(1, (document as HashMap<String, Any?>).size)
    assertEquals(true, document["b"])
  }

  @Test fun `test run when input contains an empty array`() {
    val document = JsonParser().run(LeftSquareBracketJsonToken, RightSquareBracketJsonToken)
    assertTrue(document is ArrayList<*>)
    assertEquals(0, (document as ArrayList<*>).size)
  }

  @Test fun `test run when input contains an array that contains an empty array`() {
    val document = JsonParser().run(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken, RightSquareBracketJsonToken)
    assertTrue(document is ArrayList<*>)
    assertEquals(1, (document as ArrayList<*>).size)
    assertTrue(document[0] is ArrayList<*>)
    assertEquals(0, (document[0] as ArrayList<*>).size)
  }

  @Test fun `test run when input contains 2 nested arrays`() {
    val document = JsonParser().run(
      LeftSquareBracketJsonToken,
      LeftSquareBracketJsonToken,
      LeftSquareBracketJsonToken,
      RightSquareBracketJsonToken,
      RightSquareBracketJsonToken,
      RightSquareBracketJsonToken
    )
    assertTrue(document is ArrayList<*>)
    assertEquals(1, (document as ArrayList<*>).size)
    assertTrue(document[0] is ArrayList<*>)
    assertEquals(1, (document[0] as ArrayList<*>).size)
    assertTrue((document[0] as ArrayList<*>)[0] is ArrayList<*>)
    assertEquals(0, ((document[0] as ArrayList<*>)[0] as ArrayList<*>).size)
  }

  @Test fun `test run when input contains an object that contains an array`() {
    val document = JsonParser().run(
      LeftCurlyBracketJsonToken,
      KeyJsonToken("cb"),
      ColonJsonToken,
      LeftSquareBracketJsonToken,
      RightSquareBracketJsonToken,
      RightCurlyBracketJsonToken
    )
    assertTrue(document is HashMap<*, *>)
    assertEquals(1, (document as HashMap<String, Any?>).size)
    assertTrue(document["cb"] is ArrayList<*>)
    assertEquals(0, (document["cb"] as ArrayList<*>).size)
  }

  @Test fun `test run when input contains an empty object`() {
    val document = JsonParser().run(LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken)
    assertTrue(document is HashMap<*, *>)
    assertEquals(0, (document as HashMap<*, *>).size)
  }

  @Test fun `test run when input contains an array that contains an empty object`() {
    val document = JsonParser().run(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken, RightSquareBracketJsonToken)
    assertTrue(document is ArrayList<*>)
    assertEquals(1, (document as ArrayList<*>).size)
    assertTrue(document[0] is HashMap<*, *>)
    assertEquals(0, (document[0] as HashMap<*, *>).size)
  }

  @Test fun `test run when input contains an array that contains a value`() {
    val document = JsonParser().run(LeftSquareBracketJsonToken, NumberJsonToken(320.1f), RightSquareBracketJsonToken)
    assertTrue(document is ArrayList<*>)
    assertEquals(1, (document as ArrayList<*>).size)
    assertEquals(320.1f, document[0])
  }

  @Test fun `test run when input contains a Visual Studio Code config object`() {
    val document = JsonParser().run(
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
    )
    assertTrue(document is HashMap<*, *>)
    assertEquals(4, (document as HashMap<String, Any?>).size)
    assertEquals(false, document["javascript.validate.enable"])
    assertEquals(true, document["standard.usePackageJson"])
    assertEquals("ts-standard", document["standard.engine"])
    assertTrue(document["standard.validate"] is ArrayList<*>)
    assertEquals(1, (document["standard.validate"] as ArrayList<*>).size)
    assertEquals("javascript", (document["standard.validate"] as ArrayList<*>)[0])
  }

  @Test fun `test run when input contains a reverse proxy config object`() {
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
  }
}
