package io.github.sentenza.hacktoberfest.util

import org.scalatest.{Assertion, Matchers, WordSpec, Inspectors}

class ArrayUtilSpec extends WordSpec with Matchers {
  "The ArrayUtil" should {
    "return an array of n elements" in {
      val arrayUtil = new ArrayUtil()
      val length    = scala.util.Random.nextInt(1000)
      arrayUtil.buildRandomArray(length).length shouldBe length
    }

    "return an array whose values are capped by the length" in {
      val arrayUtil = new ArrayUtil()
      val length    = scala.util.Random.nextInt(1000)
      import Inspectors._
      val maximum = scala.util.Random.nextInt(900)
      forAll(arrayUtil.buildRandomArray(length, maximum)) { elem =>
        elem should be <= maximum
      }
    }
  }
}
