package com.bintang.app.testinspira.user

import com.bintang.app.testinspira.MvpView
import com.bintang.app.testinspira.user.model.UserResponse


interface UserView : MvpView {

    fun onUserListSuccess(aUserResponse: ArrayList<UserResponse>)
}
