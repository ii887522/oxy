package ii887522.oxy.any

import org.junit.Assert.assertEquals
import org.junit.Test

class ReactiveTest {
  @Test fun `test set the reactive value when the initial value is equal to 0`() {
    val n = Reactive(0)
    n.value = 1
    assertEquals(1, n.value)
    var count = 0
    n += { _, newValue -> count += newValue }
    n.value = 2
    assertEquals(2, n.value)
    assertEquals(2, count)
    n += { _, newValue -> count += newValue }
    n.value = 3
    assertEquals(3, n.value)
    assertEquals(8, count)
  }

  @Test fun `test set the reactive value when the initial value is equal to 2`() {
    val n = Reactive(2)
    n.value = 1
    assertEquals(1, n.value)
    var count = 0
    n += { _, newValue -> count += newValue }
    n.value = 2
    assertEquals(2, n.value)
    assertEquals(2, count)
    n += { _, newValue -> count += newValue }
    n.value = 3
    assertEquals(3, n.value)
    assertEquals(8, count)
  }
}
