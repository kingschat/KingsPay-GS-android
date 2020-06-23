package com.kingspay.gs.lib

import android.content.Context
import android.content.Intent
import com.kingspay.gs.KingsPay

object KingsPay {

    fun initialize(applicationContext: Context) {
        KingsPay.initialize(applicationContext)
    }

    fun paymentIntent(context: Context, clientId: String, paymentId: String): Intent =
        KingsPay.paymentIntent(context, clientId, paymentId)

}