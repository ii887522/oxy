package ii887522.oxy.any

import ii887522.oxy.struct.IntPtr
import org.junit.Assert.assertEquals
import org.junit.Test

class AnimatedAnyTest {
  @Test fun teleportFrom0In250msIsCorrect() {
    val n = AnimatedAny(IntPtr(0), 250)
    n.teleport(IntPtr(1))
    assertEquals(0, n.start.value)
    assertEquals(1, n.now.value)
    assertEquals(1, n.end.value)
    n.teleport(IntPtr(2))
    assertEquals(1, n.start.value)
    assertEquals(2, n.now.value)
    assertEquals(2, n.end.value)
  }

  @Test fun teleportFrom10In250msIsCorrect() {
    val n = AnimatedAny(IntPtr(10), 250)
    n.teleport(IntPtr(1))
    assertEquals(10, n.start.value)
    assertEquals(1, n.now.value)
    assertEquals(1, n.end.value)
    n.teleport(IntPtr(2))
    assertEquals(1, n.start.value)
    assertEquals(2, n.now.value)
    assertEquals(2, n.end.value)
  }

  @Test fun teleportFrom10In500msIsCorrect() {
    val n = AnimatedAny(IntPtr(10), 500)
    n.teleport(IntPtr(1))
    assertEquals(10, n.start.value)
    assertEquals(1, n.now.value)
    assertEquals(1, n.end.value)
    n.teleport(IntPtr(2))
    assertEquals(1, n.start.value)
    assertEquals(2, n.now.value)
    assertEquals(2, n.end.value)
  }

  @Test fun teleportFrom10In500msWithOnAnimationEndLambdaIsCorrect() {
    var m = 0
    val n = AnimatedAny(IntPtr(10), 500) {
      ++m
    }
    n.teleport(IntPtr(1))
    assertEquals(10, n.start.value)
    assertEquals(1, n.now.value)
    assertEquals(1, n.end.value)
    assertEquals(0, m)
    n.teleport(IntPtr(2))
    assertEquals(1, n.start.value)
    assertEquals(2, n.now.value)
    assertEquals(2, n.end.value)
    assertEquals(0, m)
  }

  @Test fun stepFrom0In250msIsCorrect() {
    val n = AnimatedAny(IntPtr(0), 250)
    n.set(IntPtr(100))
    n.step(0)
    assertEquals(0, n.start.value)
    assertEquals(0, n.now.value)
    assertEquals(100, n.end.value)
    n.step(30)
    assertEquals(0, n.start.value)
    assertEquals(12, n.now.value)
    assertEquals(100, n.end.value)
    n.step(40)
    assertEquals(0, n.start.value)
    assertEquals(28, n.now.value)
    assertEquals(100, n.end.value)
    n.step(50)
    assertEquals(0, n.start.value)
    assertEquals(48, n.now.value)
    assertEquals(100, n.end.value)
    n.step(60)
    assertEquals(0, n.start.value)
    assertEquals(72, n.now.value)
    assertEquals(100, n.end.value)
    n.step(70)
    assertEquals(0, n.start.value)
    assertEquals(100, n.now.value)
    assertEquals(100, n.end.value)
  }

  @Test fun stepFrom10In250msIsCorrect() {
    val n = AnimatedAny(IntPtr(10), 250)
    n.set(IntPtr(110))
    n.step(0)
    assertEquals(10, n.start.value)
    assertEquals(10, n.now.value)
    assertEquals(110, n.end.value)
    n.step(30)
    assertEquals(10, n.start.value)
    assertEquals(22, n.now.value)
    assertEquals(110, n.end.value)
    n.step(40)
    assertEquals(10, n.start.value)
    assertEquals(38, n.now.value)
    assertEquals(110, n.end.value)
    n.step(50)
    assertEquals(10, n.start.value)
    assertEquals(58, n.now.value)
    assertEquals(110, n.end.value)
    n.step(60)
    assertEquals(10, n.start.value)
    assertEquals(82, n.now.value)
    assertEquals(110, n.end.value)
    n.step(70)
    assertEquals(10, n.start.value)
    assertEquals(110, n.now.value)
    assertEquals(110, n.end.value)
  }

  @Test fun stepFrom10In500msIsCorrect() {
    val n = AnimatedAny(IntPtr(10), 500)
    n.set(IntPtr(110))
    n.step(0)
    assertEquals(10, n.start.value)
    assertEquals(10, n.now.value)
    assertEquals(110, n.end.value)
    n.step(60)
    assertEquals(10, n.start.value)
    assertEquals(22, n.now.value)
    assertEquals(110, n.end.value)
    n.step(80)
    assertEquals(10, n.start.value)
    assertEquals(38, n.now.value)
    assertEquals(110, n.end.value)
    n.step(100)
    assertEquals(10, n.start.value)
    assertEquals(58, n.now.value)
    assertEquals(110, n.end.value)
    n.step(120)
    assertEquals(10, n.start.value)
    assertEquals(82, n.now.value)
    assertEquals(110, n.end.value)
    n.step(140)
    assertEquals(10, n.start.value)
    assertEquals(110, n.now.value)
    assertEquals(110, n.end.value)
  }

  @Test fun stepFrom10In500msWithOnAnimationEndLambdaIsCorrect() {
    var m = 0
    val n = AnimatedAny(IntPtr(10), 500) {
      ++m
    }
    n.set(IntPtr(110))
    n.step(0)
    assertEquals(10, n.start.value)
    assertEquals(10, n.now.value)
    assertEquals(110, n.end.value)
    assertEquals(0, m)
    n.step(60)
    assertEquals(10, n.start.value)
    assertEquals(22, n.now.value)
    assertEquals(110, n.end.value)
    assertEquals(0, m)
    n.step(80)
    assertEquals(10, n.start.value)
    assertEquals(38, n.now.value)
    assertEquals(110, n.end.value)
    assertEquals(0, m)
    n.step(100)
    assertEquals(10, n.start.value)
    assertEquals(58, n.now.value)
    assertEquals(110, n.end.value)
    assertEquals(0, m)
    n.step(120)
    assertEquals(10, n.start.value)
    assertEquals(82, n.now.value)
    assertEquals(110, n.end.value)
    assertEquals(0, m)
    n.step(140)
    assertEquals(10, n.start.value)
    assertEquals(110, n.now.value)
    assertEquals(110, n.end.value)
    assertEquals(1, m)
    n.step(10)
    assertEquals(10, n.start.value)
    assertEquals(110, n.now.value)
    assertEquals(110, n.end.value)
    assertEquals(1, m)
  }
}
