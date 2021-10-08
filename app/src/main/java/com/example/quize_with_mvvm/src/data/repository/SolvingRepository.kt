package com.example.quize_with_mvvm.src.data.repository

import com.example.quize_with_mvvm.src.data.datasource.local.DummyData
import com.example.quize_with_mvvm.src.data.datasource.model.Quize

class SolvingRepository {
    private var quizeList = DummyData().getQuizeList()

    fun getQuizeList():ArrayList<Quize>{
        return quizeList
    }
}