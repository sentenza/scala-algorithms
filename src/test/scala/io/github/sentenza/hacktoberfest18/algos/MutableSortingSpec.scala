package io.github.sentenza.hacktoberfest18.algos

import io.github.sentenza.hacktoberfest18.util.ArrayUtil
import org.scalatest.{Matchers, WordSpec}
import MutableSorting._
import scala.util.Random

class MutableSortingSpec extends WordSpec with Matchers {

  /**
    * The default length of the arrays that will be generated in this spec
    */
  private val defaultLength = new Random().nextInt(100)
  private val defaultMax    = new Random().nextInt(99)
  private val arrayUtil     = new ArrayUtil()

  /**
    * Helper method that returns a couple of array (unsorted, sorted)
    *
    * @param l The length of the array that will be generated
    * @param m The maximum possible element value
    * @return (unsortedArray, sortedArray)
    */
  private def getArrays(l: Int, m: Int): (Array[Int], Array[Int]) = {
    val randomUnsortedArray = arrayUtil.buildRandomArray(l, m)
    (randomUnsortedArray, randomUnsortedArray.sorted)
  }

  /* creates a random array and applies the algorithm,
   * comparing the result with a sorted version
   */
  private def compareAfterSortingWith(algo: Array[Int] => Array[Int]) = {
    val (unsorted, sorted) = getArrays(defaultLength, defaultMax)
    algo(unsorted) shouldBe sorted
  }

  "MutableSorting" should {

    "sort an array using the Cocktail Shaker sort algorithm" in {
      compareAfterSortingWith(cocktailShakerSort)
    }

    "sort an array using the Bubble sort algorithm" in {
      compareAfterSortingWith(bubbleSort)
    }

    "sort an array using the Selection sort algorithm" in {
      compareAfterSortingWith(selectionSort)
    }

    "sort an array using the Insertion sort algorithm" in {
      compareAfterSortingWith(insertionSort)
    }

    "sort an array using the Merge sort algorithm" in {
      compareAfterSortingWith(mergeSort)
    }

    "sort an array using the Quick sort algorithm" in {
      compareAfterSortingWith(quickSort)
    }

    "sort an array using the default Bucket sort algorithm" in {
      compareAfterSortingWith(bucketSort(_))
    }

    "sort an array using the Count sort algorithm" in {
      compareAfterSortingWith(countSort)
    }

    "sort an array using the Radix sort algorithm" in {
      compareAfterSortingWith(radixSort(_))

    "sort an array using the Comb sort algorithm" in {
      compareAfterSortingWith(combSort)

    }

  }
}
