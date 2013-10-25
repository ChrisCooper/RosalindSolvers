package RosalindSolvers


object DNA extends RosalindSolver {
    val dna = input_file_lines("dna").next()
    
    val nucleotide_counts = List('A', 'C', 'G', 'T').map{base => dna.count(_ == base)}
    
	copy_to_clipboard(nucleotide_counts.mkString(" "), fake = false)
}