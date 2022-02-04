package ii887522.oxy.functions

import ii887522.oxy.collection.ArrayList
import ii887522.oxy.collection.HashMap
import org.junit.Assert.assertArrayEquals
import org.junit.Test
import ii887522.oxy.struct.IntRange
import ii887522.oxy.struct.Pair

class CollectionExtTest {
  @Test fun `test swap in array between 0 and 1`() {
    val array = arrayOf(0, 1)
    array.swap(0, 1)
    assertArrayEquals(arrayOf(1, 0), array)
  }

  @Test fun `test swap in array between 0 and 2`() {
    val array = arrayOf(0, 1, 2)
    array.swap(0, 2)
    assertArrayEquals(arrayOf(2, 1, 0), array)
  }

  @Test fun `test swap in array between 0 and 3`() {
    val array = arrayOf(0, 1, 2, 3)
    array.swap(0, 3)
    assertArrayEquals(arrayOf(3, 1, 2, 0), array)
  }

  @Test fun `test swap in array between 1 and 3`() {
    val array = arrayOf(0, 1, 2, 3)
    array.swap(1, 3)
    assertArrayEquals(arrayOf(0, 3, 2, 1), array)
  }

  @Test fun `test swap in array between 2 and 3`() {
    val array = arrayOf(0, 1, 2, 3)
    array.swap(2, 3)
    assertArrayEquals(arrayOf(0, 1, 3, 2), array)
  }

