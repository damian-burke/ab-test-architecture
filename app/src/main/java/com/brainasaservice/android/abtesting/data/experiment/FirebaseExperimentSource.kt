package com.brainasaservice.android.abtesting.data.experiment

import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class FirebaseExperimentSource : ExperimentSource {
    init {
        FirebaseRemoteConfig.getInstance()
                .fetch()
                .addOnCompleteListener {
                    FirebaseRemoteConfig.getInstance()
                            .activateFetched()
                }
    }

    override fun getVariation(key: String): String {
        return FirebaseRemoteConfig.getInstance().getString(key)
    }

    companion object {
        const val BASELINE = "baseline"
        const val VARIATION_RECOMMENDED_VIDEO = "recommended_video"
        const val VIDEO_RECOMMENDATION_KEY = "recommended_video"
    }
}
