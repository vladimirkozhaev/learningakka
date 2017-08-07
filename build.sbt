name := """akkademy-db-java"""
version := "1.0"
scalaVersion := "2.11.6"
scalaSource in Test := baseDirectory.value / "test"
libraryDependencies ++= Seq(
"com.typesafe.akka" %% "akka-actor" % "2.3.6",
"com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
"junit" % "junit" % "4.11" % "test",
"com.novocode" % "junit-interface" % "0.10" % "test"
)
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"