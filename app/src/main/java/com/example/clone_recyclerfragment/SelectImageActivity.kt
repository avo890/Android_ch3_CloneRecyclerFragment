package com.example.clone_recyclerfragment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SelectImageActivity : AppCompatActivity() {

    private lateinit var imageLauncher : ActivityResultLauncher<Intent>

    private val btn_img_upload : Button by lazy {
        findViewById(R.id.btn_img_upload)
    }

    val btn_back : Button by lazy {
        findViewById(R.id.btn_back)
    }

    val iv_upload : ImageView by lazy {
        findViewById(R.id.iv_upload)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_image)

        btn_back.setOnClickListener{
            finish()
        }

        imageLauncher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
            if(result.resultCode == Activity.RESULT_OK){
              val img_URI = result.data?.data
                iv_upload.setImageURI(img_URI)
            }

        }

        btn_img_upload.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setType("image/*")
            imageLauncher.launch(intent)
        }
    }
}