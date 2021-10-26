package made

import breeze.linalg.{DenseMatrix, DenseVector, inv}

class LinearRegression {

  var w: DenseVector[Double] = DenseVector()

  def fit(X: DenseMatrix[Double], y: DenseVector[Double]): LinearRegression = {
    val n = X.rows
    val X_train = DenseMatrix.horzcat(X, DenseMatrix.ones[Double](n,1))
    w = inv(X_train.t * X_train) * X_train.t * y
    this
  }

  def predict(X: DenseMatrix[Double]): DenseVector[Double] = {
    val n = X.rows
    val X_train = DenseMatrix.horzcat(X, DenseMatrix.ones[Double](n,1))
    X_train * w
  }

}
