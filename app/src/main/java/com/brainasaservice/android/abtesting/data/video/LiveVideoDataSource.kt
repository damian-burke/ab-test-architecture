package com.brainasaservice.android.abtesting.data.video

import com.brainasaservice.android.abtesting.model.Video
import io.reactivex.Single

class LiveVideoDataSource: VideoDataSource {
    override fun getVideos(): Single<List<Video>> = Single.just(mockVideoList)

    companion object {
        val mockVideoList = listOf<Video>(
                Video("Super awesome video"),
                Video("Super boring video"),
                Video("Very important video"),
                Video("This is not a video"),
                Video("A video about videos")
        )
    }
}