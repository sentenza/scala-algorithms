package io.github.sentenza.hacktoberfest18.sort

import io.github.sentenza.hacktoberfest18.util.ArrayUtil
import org.scalatest.{Matchers, WordSpec}
import io.github.sentenza.hacktoberfest18.sort.CommonSortings.CommonSorting._
import scala.util.Random

class CommonSortingsTest extends WordSpec with Matchers{
  "CommonSortings" should {
    "sort arrays with different methods like scala's default sorting method" in {
      val rand = new Random()
      val arrayUtil = new ArrayUtil()
      val length = rand.nextInt(1000)

      val randomUnsortedArray = arrayUtil.buildRandomArray(length)
      val exampleSortedArray = randomUnsortedArray.sorted

      bubbleSort(randomUnsortedArray).sameElements(exampleSortedArray) should be
      selectionSort(randomUnsortedArray).sameElements(exampleSortedArray) should be
      insertionSort(randomUnsortedArray).sameElements(exampleSortedArray) should be
      quickSort(randomUnsortedArray).sameElements(exampleSortedArray) should be
      mergeSort(randomUnsortedArray).sameElements(exampleSortedArray) should be
    }
  }
}
