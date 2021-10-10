package io.github.sentenza.hacktoberfest.adt

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

/** Functional Queue Defines the generic type {{{Queue[T]}}}
  *
  * @see
  *   Programming in Scala (2nd edition) Ch. 19.7 Note that Queue is covariant in T
  *   [[https://sentenza.github.io/docs/scala/#variance Read about variance]] A *fully persistent*
  *   data structure with three operations:
  *   - head: returns the first element of the queue
  *   - tail: returns a queue without the first element
  *   - enqueue: returns a NEW queue with a given element appended to the end
  */
trait Queue[+T] {

  /** @return The first element of the queue */
  def head: T

  /** @return A queue without the first element */
  def tail: Queue[T]

  /** Appends and element x to the end of the queue
    * @param x
    *   The element to be appended to the end
    * @tparam U
    *   We need to define T as the LOWER BOUND of U, because the type of the function parameters
    *   must be in contravariant position
    * @return
    *   A new queue containing x at its end
    */
  def enqueue[U >: T](x: U): Queue[U]

  /** Converts the queue in a List
    */
  def toList: List[T]

  /** @param other
    *   Another Queue
    */
  def equals[U >: T](other: Queue[U]): Boolean

  /** @return
    *   True if the queue is empty
    */
  def isEmpty: Boolean

  /** !Queue.isEmtpy()
    */
  def nonEmpty: Boolean

  def size: Int

  override def toString: String
}

/** The companion object Queue.
  * @example
  *   {{{Queue(13, 21, 34, 55, 89, 144)}}}
  */
object Queue {

  /** Factory method */
  def apply[T](xs: T*): Queue[T] =
    new QueueImpl[T](xs.toList, Nil)

  /** This queue is still a pure functional object, even though we're using INTERNALLY reassignable
    * immutable fields
    * @param leading
    *   The start fo the queue
    * @param trailing
    *   The end of the queue
    */
  private class QueueImpl[+T](
      private[this] var leading: List[T],
      private[this] var trailing: List[T]
  ) extends Queue[T] {

    /** This is an impure function but we need it in order to minimise the complexity of reversing
      * an immutable list and then copying across all the elements to have at each moment: queue =
      * leading ::: (trailing.reverse)
      */
    private def mirror(): Unit =
      if (leading.isEmpty) {
        while (trailing.nonEmpty) {
          // Reversing
          leading = trailing.head :: leading
          trailing = trailing.tail
        }
      }

    def head: T = {
      mirror() // Internal side effect
      leading.head
    }

    def tail: QueueImpl[T] = {
      mirror() // Internal side effect
      if (this.size == 0)
        new QueueImpl[T](Nil, Nil)
      else
        new QueueImpl(leading.tail, trailing)
    }

    // NOTE: We're adding the new element x to head of the trailing List
    def enqueue[U >: T](x: U): Queue[U] =
      new QueueImpl[U](leading, x :: trailing)

    def toList: List[T] = {
      leading ::: trailing.reverse
    }

    override def equals[U >: T](other: Queue[U]): Boolean =
      this.toList == other.toList

    def nonEmpty: Boolean = {
      leading.nonEmpty || trailing.nonEmpty
    }

    def isEmpty: Boolean =
      leading.isEmpty && trailing.isEmpty

    def size: Int =
      leading.size + trailing.size

    /** @param separator
      *   The String separator (e.g. ",", ":"
      * @param l
      *   The leading list
      * @param t
      *   The trailing list
      */
    private def buildPrint[U >: T](separator: String)(l: List[U])(t: List[U]): String = t match {
      case Nil => l.mkString("Queue(", separator, ")")
      case _ => {
        if (l.nonEmpty)
          l.mkString("Queue(", separator, separator) + t.mkString("", separator, ")")
        else t.mkString("Queue(", separator, ")")
      }
    }

    override def toString: String = {
      buildPrint(", ")(leading)(trailing.reverse)
    }
  }

}
