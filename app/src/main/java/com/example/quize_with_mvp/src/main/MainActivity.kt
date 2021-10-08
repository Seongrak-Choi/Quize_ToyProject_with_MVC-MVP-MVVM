package com.example.quize_with_mvp.src.main

import android.content.Intent
import android.os.Bundle
import com.example.quize_with_mvp.config.BaseActivity
import com.example.quize_with_mvp.databinding.ActivityMainBinding
import com.example.quize_with_mvp.src.main.presenter.MainContract
import com.example.quize_with_mvp.src.main.presenter.MainPresenter
import com.example.quize_with_mvp.src.solving.SolvingActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainPresenter = MainPresenter(this)


        binding.btnSolving.setOnClickListener {
            mainPresenter.clickBtnSolving(getName())
        }
    }

    override fun startQuize(name:String) {
        var intent = Intent(this, SolvingActivity::class.java)
        if(name.isNotEmpty())
            intent.putExtra("name",name)
        startActivity(intent)
    }

    override fun getName() = binding.edtName.text.toString()
}