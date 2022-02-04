package ii887522.oxy.functions

import ii887522.oxy.collection.ArrayList
import ii887522.oxy.collection.HashMap
import ii887522.oxy.struct.Holder
import org.junit.Assert.*
import org.junit.Test

class UtilTest {
  @Test fun `test swap 0 and 1`() {
    val a = Holder(0)
    val b = Holder(1)
    swap(a, b)
    assertEquals(1, a.value)
    assertEquals(0, b.value)
  }

  @Test fun `test swap 0 and 2`() {
    val a = Holder(0)
    val b = Holder(2)
    swap(a, b)
    assertEquals(2, a.value)
    assertEquals(0, b.value)
  }

  @Test fun `test swap 0 and 3`() {
    val a = Holder(0)
    val b = Holder(3)
    swap(a, b)
    assertEquals(3, a.value)
    assertEquals(0, b.value)
  }

  @Test fun `test swap 1 and 3`() {
    val a = Holder(1)
    val b = Holder(3)
    swap(a, b)
    assertEquals(3, a.value)
    assertEquals(1, b.value)
  }

  @Test fun `test swap 2 and 3`() {
    val a = Holder(2)
    val b = Holder(3)
    swap(a, b)
    assertEquals(3, a.value)
    assertEquals(2, b.value)
  }

  @Test fun `test to formatted time`() {
    assertEquals("1:29", formatTime(89f))
    assertEquals("0:59", formatTime(59f))
    assertEquals("10:01", formatTime(601f))
  }

  @Test fun `test string as a JSON string that contains a Visual Studio Code config converted into an object`() {
    val document = """{
  "javascript.validate.enable": false,
  "standard.usePackageJson": true,
  "standard.engine": "ts-standard",
  "standard.validate": ["javascript"]
}
""".asJsonStringToObject()
    assertTrue(document is HashMap<*, *>)
    assertEquals(4, (document as HashMap<String, Any?>).size)
    assertEquals(false, document["javascript.validate.enable"])
    assertEquals(true, document["standard.usePackageJson"])
    assertEquals("ts-standard", document["standard.engine"])
    assertTrue(document["standard.validate"] is ArrayList<*>)
    assertEquals(1, (document["standard.validate"] as ArrayList<*>).size)
    assertEquals("javascript", (document["standard.validate"] as ArrayList<*>)[0])
  }

  @Test fun `test String as a JSON string that contains a reverse proxy config converted into an object`() {
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
  }

  @Test fun `test object that contains a Visual Studio Code config converted into a JSON string`() {
    val document = HashMap<String, Any?>()
    document["javascript.validate.enable"] = false
    document["standard.usePackageJson"] = true
    document["standard.engine"] = "ts-standard"
    document["standard.validate"] = ArrayList<Any?>()
    (document["standard.validate"] as ArrayList<Any?>).append("javascript")
    assertEquals(
      """{
  "javascript.validate.enable": false,
  "standard.engine": "ts-standard",
  "standard.usePackageJson": true,
  "standard.validate": ["javascript",],
}
""".filter { !it.isWhitespace() },
      document.toJsonString()
    )
  }

  @Test fun `test object that contains a reverse proxy config converted into a JSON string`() {
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
  }
}
