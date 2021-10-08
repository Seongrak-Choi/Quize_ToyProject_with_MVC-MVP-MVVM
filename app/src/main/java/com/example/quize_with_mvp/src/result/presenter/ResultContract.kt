package com.example.quize_with_mvp.src.result.presenter

import android.content.Context

interface ResultContract {
    interface View{
        fun reStartQuize(name:String)
        fun getName() :String

    }
    interface Presenter{
        fun clickBtnRestart(name:String)
    }
}