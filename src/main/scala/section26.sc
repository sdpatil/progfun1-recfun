import scala.annotation.tailrec

def binarySearch(ds:Array[Double] , key:Double):Int ={

  @tailrec
  def go(ds:Array[Double], key:Double, start: Int, end: Int):Int ={
    val middle = (end - start)/2
    if(end > start)
      return -1
    else if(ds(middle) == key)
      middle
    else if (ds(middle) < key)
      go(ds,key,middle+1,end)
    else
      go(ds, key, start, middle-1)
  }
  go(ds,key,0, ds.length -1)
}

def sumInts(a:Int, b:Int):Int ={
  if(a>b)
    0
  else
    a + sumInts(a+1,b)
}

def isSorted(a:Array[Int]):Boolean ={
  def go(a:Array[Int], index:Int):Boolean ={
    if(index >a.length )
      true
    else if( a(index) < a(index+1))
      false
    else
      go(a,index+1)

  }
  go(a,0)
}

