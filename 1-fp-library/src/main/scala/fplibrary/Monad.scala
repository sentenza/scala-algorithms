package io.github.sentenza.hacktoberfest.fplibrary

trait Monad[C[_]] {
  // We needed this helper method to compose functions
  // def helper[A, B](ca: C[A], acb: A => C[B]): C[B] // From Helper to FlatMap

  def flatMap[A, B](ca: C[A])(acb: A => C[B]): C[B] // Curried version of helper method
  // haskell bind
  @inline def bind[A, B](ca: C[A])(acb: A => C[B]): C[B] = flatMap(ca)(acb)
  @inline def >>=[A, B](ca: C[A])(acb: A => C[B]): C[B]  = flatMap(ca)(acb) // >>= Haskell Logo
}

// Type classes and implicitly
object Monad {
  def apply[C[_]: Monad]: Monad[C] = implicitly[Monad[C]]
}
