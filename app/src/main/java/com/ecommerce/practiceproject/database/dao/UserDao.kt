package com.ecommerce.practiceproject.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.ecommerce.practiceproject.database.entities.UserEntities

@Dao
interface UserDao
{
    @Insert
    fun addUser(user : UserEntities)
}