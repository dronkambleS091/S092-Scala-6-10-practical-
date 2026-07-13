import breeze.linalg._

object MatrixOperations {

  def main(args: Array[String]): Unit = {

    val A = DenseMatrix(
      (12.0, 18.0),
      (24.0, 30.0)
    )

    val B = DenseMatrix(
      (3.0, 6.0),
      (8.0, 10.0)
    )

    println("Matrix A")
    println(A)

    println("\nMatrix B")
    println(B)

    // Addition
    println("\nAddition")
    println(A + B)

    // Subtraction
    println("\nSubtraction")
    println(A - B)

    // Element-wise Multiplication
    val multiplication = DenseMatrix.zeros[Double](A.rows, A.cols)

    for (i <- 0 until A.rows) {
      for (j <- 0 until A.cols) {
        multiplication(i, j) = A(i, j) * B(i, j)
      }
    }

    println("\nElement-wise Multiplication")
    println(multiplication)

    // Element-wise Division
    val division = DenseMatrix.zeros[Double](A.rows, A.cols)

    for (i <- 0 until A.rows) {
      for (j <- 0 until A.cols) {
        division(i, j) = A(i, j) / B(i, j)
      }
    }

    println("\nElement-wise Division")
    println(division)

  }
}