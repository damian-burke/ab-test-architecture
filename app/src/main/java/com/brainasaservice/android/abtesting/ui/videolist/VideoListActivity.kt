package com.brainasaservice.android.abtesting.ui.videolist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.brainasaservice.android.abtesting.R
import com.brainasaservice.android.abtesting.model.Video
import com.brainasaservice.android.abtesting.ui.MvpActivity
import kotlinx.android.synthetic.main.activity_video_list.*

class VideoListActivity : MvpActivity<VideoListContract.View, VideoListContract.Presenter>(), VideoListContract.View {
    private val adapter: VideoListAdapter = VideoListAdapter()

    override fun createPresenter(): VideoListContract.Presenter {
        return VideoListPresenter()
    }

    override val contentLayout = R.layout.activity_video_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        videoListRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        videoListRecyclerView.adapter = adapter
    }

    override fun setVideos(videos: List<Video>) {
        adapter.items = videos
    }


    // No-operation
    override fun setRecommendedVideo(video: Video) = Unit
}