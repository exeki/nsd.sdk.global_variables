plugins {
    id("java-library")
    id("maven-publish")
}

group = "ru.kazantsev.nsd.sdk"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withJavadocJar()
    withSourcesJar()
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/exeki/nsd.sdk.global_variables")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
//            artifact(tasks.named("jar"))
//            artifact(tasks.named("javadocJar"))
//            artifact(tasks.named("sourcesJar"))
            from(components["java"])
//            pom {
//                groupId = project.group.toString()
//                artifactId = project.name
//                version = project.version.toString()
//            }
        }
    }
    repositories {
        mavenLocal()
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    api ("org.slf4j:slf4j-api:2.0.9")
    api ("ru.kazantsev.nsd.sdk:upper_level_classes:1.0.0")
}

