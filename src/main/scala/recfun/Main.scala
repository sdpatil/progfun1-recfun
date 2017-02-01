package recfun

import scala.collection.mutable

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balanceNonRec(chars: List[Char]): Boolean = {
    val stack = new mutable.Stack[Char]();
    for (c <- 0 until chars.length) {
      if (chars(c) == '(') {
        stack.push('(')
      } else if (chars(c) == ')') {
        if (stack.isEmpty)
          return false;
        else
          stack.pop()
      }
    }
    if (!stack.isEmpty)
      false

    true
  }
  def balance(chars: List[Char]): Boolean = {
    balanceRec(chars,0,0)
  }

  def balanceRec(chars: List[Char], charCount:Int, parCount:Int):Boolean ={
    if(parCount < 0)
      return false
    if(charCount == chars.length){
      if(parCount != 0)
        return false
      else
        return true
    }
    val newParCount =
    if(chars(charCount) == '(')
      parCount+1
    else if(chars(charCount) == ')')
      parCount -1
    else
      parCount

    balanceRec(chars,charCount+1, newParCount)
  }

  def countChange(a: Int, d: List[Int]): Int = {
    //println(s" a -> $a d -> $d ")
    if(a == 0)
      1
    else if(a < 0)
      0
    else if (d.length ==0 )
      0
    else
      countChange(a, d.slice(1,d.length)) + countChange(a-d(0), d)
  }

}
