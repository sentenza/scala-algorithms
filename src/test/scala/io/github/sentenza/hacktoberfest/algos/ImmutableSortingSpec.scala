package io.github.sentenza.hacktoberfest.algos

import io.github.sentenza.hacktoberfest.util.ListUtil
import org.scalatest.{Matchers, WordSpec}
import ImmutableSorting._
import scala.util.Random

class ImmutableSortingSpec extends WordSpec with Matchers {
  /**
    * The default length of the arrays that will be generated in this spec.
    */
  private val random = new Random()
  private val defaultLength = Math.max(100, random.nextInt(1000))
  private val listUtil = new ListUtil()
  private val randomIndices = List.fill(5)(random.nextInt(defaultLength)).distinct

  /**
    * Helper method that returns a couple of array (unsorted, sorted).
    *
    * @param l The length of the array that will be generated
    * @return (unsortedArray, sortedArray)
    */
  private def getLists(l: Int): (List[Int], List[Int]) = {
    val randomUnsortedList = listUtil.buildRandomList(l)
    (randomUnsortedList, randomUnsortedList.sorted)
  }

  /* creates a random array and set of random indices, and applies the algorithm,
   * comparing the result with a value lifted from the sorted version
   */
  private def compareAfterSortingWith(algo: List[Int] => List[Int]) = {
    val (unsorted, sorted) = getLists(defaultLength)

    algo(unsorted) shouldBe sorted
  }

  "ImmutableSorting" should {

    "sort a list using the Bubble sort algorithm" in {
      compareAfterSortingWith(bubbleSort)
    }
  }
}