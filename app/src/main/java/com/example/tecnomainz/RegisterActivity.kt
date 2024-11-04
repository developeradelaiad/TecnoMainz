package com.example.tecnomainz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tecnomainz.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.registerBtn.setOnClickListener {
            val send = getSharedPreferences("login", MODE_PRIVATE).edit()
            if (binding.nameEditText.text.toString().isEmpty() &&
                binding.passwordEditText.text.toString().isEmpty()&&
                binding.confirmPassEditText.text.toString().isEmpty() &&
                binding.emailEditText1.text.toString().isEmpty()
            )
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
           else if (
                binding.confirmPassEditText.text.toString() !=
                binding.passwordEditText.text.toString()
            )
                Toast.makeText(this, "confirm password not match", Toast.LENGTH_SHORT).show()
            else if (binding.passwordEditText.text.toString().length < 6)
                Toast.makeText(this, "Short Password", Toast.LENGTH_SHORT).show()
            else {
                send.putString("user_name", binding.nameEditText.text.toString())
                send.putString("pass", binding.passwordEditText.text.toString())
                send.putString("confirm_pass", binding.confirmPassEditText.text.toString())
                send.putString("email", binding.emailEditText1.text.toString())
                send.apply()
                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,LoginActivity::class.java))
            }
        }
    }
}