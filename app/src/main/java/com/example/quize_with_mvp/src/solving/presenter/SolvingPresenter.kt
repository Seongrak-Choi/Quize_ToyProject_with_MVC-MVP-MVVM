package com.example.quize_with_mvp.src.solving.presenter

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.quize_with_mvp.src.solving.adapter.QuizeViewPager2Adapter
import com.example.quize_with_mvp.src.solving.data.Quize

class SolvingPresenter(
    private var view : SolvingContract.View
):SolvingContract.Presenter {
    override fun setViewPager2Adapter(vp: ViewPager2,list:ArrayList<Quize>,name:String) {
        var adapter = QuizeViewPager2Adapter(list,name)
        vp.adapter=adapter
        vp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        vp.isUserInputEnabled=false

        adapter.setOnItemClickListener(object : QuizeViewPager2Adapter.OnItemClickListener{
            override fun onItemClick(v: View, position: Int, isCorrect:Boolean) {
                vp.setCurrentItem(getItem(+1),true)
            }

            fun getItem(i: Int): Int {
                return vp.currentItem + i
            }
        })
    }
}