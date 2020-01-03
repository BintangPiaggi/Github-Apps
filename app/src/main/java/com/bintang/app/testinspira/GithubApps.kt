package com.bintang.app.testinspira

import android.app.Application
import com.bintang.app.testinspira.network.RestApisImpl

class GithubApps : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
        restApi = RestApisImpl()
    }

    companion object {
        lateinit var app: GithubApps
        lateinit var restApi: RestApisImpl


        fun getAppInstance(): GithubApps {
            return app
        }

        fun getRestApis(): RestApisImpl {
            return restApi
        }
    }
}