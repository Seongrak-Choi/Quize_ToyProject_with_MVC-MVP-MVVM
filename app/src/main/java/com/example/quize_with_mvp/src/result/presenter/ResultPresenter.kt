package com.example.quize_with_mvp.src.result.presenter

import android.content.Context
import android.content.Intent
import com.example.quize_with_mvp.src.solving.SolvingActivity

class ResultPresenter(
    private var view : ResultContract.View
) : ResultContract.Presenter{
    override fun clickBtnRestart(name: String) {
        view.reStartQuize(name)
    }

}