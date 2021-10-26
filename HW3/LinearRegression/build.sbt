name := "LinearRegression"

version := "0.1"

scalaVersion := "2.12.15"

idePackagePrefix := Some("made")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.32"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.6" % Runtime

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"

libraryDependencies  ++= Seq(
  // Last stable release
  "org.scalanlp" %% "breeze" % "1.2",

  // The visualization library is distributed separately as well.
  // It depends on LGPL code
  "org.scalanlp" %% "breeze-viz" % "1.2"
)


