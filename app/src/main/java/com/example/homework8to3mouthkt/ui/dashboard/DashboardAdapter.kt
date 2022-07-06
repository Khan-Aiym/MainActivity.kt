package com.example.homework8to3mouthkt.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework8to3mouthkt.R

class DashboardAdapter(homeModels: ArrayList<DashboardModel>) :
    RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {
    private val homeModels: ArrayList<DashboardModel>

    var onClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return DashboardViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_dashboard, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.onBind(homeModels[position])
        holder.itemView.setOnClickListener {
            onClickListener?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return homeModels.size
    }

    fun getItem(pos: Int): DashboardModel {
        return homeModels[pos]
    }

    inner class DashboardViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val tvStatus: TextView
        private val tvName: TextView
        private val integer: ImageView
        fun onBind(homeViewModel: DashboardModel) {
            integer.setImageResource(homeViewModel.ivInteger)
            tvStatus.text = homeViewModel.tvStatus
            tvName.text = homeViewModel.tvName
        }

        init {
            integer = itemView.findViewById(R.id.imageView)
            tvStatus = itemView.findViewById(R.id.textView2)
            tvName = itemView.findViewById(R.id.textView)
        }
    }

    init {
        this.homeModels = homeModels
    }
}