ThisBuild / scalaVersion := "2.13.1"
ThisBuild / name := "hacktoberfest-algorithms"
ThisBuild / organization := "hacktoberfest"
// We will use Semver for this project
ThisBuild / version := "0.12.0"

// libraries
val scalaTestVersion = "3.0.8"
val ammoniteVersion  = "1.7.4"

libraryDependencies += "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
libraryDependencies += "com.lihaoyi"   % "ammonite"   % ammoniteVersion  % "test" cross CrossVersion.full

// Fancy SBT functions
watchTriggeredMessage := Watch.clearScreenOnTrigger
shellPrompt := (_ => fancyPrompt(name.value))

def cyan(projectName: String): String =
  scala.Console.CYAN + projectName + scala.Console.RESET

def fancyPrompt(projectName: String): String =
  s"""|
      |[info] Welcome to the ${cyan(projectName)} project!
      |sbt> """.stripMargin

//   Projects
lazy val `fp-library` =
  project
    .in(file("./1-fp-library"))
    .settings(
      shellPrompt := (_ => fancyPrompt(name.value))
    )

lazy val `application-library` =
  project
    .in(file("./2-application-library"))
    .settings(shellPrompt := (_ => fancyPrompt(name.value)))
    .dependsOn(`fp-library`)

// This project should contain just the main method
lazy val `end-of-the-world` =
  project
    .in(file("./3-end-of-the-world"))
    .settings(shellPrompt := (_ => fancyPrompt(name.value)))
    .dependsOn(`application-library`)

// Command Aliases
addCommandAlias("ll", "projects")

addCommandAlias("cd", "project")

addCommandAlias("lib", "project fp-library")

addCommandAlias("app", "project application-library")

addCommandAlias("eow", "project end-of-the-world")
