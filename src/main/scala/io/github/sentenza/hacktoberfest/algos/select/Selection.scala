package io.github.sentenza.hacktoberfest.algos.select

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

/** Definitions of the functions that will implement all the common selection algorithms.
  */
trait Selection[F[_], T] {
  /* *** Partition-based Selection *** */

  /** Quick Select [[https://en.wikipedia.org/wiki/Quickselect Wikipedia: Quick Select]]
    */
  def quickSelect(xs: F[T], idx: Int): Option[T]
}
