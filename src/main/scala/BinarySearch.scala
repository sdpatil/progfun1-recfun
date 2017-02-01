/**
  * Created by sunilpatil on 1/24/17.
  */
object BinarySearch {
  def binarySearch(ds: Array[Double], key: Double): Int = {
    def go(ds: Array[Double], key: Double, start: Int, end: Int): Int = {
      println(s"Key -> $key, start -> $start end -> $end")
      val middle = start + ((end - start) / 2)
      if (end < start)
        -1
      else if (ds(middle) == key)
        middle
      else if (ds(middle) < key)
        go(ds, key, middle + 1, end)
      else
        go(ds, key, start, middle - 1)
    }

    go(ds, key, 0, ds.length - 1)
  }

  def binarySearch1[A](ds: Array[A], key: A, gt: (A, A) => Boolean): Int = {
    def go(start: Int, end: Int): Int = {
      println(s"Key -> $key, start -> $start end -> $end")
      val middle = start + ((end - start) / 2)
      if (end < start)
        -1
      else if (ds(middle) == key)
        middle
      else if (gt(key, ds(middle)))
        go(start, middle - 1)
      else
        go(middle + 1, end)
    }
    go(0, ds.length - 1)
  }

  def gtD(f: Double, s:Double):Boolean = f >s
  def itD(f: Int, s:Int):Boolean = f >s

  def main(args: Array[String]): Unit = {
    val a = Array(1.0, 2.0, 4.0, 5.0, 7.0, 9.0, 11.0)
    val i =  Array(1,4,7,9)
    println(binarySearch1(i, 4, itD) )
  }
}
