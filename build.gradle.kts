
plugins {
    java
    id("io.papermc.paperweight.userdev") version "1.3.3"
}

group = "tutorial.project"
version = "1.0-SNAPSHOT"

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    systemProperty("file.encoding", "UTF-8")
}

tasks.withType<Javadoc>{
    options.encoding = "UTF-8"
}

tasks{
    assemble {
        dependsOn(reobfJar)
    }
}


repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://libraries.minecraft.net/")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://repo.md-5.net/content/repositories/snapshots/")
}

dependencies {
    paperDevBundle("1.19-R0.1-SNAPSHOT")
    compileOnly("io.papermc.paper", "paper-api", "1.19-R0.1-SNAPSHOT")
    compileOnly("com.comphenix.protocol", "ProtocolLib", "4.7.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))

    }
}