package io.github.sentenza.hacktoberfest.util

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
  * A list of useful functions to work with arrays
  */
class ArrayUtil {

  /**
    * Builds an array of random numbers
    *
    * @param length The length of the array to be built
    * @param maxElement The maximum possible value to assign to an element of the array
    * @return An array of random integers
    */
  def buildRandomArray(length: Int, maxElement: Int = Int.MaxValue / 10): Array[Int] = {
    val maximum = if (maxElement <= Int.MaxValue / 10) maxElement else Int.MaxValue
    Array.fill(length) { scala.util.Random.nextInt(maximum) }
  }

}
