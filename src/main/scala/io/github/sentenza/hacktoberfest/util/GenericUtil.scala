package io.github.sentenza.hacktoberfest.util

object GenericUtil {

  /** Tracks (and prints out) the elapsed time when executing a function
    * (a block of code).
    *
    * Usage:
    * val sorted = GenericUtil.time {
    *             MutableSorting.quickSort(randonArray)
    * }
    *
    * @param block By-name block of code
    * @return The result of the inner operation
    */
  def time[R](block: => R): R = {
    val t0     = System.nanoTime()
    val result = block
    val t1     = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

}
