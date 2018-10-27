package io.github.sentenza.hacktoberfest18.adt

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
