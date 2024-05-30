plugins {
    id("com.android.application")
}

android {
    namespace = "com.vishal.chartr"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vishal.chartr"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "v.9.3.2002"//my birthday😂

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}
buildscript {
    dependencies {
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
}



dependencies {



    implementation ("com.google.maps.android:android-maps-utils:3.8.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-maps:18.2.0")

    implementation("androidx.camera:camera-view:1.3.3")
    implementation("com.google.android.gms:play-services-location:21.2.0")


    // Glide v4 uses this new annotation processor -- see https://bumptech.github.io/glide/doc/generatedapi.html
    // for using gif
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation("androidx.navigation:navigation-fragment:2.6.0")
    implementation("androidx.navigation:navigation-ui:2.6.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.22")



    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")





    //for QR scanner
    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")





}