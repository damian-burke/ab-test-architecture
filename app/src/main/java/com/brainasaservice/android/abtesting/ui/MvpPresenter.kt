package com.brainasaservice.android.abtesting.ui

import java.lang.ref.WeakReference

abstract class MvpPresenter<V : MvpContract.View>() : MvpContract.Presenter<V> {

    private var viewRef: WeakReference<V>? = null

    override var view: V? = null
        get() = viewRef?.get()

    override fun hasView(): Boolean {
        return viewRef?.get() != null
    }

    override fun attachView(v: V) {
        viewRef = WeakReference(v)
        onViewAttached()
    }

    override fun detachView() {
        viewRef?.clear()
        viewRef = null
        onViewDetached()
    }

    override fun onViewAttached() = Unit

    override fun onViewDetached() = Unit
}
