package com.brainasaservice.android.abtesting.ui

import android.support.annotation.LayoutRes

interface MvpContract {
    interface View {
        @get:LayoutRes
        val contentLayout: Int
    }

    interface Presenter<V : View> {
        var view: V?

        fun detachView()

        fun hasView() : Boolean

        fun attachView(v: V)

        fun onViewAttached()

        fun onViewDetached()
    }
}
