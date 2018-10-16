package io.github.sentenza.hacktoberfest18.sort

/*
 * HacktoberFest 2018 - Scala Algorhitms
 * Copyright (C) 2018 sentenza
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

object CommonSortings {
  trait CommonSorting {
    def bubbleSort(array: Array[Int]): Array[Int]
    def selectionSort(array: Array[Int]): Array[Int]
    def insertionSort(array: Array[Int]): Array[Int]
    def quickSort(array: Array[Int]): Array[Int]
    def mergeSort(array: Array[Int]): Array[Int]
  }

  object CommonSorting {

    /*
     * swaps two elements with indices index1 and index2
     * in a given array
     * used in bubbleSort and selectionSort
    */
    def swap(array: Array[Int], index1: Int, index2: Int): Unit = {
      val tmp = array(index1)
      array(index1) = array(index2)
      array(index2) = tmp
    }

    def bubbleSort(array: Array[Int]): Array[Int] = {
      var swapped = false

      do{
        swapped = false;
        for(i <- 0 to array.length - 2){
          if(array(i) > array(i + 1)){
            swap(array, i, i + 1)
            swapped = true
          }
        }
      }
      while(swapped)

      array
    }

    def selectionSort(array: Array[Int]): Array[Int] = {
      for(i <- 0 until array.size - 1)
        swap(array, i, (i + 1 until array.length).foldLeft(i)((currMin, currIndx) =>
          if(array(currIndx) < array(currMin))
            currIndx
          else
            currMin
        ))

      array
    }
    def insertionSort(array: Array[Int]): Array[Int] = {
      for(j <- 1 until array.length){
        var i = j - 1
        val moving = array(j)
        while(i >= 0 && array(i) > moving){
          array(i + 1) = array(i)
          i -= 1
        }
        array(i + 1) = moving
      }

      array
    }

    def quickSort(array: Array[Int]): Array[Int] = {
      if(array.length <= 1) array
      else{
        val pivot = array(array.length / 2)
        Array.concat(
          quickSort(array filter (pivot >)),
          array filter (pivot ==),
          quickSort(array filter (pivot <))
        )
      }
    }

    def mergeSort(array: Array[Int]): Array[Int] = {
      def merge(part1: Array[Int], part2: Array[Int], l: Int, r: Int, mid: Int){
        var left = l
        var m = mid + 1

        for(i <- l to r){
          if(m > r || (left <= mid && part1(left) < part1(m))){
            part2(i) = part1(left)
            left += 1
          }
          else{
            part2(i) = part1(m)
            m += 1
          }
        }
      }

      def sort(part1: Array[Int], part2: Array[Int], l: Int, r: Int){
        if(l >= r)
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
  }
}

