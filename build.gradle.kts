plugins {
    kotlin("jvm") version "2.0.0"
}

group = "br.com.agibank"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.appium:java-client:9.3.0")
    compileOnly("com.browserstack:browserstack-java-sdk:1.20.2")
}

tasks.test {
    useJUnitPlatform()
}

var browserstackSDKArtifact: ResolvedArtifact? = null
configurations.compileClasspath.configure {
    browserstackSDKArtifact = resolvedConfiguration.resolvedArtifacts.find {
        it.name == "browserstack-java-sdk"
    }
}

tasks.register<Test>("bstackTest") {
    description = "Run tests on BrowserStack App Automate Cloud."
    group = "Verification"
    outputs.upToDateWhen { false }
    useJUnitPlatform()
    jvmArgs("-javaagent:${browserstackSDKArtifact?.file}")
}

val test by testing.suites.existing(JvmTestSuite::class)
tasks.named<Test>("bstackTest") {
    testClassesDirs = files(test.map { it.sources.output.classesDirs })
    classpath = files(test.map { it.sources.runtimeClasspath })
}
