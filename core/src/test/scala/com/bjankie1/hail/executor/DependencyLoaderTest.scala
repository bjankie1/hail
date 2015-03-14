package com.bjankie1.hail.executor

import org.scalatest.{Matchers, FlatSpec}

class DependencyLoaderTest extends FlatSpec with Matchers {

  it should "resolve a jar from maven central" in {
    val loader = new DependencyLoader
    val artifacts = loader.resolveJarDependency("org.joda", "joda-convert", "1.6")
    artifacts should not be empty
  }

}
