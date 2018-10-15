package io.github.sentenza.hacktoberfest18.sort

object mergeSort {

	def mergeSort(list: List[Int]): List[Int] = {
		def merge(l: List[Int], r: List[Int]): List[Int] = (l, r) match {
			case (Nil, _) => r
			case(_, Nil) => l
			case (lHead :: lTail, rHead :: rTail) =>
				if(lHead < rHead){
					lHead :: merge(lTail, r)
				}
				else{
					rHead :: merge(l, rTail)
				}
		}
		
		val n = list.length / 2
		if(n == 0){
			list
		}
		else{
			val (part1, part2) = list splitAt n
			merge(mergeSort(part1), mergeSort(part2))
		}
	}

}