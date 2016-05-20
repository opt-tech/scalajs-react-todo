name := """scalareact"""

version := "1.0-SNAPSHOT"

lazy val server = (project in file("./server"))
  .enablePlugins(PlayScala)
  .settings(commonSettings: _*)

lazy val domain = (project in file("./domain"))
  .settings(commonSettings: _*)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

lazy val commonSettings = Seq(
  organization := "jp.ne.opt",
  scalaVersion := "2.11.8"
)

