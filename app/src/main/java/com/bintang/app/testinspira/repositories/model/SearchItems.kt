package com.bintang.app.testinspira.repositories.model

import com.google.gson.annotations.SerializedName

data class SearchItems(
        @SerializedName("name")
        var mName: String? = null,

        val owner: OwnerItem?
)