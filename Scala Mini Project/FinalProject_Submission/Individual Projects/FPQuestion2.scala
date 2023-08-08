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