package com.kingspay.gs.lib

import android.content.Context
import android.content.Intent
import com.kingspay.gs.KingsPay

object KingsPay {

    enum class Environment {

        STAGING, PRODUCTION;

        fun toModel(): com.kingspay.gs.model.Environment =
            when(this) {
                STAGING -> com.kingspay.gs.model.Environment.STAGING
                PRODUCTION -> com.kingspay.gs.model.Environment.PRODUCTION
            }
    }

    object Result {

        const val RESULT_SUCCESS = com.kingspay.gs.model.Result.RESULT_SUCCESS
        const val RESULT_FAILURE = com.kingspay.gs.model.Result.RESULT_FAILURE

        const val EXTRA_RESULT = com.kingspay.gs.model.Result.EXTRA_RESULT
        const val EXTRA_PAYMENT_ID = com.kingspay.gs.model.Result.EXTRA_PAYMENT_ID
    }

    fun initialize(applicationContext: Context, environment: Environment) {
        KingsPay.initialize(applicationContext, environment.toModel())
    }

    fun paymentIntent(context: Context, clientId: String, paymentId: String): Intent =
        KingsPay.paymentIntent(context, clientId, paymentId)
}