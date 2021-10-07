package com.ecommerce.practiceproject.model

import com.ecommerce.practiceproject.config.BaseApplication.Companion.mContext
import com.ecommerce.practiceproject.database.DatabaseClient
import com.ecommerce.practiceproject.database.entities.UserEntities

class UserRepository
{
    fun addUser(user : UserEntities)
    {
        DatabaseClient.getInstance(mContext)
            .appDatabase
            .userDao().addUser(user)
    }
}