name := "akkademy-db-scala"

organization := "com.akkademy-db"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.1"



libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-agent" % "2.5.4",
  "com.typesafe.akka" %% "akka-actor" % "2.5.4",
  "com.typesafe.akka" %% "akka-remote" % "2.5.4",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.4" % "test",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test"
)