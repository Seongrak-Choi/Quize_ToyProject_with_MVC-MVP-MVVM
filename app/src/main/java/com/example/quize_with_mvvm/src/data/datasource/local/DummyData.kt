package com.example.quize_with_mvvm.src.data.datasource.local

import com.example.quize_with_mvvm.R
import com.example.quize_with_mvvm.src.data.datasource.model.Quize

class DummyData {
    private var quizeList = ArrayList<Quize>()

    init{
        quizeList.add(Quize(R.drawable.quize1, "40", "문제1 : 물음표에 들어 갈 답으로 알맞은 보기를 고르시오.","3","7","38","40"))
        quizeList.add(Quize(R.drawable.quize2, "51", "문제2 : 물음표에 들어 갈 답으로 알맞은 보기를 고르시오.","25","51","55","63"))
        quizeList.add(Quize(R.drawable.quize3, "410", "문제3 : 물음표에 들어 갈 답으로 알맞은 보기를 고르시오.","62","150","410","620"))
    }

    fun getQuizeList():ArrayList<Quize>{
        return quizeList
    }

}