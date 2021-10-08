package com.example.quize_with_mvp.src.result

import android.content.Intent
import android.os.Bundle
import com.example.quize_with_mvp.config.BaseActivity
import com.example.quize_with_mvp.databinding.ActivityResultBinding
import com.example.quize_with_mvp.src.result.presenter.ResultContract
import com.example.quize_with_mvp.src.result.presenter.ResultPresenter
import com.example.quize_with_mvp.src.solving.SolvingActivity

class ResultActivity  : BaseActivity<ActivityResultBinding>(ActivityResultBinding::inflate),ResultContract.View {
    private lateinit var name : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val presenter = ResultPresenter(this)

        var score = intent.getIntExtra("score",0)
        name = intent.getStringExtra("name").toString()
        binding.txCorrectCount.text=score.toString()+"개"
        binding.txNick.text=name+"님이 맞춘 개수!"
        binding.btnRetry.setOnClickListener {
            presenter.clickBtnRestart(getName())
        }

    }

    override fun reStartQuize(name: String) {
        var intent = Intent(this,SolvingActivity::class.java)
        intent.putExtra("name",name)
        startActivity(intent)
    }

    override fun getName(): String =name
}