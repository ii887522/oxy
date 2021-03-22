package ii887522.oxy.functions

import ii887522.oxy.struct.IntPtr
import ii887522.oxy.struct.IntRange
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test

class MathExtTest {
  @Test fun clamp0In1To3IsCorrect() {
    val n = IntPtr(0)
    clamp(n, IntRange(1, 3))
    assertEquals(1, n.value)
  }

  @Test fun clamp1In1To3IsCorrect() {
    val n = IntPtr(1)
    clamp(n, IntRange(1, 3))
    assertEquals(1, n.value)
  }

  @Test fun clamp2In1To3IsCorrect() {
    val n = IntPtr(2)
    clamp(n, IntRange(1, 3))
    assertEquals(2, n.value)
  }

  @Test fun clamp3In1To3IsCorrect() {
    val n = IntPtr(3)
    clamp(n, IntRange(1, 3))
    assertEquals(3, n.value)
  }

  @Test fun clamp4In1To3IsCorrect() {
    val n = IntPtr(4)
    clamp(n, IntRange(1, 3))
    assertEquals(3, n.value)
  }

  @Test fun clamp0In2To6IsCorrect() {
    val n = IntPtr(0)
    clamp(n, IntRange(2, 6))
    assertEquals(2, n.value)
  }

  @Test fun clamp2In2To6IsCorrect() {
    val n = IntPtr(2)
    clamp(n, IntRange(2, 6))
    assertEquals(2, n.value)
  }

  @Test fun clamp4In2To6IsCorrect() {
    val n = IntPtr(4)
    clamp(n, IntRange(2, 6))
    assertEquals(4, n.value)
  }

  @Test fun clamp6In2To6IsCorrect() {
    val n = IntPtr(6)
    clamp(n, IntRange(2, 6))
    assertEquals(6, n.value)
  }

  @Test fun clamp8In2To6IsCorrect() {
    val n = IntPtr(8)
    clamp(n, IntRange(2, 6))
    assertEquals(6, n.value)
  }

  @Test fun isOverlapXIsCorrect() {
    assertFalse(0 isOverlapX IntRange(1, 3))
    assertTrue(1 isOverlapX IntRange(1, 3))
    assertTrue(2 isOverlapX IntRange(1, 3))
    assertFalse(3 isOverlapX IntRange(1, 3))
    assertFalse(4 isOverlapX IntRange(1, 3))
    assertFalse(0 isOverlapX IntRange(2, 6))
    assertTrue(2 isOverlapX IntRange(2, 6))
    assertTrue(4 isOverlapX IntRange(2, 6))
    assertFalse(6 isOverlapX IntRange(2, 6))
    assertFalse(8 isOverlapX IntRange(2, 6))
  }

  @Test fun isOverlapYIsCorrect() {
    assertFalse(0 isOverlapY IntRange(1, 3))
    assertTrue(1 isOverlapY IntRange(1, 3))
    assertTrue(2 isOverlapY IntRange(1, 3))
    assertFalse(3 isOverlapY IntRange(1, 3))
    assertFalse(4 isOverlapY IntRange(1, 3))
    assertFalse(0 isOverlapY IntRange(2, 6))
    assertTrue(2 isOverlapY IntRange(2, 6))
    assertTrue(4 isOverlapY IntRange(2, 6))
    assertFalse(6 isOverlapY IntRange(2, 6))
    assertFalse(8 isOverlapY IntRange(2, 6))
  }

  @Test fun minIsCorrect() {
    assertEquals(0, min(0, 0))
    assertEquals(0, min(1, 0))
    assertEquals(1, min(1, 1))
    assertEquals(1, min(1, 2))
  }

  @Test fun maxIsCorrect() {
    assertEquals(0, max(0, 0))
    assertEquals(1, max(1, 0))
    assertEquals(1, max(1, 1))
    assertEquals(2, max(1, 2))
  }
}
