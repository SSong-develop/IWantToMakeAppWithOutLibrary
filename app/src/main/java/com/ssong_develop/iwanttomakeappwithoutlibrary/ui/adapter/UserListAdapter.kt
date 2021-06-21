package com.ssong_develop.iwanttomakeappwithoutlibrary.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity.UserInfo
import com.ssong_develop.iwanttomakeappwithoutlibrary.databinding.ViewUserInfoListBinding

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ListViewHolder>() {
    private val userInfoList = mutableListOf<UserInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewUserInfoListBinding.inflate(layoutInflater,parent,false)

        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(userInfoList[position])
    }

    override fun getItemCount(): Int = userInfoList.size

    fun submitList(items : List<UserInfo>){
        userInfoList.clear()
        userInfoList.addAll(items)
        notifyDataSetChanged()
    }

    class ListViewHolder(private val binding: ViewUserInfoListBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(item : UserInfo){
                binding.itemUserInfo = item
            }
    }
}