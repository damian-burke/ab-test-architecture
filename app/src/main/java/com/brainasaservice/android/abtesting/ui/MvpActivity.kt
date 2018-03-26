package com.brainasaservice.android.abtesting.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class MvpActivity<V : MvpContract.View, P : MvpContract.Presenter<V>>
    : AppCompatActivity(), MvpContract.View {

    private lateinit var presenter: P

    abstract fun createPresenter(): P

    fun onBeforeCreate() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
        onBeforeCreate()
        setContentView(contentLayout)
    }

    override fun onStart() {
        super.onStart()
        attachView()
    }

    override fun onStop() {
        super.onStop()
        detachView()
    }

    private val isAttached: Boolean
        get() = presenter.view?.equals(this) ?: false

    @Suppress("UNCHECKED_CAST")
    private fun attachView() {
        if (!isAttached) {
            presenter.attachView(this as V)
        }
    }

    private fun detachView() {
        if (isAttached) {
            presenter.detachView()
        }
    }
}
