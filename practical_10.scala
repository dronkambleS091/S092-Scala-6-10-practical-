import scala.io.Source

object MissingValueHandling {

  def main(args: Array[String]): Unit = {

    val fileData = Source.fromFile("list.csv").getLines().toList

    val header = fileData.head.split(",")
    val records = fileData.tail.map(_.split(",", -1))

    // Get index of Age column
    val ageIndex = header.indexOf("Age")

    if (ageIndex < 0) {
      println("Age column not found!")
      return
    }

    // Collect all valid age values
    val ageValues = records.flatMap { row =>
      val age = row(ageIndex).trim

      if (age.nonEmpty) {
        try {
          Some(age.toDouble)
        } catch {
          case _: NumberFormatException => None
        }
      } else {
        None
      }
    }

    // Calculate average age
    val averageAge = ageValues.sum / ageValues.length

    println(f"Average Age = $averageAge%.2f\n")

    println("Dataset after filling missing Age values:\n")

    // Display header
    println(header.mkString(","))

    // Replace empty Age with average
    records.foreach { row =>
      if (row(ageIndex).trim.isEmpty) {
        row(ageIndex) = f"$averageAge%.2f"
      }

      println(row.mkString(","))
    }
  }
}