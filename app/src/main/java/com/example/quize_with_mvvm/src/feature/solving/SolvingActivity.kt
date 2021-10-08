package com.example.quize_with_mvvm.src.feature.solving

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quize_with_mvvm.R
import com.example.quize_with_mvvm.databinding.ActivitySolvingBinding
import com.example.quize_with_mvvm.src.data.datasource.model.User

class SolvingActivity : AppCompatActivity(){
    private lateinit var binding : ActivitySolvingBinding
    private lateinit var solvingActivityViewModel: SolvingActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_solving)

        var user = intent.getSerializableExtra("User") as User
        solvingActivityViewModel= SolvingActivityViewModel(user)
        solvingActivityViewModel.setViewPager(binding.vPager2Question)
    }
}