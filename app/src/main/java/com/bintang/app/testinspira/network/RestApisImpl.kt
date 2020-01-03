package com.bintang.app.testinspira.network

import com.bintang.app.testinspira.repositories.model.SearchResponse
import com.bintang.app.testinspira.user.model.UserResponse
import com.hi.kotlinmvp.utils.USER_API
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RestApisImpl {

    private var mRestApis: RestApis = RetrofitClientFactory.get()


    fun doUserList(aApiCallback: RestApiCallback<Any, Any>, compositeDisposable: CompositeDisposable) {

        compositeDisposable.add(mRestApis.requestUser()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                aApiCallback.onSuccess(USER_API, it as List<UserResponse>)
            }, {
                aApiCallback.onApiError(USER_API, it.message.toString())
            }))
    }

    fun doRepositoriesSearch(aApiCallback: RestApiCallback<Any, Any>, compositeDisposable: CompositeDisposable, query: String) {

        compositeDisposable.add(mRestApis.requestRepositories(query)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                aApiCallback.onSuccess(USER_API, it as SearchResponse)
            }, {
                aApiCallback.onApiError(USER_API, it.message.toString())
            }))
    }
}