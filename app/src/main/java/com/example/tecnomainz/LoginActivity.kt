package com.example.tecnomainz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tecnomainz.base_activity.BaseActivity
import com.example.tecnomainz.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.registerBtn.setOnClickListener {
            val login = getSharedPreferences("login", MODE_PRIVATE)
            val name = login.getString("user_name", "")
            val pss = login.getString("pass", "")
            val email = login.getString("email", "")
            if (binding.emailEditText.text.toString().isEmpty() &&
                binding.passwordEditText.text.toString().isEmpty()
            )
                Toast.makeText(this, "Fill all Fields", Toast.LENGTH_SHORT).show()
            else if (binding.emailEditText.text.toString() != name ||
                binding.emailEditText.text.toString() != email &&
                binding.passwordEditText.text.toString() != pss
            )
                Toast.makeText(
                    this,
                    "incorrect  Username or Email and Password",
                    Toast.LENGTH_SHORT
                ).show()
            else if (binding.emailEditText.text.toString() == name ||
                binding.emailEditText.text.toString() == email &&
                binding.passwordEditText.text.toString() == pss
            ) {
                Toast.makeText(this, "Welcome To TecnoMainz", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, BaseActivity::class.java))
            }
        }
        binding.gh.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}