plugins {
    kotlin("jvm")

    id("io.spring.dependency-management")
}

group = "flyinwind"
version = "0.0.1"

dependencies {
    api(kotlin("stdlib-jdk8"))

    api("org.springframework.boot:spring-boot:${V.springBoot}")
    api("org.springframework.boot:spring-boot-starter-log4j2:${V.springBoot}")
    api("org.springframework:spring-web:${V.spring}")

    api("com.fasterxml.jackson.core:jackson-core:${V.jackson}")
    api("io.projectreactor:reactor-core:${V.reactor}")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:${V.reactorKotlinExtensions}")

    annotationProcessor("org.projectlombok:lombok:${V.lombok}")
}