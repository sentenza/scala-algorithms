package io.github.sentenza.hacktoberfest.algos.sort

import scala.collection.mutable.ArrayBuffer

/*
 * HacktoberFest - Scala Algorithms
 * Copyright (C) 2018-2021 sentenza
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

/**
 * Implementations of this trait should provide non-destructive sort operations on arrays. That is,
 * the array passed to a sort method should not be altered: A new array with the sorted values
 * should be returned.
 */
object MutableSorting extends Sorting[Array, Int] {

  /**
   * @inheritdoc
   *
   * "the bubble sort seems to have nothing to recommend it, except a catchy name and the fact that
   * it leads to some interesting theoretical problems"
   *   - from The Art of Computer Programming by Donald Knuth NOTE: Although bubble sort is one of
   *     the simplest sorting algorithms to understand and implement, its {{{O(n^2)}}} complexity
   *     means that its efficiency decreases dramatically on lists of more than a small number of
   *     elements. TODO: Try to refactor this method in order to avoid any direct alteration (side
   *     effect) of the provided array. We should return a completely new array that contains the
   *     sorted elements.
   *
   * @param xs
   *   Array of sortable Integers
   * @return
   *   The sorted array
   */
  def bubbleSort(xs: Array[Int]): Array[Int] = {
    var swapped = false

    do {
      swapped = false;
      for (i <- 0 to xs.length - 2) {
        if (xs(i) > xs(i + 1)) {
          swap(xs, i, i + 1)
          swapped = true
        }
      }
    } while (swapped)

    xs
  }

  /**
   * @inheritdoc
   *
   * @param array
   *   Array of sortable integers
   * @return
   *   The sorted array
   */
  def cocktailShakerSort(array: Array[Int]): Array[Int] = {
    var (start, end) = (0, array.length - 2)
    while (start <= end) {
      var (newStart, newEnd) = (end, start)
      for (i <- start to end) {
        if (array(i) > array(i + 1)) {
          swap(array, i, i + 1)
          newEnd = i
        }
      }
      end = newEnd - 1

      for (i <- end to start by -1) {
        if (array(i) > array(i + 1)) {
          swap(array, i, i + 1)
          newStart = i
        }
      }

      start = newStart + 1
    }
    array
  }

  /**
   * @inheritdoc
   * @param array
   *   Array of sortable integers
   * @return
   *   The sorted array
   */
  def combSort(array: Array[Int]): Array[Int] = ???
  // TODO: Fix Comb sort!
  /*
  {
import scala.annotation.tailrec

    def nextGap(gap: Int): Int = ((gap * 10) / 13).max(1)

    @tailrec
    def comp(array: Array[Int],
             gap: Int,
             i: Int = 0,
             swapped: Boolean = false): Boolean = {
      val ig = i + gap
      if (ig == array.length) {
        swapped
      } else if (array(i) > array(ig)) {
        swap(array, i, ig)
        comp(array, gap, i + 1, swapped = true)
      } else {
        comp(array, gap, i + 1, swapped)
      }
    }

    @tailrec
    def sort(array: Array[Int], gap: Int): Array[Int] = {
      if (comp(array, gap)) {
        sort(array, nextGap(gap))
      } else {
        array
      }
    }

    sort(array, nextGap(array.length))
  }
   */

  /**
   * @inheritdoc
   * @param array
   *   Array of sortable integers
   * @return
   *   The sorted array
   */
  def insertionSort(array: Array[Int]): Array[Int] = {
    for (j <- 1 until array.length) {
      var i      = j - 1
      val moving = array(j)
      while (i >= 0 && array(i) > moving) {
        array(i + 1) = array(i)
        i -= 1
      }
      array(i + 1) = moving
    }

    array
  }

  /**
   * @inheritdoc
   * @param array
   *   Array of sortable integers
   * @return
   *   The sorted array
   */
  def selectionSort(array: Array[Int]): Array[Int] = {
    for (i <- 0 until array.size - 1)
      swap(
        array,
        i,
        (i + 1 until array.length).foldLeft(i)((currMin, currIndx) =>
          if (array(currIndx) < array(currMin))
            currIndx
          else
            currMin
        )
      )

    array
  }

  /**
   * Heap Sort
   *
   * @param xs
   *   Array of sortable integers
   * @return
   *   The sorted array
   */
  def heapSort(xs: Array[Int]): Array[Int] = ???

  /**
   * @inheritdoc
   * @param array
   *   Array of sortable integers
   * @return
   *   The sorted array
   */
  def quickSort(array: Array[Int]): Array[Int] = {
    if (array.length <= 1) array
    else {
      val pivot = array(array.length / 2)
      Array.concat(
        quickSort(array.filter(x => pivot > x)),
        array.filter(x => pivot == x),
        quickSort(array.filter(x => pivot < x))
      )
    }
  }

