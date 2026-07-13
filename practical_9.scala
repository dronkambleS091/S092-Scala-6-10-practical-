import scala.io.Source

object MissingValue{

  def main(args: Array[String]): Unit = {

    val file = Source.fromFile("lives.csv")

    val rows = file.getLines().toList

    val header = rows.head.split(",")
    val records = rows.tail.map(_.split(",", -1))

    val ageColumn = header.indexWhere(_ == "Age")

    if (ageColumn < 0) {
      println("Age column not found!")
      file.close()
      return
    }

    // Collect all valid ages
    var ageList = List[Double]()

    for (record <- records) {
      if (record(ageColumn).trim != "") {
        try {
          ageList = ageList :+ record(ageColumn).toDouble
        } catch {
          case _: NumberFormatException =>
        }
      }
    }

    val averageAge = ageList.sum / ageList.size

    println(f"Average Age = $averageAge%.2f")
    println("\nUpdated Dataset:\n")

    println(header.mkString(","))

    for (record <- records) {

      if (record(ageColumn).trim == "") {
        record(ageColumn) = f"$averageAge%.2f"
      }

      println(record.mkString(","))
    }

    file.close()
  }
}
