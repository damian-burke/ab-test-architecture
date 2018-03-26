package com.brainasaservice.android.abtesting.ui.splashscreen

import com.brainasaservice.android.abtesting.ui.MvpContract
import com.brainasaservice.android.abtesting.ui.MvpPresenter

interface SplashscreenContract: MvpContract {
    interface View: MvpContract.View {
        fun displayVideoList()
        fun displayVideoListWithRecommendations()
    }

    abstract class Presenter: MvpPresenter<View>() {

    }
}