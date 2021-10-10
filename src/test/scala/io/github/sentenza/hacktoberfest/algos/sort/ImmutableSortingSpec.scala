package io.github.sentenza.hacktoberfest.algos.sort

import io.github.sentenza.hacktoberfest.algos.sort.ImmutableSorting._
import io.github.sentenza.hacktoberfest.util.ListUtil
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.util.Random

class ImmutableSortingSpec extends AnyWordSpec with Matchers {

  /** The default length of the arrays that will be generated in this spec.
    */
  private val random        = new Random()
  private val defaultLength = Math.max(100, random.nextInt(1000))
  private val listUtil      = new ListUtil()

  /** Helper method that returns a couple of array (unsorted, sorted).
    *
    * @param l
    *   The length of the array that will be generated
    * @return
    *   (unsortedArray, sortedArray)
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
