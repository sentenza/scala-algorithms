package io.github.sentenza.hacktoberfest.util

import scala.util.Random

/*
 * HacktoberFest - Scala Algorithms
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

/**
  * A list of useful functions to work with linked lists
  */
class ListUtil {

  /**
    * Builds a list of random numbers
    *
    * @param length The length of the list to be built
    * @return An array of random integers
    */
  def buildRandomList(length: Int): List[Int] = {
    val rand = new Random()
    List.fill(length)(rand.nextInt(length))
  }

}
