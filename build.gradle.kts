import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "com.dsm"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	//DB
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	runtimeOnly("mysql:mysql-connector-java")

	//Web
	implementation("org.springframework.boot:spring-boot-starter-web")

	//Security
	implementation("org.springframework.boot:spring-boot-starter-security")

	//Kotlin
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	//Test
	implementation("org.springframework.boot:spring-boot-starter-test:2.7.16")
	testImplementation("org.springframework.security:spring-security-test")

	//Validation
	implementation("org.springframework.boot:spring-boot-starter-validation")

	//jwt
	implementation("io.jsonwebtoken:jjwt:0.9.1")

	//json
	implementation("org.json:json:20200518")

	//lombok
	compileOnly ("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")



}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
