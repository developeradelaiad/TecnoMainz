package com.example.tecnomainz.client

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tecnomainz.R
import com.example.tecnomainz.databinding.ActivityAddClientBinding
import com.google.android.material.textfield.TextInputEditText

// TODO: Continue...
// TODO: Solve infinite loop of adding data

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
        val editTextData = mutableListOf<String>()
        binding.addClientBtn.setOnClickListener {
            if (adapter != null) {
                for (i in 0 until adapter.itemCount) {
                    val viewHolder =
                        binding.addClientRv.findViewHolderForAdapterPosition(i) as? AddClientAdapter.VH
                    if (viewHolder != null) {
                        val editText =
                            viewHolder.itemView.findViewById<TextInputEditText>(R.id.client_add_et)
                            editTextData.add(editText.text.toString())
                    }
                }
            }
            validateData()
        }

    }
    private fun validateData() {
        Toast.makeText(this, "Validating Data...", Toast.LENGTH_SHORT).show()
    }

    private fun addClient() {
        TODO("Not yet implemented")
    }
}