package com.brainasaservice.android.abtesting.data.experiment

interface ExperimentSource {
    fun getVariation(key: String): String
}
