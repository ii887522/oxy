package ii887522.oxy.collection

import ii887522.oxy.functions.toArray
import ii887522.oxy.functions.sort
import org.junit.Assert.*
import org.junit.Test

class HashMapTest {
  @Test fun `test initial capacity less than 4`() {
    assertThrows(IllegalArgumentException::class.java) {
      HashMap<Any?, Any?>(1)
    }
  }

  @Test fun `test get zero keys with initial capacity equal to 4`() {
    val keys = HashMap<String, Int>(4).keys.toArray()
    keys.sort()
    assertArrayEquals(arrayOf(), keys)
  }

  @Test fun `test get one key with initial capacity equal to 4`() {
    val map = HashMap<String, Int>(4)
    map["a"] = 0
    val keys = map.keys.toArray()
    keys.sort()
    assertArrayEquals(arrayOf("a"), keys)
  }

  @Test fun `test get 2 keys with initial capacity equal to 4`() {
    val map = HashMap<String, Int>(4)
    map["a"] = 0
    map["b"] = 1
    val keys = map.keys.toArray()
    keys.sort()
    assertArrayEquals(arrayOf("a", "b"), keys)
  }

  @Test fun `test get 3 keys with initial capacity equal to 4`() {
    val map = HashMap<String, Int>(4)
    map["a"] = 0
    map["b"] = 1
    map["c"] = 2
    val keys = map.keys.toArray()
    keys.sort()
    assertArrayEquals(arrayOf("a", "b", "c"), keys)
  }

  @Test fun `test get zero keys with initial capacity equal to 7`() {
    val keys = HashMap<String, Int>(7).keys.toArray()
    keys.sort()
    assertEquals(0, keys.size)
  }

  @Test fun `test get one key with initial capacity equal to 7`() {
    val map = HashMap<String, Int>(7)
    map["a"] = 0
    val keys = map.keys.toArray()
    keys.sort()
    assertArrayEquals(arrayOf("a"), keys)
  }

  @Test fun `test get 2 keys with initial capacity equal to 7`() {
    val map = HashMap<String, Int>(7)
    map["a"] = 0
    map["b"] = 1
    val keys = map.keys.toArray()
    keys.sort()
    assertArrayEquals(arrayOf("a", "b"), keys)
  }

  @Test fun `test get 3 keys with initial capacity equal to 7`() {
    val map = HashMap<String, Int>(7)
    map["a"] = 0
    map["b"] = 1
    map["c"] = 2
    val keys = map.keys.toArray()
    keys.sort()
    assertArrayEquals(arrayOf("a", "b", "c"), keys)
  }

