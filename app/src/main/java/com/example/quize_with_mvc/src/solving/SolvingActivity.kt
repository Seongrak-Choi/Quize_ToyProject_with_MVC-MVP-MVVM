package com.example.quize_with_mvc.src.solving

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.quize_with_mvc.R
import com.example.quize_with_mvc.config.BaseActivity
import com.example.quize_with_mvc.databinding.ActivitySolvingBinding
import com.example.quize_with_mvc.src.solving.Models.Quize

class SolvingActivity : BaseActivity<ActivitySolvingBinding>(ActivitySolvingBinding::inflate) {
    private var name = ""
    private var quizeList = ArrayList<Quize>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quizeList.add(Quize(R.drawable.quize1, "40", "문제1 : 물음표에 들어 갈 답으로 알맞은 보기를 고르시오.","3","7","38","40"))
        quizeList.add(Quize(R.drawable.quize2, "51", "문제2 : 물음표에 들어 갈 답으로 알맞은 보기를 고르시오.","25","51","55","63"))
        quizeList.add(Quize(R.drawable.quize3, "410", "문제3 : 물음표에 들어 갈 답으로 알맞은 보기를 고르시오.","62","150","410","620"))


        if (!intent.getStringExtra("name").toString().isEmpty())
            name = intent.getStringExtra("name").toString()


        var adapter = QuizeViewPager2Adapter(quizeList,this,name)
        binding.vPager2Question.adapter = adapter
        binding.vPager2Question.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.vPager2Question.isUserInputEnabled = false

        adapter.setOnItemClickListener(object : QuizeViewPager2Adapter.OnItemClickListener {
            override fun onItemClick(v: View, position: Int,isCorrect:Boolean) {
                binding.vPager2Question.setCurrentItem(getItem(+1),true)
            }
        })

//        binding.btnNext.setOnClickListener {
//            binding.vPager2Question.setCurrentItem(getItem(+1), true)
//            if(getItem(0)==quizeList.size-1){
//                binding.btnNext.text="결과 보기"
//            }
//        }
    }

    fun getItem(i: Int): Int {
        return binding.vPager2Question.currentItem + i
    }
}