package com.bintang.app.testinspira.repositories

import com.bintang.app.testinspira.GithubApps
import com.bintang.app.testinspira.network.RestApiCallback
import com.bintang.app.testinspira.repositories.model.SearchResponse
import com.hi.kotlinmvp.utils.NetworkUtils
import com.hi.kotlinmvp.utils.USER_API
import io.reactivex.disposables.CompositeDisposable

class RepositoriesPresenter constructor(var mUserView: RepositoriesView?, var query: String) : RepositoriesUseCase,
    RestApiCallback<Any, Any> {


    override fun RepositoriesList(compositeDisposable: CompositeDisposable) {
        if (NetworkUtils.isNetworkAvailable(GithubApps.app)) {
            mUserView?.showLoader()
            GithubApps.getRestApis().doRepositoriesSearch(this, compositeDisposable, query)
        } else {
            mUserView?.hideLoader()
            mUserView?.noInternetConnection()
        }
    }

    override fun onDestroy() {
        mUserView = null
    }

    override fun onSuccess(aApiCode: Int, aSuccessResponse: Any) {
        mUserView?.hideLoader()
        when (aApiCode) {
            USER_API -> mUserView?.onRepositoriesSuccess(aSuccessResponse as SearchResponse)
        }
    }

    override fun onApiError(aApiCode: Int, aFailureResponse: Any) {
        mUserView?.hideLoader()
        when (aApiCode) {
            USER_API -> mUserView?.apiError(aApiCode, aFailureResponse.toString())
        }
    }
}