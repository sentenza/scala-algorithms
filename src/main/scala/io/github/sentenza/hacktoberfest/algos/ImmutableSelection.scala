package io.github.sentenza.hacktoberfest.algos

import scala.collection.mutable.ArrayBuffer
import scala.math.Ordered

/*
 * HacktoberFest - Scala Algorhitms
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

/** Implementations of this trait should provide non-destructive select
  * operations on linked lists. That is, the linked list passed to a select
  * method should not be altered: A value at the specified sorted index
  * should be returned.
  */
object ImmutableSelection extends Selection[List, Int] {

  /** @inheritdoc
    *
    * @param list Linked list of sortable, selectable integers
    * @param idx An sorted index, that is, an index referring to the nth largest element of the list
    * @return A possible element of the array at the sorted index
    */
  def quickSelect(list: List[Int], idx: Int): Option[Int] = {
    if (idx < 0 || list.size <= idx) return None

    list match {
      case Nil => None
      case pivot :: rest => {
        val (smaller, larger) = rest partition (_ <= pivot)
        val pivotIdx          = smaller.size

        idx.compare(pivotIdx) match {
          case needleInSmaller if needleInSmaller < 0 =>
            quickSelect(smaller, idx)
          case needleIsPivot if needleIsPivot == 0 => Some(pivot)
          case needleInLarger if needleInLarger > 0 =>
            quickSelect(larger, idx - pivotIdx - 1)
        }
      }
    }
  }
}
