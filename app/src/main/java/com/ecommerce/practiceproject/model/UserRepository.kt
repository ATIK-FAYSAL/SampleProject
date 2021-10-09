package com.ecommerce.practiceproject.model

import com.ecommerce.practiceproject.config.BaseApplication.Companion.mContext
import com.ecommerce.practiceproject.database.DatabaseClient
import com.ecommerce.practiceproject.database.entities.UserEntities

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
}