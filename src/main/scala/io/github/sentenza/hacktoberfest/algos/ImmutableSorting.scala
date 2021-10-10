package io.github.sentenza.hacktoberfest.algos

/*
 * HacktoberFest - Scala Algorithms
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

/**
  * Implementations of this trait should provide non-destructive sort
  * operations on lists, returning a sorted copy of the provided input list.
  */
object ImmutableSorting extends Sorting[List, Int] {

  /** @inheritdoc
    *
    * @param xs List of sortable Integers
    * @return The sorted list
    */
  def bubbleSort(xs: List[Int]): List[Int] = {
    def bubbled(list: List[Int]): (List[Int], Boolean) = list match {
      case Nil => (Nil, false)
      case elem :: rest => rest match {
        case Nil => (elem :: Nil, false)
        case secondElem :: _ if elem <= secondElem => {
          val (restBubbled, swapped) = bubbled(rest)

          (elem :: restBubbled, swapped)
        }
        case secondElem :: secondRest => {
          val (restBubbled, _) = bubbled(elem :: secondRest)

          (secondElem :: restBubbled, true)
        }
      }
    }

    val (fullyBubbled, _) = List.fill(xs.size)(()).foldLeft[(List[Int], Boolean)]((xs, true)) {
      case (done @ (_, false), _) => done // There were no swaps in the last iteration, so short-circuit
      case ((lastList, true), _) => bubbled(lastList)
    }

    fullyBubbled
  }

  /** @inheritdoc
    *
    * @param xs List of sortable Integers
    * @return The sorted list
    */
  def cocktailShakerSort(xs: List[Int]): List[Int] = ???

  /** @inheritdoc
    *
    * @param xs List of sortable Integers
    * @return The sorted list
    */
  def combSort(xs: List[Int]): List[Int] = ???

  /** @inheritdoc
    * @param list List of sortable integers
    * @return The sorted list
    */
  def insertionSort(list: List[Int]): List[Int] = ???

  /** @inheritdoc
    * @param list List of sortable integers
    * @return The sorted list
    */
  def selectionSort(list: List[Int]): List[Int] = ???

  /** @inheritdoc
    *
    * @param xs List of sortable Integers
    * @return The sorted list
    */
  def heapSort(xs: List[Int]): List[Int] = ???

  /** @inheritdoc
    *
    * @param xs List of sortable Integers
    * @return The sorted list
    */
  def quickSort(list: List[Int]): List[Int] = ???

  /** @inheritdoc
    *
    * @param xs List of sortable Integers
    * @return The sorted list
    */
  def mergeSort(list: List[Int]): List[Int] = ???

  /** @inheritdoc
    *
    * @param xs List of sortable Integers
    * @return The sorted list
    */
  def bucketSort(xs: List[Int],
                 n: Int = 10,
                 sort: List[Int] => List[Int] = insertionSort): List[Int] = ???

  /** @inheritdoc
    *
    * @param xs List of sortable Integers
    * @return The sorted list
    */
  def countSort(xs: List[Int]): List[Int] = ???

  /** @inheritdoc
    *
    * @param xs List of sortable Integers
    * @return The sorted list
    */
  def radixSort(xs: List[Int], base: Int): List[Int] = ???
}
