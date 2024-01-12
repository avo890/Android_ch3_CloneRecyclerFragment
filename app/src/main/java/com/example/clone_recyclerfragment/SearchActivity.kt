package com.example.clone_recyclerfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SearchActivity : AppCompatActivity() {
    val btn_back : Button by lazy {
        findViewById(R.id.btn_back)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        btn_back.setOnClickListener{
            finish()
        }
    }
}