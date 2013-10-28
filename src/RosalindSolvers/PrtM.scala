package RosalindSolvers

object PrtM extends RosalindSolver {
	val protein_sequence = input_file_lines("prtm").next()
	  
	val weight = protein_sequence.map{amino_acid_weight(_)}.sum
	
	copy_to_clipboard(weight.toString)
}