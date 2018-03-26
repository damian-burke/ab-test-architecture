package com.brainasaservice.android.abtesting.ui.videolist

import android.media.MediaRecorder
import android.util.Log
import com.brainasaservice.android.abtesting.data.experiment.ExperimentSource
import com.brainasaservice.android.abtesting.data.experiment.FirebaseExperimentSource
import com.brainasaservice.android.abtesting.data.video.LiveVideoDataSource
import com.brainasaservice.android.abtesting.data.video.VideoDataSource
import com.brainasaservice.android.abtesting.ui.MvpPresenter
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class VideoListPresenter() : VideoListContract.Presenter() {
    var disposable: CompositeDisposable? = null

    // this should also be injected / factory / created somewhere else...
    private val videoSource: VideoDataSource = LiveVideoDataSource()

    override fun onViewAttached() {
        super.onViewAttached()
        disposable = CompositeDisposable()
        initVideoList()
        initRecommendedVideo()
    }

    private fun initVideoList() {
        videoSource.getVideos()
                .subscribe({
                    // display video list
                    view?.setVideos(it)
                }, {
                    Log.e("VideoListPresenter", "Oops", it)
                })
                .also { disposable?.add(it) }
    }

    private fun initRecommendedVideo() {
        videoSource.getVideos()
                .map { it.shuffled().first() }
                .subscribe({
                    // display recommended video
                    view?.setRecommendedVideo(it)
                }, {
                    Log.e("VideoListPresenter", "Oops", it)
                })
                .also { disposable?.add(it) }
    }

    override fun onViewDetached() {
        super.onViewDetached()
        disposable?.dispose()
        disposable = null
    }
}
