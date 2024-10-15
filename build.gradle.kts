// Archivo de configuración de nivel proyecto (Top-level build file)
plugins {
    alias(libs.plugins.android.application) apply false // Aplica el plugin de la aplicación Android
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin) apply false // Aplica el plugin para Google Maps
    alias(libs.plugins.google.services) apply false // Aplica el plugin para Google Services (Firebase, etc.)
}

// No es necesario declarar `repositories` aquí, ya que se gestionan en `settings.gradle.kts`
