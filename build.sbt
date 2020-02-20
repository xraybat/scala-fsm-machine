name := "fsm.machine"
organization := "au.com.carringbushsw"
organizationName := "carringbush software"
version := "1.0-SNAPSHOT"

scalaVersion := "2.13.1"
scalacOptions ++= Seq("-unchecked", "-deprecation")

logBuffered in Test := false
//resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.lihaoyi" %% "castor" % "0.1.1",
  "com.lihaoyi" %% "pprint" % "0.5.6",
  "com.lihaoyi" %% "utest" % "0.7.3" % "test"
  //"org.scalactic" %% "scalactic" % "3.0.8",
  //"org.scalatest" %% "scalatest" % "3.0.8" % "test"
)

testFrameworks += new TestFramework("utest.runner.Framework")