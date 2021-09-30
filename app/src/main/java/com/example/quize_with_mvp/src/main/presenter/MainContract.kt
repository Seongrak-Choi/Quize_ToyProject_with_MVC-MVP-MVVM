package com.example.quize_with_mvp.src.main.presenter

import android.widget.EditText

interface MainContract {
    interface View{
        fun startQuize(name:String)
        fun getName() :String
    }

    interface Presenter{
        fun clickBtnSolving(name:String)
    }
}