package ii887522.oxy.collection

import org.junit.Assert.*
import org.junit.Test

class LinkedListTest {
  @Test fun `test set`() {
    val numbers = LinkedList<Int>()
    numbers.append(0)
    numbers.append(1)
    numbers.append(2)
    assertThrows(IllegalArgumentException::class.java) { numbers[-1] = 3 }
    assertThrows(IllegalArgumentException::class.java) { numbers[3] = 3 }
    numbers[0] = 3
    numbers[1] = 4
    numbers[2] = 5
    val numberIterator = numbers.iterator()
    assertTrue(numberIterator.hasNext())
    assertEquals(3, numberIterator.next())
    assertTrue(numberIterator.hasNext())
    assertEquals(4, numberIterator.next())
    assertTrue(numberIterator.hasNext())
    assertEquals(5, numberIterator.next())
  }

  @Test fun `test get`() {
    val numbers = LinkedList<Int>()
    numbers.append(0)
    numbers.append(1)
    numbers.append(2)
    assertThrows(IllegalArgumentException::class.java) { numbers[-1] }
    assertThrows(IllegalArgumentException::class.java) { numbers[3] }
    assertEquals(0, numbers[0])
    assertEquals(1, numbers[1])
    assertEquals(2, numbers[2])
    assertEquals(3, numbers.size)
  }

