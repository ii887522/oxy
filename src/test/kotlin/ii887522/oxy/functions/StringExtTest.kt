package ii887522.oxy.functions

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StringExtTest {
  @Test fun `test substring`() {
    assertEquals("SDL2-2.0.12/", "SDL2-2.0.12/lib/x86/SDL2.dll".substring("SDL", "l"))
    assertEquals("SDL2_image-2.0.5/", "SDL2_image-2.0.5/lib/x86/libpng16-16.dll".substring("SDL", "l"))
    assertEquals("image-2.0.5/", "SDL2_image-2.0.5/lib/x86/libpng16-16.dll".substring("image", "l"))
    assertEquals("image-2.0.5/lib/x86/libpng16-16", "SDL2_image-2.0.5/lib/x86/libpng16-16.dll".substring("image", ".dll"))
  }

  @Test fun `test is unsigned integer`() {
    assertFalse("/".isUint)
    assertTrue("0".isUint)
    assertTrue("5".isUint)
    assertTrue("9".isUint)
    assertFalse(":".isUint)
    assertFalse(":/".isUint)
    assertFalse(":0".isUint)
    assertFalse(":9".isUint)
    assertFalse("::".isUint)
    assertFalse(":5".isUint)
    assertFalse("9/".isUint)
    assertTrue("95".isUint)
    assertFalse("95/".isUint)
    assertTrue("950".isUint)
    assertTrue("955".isUint)
    assertTrue("959".isUint)
    assertFalse("95:".isUint)
  }
}
