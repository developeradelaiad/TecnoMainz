package com.example.tecnomainz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tecnomainz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.login.setOnClickListener {
            val receive = getSharedPreferences("login", MODE_PRIVATE)
            val name = receive.getString("user_name", "")
            val pass = receive.getString("pass", "")
            if (binding.userNameInput.text.toString() == name &&
                binding.passInput.text.toString() == pass){
                Toast.makeText(this, "Correct Email & Password", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, BaseActivity::class.java))}
            else {
            Toast.makeText(this, "User Name or Password Not Correct", Toast.LENGTH_SHORT).show()
        }
        }
        binding.registerTxt.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}