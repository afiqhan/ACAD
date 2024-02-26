package com.example.acad_task1_clipboard

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //map widget to variable
        val editText = findViewById<EditText>(R.id.wETCopy)
        val btnCopy = findViewById<Button>(R.id.wBtnCopy)
        val btnPaste = findViewById<Button>(R.id.wBtnPaste)
        val txtView = findViewById<TextView>(R.id.wTxtView)

        val clipMan = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        var clipData : ClipData

        btnCopy.setOnClickListener {
            if (editText.text.isNullOrBlank())
                toastMsg(msg = "Please type something")
            else{
                clipData = ClipData.newPlainText("text",editText.text.toString())
                clipMan.setPrimaryClip(clipData)
                toastMsg("data stored to clipboard!")
            }
        }

        btnPaste.setOnClickListener {
            val clipData = clipMan.primaryClip
            val item = clipData?.getItemAt(0)
            txtView.text = item?.text.toString()
        }
    }

    fun toastMsg(msg:String){
        Toast.makeText(applicationContext,msg,Toast.LENGTH_LONG).show()
    }
}