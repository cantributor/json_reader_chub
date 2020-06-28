name := "JsonReaderChub"

version := "0.1"

scalaVersion := "2.12.10"

val sparkVersion = "3.0.0-preview2"

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"

libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.6.9" % "provided"