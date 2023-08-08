// Question 5 (Filtering and Yield Methods)
// Filter() Method: https://alvinalexander.com/scala/how-to-use-filter-method-scala-collections-cookbook/
// Yield Keyword: https://www.geeksforgeeks.org/scala-yield-keyword/
object FPQuestion5 {
  def main(args: Array[String]): Unit = {
    val numbers = Array(5, 7, 9, 11, 13, 15, 17, 20, 22) // Creating Array
    val FilterMethod = numbers.filter(_ > 9) // filters elements greater than 9
    // YieldKeyword: iterates over the elements from the FilterMethod array and uses if statement to keep elements greater than 13
    val YieldKeyword = for (elem <- FilterMethod if elem > 13) yield elem // yield method

    println(s"The elements inside the array are: ${numbers.mkString(", ")}") // format suggestion IntelliJ
    println(s"Numbers that are greater than 9: ${FilterMethod.mkString(", ")}") // format suggestion IntelliJ
    println(s"Getting numbers greater than 13: ${YieldKeyword.mkString(", ")}") // format suggestion IntelliJ
  }
}