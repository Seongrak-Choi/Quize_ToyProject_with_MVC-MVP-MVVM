package com.example.quize_with_mvvm.src.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.quize_with_mvvm.R
import com.example.quize_with_mvvm.databinding.ActivityMainBinding
import com.example.quize_with_mvvm.src.feature.solving.SolvingActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //binding.mainActivity=this


        mainActivityViewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.apply {

            //버튼 클릭
            btnSolving.setOnClickListener {
                println("main-click:${edtName.text}")
                mainActivityViewModel.setUserName(edtName.text.toString())//viewModel에 저장
                println("main-setUserName-after: ${mainActivityViewModel.getUser()?.name}")
                var intent = Intent(this@MainActivity, SolvingActivity::class.java)
                intent.putExtra("User",mainActivityViewModel.getUser())
                startActivity(intent)
            }
        }
    }
}