  /**
   * @inheritdoc
   * @param array
   *   Array of sortable integers
   * @return
   *   The sorted array
   */
  def mergeSort(array: Array[Int]): Array[Int] = {
    def merge(part1: Array[Int], part2: Array[Int], l: Int, r: Int, mid: Int): Unit = {
      var left = l
      var m    = mid + 1

      for (i <- l to r) {
        if (m > r || (left <= mid && part1(left) < part1(m))) {
          part2(i) = part1(left)
          left += 1
        } else {
          part2(i) = part1(m)
          m += 1
        }
      }
    }

    def sort(part1: Array[Int], part2: Array[Int], l: Int, r: Int): Unit = {
      if (l >= r)
        return

      val mid = (l + r) / 2
      sort(part1, part2, l, mid)
      sort(part1, part2, mid + 1, r)
      merge(part1, part2, l, r, mid)
      Array.copy(part2, l, part1, l, r - l + 1)
    }

    val helperArray = new Array[Int](array.length)
    sort(array, helperArray, 0, array.length - 1)
    array
  }

  /**
   * Bucket sort is a sorting algorithm that sorts an array of elements by splitting the elements
   * into n buckets and then reapplies another sorting method on the different buckets. Then merges
   * the sorted buckets. It can also be used recursively until buckets contain one element each.
   *
   * @param xs
   *   Array of sortable integers
   * @param n
   *   number of buckets in which to sort the elements.
   * @param sort
   *   The sorting algorithm to apply once buckets are divided.
   * @return
   *   the sorted array
   * @author
   *   Xoeseko
   */
  def bucketSort(
      xs: Array[Int],
      n: Int = 10,
      sort: Array[Int] => Array[Int] = insertionSort
  ): Array[Int] = {
    val buckets    = Array.ofDim[Array[Int]](n)
    val temp       = new ArrayBuffer[Int]()
    val range: Int = (xs.max / n) + 1
    temp ++= xs

    if (temp.length > 1) {
      for (i <- 0 until n) {
        buckets(i) = sort(temp.filter(a => a >= range * i && a < range * (i + 1)).toArray)
      }
    } else return xs

    val finalArray = new ArrayBuffer[Int]()

    for {
      i <- buckets.indices
      j <- buckets(i).indices
    } {
      finalArray += buckets(i)(j)
    }
    finalArray.toArray
  }

  /**
   * @inheritdoc
   * @param xs
   *   Array of sortable integers
   * @return
   *   The sorted array
   */
  def countSort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val min    = xs.min
      val max    = xs.max
      val aux    = Array.fill(max - min + 1) { 0 }
      val sorted = new Array[Int](xs.length)

      for (v <- xs) {
        aux(v - min) += 1
      }

      var i = 0
      for (k <- min to max) {
        while (aux(k - min) > 0) {
          aux(k - min) -= 1
          sorted(i) = k
          i += 1
        }
      }

      sorted
    }

  }

  /**
   * Radix Sort is a sorting algorithm that sorts an array of numbers into according to each
   * number's most significant symbols (bits, digits...) depending on the given base
   * @param xs
   *   an array to be sorted
   * @param base
   *   the sorting base and also the number of buckets
   * @return
   *   the sorted array
   * @author
   *   Xoeseko
   */
  def radixSort(xs: Array[Int], base: Int = 10): Array[Int] = {
    var array = xs
    def listToBuckets(arr: Array[Int], b: Int, it: Int): Array[Array[Int]] = {
      val buckets = Array.ofDim[ArrayBuffer[Int]](base)
      // Initialize buckets
      for (i <- buckets.indices) {
        buckets(i) = new ArrayBuffer[Int]()
      }
      for (n <- arr) {
        // Start by getting the current digit and assigning the number to corresponding bucket.
        val digit = (n / math.pow(b.toDouble, it.toDouble).toInt) % b
        buckets(digit) += n
      }
      buckets.map(a => a.toArray)
    }

    def bucketsToList(buckets: Array[Array[Int]]): Array[Int] = {
      val numbers = new Array[Int](xs.length)
      var index   = 0
      for {
        b <- buckets
        n <- b
      } {
        numbers(index) = n
        index += 1
      }
      numbers
    }

    val max = xs.max

    var i = 0
    while (math.pow(base.toDouble, i.toDouble) <= max) {
      array = bucketsToList(listToBuckets(array, base, i))
      i += 1
    }

    array
  }

  /**
   * Swaps two elements with indices index1 and index2 in a given array used in bubbleSort and
   * selectionSort TODO: get rid of this method, because it only introduces a side effect. Take
   * look at the principles of Functional programming.
   *
   * @param array
   *   The target array that will be modified
   * @param index1
   *   The index of the first element that has to be swapped
   * @param index2
   *   The index of the second element that has to be swapped
   */
  private def swap(array: Array[Int], index1: Int, index2: Int): Unit = {
    val tmp = array(index1)
    array(index1) = array(index2)
    array(index2) = tmp
  }
}
