package com.example.quize_with_mvvm.src.feature.solving

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.example.quize_with_mvvm.src.data.datasource.model.Quize
import com.example.quize_with_mvvm.src.data.datasource.model.User
import com.example.quize_with_mvvm.src.data.repository.SolvingRepository
import com.example.quize_with_mvvm.src.feature.solving.adapter.ViewPagerAdapter

class SolvingActivityViewModel(val user:User) : ViewModel() {
    private val solvingRepository = SolvingRepository()

    /*
      viewpager 어댑터
       */
    fun setViewPager(vp:ViewPager2){
        var adapter = ViewPagerAdapter(solvingRepository.getQuizeList(),user)
        vp.adapter=adapter
        vp.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        vp.isUserInputEnabled=false

        adapter.setOnItemClickListener(object : ViewPagerAdapter.OnItemClickListener{
            override fun onItemClick(v: View, position: Int, isCorrect:Boolean) {
                vp.setCurrentItem(getItem(+1),true)
            }

            fun getItem(i: Int): Int {
                return vp.currentItem + i
            }
        })
    }
}