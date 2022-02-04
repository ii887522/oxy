package ii887522.oxy.collection

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class ArrayStackTest {
  @Test fun `test push`() {
    val numbers = ArrayStack<Int>()
    numbers.push(0)
    assertEquals(1, numbers.size)
    numbers.push(1)
    assertEquals(2, numbers.size)
    numbers.push(2)
    assertEquals(3, numbers.size)
    assertEquals(2, numbers.peek())
    assertEquals(2, numbers.pop())
    assertEquals(2, numbers.size)
    assertEquals(1, numbers.pop())
    assertEquals(1, numbers.size)
    assertEquals(0, numbers.pop())
    assertEquals(0, numbers.size)
    numbers.push(3)
    assertEquals(1, numbers.size)
    numbers.push(4)
    assertEquals(2, numbers.size)
    numbers.push(5)
    assertEquals(3, numbers.size)
    assertEquals(5, numbers.peek())
    assertEquals(5, numbers.pop())
    assertEquals(2, numbers.size)
    assertEquals(4, numbers.pop())
    assertEquals(1, numbers.size)
    assertEquals(3, numbers.pop())
    assertEquals(0, numbers.size)
    assertThrows(IllegalStateException::class.java) {
      numbers.pop()
    }
    assertThrows(IllegalStateException::class.java) {
      numbers.peek()
    }
  }

  @Test fun `test set at the end`() {
    val numbers = ArrayStack<Int>()
    numbers.push(0)
    numbers.push(1)
    numbers.push(2)
    assertEquals(3, numbers.size)
    assertEquals(2, numbers.peek())
    numbers.setEnd(3)
    assertEquals(3, numbers.pop())
    assertEquals(2, numbers.size)
    assertEquals(1, numbers.peek())
    numbers.setEnd(4)
    assertEquals(4, numbers.pop())
    assertEquals(1, numbers.size)
    assertEquals(0, numbers.peek())
    numbers.setEnd(5)
    assertEquals(5, numbers.pop())
    assertEquals(0, numbers.size)
    assertThrows(IllegalStateException::class.java) {
      numbers.setEnd(6)
    }
  }

  @Test fun `test clear`() {
    val numbers = ArrayStack<Int>()
    numbers.clear()
    assertEquals(0, numbers.size)
    numbers.push(0)
    numbers.clear()
    assertEquals(0, numbers.size)
  }
}
