package com.brainasaservice.android.abtesting.ui.splashscreen

import android.util.Log
import com.brainasaservice.android.abtesting.data.experiment.ExperimentSource
import com.brainasaservice.android.abtesting.data.experiment.FirebaseExperimentSource
import com.brainasaservice.android.abtesting.ui.MvpPresenter
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class SplashscreenPresenter() : SplashscreenContract.Presenter() {
    var disposable: Disposable? = null

    // this should also be injected / factory / created somewhere else...
    private val experimentSource: ExperimentSource = FirebaseExperimentSource()

    override fun onViewAttached() {
        super.onViewAttached()

        disposable = Single.timer(1, TimeUnit.SECONDS)
                .subscribe({
                    displayVideoList()
                }, {
                    Log.e("Splashscreen", "Something went wrong...", it)
                })
    }

    /**
     * To keep it simple, we'll check here and now in which variation the user is.
     * Depending on the variation, we will forward the user to one of our two View implementations.
     */
    private fun displayVideoList() {
        when (experimentSource.getVariation(FirebaseExperimentSource.VIDEO_RECOMMENDATION_KEY)) {
            FirebaseExperimentSource.BASELINE -> {
                view?.displayVideoList()
            }
            FirebaseExperimentSource.VARIATION_RECOMMENDED_VIDEO -> {
                view?.displayVideoListWithRecommendations()
            }
        }
    }

    override fun onViewDetached() {
        super.onViewDetached()
        disposable?.dispose()
        disposable = null
    }
}