resolvers ++= Seq(
    "Sonatype snapshots"                                 at "http://oss.sonatype.org/content/repositories/snapshots/",
    "jgit-repo"                                          at "http://download.eclipse.org/jgit/maven",
    "Twitter Repo"                                       at "http://maven.twttr.com/",
    "sonatype-releases"                                  at "https://oss.sonatype.org/content/repositories/releases/"
)

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.0.1")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.0.0.BETA1")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.5.0")
