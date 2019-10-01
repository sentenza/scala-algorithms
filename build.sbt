scalaVersion := "2.12.7"
name := "hacktoberfest-2018-algorithms"
organization := "hacktoberfest"
// We will use Semver for this project
version := "0.0.9"

// libraries
lazy val scalaTestVersion = "3.0.1"
lazy val ammoniteVersion = "1.3.2"


libraryDependencies += "org.scalatest"       %% "scalatest"            % scalaTestVersion  % "test"
libraryDependencies += "com.lihaoyi" % "ammonite" % ammoniteVersion % "test" cross CrossVersion.full