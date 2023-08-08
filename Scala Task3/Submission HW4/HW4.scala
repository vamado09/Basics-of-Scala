
// Question 1

// Scala Program A
// filter method: https://www.geeksforgeeks.org/scala-list-filter-method-with-example/
// yield method: https://alvinalexander.com/scala/scala-for-loop-yield-examples-yield-tutorial/
// equals method: https://www.geeksforgeeks.org/scala-string-equals-method-with-example/
object HW4Question1ProgramA {
  private val list = List(5, 10, 15, 20, 25, 30) // chosen list
  private def AllOperations(): Unit = {
    val filteredList = list.filter(_ < 25) // return numbers that are less than 25
    println(s"Filtered list (numbers < 25): $filteredList")

    val multipliedList = for (e <- filteredList) yield e * 3 // for loop that multiplies each element by 3
    println(s"New list containing numbers from filtered list multiplied by 3: $multipliedList")

    val equalList = multipliedList.equals(List(15, 30, 45, 60)) // list comparison using equals() method
    println(s"EqualList == NewList? $equalList")
  }

  def main(args: Array[String]): Unit = {
    println(s"Chosen list for program A: $list")
    AllOperations()
  }
}

// Scala Program B
// protected scope: https://www.geeksforgeeks.org/controlling-method-scope-in-scala/
// hashCode method: https://www.geeksforgeeks.org/scala-string-hashcode-method-with-example/
// toString method: https://www.geeksforgeeks.org/scala-int-tostring-method-with-example/
// class/copy method: https://www.educative.io/answers/what-is-copy-in-scala
// this keyword: http://testingpool.com/scala-this-keyword/
// this keyword: https://www.geeksforgeeks.org/scala-this-keyword/
// overriding method: https://www.geeksforgeeks.org/method-overriding-in-scala/
// overriding: https://stackoverflow.com/questions/16110370/scala-what-is-the-purpose-of-override
class Extra(val name: String, val office: String, val role: String) {

  protected var member: Extra = this // protected member. Initialization of member property (using current instance of CLASS EXTRA)

  private def threeMethods(): (Int, String, Extra) = {
    val hashCodeResult = this.member.hashCode() // accessing hasCode method of member property (hashCode number of member)
    val toStringResult = this.member.toString //accessing toString of member property (string version of member)
    val copyResult = this.member.copy(name = "De Leon") // accessing the copy method of member property. Switching Licona for De Leon
    (hashCodeResult, toStringResult, copyResult)
  }

  def copy(name: String = this.name, office: String = this.office, role: String = this.role): Extra = { // values based on the current instance's properties
    new Extra(name, office, role)
  }

  override def toString: String = s"Extra($name, $office, $role)" // displaying objects within class Extra as strings (string version of those objects)

  def results(): (Int, String, Extra) = this.threeMethods() // getting results
}

object HW4Question1ProgramB {
  def main(args: Array[String]): Unit = {
    val extra = new Extra("Licona", "Miami", "Student")

    println("Results from applied methods:")
    val (hashCode, toString, copy) = extra.results()
    println(s"hashCode results: $hashCode")
    println(s"toString results: $toString")
    println(s"copy results: $copy")
  }
}


// Question 2
// list/Reversing lists: https://www.w3resource.com/scala-exercises/list/scala-list-exercise-16.php
object HW4Question2 {
  def main(args: Array[String]): Unit = {
    val first_list = List(1,2,3,4)
    val second_list = List(4,3,2,1)
    val result = first_list.reverse == second_list
    println(first_list)
    println(second_list)
    println(s"Are these two lists equal (containing same elements)? $result")
  }
}


// Question 3
// GroupBy(): https://www.baeldung.com/scala/strings-frequency-map
// .groupBy(identity).mapValues(_.length) (IntelliJ -> says its depreciated)
// intelliJ advices to use -> groupBy(identity).view.mapValues(_.length).toMap
// toSet method: https://www.geeksforgeeks.org/scala-map-toset-method-with-example/
// size method: https://www.geeksforgeeks.org/scala-map-size-method-with-example/
object HW4Question3 {
  def main(args: Array[String]): Unit = {
    val StringList = "abacbc" // try "aaabb" or "abacbc"
    val CharCount = StringList.groupBy(identity).view.mapValues(_.length).toMap // new version from source GroupBy() method
    val GoodString = CharCount.values.toSet.size == 1 // values is used to retrieve values of map. This line checks if al CharCount map are the same
    println(s"The string list $StringList is a good string: $GoodString")
  }
}

// Count method: https://www.baeldung.com/scala/string-char-count
// Count method: https://stackoverflow.com/questions/29895751/how-to-count-characters-of-a-string
// Count: https://stackoverflow.com/questions/68084819/count-adjacent-repeating-characters-in-a-string-using-scala
// tail method: https://www.geeksforgeeks.org/scala-stack-tail-method-with-example/
// forall method: https://www.geeksforgeeks.org/scala-list-forall-method-with-example/
object HW4Question3variation {
  def main(args: Array[String]): Unit = {
    val StringList = "aaabb"
    val Chars = StringList.distinct
    val CharCount = StringList.count(_ == Chars.head)
    val GoodString = Chars.tail.forall(ch => StringList.count(_ == ch) == CharCount)
    println(s"The string list $StringList is a good string: $GoodString")
  }
}


// Question 4
// Comparing two Scala Arrays of strings: https://stackoverflow.com/questions/5393243/how-do-i-compare-two-arrays-in-scala
// mkString: https://www.oreilly.com/library/view/scala-cookbook/9781449340292/ch10s30.html
// mkString using separator: https://www.includehelp.com/scala/how-to-print-an-array.aspx
object HW4Question4 {
  def main(args: Array[String]): Unit = {
    val word1 = Array("abc", "d", "defg") // Array("a", "cb"), Array("ab", "c"), Array("abc", "d", "defg"), Array("abcddefg")
    val word2 = Array("abcddefg")
    println(s"Comparing word1: ${word1.mkString(" , ")}" )
    println("vs")
    println(s"word2: ${word2.mkString(" , ")}")
    println(word1.mkString == word2.mkString) // printing collection of elements using the mkString
  }
}

