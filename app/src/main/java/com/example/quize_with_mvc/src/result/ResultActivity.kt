package com.example.quize_with_mvc.src.result

import android.content.Intent
import android.os.Bundle
import com.example.quize_with_mvc.config.BaseActivity
import com.example.quize_with_mvc.databinding.ActivityResultBinding
import com.example.quize_with_mvc.src.solving.SolvingActivity

class ResultActivity : BaseActivity<ActivityResultBinding>(ActivityResultBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        var score = intent.getIntExtra("score",0)
        var name = intent.getStringExtra("name")
        binding.txCorrectCount.text=score.toString()+"개"
        binding.txNick.text=name+"님이 맞춘 개수!"
        binding.btnRetry.setOnClickListener {
            var intent = Intent(this,SolvingActivity::class.java)
            intent.putExtra("name",name)
            startActivity(intent)
        }
        
    }
}