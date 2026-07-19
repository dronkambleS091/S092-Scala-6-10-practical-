import com.github.tototoshi.csv._
import java.io.File

object FilterRowThreshold {

  def main(args: Array[String]): Unit = {

    val reader = CSVReader.open(new File("list.csv"))
    val data = reader.allWithHeaders()
    reader.close()

    val threshold = 80

    // Filter rows where Marks > 80
    val filteredRows = data.filter { row =>
      row.get("Marks").exists(value =>
        value.toIntOption.exists(_ > threshold)
      )
    }

    println(s"\nTotal Rows with Marks > $threshold: ${filteredRows.length}\n")

    // Print header
    println("RollNo, Name, Age, Marks, Attendance")

    // Print filtered rows
    filteredRows.foreach { row =>
      println(
        s"${row("RollNo")}, ${row("Name")}, ${row("Age")}, ${row("Marks")}, ${row("Attendance")}"
      )
    }
  }
}
