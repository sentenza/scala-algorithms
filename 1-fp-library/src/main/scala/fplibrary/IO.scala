package io.github.sentenza.hacktoberfest.fplibrary

final case class IO[+A](unsafeRun: () => A) extends AnyVal

object IO {
  // private type Thunk[A] = () => A
  // type Description[A]   = Thunk[A]

  def create[A](a: => A): IO[A] =
    IO(() => a)

  implicit val M: Monad[IO] = new Monad[IO] {
    final override def flatMap[A, B](ca: IO[A])(acb: A => IO[B]): IO[B] =
      IO.create {
        val a  = ca.unsafeRun()
        val db = acb(a)

        val b = db.unsafeRun()

        b
      }
  }
}
