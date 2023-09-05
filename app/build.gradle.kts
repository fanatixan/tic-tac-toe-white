plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("io.fejer.tictactoe.App")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
