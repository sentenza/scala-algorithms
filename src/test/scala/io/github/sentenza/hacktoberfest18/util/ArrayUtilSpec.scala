package io.github.sentenza.hacktoberfest18.util

import org.scalatest.{Assertion, Matchers, WordSpec, Inspectors}
import scala.util.Random

class ArrayUtilSpec extends WordSpec with Matchers {
  "The ArrayUtil" should {
    "return an array of n elements" in {
      val rand = new Random()
      val arrayUtil = new ArrayUtil()
      val length = rand.nextInt(1000)
      arrayUtil.buildRandomArray(length).length shouldBe length
    }

    "return an array whose values are capped by the length" in {
      val rand = new Random()
      val arrayUtil = new ArrayUtil()
      val length = rand.nextInt(1000)
      import Inspectors._
      forAll(arrayUtil.buildRandomArray(length)){
        elem => elem should be <= length
      }
    }
  }
}
