package io.github.sentenza.hacktoberfest18.algos

import scala.collection.mutable.ArrayBuffer
import scala.math.Ordered

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

/**
  * Implementations of this trait should provide non-destructive select
  * operations on array. That is, the array passed to a select method
  * should not be altered: A value at the specified sorted index should be
  * returned.
  */
object ImmutableSelection extends Selection[Array, Int] {

  /** @inheritdoc
    *
    * @param array Array of sortable, selectable integers
    * @param Int An sorted index, that is, an index referring to the nth largest element of the list
    * @return A possible element of the array at the sorted index
    */
  def quickSelect(array: Array[Int], idx: Int): Option[Int] = {
    if (idx < 0 || array.size <= idx) return None

    array match {
      case Array() => None
      case Array(pivot, rest @ _*) => {
        val (smaller, larger) = rest partition (_ <= pivot)
        val pivotIdx = smaller.size

        idx.compare(pivotIdx) match {
          case needleInSmaller if needleInSmaller < 0 => quickSelect(smaller.toArray, idx)
          case needleIsPivot if needleIsPivot == 0 => Some(pivot)
          case needleInLarger if needleInLarger > 0 => quickSelect(larger.toArray, idx - pivotIdx - 1)
        }
      }
    }
  }
}