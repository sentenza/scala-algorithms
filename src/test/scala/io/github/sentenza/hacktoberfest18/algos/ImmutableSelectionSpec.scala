package io.github.sentenza.hacktoberfest18.algos

import io.github.sentenza.hacktoberfest18.util.ArrayUtil
import org.scalatest.{Matchers, WordSpec}
import ImmutableSelection._
import scala.util.Random

class ImmutableSelectionSpec extends WordSpec with Matchers {
  /**
    * The default length of the arrays that will be generated in this spec.
    */
  private val random = new Random()
  private val defaultLength = Math.max(100, random.nextInt(1000))
  private val arrayUtil = new ArrayUtil()
  private val randomIndices = List.fill(5)(random.nextInt(defaultLength)).distinct

  /**
    * Helper method that returns a couple of array (unsorted, sorted).
    *
    * @param l The length of the array that will be generated
    * @return (unsortedArray, sortedArray)
    */
  private def getArrays(l: Int): (Array[Int], Array[Int]) = {
    val randomUnsortedArray = arrayUtil.buildRandomArray(l)
    (randomUnsortedArray, randomUnsortedArray.sorted)
  }

  /* creates a random array and set of random indices, and applies the algorithm,
   * comparing the result with a value lifted from the sorted version
   */
  private def compareAfterSelectionWith(algo: (Array[Int], Int) => Option[Int]) = {
    val (unsorted, sorted) = getArrays(defaultLength)

    randomIndices.foreach(idx => {
      algo(unsorted, idx) shouldBe sorted.lift(idx)
    })
  }

  "ImmutableSelection" should {

    "select the nth largest element of an array using the Quick Select selection algorithm" in {
      compareAfterSelectionWith(quickSelect)
    }
  }
}