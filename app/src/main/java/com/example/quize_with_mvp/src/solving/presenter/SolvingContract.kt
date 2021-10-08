package com.example.quize_with_mvp.src.solving.presenter

import androidx.viewpager2.widget.ViewPager2
import com.example.quize_with_mvp.src.solving.data.Quize

interface SolvingContract {
    interface View {

    }

    interface Presenter{
        fun setViewPager2Adapter(vp:ViewPager2,list:ArrayList<Quize>,name:String)
    }
}