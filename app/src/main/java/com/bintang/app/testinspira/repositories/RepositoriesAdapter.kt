package com.bintang.app.testinspira.repositories

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bintang.app.testinspira.R
import com.bintang.app.testinspira.repositories.model.SearchResponse
import kotlinx.android.synthetic.main.item_repositories.view.*

class RepositoriesAdapter(private val context: Context, private val userList: SearchResponse) :
RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_repositories, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.totalCount!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = userList.items.get(0).mName
        holder.url.text = userList.items.get(0).owner?.mUrl
        holder.owner.text = userList.items.get(0).owner?.mLogin

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.tvName
        val url: TextView = view.tvUrl
        val owner: TextView = view.tvOwner
    }
}