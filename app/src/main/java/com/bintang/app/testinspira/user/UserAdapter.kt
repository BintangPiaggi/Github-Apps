package com.bintang.app.testinspira.user

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bintang.app.testinspira.R
import com.bintang.app.testinspira.user.model.UserResponse
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_user.view.*


class UserAdapter(private val context: Context, private val userList: ArrayList<UserResponse>) :
        RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userName.text = userList[position].login
        Glide.with(context).load(userList[position].avatar_url).into(holder.userIcon)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userName: TextView = view.tvUsername
        val userIcon: ImageView = view.imgUserIcon
    }
}
