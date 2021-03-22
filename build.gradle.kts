plugins {
  java
  kotlin("jvm") version "1.4.31"
  `maven-publish`
}

group = "ii887522"
version = "1.0.0"

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
      url = uri("https://gitlab.com/api/v4/projects/25306355/packages/maven")
      credentials(HttpHeaderCredentials::class) {
        name = "Private-Token"
        value = "<access-token>"
      }
      authentication {
        create("header", HttpHeaderAuthentication::class)
      }
    }
  }
}
