plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "flyinwind"
version = "0.0.1"

dependencies {
    api(kotlin("stdlib-jdk8"))

    api("org.springframework.boot:spring-boot-starter-webflux:${V.springBoot}")
    api("org.springframework.boot:spring-boot-starter-log4j2:${V.springBoot}")

    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:${V.reactorKotlinExtensions}")

    implementation("io.github.microutils:kotlin-logging:${V.kotlinLogging}")
    annotationProcessor("org.projectlombok:lombok:${V.lombok}")
}