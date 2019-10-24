package io.github.sentenza.hacktoberfest.application

import io.github.sentenza.hacktoberfest.fplibrary._

object Program {
  // def createDescription(args: Array[String]): Description[Unit] =
  //   () => displayMessages()

  lazy val createDescription: Array[String] => Description[Unit] = args =>
    Description.create {
      display(
        hyphens(
          display(
            createMessage(
              display(
                hyphens(
                  args
                )
              )
            )
          )
        )
      )
    }

  // Transforming defs into functions - Old version had def
  // The following values were actually defs and now we transformed them into functions
  // Functions from A to B: A => B
  // private def hyphens(input: Any): String = "\u2500" * 50
  private lazy val hyphens: Any => String       = _ => "\u2500" * 50
  private lazy val createMessage: Any => String = _ => "Welcome to the Program!"
  private lazy val display: Any => Unit         = input => println(input)
  private lazy val prompt: Any => String        = _ => scala.io.StdIn.readLine()
}
