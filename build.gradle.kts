plugins {
    id("java")
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "org.example"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // JPA для работы с базой данных
    implementation("mysql:mysql-connector-java") // Драйвер для MySQL
    testImplementation("org.springframework.boot:spring-boot-starter-test") // Тестирование

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "org.example.Main"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.test {
    useJUnitPlatform()
}