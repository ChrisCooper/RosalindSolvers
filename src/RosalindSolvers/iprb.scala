package RosalindSolvers

object iprb extends RosalindSolver {
  //val input_line = input_file_lines("iprb").next
  val input_line = "2 2 2"
  
  val List(dominant, heterozygous, recessive) = input_line.split(" ").toList.map{_.toInt}
  
  val parents = List((dominant, 1.0), (heterozygous, 0.5), (recessive, 0.0))
  

//  val total_p_dom = p_dom() * p()
//  
//  
//    
//  println(dominant_children)
//  println(total_children)
//  copy_to_clipboard((dominant_children / total_children).toString)
  
}