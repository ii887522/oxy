package ii887522.oxy.any

import ii887522.oxy.collection.HashMap
import ii887522.oxy.collection.ArrayList
import ii887522.oxy.struct.*
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class JsonTokenizerTest {
  @Test fun `test tokenize when input is null`() {
    assertArrayEquals(arrayOf(NullJsonToken), null.tokenize())
  }

  @Test fun `test tokenize when input contains one object`() {
    val map = HashMap<String, Any?>()
    map["b"] = true
    assertArrayEquals(
      arrayOf(LeftCurlyBracketJsonToken, KeyJsonToken("b"), ColonJsonToken, TrueJsonToken, CommaJsonToken, RightCurlyBracketJsonToken), map.tokenize()
    )
  }

  @Test fun `test tokenize when input contains an empty array`() {
    assertArrayEquals(arrayOf(LeftSquareBracketJsonToken, RightSquareBracketJsonToken), ArrayList<Any?>().tokenize())
  }

  @Test fun `test tokenize when input contains an array that contains an empty array`() {
    val list = ArrayList<Any?>()
    list.append(ArrayList<Any?>())
    assertArrayEquals(
      arrayOf(LeftSquareBracketJsonToken, LeftSquareBracketJsonToken, RightSquareBracketJsonToken, CommaJsonToken, RightSquareBracketJsonToken), list.tokenize()
    )
  }

  @Test fun `test tokenize when input contains 2 nested array`() {
    val list = ArrayList<Any?>()
    list.append(ArrayList<Any?>())
    (list[0] as ArrayList<Any?>).append(ArrayList<Any?>())
    assertArrayEquals(
      arrayOf(
        LeftSquareBracketJsonToken,
        LeftSquareBracketJsonToken,
        LeftSquareBracketJsonToken,
        RightSquareBracketJsonToken,
        CommaJsonToken,
        RightSquareBracketJsonToken,
        CommaJsonToken,
        RightSquareBracketJsonToken
      ),
      list.tokenize()
    )
  }

  @Test fun `test tokenize when input contains an object that contains an array`() {
    val map = HashMap<String, Any?>()
    map["cb"] = ArrayList<Any?>()
    assertArrayEquals(
      arrayOf(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("cb"),
        ColonJsonToken,
        LeftSquareBracketJsonToken,
        RightSquareBracketJsonToken,
        CommaJsonToken,
        RightCurlyBracketJsonToken
      ),
      map.tokenize()
    )
  }

  @Test fun `test tokenize when input contains an empty object`() {
    assertArrayEquals(arrayOf(LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken), HashMap<String, Any?>().tokenize())
  }

  @Test fun `test tokenize when input contains an array that contains an empty object`() {
    val list = ArrayList<Any?>()
    list.append(HashMap<String, Any?>())
    assertArrayEquals(
      arrayOf(LeftSquareBracketJsonToken, LeftCurlyBracketJsonToken, RightCurlyBracketJsonToken, CommaJsonToken, RightSquareBracketJsonToken), list.tokenize()
    )
  }

  @Test fun `test tokenize when input contains an array that contains a value`() {
    val list = ArrayList<Any?>()
    list.append(320.1f)
    assertArrayEquals(arrayOf(LeftSquareBracketJsonToken, NumberJsonToken(320.1f), CommaJsonToken, RightSquareBracketJsonToken), list.tokenize())
  }

  @Test fun `test tokenize when input contains a Visual Studio Code config object`() {
    val document = HashMap<String, Any?>()
    document["javascript.validate.enable"] = false
    document["standard.usePackageJson"] = true
    document["standard.engine"] = "ts-standard"
    document["standard.validate"] = ArrayList<Any?>()
    (document["standard.validate"] as ArrayList<Any?>).append("javascript")
    assertArrayEquals(
      arrayOf(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("javascript.validate.enable"),
        ColonJsonToken,
        FalseJsonToken,
        CommaJsonToken,
        KeyJsonToken("standard.engine"),
        ColonJsonToken,
        StringJsonToken("ts-standard"),
        CommaJsonToken,
        KeyJsonToken("standard.usePackageJson"),
        ColonJsonToken,
        TrueJsonToken,
        CommaJsonToken,
        KeyJsonToken("standard.validate"),
        ColonJsonToken,
        LeftSquareBracketJsonToken,
        StringJsonToken("javascript"),
        CommaJsonToken,
        RightSquareBracketJsonToken,
        CommaJsonToken,
        RightCurlyBracketJsonToken
      ),
      document.tokenize()
    )
  }

  @Test fun `test tokenize when input contains a reverse proxy config object`() {
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
  }
}
