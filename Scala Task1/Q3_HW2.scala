// Question 3
//class Operations {
  //def addInt(a: Int, b:Int) : Int = { a + b }
  //def subInt(a: Int, b:Int) : Int = { a - b }
  //def mltpInt(a: Int, b:Int) : Int = { a * b }
//}
// Main method to execute the above 3 functions
object Question3 {

  def main(args: Array[String]) : Unit = {
    val operations = new Operations()
    val add = operations.addInt(70, 5)
    val sub = operations.subInt(70, 5)
    val mltp = operations.mltpInt(70, 5)

    println(add)
    println(sub)
    println(mltp)
  }
}
