package com.brainasaservice.android.abtesting.ui.splashscreen

import com.brainasaservice.android.abtesting.R
import com.brainasaservice.android.abtesting.ui.MvpActivity

class SplashscreenActivity: MvpActivity<SplashscreenContract.View, SplashscreenContract.Presenter>(), SplashscreenContract.View {
    override fun displayVideoList() {
        TODO("not implemented")
    }

    override fun displayVideoListWithRecommendations() {
        TODO("not implemented")
    }

    // in a real app, this should be injected
    override fun createPresenter(): SplashscreenContract.Presenter = SplashscreenPresenter()

    override val contentLayout = R.layout.activity_splashscreen
}