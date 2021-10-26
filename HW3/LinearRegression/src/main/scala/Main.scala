package made

import breeze.io.CSVReader
import breeze.linalg.{Axis, DenseMatrix, DenseVector, csvwrite, sum}
import com.typesafe.scalalogging.LazyLogging

import java.io.{File, FileReader}

object Main extends LazyLogging{

  def main(args: Array[String]): Unit = {

    class Dataset(val X: DenseMatrix[Double], val y: DenseVector[Double]) {
    }

    def ReadCsv(filePath: String): Dataset =  {
      var data = CSVReader.read(new FileReader(new File(filePath)), ',', '"', '\\', 1)
      data = data.takeWhile(line => line.nonEmpty && line.head.nonEmpty)
      val df = DenseMatrix.tabulate(data.length, data.head.length)((i, j) => data(i)(j).toDouble)
      val y = df(::, 2)
      val X = df.delete(2, Axis._1)
      val ds = new Dataset(X, y)
      ds
    }

    def meanSquaredError(yPred: DenseVector[Double], y: DenseVector[Double]): Double = {
      sum((yPred - y) * (yPred - y)) / y.length
    }

    // prepared dataset (numerical features only) based on https://www.kaggle.com/mirichoi0218/insurance
    val train = ReadCsv("/home/oleg/Desktop/MADE_BigData/HW3/LinearRegression/src/main/scala/data/train.csv")
    val test = ReadCsv("/home/oleg/Desktop/MADE_BigData/HW3/LinearRegression/src/main/scala/data/test.csv")

    var reg = new LinearRegression
    reg.fit(train.X, train.y)
    val pred = reg.predict(test.X)
    csvwrite(new File("/home/oleg/Desktop/MADE_BigData/HW3/LinearRegression/src/main/scala/data/submission.csv"), pred.toDenseMatrix.t)

    logger.info("Validation MSE: " +  meanSquaredError(pred, test.y))

  }
}