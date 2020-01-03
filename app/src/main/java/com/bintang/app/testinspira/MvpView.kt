package com.bintang.app.testinspira


interface MvpView {


    fun showLoader()


    fun hideLoader()


    fun noInternetConnection()


    fun apiError(aApiCode: Int, aError: String)

}
