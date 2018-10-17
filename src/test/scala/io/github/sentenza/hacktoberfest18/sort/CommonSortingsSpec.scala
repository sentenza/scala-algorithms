
package io.github.sentenza.hacktoberfest18.sort

import org.scalatest.{Assertion, Matchers, WordSpec}
import io.github.sentenza.hacktoberfest18.util

class CommonSortingsSpec extends WordSpec with Matchers {
  "The bubbleSort" should {
    "return an sorted array from small to big with unique entries" in {
      CommonSortings.CommonSorting.bubbleSort(Array(3,2,1)) shouldBe Array(1,2,3)
    }
  }

  "The bubbleSort" should {
    "return an sorted array from small to big for an array with duplicate enties" in {
      CommonSortings.CommonSorting.bubbleSort(Array(3,2,2,1)) shouldBe Array(1,2,2,3)
    }
  }
}
