package RosalindSolvers

object FibD extends RosalindSolver {
	val input_line = input_file_lines("fibd").next()
	val Array(total_months, lifespan) = input_line.split(" ").map{_.toInt}

	val memoized_rabbits_alive = collection.mutable.Map[(Int, Int), BigInt]()
	
	def rabbits_alive_total(months: Int) : BigInt = months match {
	    case 1 | 2 => 1
	    case _ => (0 to (lifespan - 1)).toList.map{age => rabbits_alive_aged(months, age)}.sum
	}
	
	def rabbits_alive_aged(months: Int, age: Int) : BigInt = {
	  if (memoized_rabbits_alive.contains((months, age))) { 
	    memoized_rabbits_alive((months, age))
	  } else {
		  val num_rabbits : BigInt = age match {
			  case 0 => months match {
			    case months if months < 1 => 0
			    case 1 => 1
			    case 2 => 0
			    case _ => (1 to (lifespan - 1)).toList.map{age => rabbits_alive_aged(months - 1, age)}.sum 
			  }
			  case _ => months match {
			    case months if months < 2 => 0
			    case 2 => if (age == 1) 1 else 0
			    case _ => rabbits_alive_aged(months - 1, age - 1)
			  }
		  }
		  memoized_rabbits_alive((months, age)) = num_rabbits
		  return num_rabbits
	  }
	}
	  
	copy_to_clipboard(rabbits_alive_total(total_months).toString)
}
