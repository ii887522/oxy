plugins {
  java
  kotlin("jvm") version "1.4.31"
  `maven-publish`
}

group = "ii887522"
version = "1.0"

java {
  withSourcesJar()
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  testImplementation("junit", "junit", "4.12")
}

publishing {
  publications {
    create<MavenPublication>("oxy") {
      from(components["java"])
    }
  }
  repositories {
    maven {
      url = uri("https://repo1.maven.org/maven2/")
    }
  }
}
