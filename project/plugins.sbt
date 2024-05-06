// Makes our code tidy
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")

// Revolver allows us to use re-start and work a lot faster!
addSbtPlugin("io.spray" % "sbt-revolver" % "0.10.0")

// Enables test coverage analysis
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.0.12")

// Checks Maven and Ivy repositories for dependency updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.6.4")
