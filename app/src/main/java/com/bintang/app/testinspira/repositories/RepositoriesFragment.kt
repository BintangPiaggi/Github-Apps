package com.bintang.app.testinspira.repositories


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView

import com.bintang.app.testinspira.R
import com.bintang.app.testinspira.repositories.model.SearchResponse
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_repositories.view.*


class RepositoriesFragment : Fragment(), RepositoriesView {


    private lateinit var compositeDisposable: CompositeDisposable
    private var mLoginPresenter: RepositoriesPresenter? = null
    private var vieww: View? = null
    private var adapter: RepositoriesAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        vieww = inflater.inflate(R.layout.fragment_repositories, container, false)
        compositeDisposable = CompositeDisposable()
        Search()



        return vieww
    }

    fun Search(){
        vieww?.scRepo?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {

                return false
            }


            override fun onQueryTextSubmit(query: String): Boolean {
                if(query.length < 3){
                    Toast.makeText(activity, "Find mininum 3 character", Toast.LENGTH_SHORT).show()

                } else{
                    mLoginPresenter = RepositoriesPresenter(this@RepositoriesFragment, query)
                    mLoginPresenter?.RepositoriesList(compositeDisposable)
                }
                return false
            }
        })


    }




    override fun onRepositoriesSuccess(aUserResponse: SearchResponse) {
        adapter = RepositoriesAdapter(context!!, aUserResponse)
        vieww?.rvSearchRepo?.adapter = adapter

    }

    override fun showLoader() {
        vieww?.pbRepo?.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        vieww?.pbRepo?.visibility = View.GONE
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

