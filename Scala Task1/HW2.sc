
// Question 1
// private x (mutable) can only be access/modified within class Items due to private variable
// private helps prevent outsiders from accessing the fields directly

class Items {
  private var x: String = _ // _ default value defined as null, 0, False

  def get_item_from_user(input: String): Unit = {
    this.x = input // "this" key is used to fetch the variable of the class
  }

  def print_String(): Unit = {
    println(this.x.toUpperCase) // toUpperCase method
  }
}
val x = new Items() // referring to class Items
x.get_item_from_user("I had to read a lot for this Homework!")
x.print_String()



// Question 2
// we have to modify the attributes -> var
class Student(var student_name: String, var marks: Int)
val name = new Student("Vincent De Leon", 95) //referring to class Student

// String interpolation
println(s"Student Name and Marks: ${name.student_name}, ${name.marks}")

name.student_name = "Carolina Licona"
name.marks = 99
// String Interpolation
println(s"Modified Student Name and Marks: ${name.student_name}, ${name.marks}")




// Question 3
class Operations {
  def addInt(a: Int, b:Int) : Int = { a + b }
  def subInt(a: Int, b:Int) : Int = { a - b }
  def mltpInt(a: Int, b:Int) : Int = { a * b }
}
// Main method to execute the above 3 functions
// This Main runs in scala class not worksheet
object Main {

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



// Question 4
// This is based on Geeks for Geeks tutorial
// Geeks for Geeks use "123" to initialize values, we are using "_"
// _ -> will have default value fo 0 as stated above in Question 1

class Private {
  private var x: Int = _
  def display(): Unit = {
    x = 5
    println(x)
  }
}

class Protected {
  protected var y: Int = _
  def display(): Unit = {
    y = 5
    println(y)
  }
}

// Using protected modifier with New1
class New1 extends Protected {
  def display1(): Unit = {
    y = 9
    println(y)
  }
}

class Public {
  var z: Int = _
}

var e = new Private()
e.display()
var e1 = new New1()
e1.display()
e1.display1()
var e2 = new Public()
e2.z = 222
println(e2.z)



// Question 5
// Differences between these 2 classes are within PDF File
// Case class
case class Case(x: String, age: Int) {
  def result1(): Unit = {
    println(s"Hey, my name is $x and I am $age years old.")
  }
}
val name = Case("Carolina", 27)
name.result1()

// Regular Class
class Regular(val x: String, var age: Int) {
  def result1(): Unit = {
    println(s"Hey, my name is $x and I am $age years old.")
  }
}
val name = new Regular("Carolina", 27)
name.result1()



// Question 6
import scala.io.Source
import java.io._

// Simple - reading text file
// This to initially view the original text file
val source = Source.fromFile("Users/deleonv/Desktop/Student_Class.txt")
for (line <- source.getLines) {
  println(line)
}
source.close()

// Adding new row. Run this just 1 time to avoid overwriting.
val writer = new PrintWriter(new FileOutputStream(new File("Users/deleonv/Desktop/Student_Class.txt"), true))
writer.println("M physics")
writer.close()

// If you want to read it again, comment the above code (Adding new row)
// and the code from Part A (reading txt file), then run this:
//val source = Source.fromFile("Users/deleonv/Desktop/Student_Class.txt")
//for (line <- source.getLines) {
//println(line)
//}
//source.close()
// You will be able to see the new row within the Text File.

class Class_name {
  def max_class(txt_file: String): (String, Int) = {
    val source = Source.fromFile(txt_file)

    val class_list = source.getLines().drop(1).map(line => line.split("\\s+")).filter(_.length > 1).map(_(1))
    val student_class = class_list.toList

    // Find the class with the most students
    val student_count = student_class.groupBy(identity).view.mapValues(_.size).maxBy(_._2)

    source.close()

    student_count
  }
}
val class_name = new Class_name()
val results_c = class_name.max_class("Users/deleonv/Desktop/Student_Class.txt")
println(s"The class with most students is (class, # students): $results_c")


class Total_Student {
  def max_students(txt_file: String): Int = {
    val source = Source.fromFile(txt_file)

    val class_list = source.getLines().drop(1).map(line => line.split("\\s+")).filter(_.length > 1).map(_(1))
    val student_class = class_list.toList

    // Find the total number of students in all courses
    val students = student_class.size

    source.close()
    students
  }
}
val total_students = new Total_Student()
val results_d = total_students.max_students("Users/deleonv/Desktop/Student_Class.txt")
println(s"The total number of students (counting all courses): $results_d")


// Resources:

// Question 1:
// var vs val: https://docs.scala-lang.org/overviews/scala-book/two-types-variables.html#:~:text=The%20difference%20between%20val%20and%20var%20is%20that%20val%20makes,as%20values%20rather%20than%20variables.
// _ symbol: https://stackoverflow.com/questions/10040886/what-does-it-mean-assign-to-a-field-in-scala
// this keyword: https://www.includehelp.com/scala/this-keyword-in-scala.aspx
// upper case: https://www.geeksforgeeks.org/scala-string-touppercase-method-with-example/
// new keyword: https://stackoverflow.com/questions/9727637/new-keyword-in-scala

// Question 2:
// adding attributes: https://leportella.com/scala-iii/
// similar question(Python): https://www.w3resource.com/python-exercises/class-exercises/python-class-basic-1-exercise-9.php
// string interpolation: https://docs.scala-lang.org/overviews/core/string-interpolation.html

// Question 3:
// addition, main method(), class: https://www.educative.io/answers/how-to-create-a-class-in-scala
// addInt: https://www.tutorialspoint.com/scala/scala_functions.htm
// class and objects: https://www.geeksforgeeks.org/class-and-object-in-scala/

// Question 4:
// modifiers: https://www.geeksforgeeks.org/access-modifiers-in-scala/

// Question 5:
// https://www.includehelp.com/scala/what-is-the-difference-between-scala-s-case-class-and-class.aspx#:~:text=Points%20of%20difference%20between%20Case%20Class%20and%20Class%20in%20Scala&text=The%20case%20class%20is%20defined,(syntax%20for%20defining%20class).
// https://docs.scala-lang.org/tour/case-classes.html

// Question 6:
// java.io_: https://stackoverflow.com/questions/40526231/how-to-write-the-import-scala-io-source-import-java-io-libraries-in-sbt
// txt file: https://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples/
// txt file: https://www.oreilly.com/library/view/scala-cookbook/9781449340292/ch12s02.html
// adding row: https://stackoverflow.com/questions/34613697/add-a-new-line-of-text-to-an-existing-file-in-scala
// def getLines, drop, map, filer, toList, size, : https://www.scala-lang.org/api/2.13.5/scala/io/Source.html
// \\s: https://stackoverflow.com/questions/41953388/java-split-and-trim-in-one-shot
// map lines: https://stackoverflow.com/questions/26943460/how-to-create-map-for-each-line-based-on-the-column-using-scala
// groupBy(identity): https://stackoverflow.com/questions/19165977/how-does-scalas-groupby-identity-work
// https://alvinalexander.com/scala/scala-split-string-example/