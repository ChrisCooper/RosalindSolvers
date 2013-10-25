package RosalindSolvers

object RevC extends RosalindSolver {
	val dna = input_file_lines("revc").next()
	
    val complement_map = Map(('A','t'), ('C','g'), ('G','c'), ('T','a'))
    
    val reverse_complement = dna.map{base => complement_map(base)}.reverse
    
	copy_to_clipboard(reverse_complement.map{_.toUpper})
}
