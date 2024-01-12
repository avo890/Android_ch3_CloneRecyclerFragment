package com.example.clone_recyclerfragment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_recyclerfragment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = mutableListOf<ProductItem>()
        dataList.add(ProductItem(R.drawable.product, "170,000원", "12월 1일", "애플워치 팝니다.", "서초구 반포2동"))
        dataList.add(ProductItem(R.drawable.product2, "90,000원", "12월 3일", "중고카페의자.", "서초구 반포2동"))
        dataList.add(ProductItem(R.drawable.product3, "5,000원", "12월 7일", "귀여운 쿼카 파우치!", "서초구 반포2동"))
        dataList.add(ProductItem(R.drawable.product, "300,000원", "12월 11일", "애플워치 팝니다.", "서초구 반포2동"))
        dataList.add(ProductItem(R.drawable.product2, "80,000원", "12월 12일", "중고카페의자.", "서초구 반포2동"))
        dataList.add(ProductItem(R.drawable.product3, "3,000원", "12월 16일", "귀여운 쿼카 파우치!", "서초구 반포2동"))
        dataList.add(ProductItem(R.drawable.product, "200,000원", "12월 20일", "애플워치 팝니다.", "서초구 반포2동"))
        dataList.add(ProductItem(R.drawable.product2, "50,000원", "12월 22일", "중고카페의자.", "서초구 반포2동"))
        dataList.add(ProductItem(R.drawable.product3, "5,000원", "12월 31일", "귀여운 쿼카 파우치!", "서초구 반포2동"))

        binding.productRecycle.adapter = ProductAdapter(dataList)
        binding.productRecycle.layoutManager = LinearLayoutManager(this)

        binding.btnSearch.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        binding.navigation.btnFloating.setOnClickListener{
            val  intent = Intent(this, SelectImageActivity::class.java)
            startActivity(intent)
        }


    }
}