import scala.annotation.tailrec

/**
  * Created by sunilpatil on 1/24/17.
  * EXERCISE 2: Implement isSorted, which checks whether an Array[A] is sorted according to a given comparison function.
  */
object ISSorted {

  def main(argv:Array[String]): Unit ={
    val a = Array(1,2,5,3,4,6)
    println("isSorted -> " +isSortedGeneric(a,itD))
  }

  def isSorted(a:Array[Int]):Boolean ={
    @tailrec
    def go(index:Int):Boolean ={
      if(index >=a.length-1 )
        true
      else if( a(index) > a(index+1))
        false
      else
        go(index+1)
    }
    go(0)
  }


  def gtD(f: Double, s:Double):Boolean = f >s
  def itD(f: Int, s:Int):Boolean = f >s

  def isSortedGeneric(a:Array[Int], f:(Int,Int) => Boolean):Boolean ={
    @tailrec
    def go(a:Array[Int], index:Int):Boolean ={
      if(index >=a.length-1 )
        true
      else if( a(index) > a(index+1))
        false
      else
        go(a,index+1)
    }
    go(a,0)
  }
}
