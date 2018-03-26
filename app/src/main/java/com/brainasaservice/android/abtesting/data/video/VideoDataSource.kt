package com.brainasaservice.android.abtesting.data.video

import com.brainasaservice.android.abtesting.model.Video
import io.reactivex.Single

interface VideoDataSource {
    fun getVideos(): Single<List<Video>>
}