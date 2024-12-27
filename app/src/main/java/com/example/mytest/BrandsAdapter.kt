package com.example.mytest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytest.databinding.ItemBrandsBinding


class BrandsAdapter(val brandsList: ArrayList<Brands>, val listener: (position: Int) -> Unit) : RecyclerView.Adapter<BrandsAdapter.BrandsViewHolder>() {


    inner class BrandsViewHolder(val binding: ItemBrandsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(brands: Brands){
            binding.apply {
                tvName.text = brands.name
                Glide.with(itemView).load(brands.image).into(ivBrands)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BrandsAdapter.BrandsViewHolder {
        val binding = BrandsViewHolder(ItemBrandsBinding.inflate(LayoutInflater.from(parent.context),parent, false))
        return binding
    }

    override fun onBindViewHolder(holder: BrandsAdapter.BrandsViewHolder, position: Int) {
        holder.bind(brandsList[position])
        holder.itemView.setOnClickListener {
            listener(position)

        }

    }

    override fun getItemCount(): Int {
        return brandsList.size

    }

}