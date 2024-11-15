package com.example.tecnomainz.client

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnomainz.R
import com.example.tecnomainz.databinding.ActivityAddClientBinding
import com.google.android.material.textfield.TextInputEditText

class AddClientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddClientBinding
    private lateinit var adapter: AddClientAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val addFields = mutableListOf(
            AddClientItem(R.string.invoice_code, 0),
            AddClientItem(R.string.client_name, 1),
            AddClientItem(R.string.total_amount, 2),
            AddClientItem(R.string.remaining_amount, 3),
            AddClientItem(R.string.delegate_name, 4),
            AddClientItem(R.string.insect_type, 5),
            AddClientItem(R.string.phone_num, 6),
            AddClientItem(R.string.other_num, 7),
            AddClientItem(R.string.details, 8),
            AddClientItem(R.string.follow_ups, 9),
            AddClientItem(R.string.date, 10),
            AddClientItem(R.string.time, 11)
        )
        adapter = AddClientAdapter(this, addFields)
        binding.addClientRv.adapter = adapter

        // Checking User Data
        binding.addClientBtn.setOnClickListener {
            if (areAllFieldsFilled()) {
                addClient()
            } else {
                Toast.makeText(this, "Please Fill All Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun areAllFieldsFilled(): Boolean {
        for (i in 0 until adapter.itemCount) {
            val viewHolder = binding.addClientRv.findViewHolderForAdapterPosition(i) as? AddClientAdapter.VH
            viewHolder?.let {
                val text = it.itemView.findViewById<TextInputEditText>(R.id.client_add_et).text.toString().trim()
                if (text.isEmpty()) {
                    return false
                }
            }
        }
        return true
    }

    private fun addClient() {
        // TODO: Add actual client
        Toast.makeText(this, "Adding Client...", Toast.LENGTH_SHORT).show()
    }
}
