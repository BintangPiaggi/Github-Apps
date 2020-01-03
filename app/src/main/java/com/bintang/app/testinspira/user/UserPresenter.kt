package com.bintang.app.testinspira.user

import com.bintang.app.testinspira.GithubApps
import com.bintang.app.testinspira.network.RestApiCallback
import com.bintang.app.testinspira.user.model.UserResponse
import com.hi.kotlinmvp.utils.NetworkUtils
import com.hi.kotlinmvp.utils.USER_API
import io.reactivex.disposables.CompositeDisposable


class UserPresenter constructor(var mUserView: UserView?) : UserUsecase, RestApiCallback<Any, Any> {


    override fun userList(compositeDisposable: CompositeDisposable) {
        if (NetworkUtils.isNetworkAvailable(GithubApps.app)) {
            mUserView?.showLoader()
            GithubApps.getRestApis().doUserList(this, compositeDisposable)
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
            USER_API -> mUserView?.onUserListSuccess(aSuccessResponse as ArrayList<UserResponse>)
        }
    }

    override fun onApiError(aApiCode: Int, aFailureResponse: Any) {
        mUserView?.hideLoader()
        when (aApiCode) {
            USER_API -> mUserView?.apiError(aApiCode, aFailureResponse.toString())
        }
    }
}
