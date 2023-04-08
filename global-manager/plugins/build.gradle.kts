plugins { `kotlin-dsl` }

group = "com.lnsantos.brainup.plugins"
version = "0.0.1"

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
}