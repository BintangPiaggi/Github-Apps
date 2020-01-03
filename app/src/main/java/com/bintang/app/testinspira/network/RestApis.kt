package com.bintang.app.testinspira.network

import com.bintang.app.testinspira.repositories.model.SearchResponse
import com.bintang.app.testinspira.user.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApis {

    @GET("repos/square/retrofit/contributors")
    fun requestUser(): Observable<List<UserResponse>>


    @GET("search/repositories")
    fun requestRepositories(@Query("q") q: String): Observable<SearchResponse>

}