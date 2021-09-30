package com.example.quize_with_mvc.src.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quize_with_mvc.R
import com.example.quize_with_mvc.config.BaseActivity
import com.example.quize_with_mvc.databinding.ActivityMainBinding
import com.example.quize_with_mvc.src.solving.SolvingActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.btnSolving.setOnClickListener {
            var intent = Intent(applicationContext,SolvingActivity::class.java)
            if(!binding.edtName.text.toString().isEmpty())
                intent.putExtra("name",binding.edtName.text.toString())
            startActivity(intent)
        }
    }
}