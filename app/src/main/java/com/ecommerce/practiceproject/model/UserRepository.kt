package com.ecommerce.practiceproject.model

import com.ecommerce.practiceproject.config.BaseApplication.Companion.mContext
import com.ecommerce.practiceproject.data.DefaultResponse
import com.ecommerce.practiceproject.database.DatabaseClient
import com.ecommerce.practiceproject.database.entities.UserEntities
import com.ecommerce.practiceproject.network.RetrofitClient
import com.ecommerce.practiceproject.network.config.ApiConfig

class UserRepository
{
    suspend fun addUser(user : UserEntities) : Long
    {
        return DatabaseClient.getInstance(mContext)
            .appDatabase
            .userDao().addUser(user)
    }

    /**
     * ...get user list from local db
     */
    suspend fun getUserList() : List<UserEntities>
    {
        return DatabaseClient.getInstance(mContext)
            .appDatabase
            .userDao().getUserList()
    }

    /**
     * ...get user list from remote db
     */
    suspend fun getUserLists(page : Int) : DefaultResponse{
        val apiConfig = RetrofitClient.getRetrofitClient().create(ApiConfig::class.java)

        return apiConfig.getDataList(page, 10)
    }

    suspend fun getUserLists() : DefaultResponse{
        val apiConfig = RetrofitClient.getRetrofitClient().create(ApiConfig::class.java)

        return apiConfig.getDataList(50)
    }
}