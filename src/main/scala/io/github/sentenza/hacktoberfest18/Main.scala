package io.github.sentenza.hacktoberfest18
import sort.mergeSort

object Main extends App {
<<<<<<< HEAD
	
	def printMenu(): Unit = {
	  val menuText = """Choose an algorythm:
						|1. MergeSort""".stripMargin
	  println(menuText)
	  val cmd = scala.io.StdIn.readLine()
	  cmd match{
		case "1" => {
		  val testList = List(5, 8, 1, 3, 9, 7, 1, 4, 5, 6)
		  println("Unordered list: " + testList.mkString(", "))
		  val orderedList = mergeSort.mergeSort(testList)
		  println("Ordered list: " + orderedList.mkString(", "))
		  
		}		
		case _ => printMenu()
	  }
	}
	
	val heading = """
	  _  _         _   _       _             ___       _     ___ __  _ ___ 
	 | || |__ _ __| |_| |_ ___| |__  ___ _ _| __|__ __| |_  |_  )  \/ ( _ )
	 | __ / _` / _| / /  _/ _ \ '_ \/ -_) '_| _/ -_|_-<  _|  / / () | / _ \
	 |_||_\__,_\__|_\_\\__\___/_.__/\___|_| |_|\___/__/\__| /___\__/|_\___/
																		   
	"""

	val gplDisclaimer = """
	HacktoberFest 2018 Scala Algorhitms Copyright (C) 2018  @sentenza
	This program comes with ABSOLUTELY NO WARRANTY.
	This is free software, and you are welcome to redistribute it
	under certain conditions. All the details can be found at:
	https://github.com/sentenza/hacktoberfest-scala-algorithms/blob/master/LICENSE.
	"""

	println(Console.BLUE + heading)

	println(Console.YELLOW + gplDisclaimer)
	
	printMenu()
	
=======
  MenuIO.renderInteractiveMenu()
>>>>>>> master
}