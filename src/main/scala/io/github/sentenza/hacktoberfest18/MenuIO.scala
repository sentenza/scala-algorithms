package io.github.sentenza.hacktoberfest18

import System.out.println

/*
 * HacktoberFest 2018 - Scala Algorhitms
 * Copyright (C) 2018 sentenza
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
    private val heading = """
      _  _         _   _       _             ___       _     ___ __  _ ___
     | || |__ _ __| |_| |_ ___| |__  ___ _ _| __|__ __| |_  |_  )  \/ ( _ )
     | __ / _` / _| / /  _/ _ \ '_ \/ -_) '_| _/ -_|_-<  _|  / / () | / _ \
     |_||_\__,_\__|_\_\\__\___/_.__/\___|_| |_|\___/__/\__| /___\__/|_\___/

    """

    private val gplDisclaimer = """
    HacktoberFest 2018 Scala Algorhitms Copyright (C) 2018  @sentenza
    This program comes with ABSOLUTELY NO WARRANTY.
    This is free software, and you are welcome to redistribute it
    under certain conditions. All the details can be found at:
    https://github.com/sentenza/hacktoberfest-scala-algorithms/blob/master/LICENSE.
    """

    /**
     * This function should be called at the very beginning of the Main execution
     * to fetch the disclaimer message and the project Logo to be printed out
     */
    private def printDisclaimer() { println(heading + gplDisclaimer) }

    def renderInteractiveMenu(): Unit = {
      printDisclaimer()
      println("Please choose:")
      println("1: Sorting algorithms")
      // TODO: Add more categories here
      println("0: Quit this program")

      var choice = scala.io.StdIn.readInt()
      while (choice != 0) {

        choice match {
          case 1 => println("You chose sorting")
          case _ => println("Invalid choice")
        }
        choice = scala.io.StdIn.readInt()
      }
    }
}