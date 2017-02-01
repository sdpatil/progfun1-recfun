import scala.annotation.tailrec

def gcd(a:Int, b:Int):Int ={
  if(b == 0)
    a
  else
    gcd(b, a%b)
}

gcd(12,16)


def factorial(n:Int):Int ={
  def loop(acc:Int, n:Int) :Int =
    if(n == 0)
      acc
    else
      loop(acc*n, n-1)

  loop(1,n)
}

factorial(5)