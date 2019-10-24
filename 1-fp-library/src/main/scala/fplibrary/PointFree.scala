package fplibrary

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
}
