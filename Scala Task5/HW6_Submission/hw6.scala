
// Question 1
// largest number among integers: https://www.w3resource.com/scala-exercises/basic/scala-basic-exercise-19.php
// varargs Scala: https://www.geeksforgeeks.org/scala-varargs/
// max method: https://www.geeksforgeeks.org/scala-int-max-method-with-example/
object HW6Question1 {
  private def test(numbers: Int*): Int = { // Scala varargs -> Place * on the last argument to make it variable length.
    numbers.max // returning maximum value of the specified numbers
  }
  def main(args: Array[String]): Unit = {
    println("Result: " + test(1,2,3,4,5,6,7,8,9,10));
    println("Result: " + test(70,9,8,7,6,5,4,3,2,1));
    println("Result: " + test(1,1,1,1,1,1,1,1,1,1));
    println("Result: " + test(1,2,3,4,5,5,50,31,2,1));
  }
}

// Question 2
// Checking for prime numbers: https://stackoverflow.com/questions/36882103/checking-whether-a-number-is-prime-in-scala
// Integer user input: https://stackoverflow.com/questions/5055349/how-to-take-input-from-a-user-in-scala
object HW6Question2 { // StackOverFlow isPrime2 function
  private def CheckPrime(n: Int): Boolean = {
    if (n <= 1)
      false
    else if (n == 2)
      true
    else
      !(2 until n).exists(i => n % i == 0)
  }

  def main(args: Array[String]): Unit = { // HW3 -> user input
    println("Please enter a number: ")
    val input = scala.io.StdIn.readInt() // standard way to read integer values
    if (CheckPrime(input))
      println(s"The input integer $input is a prime number.")
    else
      println(s"The input integer $input is not a prime number.")
  }
}


// Question 3
// code example: https://www.w3resource.com/scala-exercises/basic/scala-basic-exercise-26.php
object HW6Question3 {
  private def copy(str: String, n: Int): String = {
    str * n // new string by repeating string "n" times
  }

  def main(args: Array[String]): Unit = {
    println(copy("Scala", 3)) // 3 times
    println(copy("Carolina", 2)) // twice
    println(copy("2", 7)) // 7 times
  }
}


// Question 4
// reverse method: https://www.geeksforgeeks.org/scala-stack-reverse-method-with-example/
// splitAt(): https://www.geeksforgeeks.org/scala-list-splitat-method-with-example/
object HW6Question4 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6)
    val reversedList = list.reverse // apply reverse method
    // applying splitAt to split the given list into a prefix/suffix pair at a stated position.
    val (firstList, secondList) = reversedList.splitAt(reversedList.size / 2) // total elements of reversed list/2
    println(s"Printing the original list: $list")
    println(s"Printing the reversed list: $reversedList")
    println(s"Printing first list: $firstList") // same number of elements as second list
    println(s"Printing second list: $secondList") // same number of elements as first list
  }
}

// Question 5
// code example: https://www.w3resource.com/scala-exercises/list/scala-list-exercise-7.php
// distinct: https://www.geeksforgeeks.org/scala-list-distinct-method-with-example/
object HW6Question5 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 3, 3, 5, 2, 7, 7, "Carolina", "Rigo", "Rigo")
    println(s"Printing the original list: $list")
    val result = list.distinct // apply distinct to return a new list of elements without any duplicates
    println(s"Unique elements of the list: $result")
  }
}

// Question 6
// reading csv: https://alvinalexander.com/scala/csv-file-how-to-process-open-read-parse-in-scala/
// reading csv: https://stackoverflow.com/questions/3614041/in-scala-how-to-read-a-simple-csv-file-having-a-header-in-its-first-line
// toList: https://www.geeksforgeeks.org/scala-stack-tolist-method-with-example/
// takeRight: https://www.geeksforgeeks.org/scala-list-takeright-method-with-example/
// mkString: https://www.geeksforgeeks.org/scala-list-mkstring-method-with-a-separator-with-example/
// setting up IntelliJ for Spark and Scala: https://medium.com/@bartoszgajda55/setting-up-intellij-idea-for-apache-spark-and-scala-development-ce26886552fd
// youtube tutorial IntelliJ, Spark, Scala: https://www.youtube.com/watch?v=1x-o9X8DwRI
// coalesce: https://stackoverflow.com/questions/31610971/spark-repartition-vs-coalesce
import scala.io.Source
import org.apache.spark.sql.SparkSession

object HW6Question6ABC {
  private def ReadCSV10Lines(): Unit = {
    val bufferedSource = Source.fromFile("/Users/deleonv/Desktop/Scala/HW6/HW6_CSV/Crime_Data_from_2020_to_Present.csv")
    val lines = bufferedSource.getLines().toList // toList method to perform operations
    val last10 = lines.takeRight(10) // takeRight method
    for (line <- last10) { // for loop to get the last 10 rows of the csv file
      val cols = line.split(",").map(_.trim)
      println(cols.mkString("|")) // column separation
    }
    bufferedSource.close // closing
  }

  private def SparkJSON(): Unit = {
    val spark = SparkSession.builder.appName("HW6Question6AB").master("local").getOrCreate()
    val df = spark.read.format("csv").option("header", "true").load("/Users/deleonv/Desktop/Scala/HW6/HW6_CSV/Crime_Data_from_2020_to_Present.csv")
    df.coalesce(1).write.json("/Users/deleonv/Desktop/Scala/HW6/HW6_CSV/Crime_Data_2020.json") // writing data into 1 single file
    spark.stop()
  }

  def main(args: Array[String]): Unit = {
    ReadCSV10Lines() // calling first function to print last 10 rows
    SparkJSON() // transform csv file into JSON format
  }
}

