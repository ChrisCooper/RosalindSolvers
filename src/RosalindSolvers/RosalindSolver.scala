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
}