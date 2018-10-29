package io.github.sentenza.hacktoberfest18.adt

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

/** Functional Queue
  *
  * A *fully persistent* data structure with three operations:
  * - head: returns the first element of the queue
  * - tail: returns a queue without the first element
  * - enqueue: returns a NEW queue with a given element appended to the end
  */
trait Queue[T] {

  /** @return The first element of the queue */
  def head: T

  /** @return A queue without the first element */
  def tail: Queue[T]

  /**
    * Appends and element x to the end of the queue
    * @param x The element to be appended to the end
    * @return A new queue containing x at its end
    */
  def enqueue(x: T): Queue[T]
}
