package com.bintang.app.testinspira.network

interface RestApiCallback<T, U> {

    fun onSuccess(aApiCode: Int, aSuccessResponse: T)

    fun onApiError(aApiCode: Int, aFailureResponse: T)

}