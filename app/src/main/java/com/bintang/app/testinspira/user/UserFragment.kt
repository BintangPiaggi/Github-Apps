package com.bintang.app.testinspira.user


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.bintang.app.testinspira.R
import com.bintang.app.testinspira.user.model.UserResponse
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_user.view.*


class UserFragment : Fragment(), UserView {

    private lateinit var compositeDisposable: CompositeDisposable
    private var mLoginPresenter: UserPresenter? = null
    private var vieww: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        vieww  = inflater.inflate(R.layout.fragment_user, container, false)
        compositeDisposable = CompositeDisposable()
        mLoginPresenter = UserPresenter(this)
        mLoginPresenter?.userList(compositeDisposable)
        return vieww

    }

    override fun onUserListSuccess(aUserResponse: ArrayList<UserResponse>) {
        if (aUserResponse.isNotEmpty()) {
            vieww?.rvUserList?.adapter = UserAdapter(context!!, aUserResponse)
        } else {
            Toast.makeText(activity, "No data found...!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showLoader() {
        vieww?.pbUser?.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        vieww?.pbUser?.visibility = View.GONE
    }

    override fun noInternetConnection() {
        Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show()
    }

    override fun apiError(aApiCode: Int, aError: String) {
        Toast.makeText(activity, aError, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}

