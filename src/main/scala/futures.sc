import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.io.Source

import scala.concurrent.ExecutionContext.Implicits.global

val url = "https://blockchain.info/q/getblockcount"

val future = Future{
  val height = Source.fromURL(url).getLines().mkString("\n")
  val end = System.currentTimeMillis()
  (height,end)
}

val startTime = System.currentTimeMillis()
println(s"start: ${startTime}")
val (count, endTime) = Await.result(future,1 second)

println(s"Blockchain has ${count} blocks now")
println(s"end: ${endTime}")
println(s"time: ${endTime - startTime} millis")
