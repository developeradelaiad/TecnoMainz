package com.example.tecnomainz.client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tecnomainz.R
import com.example.tecnomainz.databinding.ActivityAddClientBinding

class AddClientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val addFields = mutableListOf(
            R.string.invoice_code,
            R.string.client_name,
            R.string.total_amount,
            R.string.remaining_amount,
            R.string.delegate_name,
            R.string.insect_type,
            R.string.phone_num,
            R.string.other_num,
            R.string.details,
            R.string.follow_ups,
            R.string.date,
            R.string.time
            )
        binding.addClientRv.adapter = AddClientAdapter(this, addFields)
    }
}