package com.example.mytest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mytest.databinding.FragmentRVBinding

class RVFragment : Fragment() {

    private lateinit var binding: FragmentRVBinding
    private lateinit var brandsAdapter: BrandsAdapter
    private val brandsList = ArrayList<Brands>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRVBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoad()
        initRV()
    }

    private fun initRV() {
        brandsAdapter = BrandsAdapter(brandsList){
            findNavController().navigate(R.id.action_RVFragment_to_detailFragment)
        }
        binding.rvBrands.adapter = brandsAdapter

    }

    private fun onLoad() {
        brandsList.add(Brands(image1, "Lego"))
        brandsList.add(Brands(image2, "Amazon"))
        brandsList.add(Brands(image3, "KFC"))
        brandsList.add(Brands(image4, "Nike"))
        brandsList.add(Brands(image5, "Google"))


    }

}
const val image1 = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/LEGO_logo.svg/2048px-LEGO_logo.svg.png"
const val image2 = "https://i.pinimg.com/originals/01/ca/da/01cada77a0a7d326d85b7969fe26a728.jpg"
const val image3 = "https://upload.wikimedia.org/wikipedia/sco/thumb/b/bf/KFC_logo.svg/1200px-KFC_logo.svg.png"
const val image4 = "https://static.vecteezy.com/system/resources/thumbnails/010/994/232/small_2x/nike-logo-black-clothes-design-icon-abstract-football-illustration-with-white-background-free-vector.jpg"
const val image5 = "https://img.freepik.com/premium-photo/google-logo-white-background_1315971-1888.jpg"