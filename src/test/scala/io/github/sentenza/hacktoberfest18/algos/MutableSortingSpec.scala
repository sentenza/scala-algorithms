package io.github.sentenza.hacktoberfest18.algos

import io.github.sentenza.hacktoberfest18.util.ArrayUtil
import org.scalatest.{Matchers, WordSpec}
import MutableSorting._
import scala.util.Random

class MutableSortingSpec extends WordSpec with Matchers{
  /**
    * The default length of the arrays that will be generated in this spec
    */
  private val defaultLength = new Random().nextInt(1000)
  private val arrayUtil = new ArrayUtil()

  /**
    * Helper method that returns a couple of array (unsorted, sorted)
    * @param l The length of the array that will be generated
    * @return (unsortedArray, sortedArray)
    */
  private def getArrays(l: Int): (Array[Int], Array[Int]) = {
    val randomUnsortedArray = arrayUtil.buildRandomArray(l)
    (randomUnsortedArray, randomUnsortedArray.sorted)
  }

  "MutableSorting" should {

    "sort an array using the Cocktail Shaker sort algorithm" in {
      val as = getArrays(defaultLength)
      cocktailShakerSort(as._1) shouldBe as._2
    }

    "sort an array using the Bubble sort algorithm" in {
      val as = getArrays(defaultLength)
      bubbleSort(as._1) shouldBe as._2
    }

    "sort an array using the Selection sort algorithm" in {
      val as = getArrays(defaultLength)
      selectionSort(as._1) shouldBe as._2
    }

    "sort an array using the Insertion sort algorithm" in {
      val as = getArrays(defaultLength)
      insertionSort(as._1) shouldBe as._2
    }

    "sort an array using the Merge sort algorithm" in {
      val as = getArrays(defaultLength)
      mergeSort(as._1) shouldBe as._2
    }

    "sort an array using the Quick sort algorithm" in {
      val as = getArrays(defaultLength)
      quickSort(as._1) shouldBe as._2
    }

    "sort an array using the Bucket sort algorithm" in {
      val as = getArrays(defaultLength)
      bucketSort(as._1) shouldBe as._2
    }
  }

  //TODO: Add test cases for mutable arrays
  //TODO: Add test cases for arrays including negative numbers