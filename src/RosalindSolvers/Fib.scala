package RosalindSolvers

object Fib extends RosalindSolver {
	val input_line = input_file_lines("fib").next()
	val Array(total_months, pairs_per_generation) = input_line.split(" ").map{_.toLong}
	
	def rabbits_alive(months: Long) : Long = months match {
	    case 1 | 2 => 1
	    case _ => rabbits_alive(months - 1) + (rabbits_alive(months - 2) * pairs_per_generation)
	}
	  
	copy_to_clipboard(rabbits_alive(total_months).toString)
}
