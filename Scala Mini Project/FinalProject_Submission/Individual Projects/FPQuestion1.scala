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
