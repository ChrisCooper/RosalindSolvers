package RosalindSolvers

object Hamm extends RosalindSolver {
	val input_lines = input_file_lines("hamm")
	val dna1 = input_lines.next
	val dna2 = input_lines.next
	
    val mismatches = (dna1 zip dna2).count{case (base1, base2) => base1 != base2}
    
	copy_to_clipboard(mismatches.toString)	
}
