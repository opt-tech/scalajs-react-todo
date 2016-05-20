
name := """scalareact"""

version := "1.0-SNAPSHOT"

lazy val server = (project in file("./server"))
  .enablePlugins(PlayScala)
  .settings(commonSettings: _*)
  .settings(serverSettings: _*)
  .dependsOn(domain)

lazy val domain = (project in file("./domain"))
  .settings(commonSettings: _*)

lazy val client = (project in file("./client"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings: _*)
  .dependsOn(domain)
  .settings(scalajsSettings: _*)


scalaVersion := "2.11.7"
lazy val serverSettings =
  Seq(
    libraryDependencies ++= Seq(
      jdbc,
      cache,
      ws,
      "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
    )
  )

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

lazy val commonSettings = Seq(
  organization := "jp.ne.opt",
  scalaVersion := "2.11.8"
)

lazy val scalajsSettings = Seq(
  persistLauncher in Compile := true,
  persistLauncher in Test := false,
  scalaJSStage in Global := FastOptStage,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.2",
    "com.github.japgolly.scalajs-react" %%% "core" % "0.10.4"
  ),
  jsDependencies ++= Seq(
    "org.webjars.bower" % "react" % "0.14.3"
      / "react-with-addons.js"
      minified "react-with-addons.min.js"
      commonJSName "React",

    "org.webjars.bower" % "react" % "0.14.3"
      / "react-dom.js"
      minified "react-dom.min.js"
      dependsOn "react-with-addons.js"
      commonJSName "ReactDOM"
  )
)
