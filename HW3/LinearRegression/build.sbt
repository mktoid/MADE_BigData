name := "LinearRegression"

version := "0.1"

scalaVersion := "2.12.15"

idePackagePrefix := Some("made")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"

libraryDependencies  ++= Seq(
  // Last stable release
  "org.scalanlp" %% "breeze" % "1.2",

  // The visualization library is distributed separately as well.
  // It depends on LGPL code
  "org.scalanlp" %% "breeze-viz" % "1.2"
)


