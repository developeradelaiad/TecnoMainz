package com.example.tecnomainz.client

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnomainz.R

class AddClientAdapter(val a: Activity, val addFields: List<Int>): RecyclerView.Adapter<AddClientAdapter.VH>() {
    class VH(view: View): RecyclerView.ViewHolder(view) {
        val label: TextView = view.findViewById(R.id.client_add_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = a.layoutInflater.inflate(R.layout.list_client_add, parent, false)
        return VH(view)
    }

    override fun getItemCount() = addFields.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.label.setText(addFields[position])
    }
}