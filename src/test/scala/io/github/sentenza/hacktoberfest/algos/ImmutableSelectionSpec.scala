package io.github.sentenza.hacktoberfest.algos

import io.github.sentenza.hacktoberfest.algos.ImmutableSelection._
import io.github.sentenza.hacktoberfest.util.ListUtil
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.util.Random

class ImmutableSelectionSpec extends AnyWordSpec with Matchers {

  class TestCase {
    /**
      * The default length of the arrays that will be generated in this spec.
      */
    protected val random = new Random()
    protected val defaultLength: Int = Math.max(100, random.nextInt(1000))
    protected val listUtil = new ListUtil()
    protected val randomIndices: Seq[Int] = List.fill(5)(random.nextInt(defaultLength)).distinct

    /**
      * Helper method that returns a couple of array (unsorted, sorted).
      *
      * @param l The length of the array that will be generated
      * @return (unsortedArray, sortedArray)
      */
    protected def getLists(l: Int): (List[Int], List[Int]) = {
      val randomUnsortedList = listUtil.buildRandomList(l)
      (randomUnsortedList, randomUnsortedList.sorted)
    }

    /* creates a random array and set of random indices, and applies the algorithm,
   * comparing the result with a value lifted from the sorted version
   */
    protected def compareAfterSelectionWith(algo: (List[Int], Int) => Option[Int]): Unit = {
      val (unsorted, sorted) = getLists(defaultLength)

      randomIndices.foreach(idx => {
        algo(unsorted, idx) shouldBe sorted.lift(idx)
      })
    }
  }

  "ImmutableSelection" should {
    "select the nth largest element of an array using the Quick Select selection algorithm" in new TestCase {
      compareAfterSelectionWith(quickSelect)
    }
  }
}
