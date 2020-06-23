# KingsPay-GS-android
KingsPay for Goods &amp; Services for Android
[![Apache 2.0 License](https://img.shields.io/badge/license-Apache%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0.html) [![Release](https://jitpack.io/v/kingschat/KingsPay-GS-android.svg)](https://jitpack.io/#kingschat/KingsPay-GS-android)

Written in Kotlin 1.3.72

Supported Android API version 21 and higher

# Installation Guide

## Setup your merchant account
```
//TODO
```

## Gradle implementation
1. Add the JitPack repository to your root build.gradle:
```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```

2. Add the dependency to your sub build.gradle:
```gradle
dependencies {
    compile 'com.github.kingschat:KingsPay-GS-android:{latest-version}'
}
``` 

## App implementation
1. Initialize the library in Application class:
```kotlin
KingsPay.initialize(applicationContext)
```

2. Initialize the payment using KingsPay API:
```
//TODO
```

3. Get your merchant `Client ID` and `Payment ID` from previous step and create your payment Intent:
```kotlin
startAcivityForResult(KingsPay.paymentIntent(context, clientId, paymentId), REQUEST_TRANSACTION)
``` 
    
4. In Activity handle callbacks:
```kotlin
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_TRANSACTION) {
            data?.also {
                val result = data.getStringExtra(Result.EXTRA_RESULT)
                val paymentId = data.getStringExtra(Result.EXTRA_PAYMENT_ID)
            }
            finish()
        } else super.onActivityResult(requestCode, resultCode, data)
    }
```

## Sample
For more information about implementation check our sample app
