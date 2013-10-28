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
	
	def full_codon_map() : Map[String, String] = {
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
	  
	  codon_lines.map{case (seq :: aa :: _) => (seq, aa)}.toList.toMap
	}
	
	def full_weight_map() : Map[Char, Double] = {
	  val weight_lines = Source.fromString("""A 71.03711
C 103.00919
D 115.02694
E 129.04259
F 147.06841
G 57.02146
H 137.05891
I 113.08406
K 128.09496
L 113.08406
M 131.04049
N 114.04293
P 97.05276
Q 128.05858
R 156.10111
S 87.03203
T 101.04768
V 99.06841
W 186.07931
Y 163.06333""").getLines.map{_.split("\\s").toList}
	  
	  return weight_lines.map{case (aa :: weight :: _) => (aa.first, weight.toDouble)}.toList.toMap
    }
	
	val weight_mapping = full_weight_map()
	
	def amino_acid_weight(animo_acid : Char) : Double = weight_mapping(animo_acid)
}