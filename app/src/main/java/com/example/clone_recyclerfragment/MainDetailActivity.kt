package com.example.clone_recyclerfragment

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clone_recyclerfragment.databinding.ActivityMainDetailBinding

class MainDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainDetailBinding

    private val productData: ProductItem? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("productData", ProductItem::class.java)
        } else {
            intent.getParcelableExtra<ProductItem>("productData")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productData?.let { binding.ivDetailProduct.setImageResource(it.product) }
        binding.tvDetailTitle.text = productData?.title
        binding.tvDetailLoca.text = productData?.loca
        binding.tvDetailDescription.text = productData?.description
        binding.tvDetailPrice.text = productData?.price

        binding.ivBack.setOnClickListener{
            finish()
        }

    }

}