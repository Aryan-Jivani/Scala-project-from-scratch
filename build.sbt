ThisBuild / scalaVersion := "3.8.2"
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / githubWorkflowPublishTargetBranches := Seq()

lazy val commonSettings = Seq(
  scalacOptions -= "-Xfatal-warnings",
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.7.0",
    "org.typelevel" %% "munit-cats-effect" % "2.2.0" % Test
  )

)

lazy val shared = project
  .settings(commonSettings)

lazy val server = project
  .settings(commonSettings).dependsOn(shared)

lazy val client = project
  .settings(commonSettings).dependsOn(shared)

lazy val root = project
  .in(file("."))
  .settings(publish := {}, publish / skip := true)
  .aggregate(server, client, shared)