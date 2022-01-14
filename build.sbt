val ScalaTestVersion = "3.2.10"
val FlexmarkVersion  = "0.62.2"

scalafmtOnCompile := true

lazy val root = (project in file("."))
  .settings(
    organization := "io.github.sentenza.hacktoberfest",
    name         := "hacktoberfest-algorithms",
    version      := "0.12.0",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      "org.scala-lang"       % "scala-reflect" % "2.13.8",
      "org.scalatest"       %% "scalatest"     % ScalaTestVersion          % Test,
      "org.scalatestplus"   %% "mockito-3-4"   % (ScalaTestVersion + ".0") % Test,
      "org.scalactic"       %% "scalactic"     % ScalaTestVersion          % Test,
      "com.vladsch.flexmark" % "flexmark-all"  % FlexmarkVersion           % Test
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.13.2" cross CrossVersion.full),
    addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1")
  )
