import scala.io.Source

object S092prac10 {

  def main(args: Array[String]): Unit = {

    val lines = Source.fromFile("list.csv").getLines().toList

    val header = lines.head.split(",").map(_.trim)
    val rows = lines.tail

    val threshold = 80

    println(header.mkString(", "))

    rows.foreach { line =>

      if (line.trim.nonEmpty) {

        val cols = line.split(",").map(_.trim)

        if (cols.length >= 5) {

          try {
            val marks = cols(3).toInt

            if (marks > threshold) {
              println(cols.mkString(", "))
            }

          } catch {
            case _: NumberFormatException =>
              println(s"Invalid marks: ${cols(3)}")
          }
        }
      }
    }
  }
}
