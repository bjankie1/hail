package com.bjankie1.hail.executor

import java.io.File

import com.jcabi.aether.Aether
import org.sonatype.aether.repository.RemoteRepository
import org.sonatype.aether.util.artifact.DefaultArtifact

import scala.collection.JavaConversions._

/**
 * Loads dependency from Maven repository
 */
class DependencyLoader {

  val local = new File("/tmp/local-repository")

  val remotes = Seq(new RemoteRepository(
    "maven-central",
    "default",
    "http://repo1.maven.org/maven2/"
  ))

  def resolveJarDependency(groupId: String, artifactId: String, version: String) = {
    new Aether(remotes, local).resolve(
      new DefaultArtifact(groupId, artifactId, "", "jar", version), "runtime"
    )
  }

}
