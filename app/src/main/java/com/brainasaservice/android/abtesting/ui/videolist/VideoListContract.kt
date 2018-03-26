package com.brainasaservice.android.abtesting.ui.videolist

import com.brainasaservice.android.abtesting.model.Video
import com.brainasaservice.android.abtesting.ui.MvpContract
import com.brainasaservice.android.abtesting.ui.MvpPresenter

interface VideoListContract: MvpContract {
    interface View: MvpContract.View {
        fun setVideos(videos: List<Video>)
        fun setRecommendedVideo(video: Video)
    }

    abstract class Presenter: MvpPresenter<View>() {

    }
}