package io.github.sentenza.hacktoberfest

import System.out.println
import scala.annotation.tailrec
import scala.util.{Try, Success}
import io.github.sentenza.hacktoberfest.algos.sort.MutableSorting
import io.github.sentenza.hacktoberfest.algos.sort.ImmutableSorting
import io.github.sentenza.hacktoberfest.algos.sort.Sorting
import scala.reflect.runtime.universe._
import scala.reflect.ClassTag

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

  /** This function should be called at the very beginning of the Main execution to fetch the
    * disclaimer message and the project Logo to be printed out
    */
  def printDisclaimer(): Unit = { println(heading + gplDisclaimer) }

  def readNumberInputs(): Array[Int] = {
    print("Please enter a list of comma separated integers: ")
    scala.io.StdIn.readLine().split(",").map(_.trim.toInt)
  }

  case class MenuEntry(selector: Int, display: String, code: () => Unit = () => ())

  /* The following section generalize how to display collections as
   * strings, needed to interact with user input on the console
   */
  trait Show[T] {
    def toString(t: T): String
  }

  implicit def showArray[T]: Show[Array[T]] = new Show[Array[T]] {
    def toString(t: Array[T]): String = t.mkString(",")
  }

  implicit def showIterable[T, F[_] <: Iterable[_]]: Show[F[T]] = new Show[F[T]] {
    def toString(t: F[T]): String = t.mkString(",")
  }

  // TODO: Add more categories here
  private val rootEntries =
    List(
      MenuEntry(
        1,
        "Sorting algorithms",
        () => {
          println("You chose sorting\n")
          renderInteractiveMenu(sortingMenuEntries)
        }
      ),
      MenuEntry(0, "Quit the program", () => System.exit(0))
    )

  private lazy val sortingMenuEntries = List(
    MenuEntry(
      2,
      "MutableSorting",
      () => {
        println("You chose mutable sorting.")
        renderInteractiveMenu(
          createSortMenuEntries[Array, Int, MutableSorting.type](
            MutableSorting,
            readNumberInputs()
          )
        )
      }
    ),
    MenuEntry(
      1,
      "ImmutableSorting",
      () => {
        println("You chose immutable sorting.")
        renderInteractiveMenu(
          createSortMenuEntries[List, Int, ImmutableSorting.type](
            ImmutableSorting,
            readNumberInputs().toList
          )
        )
      }
    ),
    MenuEntry(0, "Quit sorting", () => renderInteractiveMenu())
  )

  @tailrec
  def renderInteractiveMenu(entries: List[MenuEntry] = rootEntries): Unit = {
    println("Please choose:")
    entries.sortBy(_.selector).foreach { case MenuEntry(num, label, _) =>
      println(s"$num: $label")
    }

    Try(scala.io.StdIn.readInt()) match {
      case Success(choice) if entries.exists(_.selector == choice) =>
        entries.find(_.selector == choice).foreach { case MenuEntry(_, _, code) =>
          code()
        }
        renderInteractiveMenu()
      case _ =>
        println("Invalid selection\n")
        renderInteractiveMenu()
    }
  }

  private def createSortMenuEntries[F[_], T, S <: Sorting[F, T]: TypeTag: ClassTag](
      sorting: S,
      toSort: => F[T]
  )(implicit show: Show[F[T]], ftt: TypeTag[F[T]]) = {

    val (_, entries) = collectSortMethods[S, F[T]](sorting)
      .foldLeft(1 -> List.empty[MenuEntry]) { case ((count, entries), (sortName, sortFunction)) =>
        count + 1 -> (entries :+ MenuEntry(
          count,
          sortName,
          () => executeSort(sortName, sortFunction, toSort)
        ))
      }

    entries
  }

  private def executeSort[T: Show](name: String, sorter: T => T, toSort: => T) = {
    val show = implicitly[Show[T]]

    println(s"You've chosen $name!")
    // forces the on-demand evaluation of the input collection
    val values = toSort
    println(
      s"You entered:${show.toString(values)}. They are going to be sorted by $name.\n Sorting..."
    )
    println(s"Your number entries sorted are: ${show.toString(sorter(values))}")
  }

  private def collectSortMethods[C: TypeTag: ClassTag, T: TypeTag](c: C) =
    typeOf[C].decls.collect {
      case t
          if
          // matches all sort methods that takes exactly an T (some collection type) and spits a T again
          t.fullName.endsWith("Sort") &&
            t.isMethod &&
            t.asMethod.paramLists
              .exists(ins => ins.headOption.exists(_.info =:= typeOf[T])) &&
            t.asMethod.returnType =:= typeOf[T] =>
        // we get a method handle and wrap it in a typed function to return back
        val method =
          runtimeMirror(c.getClass().getClassLoader())
            .reflect(c)
            .reflectMethod(t.asMethod)
        // use the method name as key and the function as value of this map
        t.name.decodedName.toString() -> { (in: T) => method(in).asInstanceOf[T] }
    }.toMap

}
