package io.github.sentenza.hacktoberfest.eotw

import io.github.sentenza.hacktoberfest.fplibrary._
import io.github.sentenza.hacktoberfest.application.Program

object Interpreter {
  def main(args: Array[String]): Unit = {
    val description: IO[Unit]        = Program.createIO(args)
    def interpret[A](desc: IO[A]): A = desc.unsafeRun()
    print(Console.YELLOW)
    printDisclaimer()
    print(Console.RED)
    // <==== If you saw some red text you would know that something bad is going on ====>
    print(Console.GREEN)
    interpret(description)
    print(Console.RESET)
  }

  private def printDisclaimer(): Unit = {
    println(heading + gplDisclaimer)
  }

  private val heading = 
  """
   _   _            _    _        _              ______        _   
  | | | |          | |  | |      | |             |  ___|      | |  
  | |_| | __ _  ___| | _| |_ ___ | |__   ___ _ __| |_ ___  ___| |_ 
  |  _  |/ _` |/ __| |/ / __/ _ \| '_ \ / _ \ '__|  _/ _ \/ __| __|
  | | | | (_| | (__|   <| || (_) | |_) |  __/ |  | ||  __/\__ \ |_ 
  \_| |_/\__,_|\___|_|\_\\__\___/|_.__/ \___|_|  \_| \___||___/\__|
                                                                     
  """

  private val gplDisclaimer =
    """
    HacktoberFest Scala Algorhitms Copyright (C) 2018-2019  @sentenza
    This program comes with ABSOLUTELY NO WARRANTY.
    This is free software, and you are welcome to redistribute it
    under certain conditions. All the details can be found at:
    https://github.com/sentenza/hacktoberfest-scala-algorithms/blob/master/LICENSE.
    """
}
