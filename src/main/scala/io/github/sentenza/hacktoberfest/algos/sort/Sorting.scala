package io.github.sentenza.hacktoberfest.algos.sort

/** Definitions of the common sorting algorithms.
  *
  * Note that usually one can claim that the known sorting algorithms would not actually be the same
  * if implemented without loops and mutable variables. The reasoning is that you usually lose the
  * ability keep the same time-space analysis results.
  *
  * TODO: find an alternative to: {{{F[_] <: Iterable[_]}}}
  *
  * [[https://stackoverflow.com/q/6246719/1977778 Higher Kinded Types]]
  *
  * @tparam F
  *   A set of iterable elements (Array or Iterable)
  * @tparam T
  *   The type of the elements contained in the set
  */
trait Sorting[F[_], T] {

  /* ****** Exchange Sorts ****** */

  /** Bubble Sort [[http://en.wikipedia.org/wiki/Bubble_sort Wikipedia: Bubble Sort]]
    */
  def bubbleSort(xs: F[T]): F[T]

  /** Cocktail Shaker Sort
    * [[https://en.wikipedia.org/wiki/Cocktail_shaker_sort Wikipedia: Cocktail Shaker Sort]]
    */
  def cocktailShakerSort(xs: F[T]): F[T]

  /** Comb Sort [[https://en.wikipedia.org/wiki/Comb_sort Wikipedia: Comb Sort]]
    */
  def combSort(xs: F[T]): F[T]

  /** Quick Sort [[https://en.wikipedia.org/wiki/Quicksort Wikipedia: Quick Sort]]
    */
  def quickSort(xs: F[T]): F[T]

  /* ****** Selection Sorts ****** */

  /** Selection Sort [[https://en.wikipedia.org/wiki/Selection_sort Wikipedia: Selection Sort]]
    */
  def selectionSort(xs: F[T]): F[T]

  /** Heap Sort [[https://en.wikipedia.org/wiki/Heapsort Wikipedia: Heap Sort]]
    */
  def heapSort(xs: F[T]): F[T]

  /* ****** Insertion Sorts ****** */

  /** Insertion Sort [[https://en.wikipedia.org/wiki/Insertion_sort Wikipedia: Insertion Sort]]
    */
  def insertionSort(xs: F[T]): F[T]

  /* ****** Merge Sorts ****** */

  /** Merge Sort [[https://en.wikipedia.org/wiki/Merge_sort Wikipedia: Merge Sort]]
    */
  def mergeSort(xs: F[T]): F[T]

  /* ****** Distribution Sorts ****** */

  /** Bucket Sort
    */
  def bucketSort(xs: F[T], n: Int, sort: F[T] => F[T]): F[T]

  /** Count Sort
    */
  def countSort(xs: F[T]): F[T]

  /** Radix Sort
    */
  def radixSort(xs: F[T], base: Int): F[T]
}
