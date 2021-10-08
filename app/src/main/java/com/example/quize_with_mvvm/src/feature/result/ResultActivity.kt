package com.example.quize_with_mvvm.src.feature.result

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quize_with_mvvm.R
import com.example.quize_with_mvvm.databinding.ActivityResultBinding
import com.example.quize_with_mvvm.src.data.datasource.model.User
import com.example.quize_with_mvvm.src.feature.solving.SolvingActivity

class ResultActivity :AppCompatActivity(){
    private lateinit var binding : ActivityResultBinding
    private lateinit var resultActivityViewModel : ResultActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_result)

        var user = intent.getSerializableExtra("User") as User

        resultActivityViewModel= ResultActivityViewModel(user)

        binding.txCorrectCount.text=user.score.toString()+"개"
        binding.txNick.text=user.name+"님이 맞춘 개수!"

        binding.apply {
//            lifecycleOwner=this@ResultActivity
//            activityResult=this@ResultActivity

            txNick.text=resultActivityViewModel.getUserName()+"님이 맞춘 개수!"
            txCorrectCount.text=resultActivityViewModel.getUserScore().toString()

            btnRetry.setOnClickListener {
                var intent = Intent(applicationContext,SolvingActivity::class.java)
                intent.putExtra("User",user)
                startActivity(intent)            }
        }
    }
}