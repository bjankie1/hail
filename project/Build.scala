import sbt.Keys._
import sbt._
import org.scalastyle.sbt.ScalastylePlugin

object hail extends Build {

  val scalaMajorVersion = "2.11"
  val scalaMinorVersion = "6"
  val scalaFullVersion = scalaMajorVersion + "." + scalaMinorVersion

  val FinagleVersion = "6.24.0"
  val playVersion = "2.3.7"
  val akkaVersion = "2.3.9"
  val ScalatestVersion = "2.2.4"
  val ScalazVersion = "7.1.0"

  val aetherVersion = "1.0.2.v20150114"

  val mahout = "org.apache.mahout" % "mahout-core" % "0.7"
  val dispatch = "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
  val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.12.0"

  val sharedSettings: Seq[Def.Setting[_]] = Seq(
    organization := "com.bjankie1",
    version := "0.0.1",
    scalaVersion := scalaFullVersion,
    resolvers ++= Seq(
      "Typesafe repository snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
      "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/",
      "Sonatype repo" at "https://oss.sonatype.org/content/groups/scala-tools/",
      "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
      "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      "Sonatype staging" at "http://oss.sonatype.org/content/repositories/staging",
      "Java.net Maven2 Repository" at "http://download.java.net/maven/2/",
      "Twitter Repository" at "http://maven.twttr.com",
      "Websudos releases" at "http://maven.websudos.co.uk/ext-release-local",
      "Websudos snapshots" at "http://maven.websudos.co.uk/ext-snapshot-local"
    ),
    scalacOptions ++= Seq(
      "-language:postfixOps",
      "-language:implicitConversions",
      "-language:reflectiveCalls",
      "-language:higherKinds",
      "-language:existentials",
      "-Yinline-warnings",
      "-Xlint",
      "-deprecation",
      "-feature",
      "-unchecked"
    ),
    libraryDependencies ++= Seq(
      "com.github.nscala-time" %% "nscala-time" % "1.0.0",
      "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
      "org.scalaz" %% "scalaz-scalacheck-binding" % ScalazVersion % "test",
      "org.scalatest" %% "scalatest" % ScalatestVersion % "test, provided",
      "org.scalamock" %% "scalamock-scalatest-support" % "3.2.1" % "test"
    ),
    fork in Test := true,
    javaOptions in Test ++= Seq("-Xmx2G")
  ) ++ net.virtualvoid.sbt.graph.Plugin.graphSettings ++ ScalastylePlugin.Settings

  lazy val root = (project in file(".")).settings(
    scalaVersion := "2.11.4",
    libraryDependencies ++= Seq(mahout, dispatch, scalaCheck % Test),
    updateOptions := updateOptions.value.withCachedResolution(true)
  )

  lazy val core = Project(
    id = "hail-core",
    base = file("core"),
    settings = Defaults.coreDefaultSettings ++ sharedSettings
  ).settings(
      name := "hail-core",
      libraryDependencies ++= Seq(
        "com.typesafe.akka" %% "akka-actor" % akkaVersion,
        "joda-time" % "joda-time" % "2.3",
        "org.joda" % "joda-convert" % "1.6",
        "com.jcabi" % "jcabi-aether" % "0.10.1",
        "org.apache.maven" % "maven-core" % "3.0.5",
        "com.typesafe.play" %% "play-json" % playVersion,
        "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test"
      )
    )


  lazy val api = Project(
    id = "hail-api",
    base = file("api"),
    settings = Defaults.coreDefaultSettings ++ sharedSettings
  )
}