package com.bintang.app.testinspira.repositories.model

import com.google.gson.annotations.SerializedName

data class OwnerItem(
        @SerializedName("login")
        var mLogin: String? = null,

        @SerializedName("url")
        var mUrl: String? = null
)