package com.example.maskedit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.vicmikhailau.maskededittext.MaskedEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt1 = findViewById<MaskedEditText>(R.id.edtCreditCard)
        val edt2 = findViewById<MaskedEditText>(R.id.edtPhoneNum)

        val myBtn = findViewById<Button>(R.id.btn)

        myBtn.setOnClickListener {
        val text1 = edt1.text.toString()+" "+edt2.text.toString()
            Toast.makeText(applicationContext,text1,Toast.LENGTH_LONG).show()
        }

    }
}