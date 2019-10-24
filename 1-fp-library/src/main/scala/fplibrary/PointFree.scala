package io.github.sentenza.hacktoberfest.fplibrary

object PointFree {
  // val ac = compose(ab, bc)
  def compose[A, B, C](ab: A => B, bc: B => C): A => C = a => {
    // taking A in and producing b
    val b = ab(a)
    // Going from B to C
    val c = bc(b)
    // Returning C
    c
  }

  def composeKleisliOld[A, B, C](
      adb: A => IO[B],
      bdc: B => IO[C]
  ): A => IO[C] = a => {
    val db: IO[B] = adb(a)
    val b         = db.unsafeRun()

    val dc = bdc(b)

    dc
  }

  // Kleisli Composition won't actually work without Monads (try to remove Monad from D[_]: Monad)
  def composeKleisli[A, B, C, D[_]: Monad](adb: A => D[B], bdc: B => D[C]): A => D[C] = a => {
    val db: D[B] = adb(a)
    val dc       = Monad[D].flatMap(db)(bdc)
    dc
  }

}
