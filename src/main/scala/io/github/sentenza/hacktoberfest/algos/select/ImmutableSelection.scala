package io.github.sentenza.hacktoberfest.algos.select

/** Implementations of this trait should provide non-destructive select operations on linked lists.
  * That is, the linked list passed to a select method should not be altered: A value at the
  * specified sorted index should be returned.
  */
object ImmutableSelection extends Selection[List, Int] {

  /** @inheritdoc
    *
    * @param list
    *   Linked list of sortable, selectable integers
    * @param idx
    *   An sorted index, that is, an index referring to the nth largest element of the list
    * @return
    *   A possible element of the array at the sorted index
    */
  def quickSelect(list: List[Int], idx: Int): Option[Int] = {
    if (idx < 0 || list.size <= idx) return None

    list match {
      case Nil => None
      case pivot :: rest => {
        val (smaller, larger) = rest partition (_ <= pivot)
        val pivotIdx          = smaller.size

        idx.compare(pivotIdx) match {
          case needleInSmaller if needleInSmaller < 0 =>
            quickSelect(smaller, idx)
          case needleIsPivot if needleIsPivot == 0 => Some(pivot)
          case needleInLarger if needleInLarger > 0 =>
            quickSelect(larger, idx - pivotIdx - 1)
        }
      }
    }
  }
}
