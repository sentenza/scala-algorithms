package io.github.sentenza.hacktoberfest.algos.select

/** Definitions of the functions that will implement all the common selection algorithms.
  */
trait Selection[F[_], T] {
  /* *** Partition-based Selection *** */

  /** Quick Select [[https://en.wikipedia.org/wiki/Quickselect Wikipedia: Quick Select]]
    */
  def quickSelect(xs: F[T], idx: Int): Option[T]
}
