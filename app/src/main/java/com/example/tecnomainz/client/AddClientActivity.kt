package com.example.tecnomainz.client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tecnomainz.databinding.ActivityAddClientBinding

class AddClientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}