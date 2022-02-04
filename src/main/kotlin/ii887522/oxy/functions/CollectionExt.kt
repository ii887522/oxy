package ii887522.oxy.functions

import ii887522.oxy.collection.List
import ii887522.oxy.collection.Map
import ii887522.oxy.struct.Holder
import ii887522.oxy.struct.Pair
import kotlin.math.min
import ii887522.oxy.struct.IntRange
import java.lang.System.arraycopy

/**
 * It exchanges objects that are inside the array.
 *
 * @param leftIndex The index which identifies the left object to be moved.
 * @param rightIndex The index which identifies the right object to be moved.
 */
fun <T> Array<T>.swap(leftIndex: Int, rightIndex: Int) {
  val left = this[leftIndex]
  this[leftIndex] = this[rightIndex]
  this[rightIndex] = left
}

/**
 * It sorts a portion of the array by using insertion sort.
 *
 * @param indices The indices specify the portion of the array where the elements inside it will become sorted.
 * @param compare The function used to determine whether the positions of both elements should be swapped during sorting. If the function returns true, both
 *   elements will be swapped, otherwise nothing happens.
 */
inline fun <T : Comparable<T>> Array<T>.insertionSort(
  indices: IntRange = IntRange(0, Int.MAX_VALUE), compare: (left: T, right: T) -> Boolean = { left, right -> left > right }
) {
  val maxIndex = min(indices.max, size - 1)
  for (i in indices.min + 1..maxIndex) {
    for (j in i downTo indices.min + 1) {
      if (compare(this[j - 1], this[j])) swap(j - 1, j)
      else break
    }
  }
}

/**
 * It sorts the array into a sequence of sorted runs by using insertion sort. A run is a number of consecutive elements which is a part of the array.
 *
 * @param runSize The size of the consecutive elements which will become sorted.
 * @param compare The function used to determine whether the positions of both elements should be swapped during sorting. If the function returns true, both
 *   elements will be swapped, otherwise nothing happens.
 */
inline fun <T : Comparable<T>> Array<T>.insertionSorts(runSize: Int = Int.MAX_VALUE, compare: (left: T, right: T) -> Boolean = { left, right -> left > right }) {
  for (i in indices step runSize) insertionSort(IntRange(i, i + runSize - 1), compare)
}

/**
 * It sorts the array by using merge sort and assuming that there is a sequence of sorted runs in the array. Each sorted run has `sortedRunSize` consecutive
 * elements which is a part of the array.
 *
 * @param sortedRunSize The size of the consecutive elements which has become sorted.
 * @param compare The function used to determine whether the positions of both elements should be swapped during sorting. If the function returns true, both elements
 *   will be swapped, otherwise nothing happens.
 */
inline fun <reified T : Comparable<T>> Array<T>.mergeSort(sortedRunSize: Int = 1, compare: (left: T, right: T) -> Boolean = { left, right -> left > right }) {
  if (size <= 1) return
  var step = sortedRunSize shl 1
  val currentArray = Holder(arrayOfNulls<T>(size))
  val nextArray = Holder(arrayOf<T?>(*this))
  while (true) {
    for (i in indices step step) {
      val leftEnd = i + (step shr 1)
      val rightEnd = i + step
      var left = i
      var right = leftEnd
      var current = i
      while (left != leftEnd || right != rightEnd) {
        if (left == size || (left == leftEnd && right == size)) break
        if (right < size && right != rightEnd && (left == leftEnd || compare(nextArray.value[left]!!, nextArray.value[right]!!))) {
          currentArray.value[current] = nextArray.value[right]
          ++right
        } else {
          currentArray.value[current] = nextArray.value[left]
          ++left
        }
        ++current
      }
    }
    swap(currentArray, nextArray)
    if (step >= size) break
    step = step shl 1
  }
  arraycopy(nextArray.value, 0, this, 0, nextArray.value.size)
}

/**
 * It sorts the array by using tim sort.
 *
 * @param compare The function used to determine whether the positions of both elements should be swapped during sorting. If the function returns true, both
 *   elements will be swapped, otherwise nothing happens.
 */
inline fun <reified T : Comparable<T>> Array<T>.sort(compare: (left: T, right: T) -> Boolean = { left, right -> left > right }) {
  val runSize = 32
  insertionSorts(runSize, compare)
  mergeSort(runSize, compare)
}

/**
 * It copies the items in the `List` and converts it into a fixed size array.
 *
 * @return The fixed size array that contains all the items stored in the `List`.
 */
inline fun <reified T> List<T>.toArray(): Array<T> {
  val result = arrayOfNulls<T?>(size)
  for ((index, item) in withIndex()) result[index] = item
  return result as Array<T>
}

/**
 * It copies the items in the `Map` and converts it into a fixed size array that is sorted by keys.
 *
 * @return The fixed size sorted array that contains all the items stored in the `Map`.
 */
inline fun <reified K : Comparable<K>, reified V> Map<K, V>.toArray(): Array<Pair<K, V>> {
  val result = arrayOfNulls<Pair<K, V?>?>(size)
  val keyArray = keys.toArray()
  keyArray.sort()
  for ((index, key) in keyArray.withIndex()) result[index] = Pair(key, this[key])
  return result as Array<Pair<K, V>>
}
