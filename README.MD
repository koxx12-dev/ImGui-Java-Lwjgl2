# Java ImGui Lwjgl2 Backend
this is a lwjgl2 backend to [java imgui](https://github.com/SpaiR/imgui-java/), mainly made for usage in minecraft so no idea if it will work outside but it should </br>

code quailty is absolute trash but feel free to dig in if you want
# Usage
there is a minecraft 1.8.9 example renderer in examples folder soooo do whatever you want with it

Multiple Viewports, cursor icons and gamepad support are not implemented

#### gradle.kts

```gradle
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.koxx12-dev:ImGui-Java-Lwjgl2:1.0.0")
}
```

you will have to register scrollCallback and keyCallback yourself

# Credits
Java ImGui contributors that wrote that lwjgl3 backend

