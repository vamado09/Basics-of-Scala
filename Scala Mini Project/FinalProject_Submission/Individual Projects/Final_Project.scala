
// Question 1 (Synthetic Methods)
// Equals() method: https://www.geeksforgeeks.org/scala-string-equals-method-with-example/
// hashCode() method: https://www.geeksforgeeks.org/scala-string-hashcode-method-with-example/
// toString() method: https://www.geeksforgeeks.org/scala-int-tostring-method-with-example/
// copy() method: https://www.educative.io/answers/what-is-copy-in-scala

object FPQuestion1 {
  private case class Person(name: String, age: Int, salary: Int)

  def main(args: Array[String]): Unit = {
    val person1 = Person("Carolina", 28, 5000) // creating instance person 1
    val person2 = Person("Vicente", 27, 5000) // creating instance person 2

    // Using the Equals() method
    val EqualsMethod = person1.equals(person2) // lets compare them
    println(s"Are person1 and person2 equal? $EqualsMethod")

    // hashCode() method
    val HashCode1 = person1.hashCode() // integer
    val HashCode2 = person2.hashCode() // integer
    println(s"hashCode for person1 is: $HashCode1")
    println(s"hashCode for person2 is: $HashCode2")

    // toString method
    val toString1 = person1.toString // no need to use () -> toString() string representation
    val toString2 = person2.toString // no need to use () -> toString() string representation
    println(s"The string representation of person1 is: $toString1")
    println(s"The string representation of person2 is: $toString2")

    // Copy() method
    val person2Modified = person2.copy(age = 30, salary = 6000) // new instance along with new values
    println(s"Applying the copy() method to person2: $person2Modified") // should be Vicente, 30, 6000
  }
}

// Question 2 (Arrays, Lists, Vectors)
// checking objects: https://stackoverflow.com/questions/44454287/scala-how-to-check-whether-a-object-is-instance-of-array
// checking objects: https://stackoverflow.com/questions/11290169/how-does-isinstanceof-work
// stack to list: https://www.geeksforgeeks.org/scala-stack-tolist-method-with-example/
// arrays: https://www.geeksforgeeks.org/scala-arrays/
// vectors: https://www.geeksforgeeks.org/scala-vector/
// toList: https://www.geeksforgeeks.org/scala-map-tolist-method-with-example/
// toVector: https://www.geeksforgeeks.org/program-to-convert-java-list-to-a-vector-in-scala/
// mkString: https://www.geeksforgeeks.org/scala-list-mkstring-method-with-a-separator-with-example/

object FPQuestion2 {
  def main(args: Array[String]): Unit = {
    val array1 = Array(3.0, 5.0, 5.5, 7.5, 9.0) // Creating array with elements
    if (array1.isInstanceOf[Array[_]]) // checking if it's an array
      println("array1 is an Array")
    println("The array elements are: ")
    for (elem <- array1) {
      println(elem)
    }
    println("\n")

    val list1 = array1.toList // Converting array to list using the toList method
    if (list1.isInstanceOf[List[_]]) // checking if it's a list
      println("list1 is a List")
    print("Check the list: ")
    println(list1)
    println("\n")

    val vector1 = list1.toVector // Converting list to vector using the toVector method
    if (vector1.isInstanceOf[Vector[_]]) // checking if it's a vector
      println("vector1 is a Vector")
    print("Check the vector: ")
    println(vector1)
    println("\n")

    // Basic operations -> Array (calculate the sum of all array elements)
    // total: https://www.tutorialspoint.com/scala/scala_arrays.htm
    var total = 0.0
    for (elem <- array1) {
      total += elem
    }
    println("The total number of elements in the Array is: " + total)

    // Basic operations -> Lists (maximum element of list)
    // max: https://www.geeksforgeeks.org/scala-list-max-method-with-example/
    val MaxList = list1.max
    println("The largest of all the elements in the list is: " + MaxList)

    // Basic operations -> Vector (creating a new vector by merging two vectors together)
    // vector: https://www.geeksforgeeks.org/scala-vector/
    val vector2 = Vector(50.0, 100.0)
    val NewVector = vector1 ++ vector2
    println("Merging Vector 1 and Vector 2:")
    println(NewVector.mkString(" "))
  }
}


// Question 3
// Modifiers: https://www.geeksforgeeks.org/access-modifiers-in-scala/
// new keyword: https://stackoverflow.com/questions/9727637/new-keyword-in
class abc { // public modifier
  var x: Int = 222 // variable x -> public member
}

class xyz {
  private var y: Int = 579 // variable y -> private member (accessed via class xyz)
  protected var x: Int = 999 // variable x -> protected member (accessed via class xyz and subclass new1)

  // class xyz contains functions/methods display() and modifier()
  def display(): Unit = {
    y = 5
    println(y)
  }

  def modifier(e: abc): Unit = {
    e.x = x
    println(e.x)
  }
}

// Class that extends to xyz
class new1 extends xyz {
  // contains function/method display2()
  def display2(e: abc): Unit = {
    x = 10
    println(x)
    e.x = x
    println(e.x)
  }
}

object FPQuestion3 {
  def main(args: Array[String]): Unit = {
    val NewAbc = new abc()
    val NewXyz = new xyz()
    val New1 = new new1()
    NewXyz.display()
    NewXyz.modifier(NewAbc)
    New1.display2(NewAbc)
  }
}


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




