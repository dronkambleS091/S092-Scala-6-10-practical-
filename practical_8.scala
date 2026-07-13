import scala.io.Source

object CSVStatistics {

  def main(args: Array[String]): Unit = {

    val lines = Source.fromFile("heart.csv").getLines().toList

    if (lines.isEmpty) {
      println("CSV file is empty.")
      return
    }

    val header = lines.head.split(",")

    val data = lines.tail.map(_.split(","))

    println("Basic Statistics\n")

    for (col <- 0 until header.length) {

      val values = data.flatMap { row =>
        try {
          Some(row(col).trim.toDouble)
        } catch {
          case _: Exception => None
        }
      }

      if (values.nonEmpty) {

        val mean = values.sum / values.length
        val min = values.min
        val max = values.max

        println("Column : " + header(col))
        println("Count  : " + values.length)
        println("Mean   : " + mean)
        println("Min    : " + min)
        println("Max    : " + max)
        println("---------------------------")
      }
    }
  }
}