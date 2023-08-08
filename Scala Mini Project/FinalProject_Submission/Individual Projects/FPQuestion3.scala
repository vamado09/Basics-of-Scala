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