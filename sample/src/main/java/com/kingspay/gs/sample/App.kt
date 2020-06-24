package com.kingspay.gs.sample

import android.app.Application
import com.kingspay.gs.KingsPay

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        KingsPay.initialize(this, KingsPay.Environment.PRODUCTION)
    }
}