  @Test fun `test put with initial capacity equal to 4`() {
    val map = HashMap<String, Int>(4)
    assertNull(map["a"])
    assertEquals(0, map.size)
    map["a"] = 0
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map.size)
    map["b"] = 1
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map.size)
    map["c"] = 2
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map.size)
    map["d"] = 3
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map.size)
    map["e"] = 4
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map.size)
    map["f"] = 5
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map.size)
    map["g"] = 6
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map.size)
    map["a"] = 7
    assertEquals(7, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map.size)
    map["b"] = 8
    assertEquals(7, map["a"]!!.toInt())
    assertEquals(8, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map.size)
    map["c"] = 9
    assertEquals(7, map["a"]!!.toInt())
    assertEquals(8, map["b"]!!.toInt())
    assertEquals(9, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map.size)
    map["d"] = 10
    assertEquals(7, map["a"]!!.toInt())
    assertEquals(8, map["b"]!!.toInt())
    assertEquals(9, map["c"]!!.toInt())
    assertEquals(10, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map.size)
    map["e"] = 11
    assertEquals(7, map["a"]!!.toInt())
    assertEquals(8, map["b"]!!.toInt())
    assertEquals(9, map["c"]!!.toInt())
    assertEquals(10, map["d"]!!.toInt())
    assertEquals(11, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map.size)
    map["f"] = 12
    assertEquals(7, map["a"]!!.toInt())
    assertEquals(8, map["b"]!!.toInt())
    assertEquals(9, map["c"]!!.toInt())
    assertEquals(10, map["d"]!!.toInt())
    assertEquals(11, map["e"]!!.toInt())
    assertEquals(12, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map.size)
    map["g"] = 13
    assertEquals(7, map["a"]!!.toInt())
    assertEquals(8, map["b"]!!.toInt())
    assertEquals(9, map["c"]!!.toInt())
    assertEquals(10, map["d"]!!.toInt())
    assertEquals(11, map["e"]!!.toInt())
    assertEquals(12, map["f"]!!.toInt())
    assertEquals(13, map["g"]!!.toInt())
    assertEquals(7, map.size)
  }

  @Test fun `test put with initial capacity equal to 7`() {
    val map = HashMap<String, Int>(7)
    assertNull(map["a"])
    assertEquals(0, map.size)
    map["a"] = 0
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map.size)
    map["b"] = 1
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map.size)
    map["c"] = 2
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map.size)
    map["d"] = 3
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map.size)
    map["e"] = 4
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map.size)
    map["f"] = 5
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map.size)
    map["g"] = 6
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map.size)
    map["h"] = 7
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map["h"]!!.toInt())
    assertEquals(8, map.size)
    map["i"] = 8
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map["h"]!!.toInt())
    assertEquals(8, map["i"]!!.toInt())
    assertEquals(9, map.size)
    map["j"] = 9
    assertEquals(0, map["a"]!!.toInt())
    assertEquals(1, map["b"]!!.toInt())
    assertEquals(2, map["c"]!!.toInt())
    assertEquals(3, map["d"]!!.toInt())
    assertEquals(4, map["e"]!!.toInt())
    assertEquals(5, map["f"]!!.toInt())
    assertEquals(6, map["g"]!!.toInt())
    assertEquals(7, map["h"]!!.toInt())
    assertEquals(8, map["i"]!!.toInt())
    assertEquals(9, map["j"]!!.toInt())
    assertEquals(10, map.size)
  }

  @Test fun `test remove with initial capacity equal to 4`() {
    val map = HashMap<String, Int>(4)
    map["a"] = 0
    map["b"] = 1
    map["c"] = 2
    map["d"] = 3
    assertEquals(1, map.remove("b")!!.toInt())
    assertEquals(3, map.remove("d")!!.toInt())
    assertEquals(0, map.remove("a")!!.toInt())
    assertEquals(1, map.size)
    assertNull(map.remove("e"))
    assertEquals(2, map.remove("c")!!.toInt())
    assertEquals(0, map.size)
    assertNull(map.remove("a"))
  }

  @Test fun `test remove with initial capacity equal to 7`() {
    val map = HashMap<String, Int>(7)
    map["a"] = 0
    map["b"] = 1
    map["c"] = 2
    map["d"] = 3
    map["e"] = 4
    map["f"] = 5
    map["g"] = 6
    assertEquals(1, map.remove("b")!!.toInt())
    assertEquals(6, map.remove("g")!!.toInt())
    assertEquals(0, map.remove("a")!!.toInt())
    assertEquals(4, map.size)
    assertNull(map.remove("h"))
    assertEquals(2, map.remove("c")!!.toInt())
    assertEquals(3, map.remove("d")!!.toInt())
    assertEquals(4, map.remove("e")!!.toInt())
    assertEquals(5, map.remove("f")!!.toInt())
    assertEquals(0, map.size)
    assertNull(map.remove("a"))
  }

  @Test fun `test clear with initial capacity equal to 4`() {
    val map = HashMap<String, Int>(4)
    map.clear()
    assertEquals(0, map.size)
    map["a"] = 1
    map.clear()
    assertEquals(0, map.size)
  }

  @Test fun `test clear with initial capacity equal to 7`() {
    val map = HashMap<String, Int>(7)
    map.clear()
    assertEquals(0, map.size)
    map["a"] = 1
    map.clear()
    assertEquals(0, map.size)
  }
}
