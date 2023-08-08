//General: https://www.geeksforgeeks.org/scala-programming-language/
import scala.io.StdIn.readLine // easiest way to read command_line input
import scala.collection.mutable.ListBuffer // creating mutable data

// Question 1
// Reading input: https://docs.scala-lang.org/overviews/scala-book/command-line-io.html
// Taking input from user: https://stackoverflow.com/questions/5055349/how-to-take-input-from-a-user-in-scala
// print vs println: https://www.tutorialspoint.com/difference-between-print-and-println-in-java
// Initializing variable: https://stackoverflow.com/questions/2754301/initialise-a-var-in-scala
// While loop: https://stackoverflow.com/questions/46199788/java-while-loop-for-entering-username-and-password-3-times-issue-with-break-s
// If/Else: https://www.tutorialspoint.com/scala/scala_if_else.htm
object HW3Question1 {
  val username = "vdeleonw"
  val password = "ScalaBasics"

  def main(args: Array[String]): Unit = {
    print("Please enter your username: ")
    val existingUsername = readLine() // read from the console
    if (existingUsername == username) {
      var existingPassword = "" // initialize empty string
      while (existingPassword != password) {
        print("Please enter your password: ")
        existingPassword = readLine() // read from the console
        if (existingPassword == password) {
          println("Welcome vdeleonw!")
        } else {
          println("Incorrect password. Please try again.")
        }
      }
    } else {
      println("Username not valid or doesn't exists. Please run the program again.")
    }
  }
}


// Question 2
// Continuation from Question 1
// Question 1 sources
// Scala Decision Making: https://www.geeksforgeeks.org/scala-decision-making-if-if-else-nested-if-else-if-else-if/
// For loop: https://www.geeksforgeeks.org/for-loop-in-scala/
// String interpolation: https://docs.scala-lang.org/overviews/core/string-interpolation.html
// lower case or caps lock: https://www.geeksforgeeks.org/scala-string-equalsignorecase-method-with-example/
object HW3Question2 {
  val username = "vdeleonw"
  var password = "ScalaBasics"
  private val question = "What class did you take last semester?"
  private val answer = "Applied Machine Learning"

  def main(args: Array[String]): Unit = {
    print("Please enter your username: ")
    val existingUsername = readLine() // reading user input console
    if (existingUsername == username) {
      var attempts = 0 //initializing local variable
      for (attempts <- 1 to 3) { // for loop, range from 1-3
        print("Please enter your password: ")
        val existingPassword = readLine() // reading user input console
        if (existingPassword == password) {
          println("Welcome vdeleonw!")
          return
        } else if (attempts < 3) { // deciding amon options geek for geeks
          println("Incorrect password. Please try again.")
        }
      }

      print("Would you like to reset your password? Please choose Yes or No: ")
      if (readLine().equalsIgnoreCase("yes")) { // equalsIgnoreCase -> either lower case or cap locks
        print(s"$question: ") // string interpolation
        if (readLine() == answer) {
          print("Please enter your new password: ")
          password = readLine() // reading user input console
          println("Done. Your password has been reset.")
        } else {
          println("The answers you provided are not correct. Your account is blocked.")
        }
      }
    } else {
      println("Username not valid or doesn't exist. Please run the program again.")
    }
  }
}


