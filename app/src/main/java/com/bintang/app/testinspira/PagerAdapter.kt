package com.bintang.app.testinspira

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bintang.app.testinspira.repositories.RepositoriesFragment
import com.bintang.app.testinspira.user.UserFragment

class PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){

    private val pages = listOf(
        UserFragment(),
        RepositoriesFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Users"
            else -> "Repositories"

        }
    }
}