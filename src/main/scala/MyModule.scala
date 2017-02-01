import scala.annotation.tailrec

/**
  * Created by sunilpatil on 1/21/17.
  */
object MyModule {

  def abs(n: Int):Int =
    if( n < 0) -n  else n


  private def formatAbs(x: Int) ={
    val msg = "The absolute value of %d is %d"
    msg.format(x,abs(x))
  }


  def factorialOld(n:Int):Int ={
    var result = 1
    for(i <- 1 to n)
      result = result*i
    result
  }

  def facotiralWhile(n:Int):Int ={
    var result =1
    var newN = n
    while(newN >= 0){
      result = result*newN
      newN = newN-1
    }

    result
  }

  def factorial(n:Int):Int ={

    @tailrec
    def go(n:Int, acc:Int):Int ={
      if(n <= 0) acc else go(n-1, n*acc)
    }
    go(n,1)
  }

  def fibWhile(n :Int): Int ={
    var first = 1
    var second = 1

    println(first)
    println(second)
    var counter = 1
    var number = 0
    while(counter < n ){
      number = first + second
      println(number)
      first = second
      second = number
      counter = counter+1
    }
    number
  }

  def fib(n:Int):Int ={
    @tailrec
    def go(first: Int, second: Int, counter:Int):Int ={
      println(s"first -> $first, second -> $second, counter -> $counter")
      if(counter == n) first + second
      else go(second,first + second,counter+1)
    }

    go(0,1,1)
  }

  def formatResult(name:String, n:Int, f: Int => Int) ={
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  val lessThan = new Function2[Int,Int, Boolean] {
    override def apply(v1: Int, v2: Int): Boolean = {
      v1 < v2
    }
  }

  val sum = new Function3[Int,Int,Int,Int] {
    override def apply(v1: Int, v2: Int, v3: Int): Int = v1+v2+v3
  }




}

case class Contact(name: String, age: Int)