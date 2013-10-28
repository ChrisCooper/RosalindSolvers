package RosalindSolvers

object Prot extends RosalindSolver {
  val dna_sequence = input_file_lines("prot").next()
  
  val codon_map = full_codon_map()
  
  val codons = dna_sequence.grouped(3).map{codon_map(_)}
  
  val protein_sequence = codons.takeWhile{
    case "Stop" => false
    case _ => true
  }.mkString

  copy_to_clipboard(protein_sequence)
}