plugins {
    application
    kotlin("jvm") version "1.3.10"
}

application {
    mainClassName = "processing.Hello"
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.processing:core:3.3.7")
    testImplementation("junit:junit:4.12")
}

repositories {
    jcenter()
    mavenCentral()
}

task<Jar>("uberJar") {
    appendix = "uber"

    manifest {
        attributes(
            mutableMapOf<String, String>(
                "Base-Name" to "Processing",
                "Main-Class" to "processing.Hello"
        ))
    }

    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from(Callable {
        configurations.runtimeClasspath.filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}
