package RosalindSolvers

import scala.io.Source
import java.awt.datatransfer.StringSelection
import java.awt.Toolkit

class RosalindSolver extends App {
  
	def input_file_lines(problem_name: String) =
	  Source.fromFile("/Users/chriscooper/Downloads/rosalind_%s.txt".format(problem_name)).getLines
  
	def copy_to_clipboard(str: String, fake: Boolean = false) : Unit = {
		if (fake) {
			println(str)
			return
		}
		println("Copying to clipboard:\n%s".format(str))
		
		val stringSelection = new StringSelection(str);
		val clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		
		println("Finished copying to clipboard")
	}
	
	abstract case class Codon
	case class AminoAcid(nucleotides: String, letter: String) extends Codon
	case class Stop(nucleotides: String) extends Codon
	case class Start() extends AminoAcid("AUG", "M")
	
	def full_codon_map() : Map[String, Codon] = {
//	  val codon_resource_url = getClass.getResource("codon_mappings.txt")
//	  val codon_source = Source.fromURL(codon_resource_url)
//	  val codon_lines = codon_source.getLines.map{_.split("\\s").toList}
	  val codon_lines = Source.fromString("""UUU F
CUU L
AUU I
GUU V
UUC F
CUC L
AUC I
GUC V
UUA L
CUA L
AUA I
GUA V
UUG L
CUG L
AUG M
GUG V
UCU S
CCU P
ACU T
GCU A
UCC S
CCC P
ACC T
GCC A
UCA S
CCA P
ACA T
GCA A
UCG S
CCG P
ACG T
GCG A
UAU Y
CAU H
AAU N
GAU D
UAC Y
CAC H
AAC N
GAC D
UAA Stop
CAA Q
AAA K
GAA E
UAG Stop
CAG Q
AAG K
GAG E
UGU C
CGU R
AGU S
GGU G
UGC C
CGC R
AGC S
GGC G
UGA Stop
CGA R
AGA R
GGA G
UGG W
CGG R
AGG R
GGG G""").getLines.map{_.split("\\s").toList}
	  print(codon_lines.toList)
	  val mapping = codon_lines.map{case (seq :: aa :: _) => (seq, aa match {
	    case "M" => Start()
	    case "Stop" => Stop(seq)
	    case _ => AminoAcid(seq, aa)
	  })}.toList.toMap
	  
	  return mapping
	}
	
	
}