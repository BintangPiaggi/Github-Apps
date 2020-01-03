package com.bintang.app.testinspira.repositories.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
        @SerializedName("total_count")
        val totalCount: Int?,
        @SerializedName("incomplete_results")
        val incompleteResults: Boolean?,
        val items: List<SearchItems>
)