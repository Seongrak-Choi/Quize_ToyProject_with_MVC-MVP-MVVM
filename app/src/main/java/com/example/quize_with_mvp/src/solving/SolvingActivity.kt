package com.example.quize_with_mvp.src.solving

import android.os.Bundle
import com.example.quize_with_mvp.config.BaseActivity
import com.example.quize_with_mvp.databinding.ActivitySolvingBinding

class SolvingActivity : BaseActivity<ActivitySolvingBinding>(ActivitySolvingBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showCustomToast("왔쩌요")
    }
}