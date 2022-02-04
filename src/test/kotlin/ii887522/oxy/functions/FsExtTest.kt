package ii887522.oxy.functions

import org.junit.Assert.*
import org.junit.Test

class FsExtTest {
  @Test fun `test get file name`() {
    assertEquals("SDL2.dll", "SDL2-2.0.12/lib/x86/SDL2.dll".fileName)
    assertEquals("libpng16-16.dll", "SDL2_image-2.0.5/lib/x86/libpng16-16.dll".fileName)
    assertEquals("SDL2_ttf.dll", "SDL2_ttf-2.0.15/lib/x86/SDL2_ttf.dll".fileName)
  }

  @Test fun `test has file with extension`() {
    assertFalse("src/test/resources/a".hasFileWithExtension("txt"))
    assertTrue("src/test/resources/c".hasFileWithExtension("txt"))
    assertFalse("src/test/resources/d".hasFileWithExtension("txt"))
    assertTrue("src/test/resources/e".hasFileWithExtension("txt"))
    assertTrue("src/test/resources/f".hasFileWithExtension("txt"))
    assertFalse("src/test/resources/g".hasFileWithExtension("txt"))
    assertTrue("src/test/resources/h".hasFileWithExtension("txt"))
    assertTrue("src/test/resources/i".hasFileWithExtension("txt"))
    assertFalse("src/test/resources/a".hasFileWithExtension("png"))
    assertFalse("src/test/resources/c".hasFileWithExtension("png"))
    assertTrue("src/test/resources/d".hasFileWithExtension("png"))
    assertTrue("src/test/resources/e".hasFileWithExtension("png"))
    assertFalse("src/test/resources/f".hasFileWithExtension("png"))
    assertTrue("src/test/resources/g".hasFileWithExtension("png"))
    assertTrue("src/test/resources/h".hasFileWithExtension("png"))
    assertFalse("src/test/resources/i".hasFileWithExtension("png"))
  }

  @Test fun `test read`() {
    assertEquals("", "src/test/resources/c/a.txt".read())
    assertEquals("a", "src/test/resources/e/a.txt".read())
    assertEquals("b", "src/test/resources/f/a.txt".read())
    assertEquals("c", "src/test/resources/f/b.txt".read())
    assertEquals("ca", "src/test/resources/h/a.txt".read())
    assertEquals("cb", "src/test/resources/i/a.txt".read())
    assertEquals("db", "src/test/resources/i/b.txt".read())
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
  }
}
