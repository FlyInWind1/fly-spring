plugins {
    kotlin("jvm")

    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "flyinwind"
version = "0.0.1"

dependencies {
    api("org.springframework.boot:spring-boot-starter-log4j2")
    api("org.springframework.boot:spring-boot")

    api("org.springframework:spring-web")

    api ("com.fasterxml.jackson.core:jackson-core")

    annotationProcessor("org.projectlombok:lombok:${V.lombok}")
}