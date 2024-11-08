package com.example.tecnomainz.base_activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tecnomainz.R
import com.example.tecnomainz.client.ClientActivity
import com.example.tecnomainz.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val list = mutableListOf<DataBase>()
        list.add(DataBase(R.drawable.client, "18", "Client"))
        list.add(DataBase(R.drawable.book, "18", "Booking"))
        list.add(DataBase(R.drawable.warranty, "18", "Warranty"))
        list.add(DataBase(R.drawable.follow, "18", "Follow up"))
        list.add(DataBase(R.drawable.inquiry, "18", "inquiry"))
        list.add(DataBase(R.drawable.price, "18", "Show prices"))
        list.add(DataBase(R.drawable.delegate, "18", "The delegate"))
        list.add(DataBase(R.drawable.customer, "18", "Customer problems"))
        list.add(DataBase(R.drawable.comments, "18", "comments"))
        binding.recycler.adapter = BaseAdapter(this, list)


        val shared = getSharedPreferences("login", MODE_PRIVATE)
        val userName = shared.getString("user_name", "")
        binding.topAppBar.menu.findItem(R.id.user_name_menu).title = userName


        binding.topAppBar.setOnMenuItemClickListener {
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