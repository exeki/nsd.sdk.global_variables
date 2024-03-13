import org.gradle.api.tasks.bundling.Tar

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
                username = System.getenv("GITHUB_USERNAME")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

repositories {
    maven {
        url = uri("https://maven.pkg.github.com/exeki/*")
        credentials {
            username = System.getenv("GITHUB_USERNAME")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
    mavenCentral()
}

dependencies {
    api ("org.slf4j:slf4j-api:2.0.9")
    api ("ru.kazantsev.nsd.sdk:upper_level_classes:1.0.0")
}

tasks {
    register<Tar>("javadocTar") {
        archiveBaseName.set("javadoc")
        archiveExtension.set("tar")
        archiveVersion.set("")
        compression = Compression.GZIP
        from(javadoc.get().destinationDir)
        println(javadoc.get().destinationDir)
        finalizedBy(named<Tar>("githubPagesGz").get())
    }
    register<Tar>("githubPagesGz") {
        archiveBaseName.set("github-pages")
        archiveExtension.set("gz")
        archiveVersion.set("")
        compression = Compression.GZIP
        from(named<Tar>("javadocTar").get().archiveFile)
    }
    javadoc.get().finalizedBy(named<Tar>("javadocTar").get())
}
