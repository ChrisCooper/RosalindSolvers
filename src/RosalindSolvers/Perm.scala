package RosalindSolvers

object Perm extends RosalindSolver {
	val permutation_length = input_file_lines("perm").next().toInt
	  
	val permutations = (1 to permutation_length).toList.permutations.map{_.mkString(" ")}.toList
	
	val output = (permutations.length :: permutations).mkString("\n")
	
	copy_to_clipboard(output)
}