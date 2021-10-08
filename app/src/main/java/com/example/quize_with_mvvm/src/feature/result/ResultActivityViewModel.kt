package com.example.quize_with_mvvm.src.feature.result

import androidx.lifecycle.ViewModel
import com.example.quize_with_mvvm.src.data.datasource.model.User

class ResultActivityViewModel(val user: User) : ViewModel() {
    /*
    user의 name을 리턴
     */
    fun getUserName():String{
        return user.name
    }

    fun getUserScore():Int{
        return user.score
    }

}