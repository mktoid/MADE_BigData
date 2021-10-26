package made

import breeze.linalg.DenseVector

import org.scalatest._
import flatspec._
import matchers._

class LinearRegressionTest extends AnyFlatSpec with should.Matchers {

  "Predict length" should "match number of rows in test dataset" in {
    val xTrain = DenseVector[Double](1.66666667, -3.88888889, -1.66666667, -0.55555556,  3.88888889)
    val yTrain = DenseVector[Double](13.78720563, -4.27348569,  5.34625839,  2.27038372, 17.65965573)
    var reg = new LinearRegression
    reg.fit(xTrain.toDenseMatrix.t, yTrain)
    val pred = reg.predict(xTrain.toDenseMatrix.t)
    pred.length should be (xTrain.length)

  }
}