package com.brainasaservice.android.abtesting.ui.videolist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brainasaservice.android.abtesting.R
import com.brainasaservice.android.abtesting.model.Video
import kotlinx.android.synthetic.main.item_video_list.view.*

class VideoListAdapter : RecyclerView.Adapter<VideoListAdapter.VideoHolder>() {
    var items: List<Video> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        return VideoHolder.create(parent)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VideoHolder, position: Int) = holder.bind(items[position])

    class VideoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(video: Video) {
            itemView.videoTitleTextView.text = video.title
        }

        companion object {
            fun create(viewGroup: ViewGroup) = VideoHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_video_list, viewGroup, false))
        }
    }
}