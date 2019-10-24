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
      adb: A => Description[B],
      bdc: B => Description[C]
  ): A => Description[C] = a => {
    val db: Description[B] = adb(a)
    val b                  = db.apply()

    val dc = bdc(b)

    dc
  }

  def composeKleisli[A, B, C, D[_]: Monad](adb: A => D[B], bdc: B => D[C]): A => D[C] = a => {
    val db: D[B] = adb(a)
    val dc = Monad[D].flatMap(db)(bdc)
    dc
  }

}
