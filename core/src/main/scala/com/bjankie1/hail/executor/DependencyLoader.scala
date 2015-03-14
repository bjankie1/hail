package com.bjankie1.hail.executor

/**
 * Loads dependency from Maven repository
 */
class DependencyLoader {

  def resolveJarDependency(groupId: String, artifactId: String, version: String) = {
    // new Aether(remotes, local).resolve(
    // new DefaultArtifact(groupId, artifactId, "", "jar", version), "runtime"
    Nil
  }

}
