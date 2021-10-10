package com.ecommerce.practiceproject.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.practiceproject.R
import com.ecommerce.practiceproject.core.BaseAdapter
import com.ecommerce.practiceproject.data.ItemModel
import com.ecommerce.practiceproject.database.entities.UserEntities

class UserListAdapter(private val context: Context, items:List<ItemModel>) : BaseAdapter<UserListAdapter.ViewHolder, UserEntities>()
{
    private var userList = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.model_user, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = userList[position]

        holder.tvUserName.text = "${model.nameInfo.title} ${model.nameInfo.firstName} ${model.nameInfo.lastName}"
        holder.tvPhone.text = model.phone
        holder.tvEmail.text = model.email
        holder.tvAddress.text = "${model.location.city}, ${model.location.state} ${model.location.postcode}, ${model.location.country}"
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUserName: TextView = itemView.findViewById(R.id.tv_name)
        val tvAddress: TextView = itemView.findViewById(R.id.tv_address)
        val tvEmail: TextView = itemView.findViewById(R.id.tv_email)
        val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
    }

    override fun setData(data: List<UserEntities>) {}
}