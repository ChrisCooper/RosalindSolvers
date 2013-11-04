package RosalindSolvers

object Lexf extends RosalindSolver {
    //val lines = input_file_lines("lexf")
	val characters = "T A G C".split("\\s*").toList//lines.next().split("\\s*").toList
	val permutation_length = 2//lines.next().toInt
	  
	val combinations = characters.combinations(permutation_length).toList
	val permutations = characters.map{_.toList.permutations.map{_.mkString("")}
	
	val output = permutations.map{_.mkString("\n")}.mkString("\n")
	
	copy_to_clipboard(output)
}