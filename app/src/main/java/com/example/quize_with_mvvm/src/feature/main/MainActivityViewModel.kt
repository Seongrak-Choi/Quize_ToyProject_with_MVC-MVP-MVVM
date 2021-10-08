package com.example.quize_with_mvvm.src.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quize_with_mvvm.src.data.datasource.local.DummyData
import com.example.quize_with_mvvm.src.data.datasource.model.Quize
import com.example.quize_with_mvvm.src.data.datasource.model.User
import com.example.quize_with_mvvm.src.data.repository.MainActivityRepository
import com.example.quize_with_mvvm.src.feature.solving.adapter.ViewPagerAdapter

class MainActivityViewModel : ViewModel(){
    private  var user : User
    private val mainActivityRepository : MainActivityRepository = MainActivityRepository()

    init {
        user=mainActivityRepository.getUser()
        println("뷰모델 생성자 ${user.name}")
    }


    /*
    MainActivityRepository의 setUserName을 호출해 데이터를 저장
     */
    fun setUserName(name:String){
        println("viewmodel:${name}")
        mainActivityRepository.setUserName(name)
    }

    /*
    ViewModel의 user데이터를 받기위한 메소드
     */
    fun getUser() : User {
        var returnUser = user
        return returnUser
    }

}