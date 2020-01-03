package com.bintang.app.testinspira.repositories

import io.reactivex.disposables.CompositeDisposable

interface RepositoriesUseCase {

    fun RepositoriesList(compositeDisposable: CompositeDisposable)

    fun onDestroy()
}
