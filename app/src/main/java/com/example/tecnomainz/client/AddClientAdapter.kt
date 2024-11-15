package com.example.tecnomainz.client

import android.app.Activity
import android.text.Editable
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnomainz.R
import com.google.android.material.textfield.TextInputEditText

// TODO: Edit the list item
class AddClientAdapter(private val a: Activity, private val addFields: List<AddClientItem>): RecyclerView.Adapter<AddClientAdapter.VH>() {

    val editTextDataList = mutableListOf<String>()

    class VH(view: View): RecyclerView.ViewHolder(view) {
        val label: TextView = view.findViewById(R.id.client_add_tv)
        val input: TextInputEditText = view.findViewById(R.id.client_add_et)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = a.layoutInflater.inflate(R.layout.list_client_add, parent, false)
        return VH(view)
    }

    override fun getItemCount() = addFields.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.label.setText(addFields[position].name)
        val editText = holder.itemView.findViewById<EditText>(R.id.client_add_et)
        editTextDataList.add(editText.text.toString())
        editText.addTextChangedListener { editable ->
            editTextDataList[position] = editable.toString()
        }
    }
}