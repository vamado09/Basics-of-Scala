

import scala.collection.immutable._

//Question 1
// mylist.last: https://www.geeksforgeeks.org/find-the-last-element-of-a-list-in-scala/
// last method: https://www.geeksforgeeks.org/scala-stack-last-method-with-example/
object HW5Question1 {
  def main(args: Array[String]): Unit = {
    val hw1list: List[String] = List("Rigo", "Bella", "Vicente", "Gaby") // list with elements
    val lastElement = hw1list.last // last method
    println(s"The last element of the list is: $lastElement")
  }
}

// Question 2
// other available methods: https://stackoverflow.com/questions/48040958/finding-the-penultimate-element-in-scala-list
// init: https://www.geeksforgeeks.org/scala-list-init-method-with-example/
// last: https://www.geeksforgeeks.org/scala-stack-last-method-with-example/
object HW5Question2 {
  def main(args: Array[String]): Unit = {
    val hw1list2: List[String] = List("Rigo", "Bella", "Vicente", "Gaby") // list
    // init method returns all elements of the list except the last one
    val penultimo = hw1list2.init.last // last method to return the last element of the stack
    println(s"The last but one element of the list is: $penultimo")
  }
}

// Question 3
// palindrome or not: https://www.w3resource.com/scala-exercises/list/scala-list-exercise-17.php
// reverse scala: https://www.geeksforgeeks.org/how-to-reverse-a-list-in-scala/
// python example: https://www.geeksforgeeks.org/python-test-if-list-is-palindrome/
object HW5Question3 {
  private def PalindromeCheck[A](list_nums: List[A]): Boolean = {
    list_nums == list_nums.reverse // checking if list is the same from front and rear
  }

  private val hw5list3: List[Int] = List(3, 5, 7, 9, 7, 5, 3) // list 3
  private val hw5list4: List[Int] = List(2, 4, 6) // list 4

  def main(args: Array[String]): Unit = {
    println("Is hw5list3 Palindrome True or False?: " + PalindromeCheck(hw5list3))
    println("Is hw5list4 Palindrome True or False?: " + PalindromeCheck(hw5list4))
  }
}


// Question 4
// Tuple: https://www.tutorialspoint.com/scala/scala_tuples.htm
// Tuple name._1: https://www.geeksforgeeks.org/scala-tuple/
object HW5Question4 {
  def main(args: Array[String]): Unit = {
    val tuple1 = (5, 7, 9)
    val tuple2 = ("v", "c", "r")
    val result = (tuple1._1, tuple1._2, tuple1._3, tuple2._1, tuple2._2, tuple2._3) // creating new tuple with all elements
    println(result)
  }
}

// Question 5
// palindrome words example: https://en.wikipedia.org/wiki/Palindrome#:~:text=Examples%20are%20civic%2C%20radar%2C%20level,are%20orders%20of%20magnitude%20rarer.
object HW5Question5 {
  def main(args: Array[String]): Unit = {
    val hw5list5 = List("rotator", "scala", "Carolina", "reviver", "kayak", "Rigo")
    def PalindromeCheck(p: String): Boolean = p == p.reverse // we apply the same logic as question 3
    val palindromes = hw5list5.filter(PalindromeCheck) // create new variable using filter method
    palindromes.foreach(println)
  }
}

// Question 6
// Sets: https://www.tutorialspoint.com/scala/scala_sets.htm
// subsets().map(_.toList).toList: https://stackoverflow.com/questions/24150494/list-of-all-combinations
// the above code seems to generate many subsets, converts each subset into a list, and stores all of those new subsets into a single list
class UniqueSubsets {
  def Combinations(inputSet: Set[Int]): List[List[Int]] = {
    inputSet.subsets().map(_.toList).toList // stackOverFlow
  }
}

object HW5Question6 {
  def main(args: Array[String]): Unit = {
    val gen = new UniqueSubsets // new instance of class UniqueSubsets and assign it to variable gen (generator)
    val subsets = gen.Combinations(Set(4, 5, 6)) // apply Combinations function
    println(subsets)
  }
}


// Question 7
// Sets: https://www.tutorialspoint.com/scala/scala_sets.htm
// sets order: https://stackoverflow.com/questions/5245713/scala-can-i-rely-on-the-order-of-items-in-a-set
// for loop: https://alvinalexander.com/scala/how-to-loop-over-scala-collection-for-loop-cookbook/
object HW5Question7 {
  def main(args: Array[String]): Unit = {
    val mySet = Set("Carolina", "Rigo", "Vicente", "Scala") // Set(4, 5, 6, 7, 8, 9)
    for (i <- mySet) {
      println(i) // it seems that Scala Sets() doesn't maintains any particular order
    }
  }
}

// Question 8
// toList: https://www.geeksforgeeks.org/scala-set-tolist-method-with-example/
object HW5Question8 {
  def main(args: Array[String]): Unit = {
    val set = Set("Carolina", "Rigo", "Vicente", "Scala") // Carolina", "Rigo", "Vicente", "Scala", 10, 3
    val list = set.toList //  tolist method
    println(s"Converting set into list: $list")
  }
}

// Question 9
// Tuple: https://www.tutorialspoint.com/scala/scala_tuples.htm
// toString method: https://www.geeksforgeeks.org/scala-int-tostring-method-with-example/
object HW5Question9 {
  def main(args: Array[String]): Unit = {
    val tuple3 = ("Rigo", 10, "Carolina")
    val TupleToString = tuple3.toString() // toString method
    println(s"Converting tuple into string: $TupleToString")
  }
}


// Question 10
// (list4.indices zip list4).toMap: https://stackoverflow.com/questions/17828431/convert-scalas-list-into-map-with-indicies-as-keys
object HW5Question10 {
  def main(args: Array[String]): Unit = {
    val list4 = List("Carolina", "Rigo", "Bella")
    val map = (list4.indices zip list4).toMap
    println(s"Converting list into map: $map")
  }
}



