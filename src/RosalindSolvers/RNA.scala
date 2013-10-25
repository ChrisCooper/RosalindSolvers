package RosalindSolvers

object RNA extends RosalindSolver {
	val dna = input_file_lines("rna").next()
    
    val rna = dna.replace('T', 'U')
    
	copy_to_clipboard(rna)
}