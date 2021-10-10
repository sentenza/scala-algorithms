package io.github.sentenza.hacktoberfest

import System.out.println
import scala.annotation.tailrec
import scala.util.{Try, Success}

/*
 * HacktoberFest - Scala Algorithms
 * Copyright (C) 2018-2021 sentenza
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

object MenuIO {
  private val heading =
    """
      _  _         _   _       _             ___       _
     | || |__ _ __| |_| |_ ___| |__  ___ _ _| __|__ __| |_
     | __ / _` / _| / /  _/ _ \ '_ \/ -_) '_| _/ -_|_-<  _|
     |_||_\__,_\__|_\_\\__\___/_.__/\___|_| |_|\___/__/\__|

    """

  private val gplDisclaimer =
    """
    HacktoberFest Scala Algorithms Copyright (C) 2018-2021  @sentenza
    This program comes with ABSOLUTELY NO WARRANTY.
    This is free software, and you are welcome to redistribute it
    under certain conditions. All the details can be found at:
    https://github.com/sentenza/hacktoberfest-scala-algorithms/blob/master/LICENSE.
    """

  /**
    * This function should be called at the very beginning of the Main execution
    * to fetch the disclaimer message and the project Logo to be printed out
    */
  def printDisclaimer(): Unit = { println(heading + gplDisclaimer) }

  private val noOp = () => ()

  def readNumberInputs: Array[Int] = scala.io.StdIn.readLine().split(",").map(_.toInt)

  case class MenuEntry(selector: Int, display: String, code: () => Unit)

  // TODO: Add more categories here
  private val entries =
    List(
      MenuEntry(1, "Sorting algorithms", () => println("You chose sorting\n")),
      MenuEntry(0, "Quit the program", noOp)
    )


  @tailrec
  def renderInteractiveMenu(): Unit = {
    println("Please choose:")
    entries.foreach {
      case MenuEntry(num, label, _) =>
        println(s"$num: $label")
    }

      Try(scala.io.StdIn.readInt()) match {
        case Success(0) =>
          ()
        case Success(choice) if entries.exists(_.selector == choice) =>
          entries.find(_.selector == choice).foreach{
            case MenuEntry(_, _, code) => code()
          }
          renderInteractiveMenu()
        case _ =>
          println("Invalid selection\n")
          renderInteractiveMenu()
      }
    }
}
