package com.kingspay.gs.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kingspay.gs.lib.KingsPay
import com.kingspay.gs.lib.Result

class MainActivity : AppCompatActivity() {

    private val REQUEST_TRANSACTION = 1

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivityForResult(
            KingsPay.paymentIntent(
                this,
                "client_id", //TODO
                "payment_id" //TODO
            ),
            REQUEST_TRANSACTION
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_TRANSACTION) {
            data?.also { //TODO
                val result = data.getStringExtra(Result.EXTRA_RESULT)
                val paymentId = data.getStringExtra(Result.EXTRA_PAYMENT_ID)
            }
            finish()
        } else super.onActivityResult(requestCode, resultCode, data)
    }
}
