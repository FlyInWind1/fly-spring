plugins {
    `maven-publish`

    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "flyinwind"
version = "0.0.1"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive:${V.springBoot}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${V.jackson}")
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}