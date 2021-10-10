package io.github.sentenza.hacktoberfest.adt

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
  * Represents a simple Binary Tree data structure
  */
sealed trait Tree[+T]

case class Leaf[T](value: T) extends Tree[T]

/**
  * A branch will contain only two pointers
  * @param left The left recursive Tree
  * @param right The right recursive Tree
  */
case class Branch[T](left: Tree[T], right: Tree[T]) extends Tree[T]

object Tree {

  /**
    * Using pattern matching it returns the size of the Tree
    * @param tree The Tree to compute the size of
    * @return the number of nodes of a Tree
    */
  def size[T](tree: Tree[T]): Int = tree match {
    case _: Leaf[T]   => 1                     // A Leaf counts 1
    case Branch(l, r) => 1 + size(l) + size(r) // A Branch counts 1
  }

  /**
    * Returns the maximum depth of the Tree recursively
    * @param tree The tree to work on
    * @return the maximum path length from the root of a Tree to any leaf
    */
  def depth[T](tree: Tree[T]): Int = tree match {
    case _: Leaf[T]   => 0                                                     // A Leaf counts 0
    case Branch(l, r) => 1 + (if (depth(l) > depth(r)) depth(l) else depth(r)) // A Branch counts 1
  }

  /**
    * Returns a Tree with all the values replaced with the given function
    * @param tree The tree to work on
    * @param f The function to be applied to each leaf of the Tree
    * @tparam F The type of the element that will be returned by f
    * @return A new Tree which will be made by applying f to the original Tree
    */
  def map[T, F](tree: Tree[T], f: (T) => F): Tree[F] = tree match {
    case Leaf(v) => Leaf(f(v))
    case Branch(l, r) => Branch(map(l, f), map(r, f))
  }

  //  def maximum[T](): T = ???
}
