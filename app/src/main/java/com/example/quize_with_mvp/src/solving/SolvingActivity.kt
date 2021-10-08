package com.example.quize_with_mvp.src.solving

import android.os.Bundle
import com.example.quize_with_mvp.R
import com.example.quize_with_mvp.config.BaseActivity
import com.example.quize_with_mvp.databinding.ActivitySolvingBinding
import com.example.quize_with_mvp.src.solving.adapter.QuizeViewPager2Adapter
import com.example.quize_with_mvp.src.solving.data.Quize
import com.example.quize_with_mvp.src.solving.presenter.SolvingContract
import com.example.quize_with_mvp.src.solving.presenter.SolvingPresenter

class SolvingActivity : BaseActivity<ActivitySolvingBinding>(ActivitySolvingBinding::inflate),SolvingContract.View {
    private var name = ""
    private var quizeList = ArrayList<Quize>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val present = SolvingPresenter(this)

        if (intent.getStringExtra("name").toString().isNotEmpty())
            name = intent.getStringExtra("name").toString()

        println(name)

        quizeList.add(Quize(R.drawable.quize1, "40", "문제1 : 물음표에 들어 갈 답으로 알맞은 보기를 고르시오.","3","7","38","40"))
        quizeList.add(Quize(R.drawable.quize2, "51", "문제2 : 물음표에 들어 갈 답으로 알맞은 보기를 고르시오.","25","51","55","63"))
        quizeList.add(Quize(R.drawable.quize3, "410", "문제3 : 물음표에 들어 갈 답으로 알맞은 보기를 고르시오.","62","150","410","620"))

        present.setViewPager2Adapter(binding.vPager2Question,quizeList,name)
    }
}