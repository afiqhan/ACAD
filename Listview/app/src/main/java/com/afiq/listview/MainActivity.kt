package com.afiq.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayAdapter : ArrayAdapter<*>

        val langList = arrayOf(
            "Java",
            "Python",
            "C++",
            "Fortran",
            "HTML",
            "CSS",
            "JavaScript",
            "Linux",
            "PHP",
            "Cobol",
            "CMake",
            "Ruby",
            "Pascal",
            "Kotlin",
            "Rust",
            "Dart",
            "Swift",
            "Arduino",
            "Firebase",
            "Node.js",


        )

        val mListView =  findViewById<ListView>(R.id.langList)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, langList)
        mListView.adapter=arrayAdapter

    }
}