// Question 3
// Python version tutorial: https://github.com/doocs/leetcode/blob/main/solution/0000-0099/0029.Divide%20Two%20Integers/README_EN.md
// <<, <= =>, && operators: https://www.tutorialspoint.com/scala/scala_operators.htm
// math.abs(): https://www.alphacodingskills.com/scala/notes/scala-math-abs.php
// toDouble: https://www.includehelp.com/scala/convert-int-to-double.aspx
object HW3Question3 {
  private def divide(a: Int, b: Int): Int = {
    val INT_MAX = (1 << 31) - 1 // << -> binary left shift operator
    val INT_MIN = -(1 << 31) // // << -> binary left shift operator
    val sign = if (a * b < 0) -1 else 1
    var new_a = Math.abs(a) // specify a number whose absolute value need to be determined.
    val new_b = Math.abs(b) // specify a number whose absolute value need to be determined.
    var tot = 0
    while (new_a >= new_b) { // new_a >= new_b is not true
      var cnt = 0
      do {
        cnt += 1 // assignment just like python
      } while (new_a >= (new_b << cnt))
      cnt -= 1 // assignment just like python
      tot += 1 << cnt
      new_a -= new_b << cnt
    }
    val ans = sign * tot
    if (INT_MIN <= ans && ans <= INT_MAX) ans else INT_MAX // (INT_MIN <= ans && ans <= INT_MAX) is false
  }

  def main(args: Array[String]): Unit = {
    val x = 14 // dividend
    val y = 3 // divisor
    val division = divide(x, y)
    val result = x.toDouble / y.toDouble
    println(f"Explanation: $x/$y = $result%.10f. which is truncated to $division.") // string interpolation
  }
}

// Question 4
// Code tutorial: https://www.geeksforgeeks.org/all-unique-combinations-whose-sum-equals-to-k/
// Lists: https://www.geeksforgeeks.org/scala-lists/
// ListBuffer:  https://www.scala-lang.org/api/2.13.6/scala/collection/mutable/ListBuffer.html
// ListBuffer: https://www.geeksforgeeks.org/scala-listbuffer/
// mkString(): https://www.geeksforgeeks.org/scala-list-mkstring-method-with-a-separator-with-example/
// operators: https://www.tutorialspoint.com/scala/scala_operators.htm
object HW3Question4 {
  def uniqueCombination(l: Int, sum: Int, K: Int, local: ListBuffer[Int], A: List[Int]): Unit = {
    if (sum == K) { // if sum equals k print results within local
      println(local.mkString(",")) // aesthetic purposes mkString separation with ,
      return
    }
    for (i <- l until A.length) { // iterate over elements
      val newSum = sum + A(i) // newSum contains the values from "sum"
      if (newSum <= K && !(i > l && A(i) == A(i - 1))) { // checks if newSum is less than or equal to target k and it check for duplicates
        local += A(i) // local list containing combinations
        uniqueCombination(i + 1, newSum, K, local, A) // (recursive) implement above function after adding elements
        local.remove(local.length - 1) // remove last element of local list
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val A = List(10, 1, 2, 7, 6, 1, 5) // assignment list example
    val K = 8 // target example
    uniqueCombination(0, 0, K, ListBuffer(), A.sorted) // mutable data with ListBuffer and sorting list A for aesthetic purposes
  }
}


// Question 5
// Arrays: https://www.geeksforgeeks.org/scala-arrays/
// Distinct: https://www.geeksforgeeks.org/scala-list-distinct-method-with-example/
// mkString(): https://www.geeksforgeeks.org/scala-list-mkstring-method-with-a-separator-with-example/
object HW3Question5 {
  def main(args: Array[String]): Unit = {
    val nums = Array(0,0,1,1,1,2,2,3,3,4)
    val noDuplicates = nums.distinct // simpler approach to avoid duplicates within list "num"
    println(noDuplicates.mkString(", ")) // mkString for aesthetic results
  }
}


// Question 6
// Lists: https://www.geeksforgeeks.org/scala-lists/
// ::: method: https://www.includehelp.com/scala/merge-lists-in-scala.aspx
// Descending order: https://blog.knoldus.com/sorting-in-scala-using-sortedsortby-and-sortwith-function/
object HW3Question6 {
  def main(args: Array[String]): Unit = {
    val list_1 = List(14, 12, 25, 0, 1)
    val list_2 = List(123, 2, 44, 3)
    val list_3 = list_1 ::: list_2 // Merging 2 lists using the ::: method
    val FinalList = list_3.sortWith(_ > _) // SortWith() function
    println(FinalList)
  }
}