  @Test fun `test append`() {
    val numbers = LinkedList<Int>()
    numbers.append(0)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertFalse(numberIterator.hasNext())
      assertEquals(1, numbers.size)
    }
    numbers.append(1)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertFalse(numberIterator.hasNext())
      assertEquals(2, numbers.size)
    }
    numbers.append(2)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertFalse(numberIterator.hasNext())
      assertEquals(3, numbers.size)
    }
  }

  @Test fun `test prepend`() {
    val numbers = LinkedList<Int>()
    numbers.prepend(0)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertFalse(numberIterator.hasNext())
      assertEquals(1, numbers.size)
    }
    numbers.prepend(1)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertFalse(numberIterator.hasNext())
      assertEquals(2, numbers.size)
    }
    numbers.prepend(2)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertFalse(numberIterator.hasNext())
      assertEquals(3, numbers.size)
    }
  }

  @Test fun `test insert`() {
    val numbers = LinkedList<Int>()
    numbers.append(0)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertFalse(numberIterator.hasNext())
      assertEquals(1, numbers.size)
    }
    numbers.append(1)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertFalse(numberIterator.hasNext())
      assertEquals(2, numbers.size)
    }
    numbers.append(2)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertFalse(numberIterator.hasNext())
      assertEquals(3, numbers.size)
    }
    assertThrows(IllegalArgumentException::class.java) { numbers.insert(-1, 3) }
    assertThrows(IllegalArgumentException::class.java) { numbers.insert(4, 3) }
    numbers.insert(0, 3)
    numbers.insert(4, 4)
    numbers.insert(1, 5)
    numbers.insert(2, 6)
    numbers.insert(3, 7)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(3, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(5, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(6, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(7, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(4, numberIterator.next())
      assertFalse(numberIterator.hasNext())
      assertEquals(8, numbers.size)
    }
  }

  @Test fun `test remove`() {
    val numbers = LinkedList<Int>()
    assertThrows(IllegalStateException::class.java) { numbers.remove(0) }
    numbers.append(0)
    numbers.append(1)
    numbers.append(2)
    numbers.append(3)
    numbers.append(4)
    numbers.append(5)
    numbers.append(6)
    numbers.append(7)
    numbers.append(8)
    numbers.append(9)
    numbers.append(10)
    numbers.append(11)
    numbers.append(12)
    numbers.append(13)
    numbers.append(14)
    numbers.append(15)
    assertThrows(IllegalArgumentException::class.java) { numbers.remove(-1) }
    assertThrows(IllegalArgumentException::class.java) { numbers.remove(16) }
    assertEquals(0, numbers.remove(0))
    assertEquals(15, numbers.remove(14))
    assertEquals(2, numbers.remove(1))
    assertEquals(4, numbers.remove(2))
    assertEquals(6, numbers.remove(3))
    assertEquals(11, numbers.size)
  }

  @Test fun `test remove back`() {
    val numbers = LinkedList<Int>()
    assertThrows(IllegalStateException::class.java) { numbers.removeBack() }
    numbers.append(0)
    numbers.append(1)
    numbers.append(2)
    numbers.append(3)
    numbers.append(4)
    numbers.append(5)
    assertEquals(5, numbers.removeBack())
    assertEquals(4, numbers.removeBack())
    assertEquals(3, numbers.removeBack())
    assertEquals(2, numbers.removeBack())
    assertEquals(1, numbers.removeBack())
    assertEquals(0, numbers.removeBack())
    assertFalse(numbers.iterator().hasNext())
    assertEquals(0, numbers.size)
  }

  @Test fun `test remove front`() {
    val numbers = LinkedList<Int>()
    assertThrows(IllegalStateException::class.java) { numbers.removeFront() }
    numbers.append(0)
    numbers.append(1)
    numbers.append(2)
    numbers.append(3)
    numbers.append(4)
    numbers.append(5)
    assertEquals(0, numbers.removeFront())
    assertEquals(1, numbers.removeFront())
    assertEquals(2, numbers.removeFront())
    assertEquals(3, numbers.removeFront())
    assertEquals(4, numbers.removeFront())
    assertEquals(5, numbers.removeFront())
    assertFalse(numbers.iterator().hasNext())
    assertEquals(0, numbers.size)
  }

  @Test fun `test clear`() {
    val numbers = LinkedList<Int>()
    numbers.clear()
    assertEquals(0, numbers.size)
    numbers.append(0)
    numbers.clear()
    assertEquals(0, numbers.size)
  }

  @Test fun `test swap`() {
    val numbers = LinkedList<Int>()
    numbers.append(0)
    numbers.append(1)
    numbers.append(2)
    numbers.append(3)
    numbers.append(4)
    numbers.swap(0, 0)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(3, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(4, numberIterator.next())
      assertFalse(numberIterator.hasNext())
    }
    numbers.swap(0, 1)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(3, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(4, numberIterator.next())
      assertFalse(numberIterator.hasNext())
    }
    numbers.swap(0, 2)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(3, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(4, numberIterator.next())
      assertFalse(numberIterator.hasNext())
    }
    numbers.swap(1, 2)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(3, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(4, numberIterator.next())
      assertFalse(numberIterator.hasNext())
    }
    numbers.swap(2, 2)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(3, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(4, numberIterator.next())
      assertFalse(numberIterator.hasNext())
    }
    numbers.swap(2, 3)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(3, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(4, numberIterator.next())
      assertFalse(numberIterator.hasNext())
    }
    numbers.swap(2, 4)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(4, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(3, numberIterator.next())
      assertFalse(numberIterator.hasNext())
    }
    numbers.swap(3, 4)
    run {
      val numberIterator = numbers.iterator()
      assertTrue(numberIterator.hasNext())
      assertEquals(2, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(1, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(4, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(3, numberIterator.next())
      assertTrue(numberIterator.hasNext())
      assertEquals(0, numberIterator.next())
      assertFalse(numberIterator.hasNext())
    }
    assertThrows(java.lang.IllegalArgumentException::class.java) { numbers.swap(-1, 0) }
    assertThrows(java.lang.IllegalArgumentException::class.java) { numbers.swap(5, 0) }
    assertThrows(java.lang.IllegalArgumentException::class.java) { numbers.swap(0, -1) }
    assertThrows(java.lang.IllegalArgumentException::class.java) { numbers.swap(0, 5) }
    assertThrows(java.lang.IllegalArgumentException::class.java) { numbers.swap(1, 0) }
  }

  @Test fun `test iterator`() {
    val numbers = LinkedList<Int>()
    numbers.append(0)
    numbers.append(1)
    numbers.append(2)
    val numberIterator = numbers.iterator()
    assertTrue(numberIterator.hasNext())
    assertEquals(0, numberIterator.next())
    assertTrue(numberIterator.hasNext())
    assertEquals(1, numberIterator.next())
    assertTrue(numberIterator.hasNext())
    assertEquals(2, numberIterator.next())
    assertFalse(numberIterator.hasNext())
    assertEquals(3, numbers.size)
  }
}
