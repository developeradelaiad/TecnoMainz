package com.example.tecnomainz.recycler

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnomainz.data.DataBase
import com.example.tecnomainz.databinding.ListBaseBinding

class BaseRecycler(private val a:Activity, private val list: List<DataBase>):RecyclerView.Adapter<BaseRecycler.BaseViewHolder>() {
    class BaseViewHolder (val binding: ListBaseBinding):RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
val v=ListBaseBinding.inflate(a.layoutInflater,parent,false)
    return BaseViewHolder(v)
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding.logoList.setImageResource(list[position].img)
        holder.binding.countList.text = list[position].count
        holder.binding.nameList.text=list[position].name
    }
}