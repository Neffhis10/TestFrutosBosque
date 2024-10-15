pluginManagement {
    repositories {
        google() // Aquí debes tener el repositorio de Google
        mavenCentral() // Repositorio de Maven Central
        gradlePluginPortal() // Portal de plugins de Gradle
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // Asegura que solo use los repositorios a nivel de proyecto
    repositories {
        google() // Repositorio de Google
        mavenCentral() // Repositorio Maven Central
    }
}

rootProject.name = "frutossecoschillan2"
include(":app")
