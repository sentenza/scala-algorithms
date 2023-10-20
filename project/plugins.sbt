// Easily manage scalac settings across scala versions with this
addSbtPlugin("org.typelevel" % "sbt-tpolecat" % "0.5.0")

// Makes our code tidy
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")

// Revolver allows us to use re-start and work a lot faster!
addSbtPlugin("io.spray" % "sbt-revolver" % "0.10.0")

// To keep our dependencies up to date
addSbtPlugin("net.vonbuchholtz" % "sbt-dependency-check" % "5.1.0")

// Enables test coverage analysis
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.0.9")

// Checks Maven and Ivy repositories for dependency updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.6.4")
