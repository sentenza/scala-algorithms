quickSort(Array(3,2,4,1,0))

def quickSort(array: Array[Int]): Array[Int] = {
  if (array.length>1) {
    var pivot = array(0)
    (quickSort(array.filter(a => a < pivot)) :+ pivot) ++ quickSort(array.filter(a => a > pivot))
  }
  else array
}
