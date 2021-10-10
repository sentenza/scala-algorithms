package io.github.sentenza.hacktoberfest.algos.loopless

/** Provides implementation of the algorithms and data structures originally presented in Jamie
  * Snape's Master Thesis "Loopless Functional Algorithms" available from
  * https://wwwx.cs.unc.edu/~snape/publications/msc/
  */
object LooplessFunctional {

  /** Builds a list from a particular value This is considered the principal building block of
    * loopless algorithms in the mentioned work
    *
    * While the function takes a single step operation, in all the sequent algorithms the step is
    * actually a composition of `step compose prologue``, where prologue should take `O(n)` time and
    * the step `O(1)`
    */
  def unfoldr[A, B](step: B => Option[(A, B)])(b: B): List[A] =
    step(b) match {
      case Some((x, y)) => x :: unfoldr(step)(y)
      case None         => List.empty
    }

  /** First example algo presented, flattens nested lists */
  def concat[A](nested: List[List[A]]): List[A] = {

    //make typing shorter
    type LL = List[List[A]]

    //the unfolding step
    val step: LL => Option[(A, LL)] = {
      case (a :: as) :: rest =>
        val result: (A, LL) = (a, as :: rest)
        Some(result)
      case List(Nil) => None
      case Nil       => None
      case _         => None
    }

    //prolog for concat, removes empty nestings
    val prologue: LL => LL = _.filter(_.nonEmpty)

    unfoldr(step compose prologue)(nested)
  }

}
