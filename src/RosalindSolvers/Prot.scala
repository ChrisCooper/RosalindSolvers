package RosalindSolvers

object Prot extends RosalindSolver {
  val dna_sequence = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA"//input_file_lines("prot").next()
  
  val codon_map = full_codon_map()
  
  val codons = dna_sequence.grouped(3).map{_ => translated_amino_acid(_)}
  
  val str = codons.takeWhile{
    case AminoAcid(nucleotides, letter) => true
    case Stop(_) => false  
  }
  
  def translated_amino_acid(nucleotides: String) = {
    codon_map(nucleotides)
  }
  
  print(str.toList)
  copy_to_clipboard("Yo")
}