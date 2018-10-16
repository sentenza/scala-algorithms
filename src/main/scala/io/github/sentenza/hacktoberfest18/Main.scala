package io.github.sentenza.hacktoberfest18

object Main extends App {

	
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

	MenuIO.renderInteractiveMenu()

}