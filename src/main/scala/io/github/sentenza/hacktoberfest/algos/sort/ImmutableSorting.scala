package io.github.sentenza.hacktoberfest.algos.sort

import scala.annotation.tailrec

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
 * Implementations of this trait should provide non-destructive sort operations on lists, returning
 * a sorted copy of the provided input list.
 */
object ImmutableSorting extends Sorting[List, Int] {

  /**
   * @inheritdoc
   *
   * @param xs
   *   List of sortable Integers
   * @return
   *   The sorted list
   */
  def bubbleSort(xs: List[Int]): List[Int] = {
    def bubbled(list: List[Int]): (List[Int], Boolean) = list match {
      case Nil => (Nil, false)
      case elem :: rest =>
        rest match {
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
      case (done @ (_, false), _) =>
        done // There were no swaps in the last iteration, so short-circuit
      case ((lastList, true), _) => bubbled(lastList)
    }

    fullyBubbled
  }

  /**
   * @inheritdoc
   *
   * @param xs
   *   List of sortable Integers
   * @return
   *   The sorted list
   */
  def cocktailShakerSort(xs: List[Int]): List[Int] = ???

  /**
   * @inheritdoc
   *
   * @param xs
   *   List of sortable Integers
   * @return
   *   The sorted list
   */
  def combSort(xs: List[Int]): List[Int] = ???

  /**
   * @inheritdoc
   * @param list
   *   List of sortable integers
   * @return
   *   The sorted list
   */
  def insertionSort(list: List[Int]): List[Int] = ???

  /**
   * @inheritdoc
   * @param list
   *   List of sortable integers
   * @return
   *   The sorted list
   */
  def selectionSort(list: List[Int]): List[Int] = ???

  /**
   * @inheritdoc
   *
   * @param xs
   *   List of sortable Integers
   * @return
   *   The sorted list
   */
  def heapSort(xs: List[Int]): List[Int] = ???

  /**
   * @inheritdoc
   *
   * @param xs
   *   List of sortable Integers
   * @return
   *   The sorted list
   */
  def quickSort(list: List[Int]): List[Int] = ???

  /**
   * @inheritdoc
   *
   * @param list
   *   List of sortable Integers
   * @return
   *   The sorted list
   */
  def mergeSort(list: List[Int]): List[Int] = {
    @tailrec
    // (1,3,2,6,4) => ( (4), (6, 2), (3, 1) )
    def split(rem: List[Int], acc: List[List[Int]]): List[List[Int]] = {
      rem match {
        case h :: t =>
          acc match {
            case Nil =>
              split(t, (h :: Nil) :: Nil)
            case ha :: ta =>
              ha match {
                case hah :: _ if hah <= h =>
                  split(t, (h :: ha) :: ta)
                case _ :: _ =>
                  split(t, (h :: Nil) :: acc)
                case Nil => // should not happen but safer to handle
                  split(t, (h :: Nil) :: ta)
              }
          }
        case Nil =>
          acc
      }
    }
    val forward  = (x: Int, y: Int) => y < x
    val backward = (x: Int, y: Int) => y > x
    @tailrec
    // (6,4,2), (7,3,1) backward => (1,2,3,4,6,7)
    def merge(
        l1: List[Int],
        l2: List[Int],
        dir: (Int, Int) => Boolean,
        acc: List[Int]
    ): List[Int] = {
      l1 match {
        case h1 :: t1 =>
          l2 match {
            case h2 :: t2 if dir(h1, h2) =>
              merge(l1, t2, dir, h2 :: acc)
            case _ =>
              merge(t1, l2, dir, h1 :: acc)
          }
        case Nil =>
          l2 match {
            case h :: t =>
              merge(t, l1, dir, h :: acc)
            case Nil =>
              acc
          }
      }
    }
    @tailrec
    def merger(l: List[List[Int]], isForward: Boolean, acc: List[List[Int]]): List[Int] = {
      l match {
        case Nil =>
          acc match {
            case Nil                   => Nil
            case h :: Nil if isForward => h.reverse
            case h :: Nil              => h
            case _                     => merger(acc, !isForward, Nil)
          }
        case h :: Nil =>
          merger(Nil, isForward, h.reverse :: acc)
        case f :: s :: t =>
          merger(t, isForward, merge(f, s, if (isForward) forward else backward, Nil) :: acc)
      }
    }

    val splitList = split(list, Nil)
    merger(splitList, isForward = false, Nil)
  }

  /**
   * @inheritdoc
   *
   * @param xs
   *   List of sortable Integers
   * @return
   *   The sorted list
   */
  def bucketSort(
      xs: List[Int],
      n: Int = 10,
      sort: List[Int] => List[Int] = insertionSort
  ): List[Int] = ???

  /**
   * @inheritdoc
   *
   * @param xs
   *   List of sortable Integers
   * @return
   *   The sorted list
   */
  def countSort(xs: List[Int]): List[Int] = ???

  /**
   * @inheritdoc
   *
   * @param xs
   *   List of sortable Integers
   * @return
   *   The sorted list
   */
  def radixSort(xs: List[Int], base: Int): List[Int] = ???
}
