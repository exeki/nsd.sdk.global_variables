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
    api("org.slf4j:slf4j-api:2.0.9")
    api("ru.kazantsev.nsd.sdk:upper_level_classes:1.0.0")
}
    /*
tasks {

    register<Tar>("javadocTar") {
        archiveBaseName.set("javadoc8")
        archiveExtension.set("tar")
        archiveVersion.set("")
        include("*.*")
        compression = Compression.GZIP
        val files = File("${projectDir}/build/docs/javadoc/").listFiles()!!.map { it.path }
        files.forEach { println(it) }
        into("/")
        from(files)
        finalizedBy(named<Tar>("githubPagesGz").get())
    }

    javadoc.get().finalizedBy(named<Tar>("javadocTar").get())

    register<Tar>("testtar") {
        archiveBaseName.set("aaa")
        archiveExtension.set("tar")


        into("build/distributions") {
            from("build/docs")
            include("*.html")
        }
        destinationDirectory.set(File("build/distributions"))


        compression = Compression.GZIP
    }

}
*/