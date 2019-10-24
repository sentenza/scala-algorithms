package io.github.sentenza.hacktoberfest

package object fplibrary {
  import _root_.fplibrary.PointFree
  private type Thunk[A]                 = () => A
  type Description[A]                   = Thunk[A]
  private type RegularArrow[A, B]       = A => B
  private type KleisliArrow[A, B, C[_]] = A => C[B]

  // Why are we extending AnyVal? You said performance, why?
  // val ac = ab `;` bc
  implicit final class InfixNotationForPointFree[A, B](private val ab: A => B) extends AnyVal {
    @inline def `;`[C](bc: B => C): A => C = PointFree.compose(ab, bc)
    // Alias: In Haskell compose is a simple dot
    @inline def `.`[C](bc: B => C): A => C = PointFree.compose(ab, bc)
    // Let's also define an Arrow
    @inline def -->[C](bc: B => C): A => C = PointFree.compose(ab, bc)
  }
}
