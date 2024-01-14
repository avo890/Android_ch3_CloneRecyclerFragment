package com.example.clone_recyclerfragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_recyclerfragment.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    private lateinit var adapter: ProductAdapter
    private lateinit var dataList: MutableList<ProductItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataList = mutableListOf<ProductItem>()
        dataList.add(ProductItem(R.drawable.product, "170,000원", "12월 1일", "애플워치 팝니다.-a24rkf!2", "군자동","상품설명입니다.-a24rkf!2"))
        dataList.add(ProductItem(R.drawable.product2, "90,000원", "12월 3일", "중고카페의자.-38ghakj@", "군자동","상품설명입니다.-38ghakj@"))
        dataList.add(ProductItem(R.drawable.product3, "5,000원", "12월 7일", "귀여운 쿼카 파우치!-kajnkg9321dfga", "군자동","상품설명입니다.-kajnkg9321dfga"))
        dataList.add(ProductItem(R.drawable.product, "300,000원", "12월 11일", "애플워치 팝니다.-128dkgj1y", "군자동","상품설명입니다.-128dkgj1y"))
        dataList.add(ProductItem(R.drawable.product2, "80,000원", "12월 12일", "중고카페의자.-gi4280th1j", "군자동","상품설명입니다.-gi4280th1j"))
        dataList.add(ProductItem(R.drawable.product3, "3,000원", "12월 16일", "귀여운 쿼카 파우치!-agj8r12#2", "군자동","상품설명입니다.-agj8r12#2"))
        dataList.add(ProductItem(R.drawable.product, "200,000원", "12월 20일", "애플워치 팝니다.-39gjsdkj2", "군자동","상품설명입니다.-39gjsdkj2"))
        dataList.add(ProductItem(R.drawable.product2, "50,000원", "12월 22일", "중고카페의자.-02409tf13jdfagj", "군자동","상품설명입니다.-02409tf13jdfagj"))
        dataList.add(ProductItem(R.drawable.product3, "5,000원", "12월 31일", "귀여운 쿼카 파우치!-39sdjgakl", "군자동","상품설명입니다.-39sdjgakl"))

        adapter = ProductAdapter(dataList)
        binding.productRecycle.adapter = adapter
        binding.productRecycle.layoutManager = LinearLayoutManager(context)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFloating.setOnClickListener{
            val  intent = Intent(context, SelectImageActivity::class.java)
            startActivity(intent)
        }

        adapter.productClick = object : ProductAdapter.ProductClick {
            override fun onClick(view: View, position: Int) {

                val intent = Intent(context,MainDetailActivity::class.java)
                intent.putExtra("productData",dataList[position])
                startActivity(intent)
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}