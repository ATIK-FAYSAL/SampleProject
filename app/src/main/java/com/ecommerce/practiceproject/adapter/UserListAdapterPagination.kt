package com.ecommerce.practiceproject.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.practiceproject.R
import com.ecommerce.practiceproject.data.ItemModel

class UserListAdapterPagination : PagingDataAdapter<ItemModel, UserListAdapterPagination.ViewHolder> (DataDifferentiator)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.model_user, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = getItem(position)

        if(model != null)
        {
            holder.tvUserName.text = "${model.nameInfo.title} ${model.nameInfo.firstName} ${model.nameInfo.lastName}"
            holder.tvPhone.text = model.phone
            holder.tvEmail.text = model.email
            holder.tvAddress.text = "${model.location.city}, ${model.location.state} ${model.location.postcode}, ${model.location.country}"
        }
    }

    object DataDifferentiator : DiffUtil.ItemCallback<ItemModel>() {
        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.email == newItem.email
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUserName: TextView = itemView.findViewById(R.id.tv_name)
        val tvAddress: TextView = itemView.findViewById(R.id.tv_address)
        val tvEmail: TextView = itemView.findViewById(R.id.tv_email)
        val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
    }
}