# KingsPay-GS-android
KingsPay for Goods &amp; Services for Android
[![Apache 2.0 License](https://img.shields.io/badge/license-Apache%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0.html)

Written in Kotlin 1.3.72

Supported Android API version 21 and higher

# Installation Guide

## Setup your Merchant account
Create your Merchant account following the section 1 of the [Developer's Guide](https://kingspay-gs-api.kingsch.at/pdfs/kingspay_goods_and_services_merchant_integration.pdf)

## Gradle implementation
1. Add the following repositories to your project-level build.gradle:
```gradle
repositories {
    google()
    jcenter()
    mavenCentral()
    maven { url "https://jitpack.io" }
    maven {
            url "https://auto-close.appspot.com/maven/893"
            credentials {
                username 'un-important'
                password '893:HFGYwGK4Uej9VJDq9FsLCS92'
            }
        }
}
```

2. Add the dependency to your module-level build.gradle:
```gradle
dependencies {
    implementation 'com.kingspay.gs:gs:v0.1.7'
}
``` 

## App implementation
1. Initialize the library in Application class and choose environment (staging for testing or production):
```kotlin
KingsPay.initialize(applicationContext, KingsPay.Environment.PRODUCTION)
```

2. Initialize the payment using KingsPay G&S API as described in section 3 of the [Developer's Guide](https://kingspay-gs-api.kingsch.at/pdfs/kingspay_goods_and_services_merchant_integration.pdf)

API Documentations:
[Production API](https://kingspay-gs-api.kingsch.at/docs/index.html#/Payment/Web_PaymentController_initialize)
[Staging API](https://kpay-gs-api.appunite.net/docs/index.html#/Payment/Web_PaymentController_initialize)

3. Get your `Client ID` of your Merchant account and `Payment ID` from payment initialization response and start your payment Intent:
```kotlin
startAcivityForResult(KingsPay.paymentIntent(context, clientId, paymentId), REQUEST_TRANSACTION)
``` 
    
4. In Activity you can handle callbacks:
```kotlin
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_TRANSACTION) {
            data?.also {
                val result = data.getStringExtra(KingsPay.Result.EXTRA_RESULT)
                val paymentId = data.getStringExtra(KingsPay.Result.EXTRA_PAYMENT_ID)
            }
            finish()
        } else super.onActivityResult(requestCode, resultCode, data)
    }
```
There are two possible outcomes you can get in `String` extra `KingsPay.Result.EXTRA_RESULT`:
- `KingsPay.Result.SUCCESS`
- `KingsPay.Result.FAILURE`

## Sample
For more information about implementation check our sample app
