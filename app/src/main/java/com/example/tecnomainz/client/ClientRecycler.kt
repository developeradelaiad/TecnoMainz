package com.example.tecnomainz.client

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnomainz.databinding.ListClientBinding

class ClientRecycler(private val a: Activity, private val list: List<String>):RecyclerView.Adapter<ClientRecycler.ClientViewHolder>() {
    class ClientViewHolder (val binding: ListClientBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val v = ListClientBinding.inflate(a.layoutInflater,parent,false)
        return ClientViewHolder(v)
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        holder.binding.clientNameTx.text=list[position]
    }
}