  @Test fun `test insertion sort an array that contains 0`() {
    val numbers = arrayOf(0)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(0), numbers)
  }

  @Test fun `test insertion sort an array that contains 1`() {
    val numbers = arrayOf(1)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(1), numbers)
  }

  @Test fun `test insertion sort an array that contains 1 and 0`() {
    val numbers = arrayOf(1, 0)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(0, 1), numbers)
  }

  @Test fun `test insertion sort an array that contains 2 1's`() {
    val numbers = arrayOf(1, 1)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(1, 1), numbers)
  }

  @Test fun `test insertion sort an array that contains 2 and 1`() {
    val numbers = arrayOf(2, 1)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(1, 2), numbers)
  }

  @Test fun `test insertion sort an array that contains 2, 1 and 0`() {
    val numbers = arrayOf(2, 1, 0)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(0, 1, 2), numbers)
  }

  @Test fun `test insertion sort an array that contains 2, 1 and 1`() {
    val numbers = arrayOf(2, 1, 1)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(1, 1, 2), numbers)
  }

  @Test fun `test insertion sort an array that contains 2, 1 and 2`() {
    val numbers = arrayOf(2, 1, 2)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(1, 2, 2), numbers)
  }

  @Test fun `test insertion sort an array that contains 2, 1 and 3`() {
    val numbers = arrayOf(2, 1, 3)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(1, 2, 3), numbers)
  }

  @Test fun `test insertion sort an array that contains 2, 2 and 3`() {
    val numbers = arrayOf(2, 2, 3)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(2, 2, 3), numbers)
  }

  @Test fun `test insertion sort an array that contains 3, 2 and 3`() {
    val numbers = arrayOf(3, 2, 3)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(2, 3, 3), numbers)
  }

  @Test fun `test insertion sort an array that contains 4 elements`() {
    val numbers = arrayOf(3, 2, 3, 0)
    numbers.insertionSort()
    assertArrayEquals(arrayOf(0, 2, 3, 3), numbers)
  }

  @Test fun `test insertion sort an array that contains 4 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0)
    numbers.insertionSort(IntRange(0, numbers.lastIndex)) { left, right -> left < right }
    assertArrayEquals(arrayOf(3, 3, 2, 0), numbers)
  }

  @Test fun `test insertion sort an array that contains 5 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 5)
    numbers.insertionSort(IntRange(1, numbers.lastIndex)) { left, right -> left < right }
    assertArrayEquals(arrayOf(3, 5, 3, 2, 0), numbers)
  }

  @Test fun `test insertion sort 3 elements in the middle of an array in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 5)
    numbers.insertionSort(IntRange(1, 3)) { left, right -> left < right }
    assertArrayEquals(arrayOf(3, 3, 2, 0, 5), numbers)
  }

  @Test fun `test insertion sorts an array that contains 0`() {
    val numbers = arrayOf(0)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(0), numbers)
  }

  @Test fun `test insertion sorts an array that contains 1`() {
    val numbers = arrayOf(1)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(1), numbers)
  }

  @Test fun `test insertion sorts an array that contains 1 and 0`() {
    val numbers = arrayOf(1, 0)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(0, 1), numbers)
  }

  @Test fun `test insertion sorts an array that contains 2 1's`() {
    val numbers = arrayOf(1, 1)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(1, 1), numbers)
  }

  @Test fun `test insertion sorts an array that contains 2 and 1`() {
    val numbers = arrayOf(2, 1)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(1, 2), numbers)
  }

  @Test fun `test insertion sorts an array that contains 2, 1 and 0`() {
    val numbers = arrayOf(2, 1, 0)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(0, 1, 2), numbers)
  }

  @Test fun `test insertion sorts an array that contains 2, 1 and 1`() {
    val numbers = arrayOf(2, 1, 1)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(1, 1, 2), numbers)
  }

  @Test fun `test insertion sorts an array that contains 2, 1 and 2`() {
    val numbers = arrayOf(2, 1, 2)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(1, 2, 2), numbers)
  }

  @Test fun `test insertion sorts an array that contains 2, 1 and 3`() {
    val numbers = arrayOf(2, 1, 3)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(1, 2, 3), numbers)
  }

  @Test fun `test insertion sorts an array that contains 2, 2 and 3`() {
    val numbers = arrayOf(2, 2, 3)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(2, 2, 3), numbers)
  }

  @Test fun `test insertion sorts an array that contains 3, 2 and 3`() {
    val numbers = arrayOf(3, 2, 3)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(2, 3, 3), numbers)
  }

  @Test fun `test insertion sorts an array that contains 4 elements`() {
    val numbers = arrayOf(3, 2, 3, 0)
    numbers.insertionSorts()
    assertArrayEquals(arrayOf(0, 2, 3, 3), numbers)
  }

  @Test fun `test insertion sorts an array that contains 4 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0)
    numbers.insertionSorts(4) { left, right -> left < right }
    assertArrayEquals(arrayOf(3, 3, 2, 0), numbers)
  }

  @Test fun `test insertion sorts an array that contains 5 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4)
    numbers.insertionSorts(5) { left, right -> left < right }
    assertArrayEquals(arrayOf(4, 3, 3, 2, 0), numbers)
  }

  @Test fun `test insertion sorts an array that contains 6 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8)
    numbers.insertionSorts(6) { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 4, 3, 3, 2, 0), numbers)
  }

  @Test fun `test insertion sorts an array that contains 7 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6)
    numbers.insertionSorts(7) { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 6, 4, 3, 3, 2, 0), numbers)
  }

  @Test fun `test insertion sorts an array that contains 8 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1)
    numbers.insertionSorts(8) { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 6, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test insertion sorts an array that contains 9 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5)
    numbers.insertionSorts(9) { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 6, 5, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test insertion sorts an array that contains 10 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5, 9)
    numbers.insertionSorts(10) { left, right -> left < right }
    assertArrayEquals(arrayOf(9, 8, 6, 5, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test insertion sorts an array that contains 11 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5, 9, 7)
    numbers.insertionSorts(11) { left, right -> left < right }
    assertArrayEquals(arrayOf(9, 8, 7, 6, 5, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test insertion sorts an array in descending order into sorted runs of 4 elements`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5, 9, 7)
    numbers.insertionSorts(4) { left, right -> left < right }
    assertArrayEquals(arrayOf(3, 3, 2, 0, 8, 6, 4, 1, 9, 7, 5), numbers)
  }

  @Test fun `test merge sort an array that contains 0`() {
    val numbers = arrayOf(0)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(0), numbers)
  }

  @Test fun `test merge sort an array that contains 1`() {
    val numbers = arrayOf(1)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(1), numbers)
  }

  @Test fun `test merge sort an array that contains 1 and 0`() {
    val numbers = arrayOf(1, 0)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(0, 1), numbers)
  }

  @Test fun `test merge sort an array that contains 2 1's`() {
    val numbers = arrayOf(1, 1)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(1, 1), numbers)
  }

  @Test fun `test merge sort an array that contains 2 and 1`() {
    val numbers = arrayOf(2, 1)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(1, 2), numbers)
  }

  @Test fun `test merge sort an array that contains 2, 1 and 0`() {
    val numbers = arrayOf(2, 1, 0)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(0, 1, 2), numbers)
  }

  @Test fun `test merge sort an array that contains 2, 1 and 1`() {
    val numbers = arrayOf(2, 1, 1)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(1, 1, 2), numbers)
  }

  @Test fun `test merge sort an array that contains 2, 1 and 3`() {
    val numbers = arrayOf(2, 1, 3)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(1, 2, 3), numbers)
  }

  @Test fun `test merge sort an array that contains 2, 2 and 3`() {
    val numbers = arrayOf(2, 2, 3)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(2, 2, 3), numbers)
  }

  @Test fun `test merge sort an array that contains 3, 2 and 3`() {
    val numbers = arrayOf(3, 2, 3)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(2, 3, 3), numbers)
  }

  @Test fun `test merge sort an array that contains 4 elements`() {
    val numbers = arrayOf(3, 2, 3, 0)
    numbers.mergeSort()
    assertArrayEquals(arrayOf(0, 2, 3, 3), numbers)
  }

  @Test fun `test merge sort an array that contains 4 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0)
    numbers.mergeSort(1) { left, right -> left < right }
    assertArrayEquals(arrayOf(3, 3, 2, 0), numbers)
  }

  @Test fun `test merge sort an array that contains 5 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4)
    numbers.mergeSort(1) { left, right -> left < right }
    assertArrayEquals(arrayOf(4, 3, 3, 2, 0), numbers)
  }

  @Test fun `test merge sort an array that contains 6 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8)
    numbers.mergeSort(1) { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 4, 3, 3, 2, 0), numbers)
  }

  @Test fun `test merge sort an array that contains 7 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6)
    numbers.mergeSort(1) { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 6, 4, 3, 3, 2, 0), numbers)
  }

  @Test fun `test merge sort an array that contains 8 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1)
    numbers.mergeSort(1) { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 6, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test merge sort an array that contains 9 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5)
    numbers.mergeSort(1) { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 6, 5, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test merge sort an array that contains 10 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5, 9)
    numbers.mergeSort(1) { left, right -> left < right }
    assertArrayEquals(arrayOf(9, 8, 6, 5, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test merge sort an array that contains 11 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5, 9)
    numbers.mergeSort(1) { left, right -> left < right }
    assertArrayEquals(arrayOf(9, 8, 6, 5, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test merge sort an array that contains 11 elements in descending order with assumption that there are 2 elements in each sorted run`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5, 9, 7)
    numbers.mergeSort(2) { left, right -> left < right }
    assertArrayEquals(arrayOf(7, 6, 5, 9, 4, 8, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test sort an array that contains 0`() {
    val numbers = arrayOf(0)
    numbers.sort()
    assertArrayEquals(arrayOf(0), numbers)
  }

  @Test fun `test sort an array that contains 1`() {
    val numbers = arrayOf(1)
    numbers.sort()
    assertArrayEquals(arrayOf(1), numbers)
  }

  @Test fun `test sort an array that contains 1, 0`() {
    val numbers = arrayOf(1, 0)
    numbers.sort()
    assertArrayEquals(arrayOf(0, 1), numbers)
  }

  @Test fun `test sort an array that contains 2 1's`() {
    val numbers = arrayOf(1, 1)
    numbers.sort()
    assertArrayEquals(arrayOf(1, 1), numbers)
  }

  @Test fun `test sort an array that contains 2 and 1`() {
    val numbers = arrayOf(2, 1)
    numbers.sort()
    assertArrayEquals(arrayOf(1, 2), numbers)
  }

  @Test fun `test sort an array that contains 2, 1 and 0`() {
    val numbers = arrayOf(2, 1, 0)
    numbers.sort()
    assertArrayEquals(arrayOf(0, 1, 2), numbers)
  }

  @Test fun `test sort an array that contains 2, 1 and 1`() {
    val numbers = arrayOf(2, 1, 1)
    numbers.sort()
    assertArrayEquals(arrayOf(1, 1, 2), numbers)
  }

  @Test fun `test sort an array that contains 2, 1 and 2`() {
    val numbers = arrayOf(2, 1, 2)
    numbers.sort()
    assertArrayEquals(arrayOf(1, 2, 2), numbers)
  }

  @Test fun `test sort an array that contains 2, 1 and 3`() {
    val numbers = arrayOf(2, 1, 3)
    numbers.sort()
    assertArrayEquals(arrayOf(1, 2, 3), numbers)
  }

  @Test fun `test sort an array that contains 2, 2 and 3`() {
    val numbers = arrayOf(2, 2, 3)
    numbers.sort()
    assertArrayEquals(arrayOf(2, 2, 3), numbers)
  }

  @Test fun `test sort an array that contains 3, 2 and 3`() {
    val numbers = arrayOf(3, 2, 3)
    numbers.sort()
    assertArrayEquals(arrayOf(2, 3, 3), numbers)
  }

  @Test fun `test sort an array that contains 4 elements`() {
    val numbers = arrayOf(3, 2, 3, 0)
    numbers.sort()
    assertArrayEquals(arrayOf(0, 2, 3, 3), numbers)
  }

  @Test fun `test sort an array that contains 4 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0)
    numbers.sort { left, right -> left < right }
    assertArrayEquals(arrayOf(3, 3, 2, 0), numbers)
  }

  @Test fun `test sort an array that contains 5 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4)
    numbers.sort { left, right -> left < right }
    assertArrayEquals(arrayOf(4, 3, 3, 2, 0), numbers)
  }

  @Test fun `test sort an array that contains 6 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8)
    numbers.sort { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 4, 3, 3, 2, 0), numbers)
  }

  @Test fun `test sort an array that contains 7 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6)
    numbers.sort { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 6, 4, 3, 3, 2, 0), numbers)
  }

  @Test fun `test sort an array that contains 8 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1)
    numbers.sort { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 6, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test sort an array that contains 9 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5)
    numbers.sort { left, right -> left < right }
    assertArrayEquals(arrayOf(8, 6, 5, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test sort an array that contains 10 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5, 9)
    numbers.sort { left, right -> left < right }
    assertArrayEquals(arrayOf(9, 8, 6, 5, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test sort an array that contains 11 elements in descending order`() {
    val numbers = arrayOf(3, 2, 3, 0, 4, 8, 6, 1, 5, 9, 7)
    numbers.sort { left, right -> left < right }
    assertArrayEquals(arrayOf(9, 8, 7, 6, 5, 4, 3, 3, 2, 1, 0), numbers)
  }

  @Test fun `test to array from an array list of pair with default initial capacity`() {
    val numbers = ArrayList<Pair<Int, String>>()
    assertArrayEquals(arrayOf(), numbers.toArray())
    numbers.append(Pair(0, "a"))
    assertArrayEquals(arrayOf(Pair(0, "a")), numbers.toArray())
    numbers.append(Pair(1, "b"))
    assertArrayEquals(arrayOf(Pair(0, "a"), Pair(1, "b")), numbers.toArray())
    numbers.append(Pair(2, "c"))
    assertArrayEquals(arrayOf(Pair(0, "a"), Pair(1, "b"), Pair(2, "c")), numbers.toArray())
  }

  @Test fun `test to array from an array list of pair with initial capacity equal to 16`() {
    val numbers = ArrayList<Pair<Int, String>>(16)
    assertArrayEquals(arrayOf(), numbers.toArray())
    numbers.append(Pair(0, "a"))
    assertArrayEquals(arrayOf(Pair(0, "a")), numbers.toArray())
    numbers.append(Pair(1, "b"))
    assertArrayEquals(arrayOf(Pair(0, "a"), Pair(1, "b")), numbers.toArray())
    numbers.append(Pair(2, "c"))
    assertArrayEquals(arrayOf(Pair(0, "a"), Pair(1, "b"), Pair(2, "c")), numbers.toArray())
  }

  @Test fun `test to array from a hash map with initial capacity equal to 4`() {
    val map = HashMap<String, Int>(4)
    assertArrayEquals(arrayOf(), map.toArray())
    map["a"] = 0
    assertArrayEquals(arrayOf(Pair("a", 0)), map.toArray())
    map["b"] = 1
    assertArrayEquals(arrayOf(Pair("a", 0), Pair("b", 1)), map.toArray())
    map["c"] = 2
    assertArrayEquals(arrayOf(Pair("a", 0), Pair("b", 1), Pair("c", 2)), map.toArray())
  }

  @Test fun `test to array from a hash map with initial capacity equal to 7`() {
    val map = HashMap<String, Int>(7)
    assertArrayEquals(arrayOf(), map.toArray())
    map["a"] = 0
    assertArrayEquals(arrayOf(Pair("a", 0)), map.toArray())
    map["b"] = 1
    assertArrayEquals(arrayOf(Pair("a", 0), Pair("b", 1)), map.toArray())
    map["c"] = 2
    assertArrayEquals(arrayOf(Pair("a", 0), Pair("b", 1), Pair("c", 2)), map.toArray())
  }
}
