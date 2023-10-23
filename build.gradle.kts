plugins {
    id("java-library")
    id("maven-publish")
}

group = "ru.ekazantsev"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
            }
        }
    }
    repositories {
        mavenLocal()
        mavenLocal()
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation ("org.slf4j:slf4j-api:2.0.9")
    implementation ("ru.ekazantsev.nsd_upper_level_classes:1.0.0")
}

