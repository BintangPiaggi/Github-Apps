package com.bintang.app.testinspira.network

import com.bintang.app.testinspira.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClientFactory {
    private const val mBaseUrl = BuildConfig.BASE_URL

    private val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient().newBuilder().retryOnConnectionFailure(true).connectTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES)
    private val okHttpClient = okHttpClientBuilder.build()

    fun get(): RestApis {
        val mRetrofitClient: RestApis

        val retrofit = Retrofit.Builder()
            .baseUrl(mBaseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mRetrofitClient = retrofit.create(RestApis::class.java)
        return mRetrofitClient
    }
}