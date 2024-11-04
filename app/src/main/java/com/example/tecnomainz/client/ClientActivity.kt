package com.example.tecnomainz.client

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.tecnomainz.R
import com.example.tecnomainz.databinding.ActivityClientBinding

class ClientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClientBinding
    private  var viewModel = ViewModelProvider(this)[ClientViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel.getClient().observe(this){ client ->
           val userName= client.map { it.userName }
            binding.clientRecycler.adapter=ClientRecycler(this,userName)
        }

        binding.addClient.setOnClickListener {
            startActivity(Intent(this,AddClientActivity::class.java))
        }
        val shared = getSharedPreferences("login", MODE_PRIVATE)
        val userName = shared.getString("user_name", "")
        binding.topAppBarClient.menu.findItem(R.id.user_name_menu).title = userName


        binding.topAppBarClient.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    true
                }

                R.id.call_center -> {
                    true
                }

                R.id.ad_with_us -> {
                    true
                }

                R.id.sign_out -> {
                    true
                }

                else -> false
            }
        }
    }
}