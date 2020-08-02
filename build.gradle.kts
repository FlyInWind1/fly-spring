plugins {
    `maven-publish`

    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "flyinwind"
version = "0.0.1"

dependencies {
    api(kotlin("stdlib-jdk8"))
    api("org.springframework.boot:spring-boot-starter-data-redis:${V.springBoot}")
}

java{
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}