package io.github.sentenza.hacktoberfest.application

import io.github.sentenza.hacktoberfest.fplibrary._

object Program {
  // def createDescription(args: Array[String]): Description[Unit] =
  //   () => displayMessages()

  lazy val unreadableCreateDescription: Array[String] => Description[Unit] = args =>
    Description.create(
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
    )

  // lazy val createDescription: Array[String] => IO[Unit] =
  //   ignoreArgs                --> hyphens --> displayKleisli                                            >=>
  //   question                  --> displayKleisli                                                        >=>
  //   promptKleisli                                                                                       >=>
  //   convertStringToInt        --> ensureAmountIsPositive --> round --> createMessage --> displayKleisli >=>
  //   hyphens                   --> displayKleisli

  // --> is equal to the std library "andThen"
  
  import io.github.sentenza.hacktoberfest.fplibrary.Description._
  // Format: OFF
  lazy val createDescription: Array[String] => Description[Unit] =
    ignoreArgs --> hyphens -->    displayKleisli >=>
    createMessage -->             displayKleisli >=>
      hyphens -->                 displayKleisli
  //Format: ON

  // Transforming defs into functions - Old version had def
  // The following values were actually defs and now we transformed them into functions
  // Functions from A to B: A => B
  // private def hyphens(input: Any): String = "\u2500" * 50
  private lazy val hyphens: Any => String            = _ => "\u2500" * 50
  private lazy val createMessage: Any => String      = _ => "Welcome to HacktoberFest Scala Algorhitms!"
  private lazy val display: Any => Unit              = input => println(input)
  private lazy val prompt: Any => String             = _ => scala.io.StdIn.readLine()
  private lazy val ignoreArgs: Array[String] => Unit = _ => ()

  // Kleisli
  private lazy val displayKleisli: Any => Description[Unit] = input =>
    Description.create(println(input))
  private lazy val promptKleisli: Any => Description[String] = _ =>
    Description.create(scala.io.StdIn.readLine())
}
