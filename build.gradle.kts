plugins {
  java
  kotlin("jvm") version "1.4.31"
  `maven-publish`
  id("net.saliman.cobertura") version "4.0.0"
}

group = "ii887522"
version = "2.0.0"

cobertura {
  coverageSourceDirs = project.sourceSets.main.get().allSource.srcDirs
}

java {
  withSourcesJar()
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  testImplementation("junit", "junit", "4.13")
  testRuntimeOnly("org.slf4j", "slf4j-api", "1.7.10")
}

publishing {
  publications {
    create<MavenPublication>("oxy") {
      from(components["java"])
    }
  }
  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/ii887522/oxy")
      credentials {
        username = System.getenv("GITHUB_USERNAME")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
}
