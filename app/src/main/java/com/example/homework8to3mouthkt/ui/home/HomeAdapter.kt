package com.example.homework8to3mouthkt.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework8to3mouthkt.OnClickItem
import com.example.homework8to3mouthkt.R

class HomeAdapter(homeModels: ArrayList<HomeModel>, onClickItem: OnClickItem) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private val homeModels: ArrayList<HomeModel>
    private val onClickItem: OnClickItem
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(homeModels[position])
        holder.itemView.setOnClickListener {
            onClickItem.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return homeModels.size
    }

    fun getItem(pos: Int): HomeModel {
        return homeModels[pos]
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvLocation: TextView
        private val tvNameLocation: TextView
        fun onBind(homeViewModel: HomeModel) {
            tvLocation.text = homeViewModel.tvLocation
            tvNameLocation.text = homeViewModel.tvNameLocation
        }

        init {
            tvLocation = itemView.findViewById(R.id.location)
            tvNameLocation = itemView.findViewById(R.id.name_location)
        }
    }

    init {
        this.homeModels = homeModels
        this.onClickItem = onClickItem
    }
}