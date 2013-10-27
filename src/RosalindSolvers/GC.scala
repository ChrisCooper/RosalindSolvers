package RosalindSolvers

import scala.collection.immutable.WrappedString
import scala.collection.immutable.WrappedString


object GC extends RosalindSolver {
  
  val input_lines = """>Rosalind_6404
CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCC
TCCCACTAATAATTCTGAGG
>Rosalind_5959
CCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAGGCGCTCCGCCGAAGGTCT
ATATCCATTTGTCAGCAGACACGC
>Rosalind_0808
CCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGAC
TGGGAACCTGCGGGCAGTAGGTGGAAT""".split("\n").map{_.trim}.iterator//input_file_lines("gc")

//"spliterate"

  def gc_content(fasta_lines: Iterator[String]) : (Double, String, Iterator[String]) = {
	val header = input_lines.next.stripPrefix(">")
	val (current_entries, remaining_entires) = input_lines.span(! _.startsWith(">"))
	val dna_sequence = current_entries.mkString
	val g_and_c_count = dna_sequence.count(base => (base == 'G') || (base == 'C'))
	
    (g_and_c_count / dna_sequence.length().toDouble, header, remaining_entires)
  }
  
  
  print(gc_content(input_lines))

  	
	  
	//copy_to_clipboard(" ")	  	
}