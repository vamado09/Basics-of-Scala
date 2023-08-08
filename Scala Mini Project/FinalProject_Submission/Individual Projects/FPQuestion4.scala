// Question 4 (For Loop, While Loop, Foreach Loop Methods)
// While Loop: https://www.geeksforgeeks.org/while-and-do-while-loop-in-scala/
// For Loop: https://www.geeksforgeeks.org/for-loop-in-scala/
// For Loop: https://stackoverflow.com/questions/6833501/efficient-iteration-with-index-in-scala
// Foreach: https://stackoverflow.com/questions/45165065/foreach-loop-in-scala
// Foreach: https://www.baeldung.com/scala/foreach-collections
// Java Foreach Loop updating elements: https://www.geeksforgeeks.org/how-to-change-values-in-an-array-when-doing-foreach-loop-in-javascript/
object FPQuestion4 {
  private val numbers = Array(5, 7, 9, 11, 13, 15) // lets create an Array

  private def WhileLoop(): Unit = { // While Loop method
    var elem = 0
    while (elem < numbers.length) { // loop continues as long as element is less than length of array
      numbers(elem) = numbers(elem) + 3 // adding + 3 to elements in position 0, 3, 6, 9 etc
      elem += 3 // adding + 3 after iteration
    }
  }

  private def ForLoop(): Unit = { // For Loop method
    for (elem <- numbers.indices) {
      numbers(elem) = numbers(elem) + 5 // adding +5 of each element within the array
    }
  }

  // Foreach Loop: https://www.baeldung.com/scala/foreach-collections
  // Java Foreach Loop updating elements: https://www.geeksforgeeks.org/how-to-change-values-in-an-array-when-doing-foreach-loop-in-javascript/
  private def ForeachLoop(): Unit = { // JAVA - foreach loop
    numbers.indices.foreach(elem => numbers(elem) = numbers(elem) + 7) // add +7 to each element within the array
  }

  def main(args: Array[String]): Unit = {
    WhileLoop()
    println(s"The While Loop results are: ${numbers.mkString(", ")}") // format suggestion IntelliJ
    ForLoop()
    println(s"The For Loop results are: ${numbers.mkString(", ")}") // format suggestion IntelliJ
    ForeachLoop()
    println(s"The Foreach Loop results are: ${numbers.mkString(", ")}") // format suggestion IntelliJ
  }
}
