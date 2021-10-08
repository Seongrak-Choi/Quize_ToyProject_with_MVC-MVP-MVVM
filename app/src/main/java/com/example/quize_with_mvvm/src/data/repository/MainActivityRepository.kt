package com.example.quize_with_mvvm.src.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.quize_with_mvvm.src.data.datasource.model.User

class MainActivityRepository {
    private var user : User = User("라구",0)


    fun getUser():User{
        return user
    }

    fun setUserName(name:String){
        user.name=name
        println("repository:${user.name}")
    }
}