package RosalindSolvers

object Subs extends RosalindSolver {
  	val input_lines = input_file_lines("subs")
	val dna = input_lines.next
	val target_sequence = input_lines.next
	  
	val target_locations = dna.sliding(target_sequence.length).counted.map{_ == target_sequence}
	
	val indices = target_locations.zipWithIndex
		.filter{case(was_found, index) => was_found}
		.map{case(was_found, index) => index + 1}
	
	copy_to_clipboard(indices.mkString(" "))	
  
}