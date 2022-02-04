package ii887522.oxy.functions

import ii887522.oxy.struct.IntRange
import org.junit.Assert.*
import org.junit.Test

class MathExtTest {
  @Test fun `test clamp`() {
    assertEquals(1, clamp(0, IntRange(1, 3)))
    assertEquals(1, clamp(1, IntRange(1, 3)))
    assertEquals(2, clamp(2, IntRange(1, 3)))
    assertEquals(3, clamp(3, IntRange(1, 3)))
    assertEquals(3, clamp(4, IntRange(1, 3)))
    assertEquals(2, clamp(0, IntRange(2, 6)))
    assertEquals(2, clamp(2, IntRange(2, 6)))
    assertEquals(4, clamp(4, IntRange(2, 6)))
    assertEquals(6, clamp(6, IntRange(2, 6)))
    assertEquals(6, clamp(8, IntRange(2, 6)))
  }

  @Test fun `test is overlap`() {
    assertFalse(0 isOverlap IntRange(1, 3))
    assertTrue(1 isOverlap IntRange(1, 3))
    assertTrue(2 isOverlap IntRange(1, 3))
    assertTrue(3 isOverlap IntRange(1, 3))
    assertFalse(4 isOverlap IntRange(1, 3))
    assertFalse(0 isOverlap IntRange(2, 6))
    assertTrue(2 isOverlap IntRange(2, 6))
    assertTrue(4 isOverlap IntRange(2, 6))
    assertTrue(6 isOverlap IntRange(2, 6))
    assertFalse(8 isOverlap IntRange(2, 6))
  }

  @Test fun `test to seconds`() {
    assertEquals(0f, toSeconds(0L))
    assertEquals(1f, toSeconds(1e+9.toLong()))
    assertEquals(2f, toSeconds(2e+9.toLong()))
  }

  @Test fun `test is ddd`() {
    assertFalse(0.isOdd)
    assertTrue(1.isOdd)
    assertFalse(2.isOdd)
    assertTrue(3.isOdd)
  }

  @Test fun `test is even`() {
    assertTrue(0.isEven)
    assertFalse(1.isEven)
    assertTrue(2.isEven)
    assertFalse(3.isEven)
  }

  @Test fun `test is prime`() {
    assertFalse(0.isPrime)
    assertFalse(1.isPrime)
    assertTrue(2.isPrime)
    assertTrue(3.isPrime)
    assertFalse(4.isPrime)
    assertTrue(5.isPrime)
    assertFalse(6.isPrime)
    assertTrue(7.isPrime)
    assertFalse(8.isPrime)
    assertFalse(9.isPrime)
    assertFalse(10.isPrime)
    assertTrue(11.isPrime)
    assertFalse(12.isPrime)
    assertTrue(13.isPrime)
    assertFalse(14.isPrime)
    assertFalse(15.isPrime)
    assertFalse(16.isPrime)
    assertTrue(17.isPrime)
    assertFalse(18.isPrime)
    assertTrue(19.isPrime)
    assertFalse(20.isPrime)
    assertFalse(21.isPrime)
    assertFalse(22.isPrime)
    assertTrue(23.isPrime)
  }

  @Test fun `test get next prime`() {
    assertEquals(2, 0.nextPrime)
    assertEquals(2, 1.nextPrime)
    assertEquals(3, 2.nextPrime)
    assertEquals(5, 3.nextPrime)
    assertEquals(5, 4.nextPrime)
    assertEquals(7, 5.nextPrime)
    assertEquals(7, 6.nextPrime)
    assertEquals(11, 7.nextPrime)
  }

  @Test fun `test is power of two`() {
    assertTrue(1.isPowerOfTwo)
    assertTrue(2.isPowerOfTwo)
    assertFalse(3.isPowerOfTwo)
    assertTrue(4.isPowerOfTwo)
    assertFalse(5.isPowerOfTwo)
  }

  @Test fun `test integer size`() {
    assertEquals(1, 0.size)
    assertEquals(1, 1.size)
    assertEquals(1, 2.size)
    assertEquals(2, 20.size)
    assertEquals(2, 21.size)
    assertEquals(2, 31.size)
    assertEquals(3, 310.size)
  }

  @Test fun `test integer as a fraction to float`() {
    assertEquals(0f, 0.asFractionToFloat())
    assertEquals(.1f, 1.asFractionToFloat())
    assertEquals(.2f, 2.asFractionToFloat())
    assertEquals(.2f, 20.asFractionToFloat())
    assertEquals(.21f, 21.asFractionToFloat())
    assertEquals(.31f, 31.asFractionToFloat())
    assertEquals(.31f, 310.asFractionToFloat())
    assertEquals(.311f, 311.asFractionToFloat())
    assertEquals(.321f, 321.asFractionToFloat())
    assertEquals(.0321f, 321.asFractionToFloat(1))
    assertEquals(.00321f, 321.asFractionToFloat(2))
  }
}
