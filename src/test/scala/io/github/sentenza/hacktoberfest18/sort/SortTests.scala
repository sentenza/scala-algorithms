package io.github.sentenza.hacktoberfest18.sort
import io.github.sentenza.hacktoberfest18.util.ArrayUtil
import org.scalatest.FunSuite
import util.Random
import io.github.sentenza.hacktoberfest18.sort.CommonSortings.CommonSorting._

/**
  * This class is a test suite for the methods in object CommonSortings. To run
  * the test suite, you can either:
  *  - run the "test" command in the SBT console
  *  - right-click the file in zour editor of choice and 'run as test' or 'run'
  */
class SortTests extends FunSuite {

  /**
    * Trait code for the random arrays to re-use in every test.
    * traits work like special classes creating an instance in each test.
    */
  trait randTestArrays {
    val aUtil = new ArrayUtil()
    val rand = new Random()
    val aRand = aUtil.buildRandomArray(rand.nextInt(1000))
    val aSorted = aRand.sorted
  }

  /**
    * Trait code for the arrays with duplicate values to re-use in every test
    * traits work like special classes creating an instance in each test.
    */
  trait dupliTestArrays {
    val aDuplicates = Array(3,3,4,3,2,1,1)
    val aDupsorted = aDuplicates.sorted
  }

  test("QuickSort works on random array smaller than 1000 elements"){
    new randTestArrays {
      assert(quickSort(aRand) === aSorted)
    }
  }

  test("QuickSort works on array with duplicate elements"){
    new dupliTestArrays {
      assert(quickSort(aDuplicates) === aDupsorted)
    }
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "selectionSort" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "selectionSort", exchange the
    * function "ignore" by "test".
    */
  ignore("SelectionSort works on random array smaller than 1000 elements"){
    new randTestArrays {
      assert(selectionSort(aRand) === aSorted)
    }
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "selectionSort" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "selectionSort", exchange the
    * function "ignore" by "test".
    */
  ignore("SelectionSort works on array with duplicate elements"){
    new dupliTestArrays {
      assert(selectionSort(aDuplicates) === aDupsorted)
    }
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "mergeSort" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "mergeSort", exchange the
    * function "ignore" by "test".
    */
  ignore("MergeSort works on random array smaller than 1000 elements"){
    new randTestArrays {
      assert(mergeSort(aRand) === aSorted)
    }
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "mergeSort" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "mergeSort", exchange the
    * function "ignore" by "test".
    */
  ignore("MergeSort works on array with duplicate elements"){
    new dupliTestArrays {
      assert(mergeSort(aDuplicates) === aDupsorted)
    }
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "bubbleSort" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "bubbleSort", exchange the
    * function "ignore" by "test".
    */
  ignore("BubbleSort works on random array smaller than 1000 elements"){
    new randTestArrays {
      assert(bubbleSort(aRand) === aSorted)
    }
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "bubbleSort" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "bubbleSort", exchange the
    * function "ignore" by "test".
    */
  ignore("BubbleSort works on array with duplicate elements"){
    new dupliTestArrays {
      assert(bubbleSort(aDuplicates) === aDupsorted)
    }
  }

  /**
    * This test is currently disabled (by using "ignore") because the method
    * "insertionSort" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "insertionSort", exchange the
    * function "ignore" by "test".
    */
  ignore("InsertionSort works on random array smaller than 1000 elements"){
    new randTestArrays {
      assert(insertionSort(aRand) === aSorted)
    }
  }
  /**
    * This test is currently disabled (by using "ignore") because the method
    * "insertionSort" is not yet implemented and the test would fail.
    *
    * Once you finish your implementation of "insertionSort", exchange the
    * function "ignore" by "test".
    */
  ignore("InsertionSort works on array with duplicate elements"){
    new dupliTestArrays {
      assert(insertionSort(aDuplicates) === aDupsorted)
    }
  }


}
