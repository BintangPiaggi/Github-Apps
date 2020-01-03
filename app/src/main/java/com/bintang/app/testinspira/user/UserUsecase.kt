package com.bintang.app.testinspira.user

import io.reactivex.disposables.CompositeDisposable


interface UserUsecase {

    fun userList(compositeDisposable: CompositeDisposable)

    fun onDestroy()
}
