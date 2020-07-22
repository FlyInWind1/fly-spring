plugins {
    kotlin("jvm")
    kotlin("plugin.spring")

    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "flyinwind"
version = "0.0.1"

dependencies{
    api("org.springframework.boot:spring-boot-starter-log4j2")
}