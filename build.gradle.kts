plugins {
    java
    `maven-publish`
}

group = "com.github.koxx12dev"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation("org.lwjgl.lwjgl:lwjgl:2.9.4-nightly-20150209")
    implementation("org.lwjgl.lwjgl:lwjgl_util:2.9.4-nightly-20150209")
    implementation("org.lwjgl.lwjgl:lwjgl-platform:2.9.4-nightly-20150209-natives-windows")

    implementation("io.github.spair:imgui-java-binding:1.86.10")
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.koxx12dev"
            artifactId = "imgui-java-lwjgl2"
            version = "1.0.0"

            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
    }
}