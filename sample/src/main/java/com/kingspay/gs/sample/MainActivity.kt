package com.kingspay.gs.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kingspay.gs.KingsPay

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
            data?.also {
                val paymentId = data.getStringExtra(KingsPay.Result.EXTRA_PAYMENT_ID)
                val result = data.getStringExtra(KingsPay.Result.EXTRA_RESULT)
                if(result == KingsPay.Result.RESULT_SUCCESS) {
                    //TODO
                }
            }
            finish()
        } else super.onActivityResult(requestCode, resultCode, data)
    }
}
