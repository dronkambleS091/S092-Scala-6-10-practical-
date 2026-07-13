import breeze.linalg._
import breeze.stats._

object MatrixSlice {
  def main(args: Array[String]): Unit = {

    val matrix = DenseMatrix(
      (1, 2, 3),
      (4, 5, 6),
      (7, 8, 9)
    )

    println("Original Matrix:")
    println(matrix)

    // Slice first 2 rows and first 2 columns
    val subMatrix = matrix(0 to 1, 0 to 1)

    println("\nSub Matrix:")
    println(subMatrix)

    // Row sums
    println("\nRow Sums:")
    for(i <- 0 until subMatrix.rows){
      println(sum(subMatrix(i, ::)))
    }

    // Column sums
    println("\nColumn Sums:")
    for(j <- 0 until subMatrix.cols){
      println(sum(subMatrix(::, j)))
    }

  }
}