package com.bintang.app.testinspira.repositories

import com.bintang.app.testinspira.MvpView
import com.bintang.app.testinspira.repositories.model.SearchResponse


interface RepositoriesView : MvpView {

    fun onRepositoriesSuccess(aUserResponse: SearchResponse)
}
