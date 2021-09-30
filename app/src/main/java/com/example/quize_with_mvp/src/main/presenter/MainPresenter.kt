package com.example.quize_with_mvp.src.main.presenter

class MainPresenter(
    private var view: MainContract.View
): MainContract.Presenter {
    override fun clickBtnSolving(name: String) {
        view.startQuize(name)
    }
}