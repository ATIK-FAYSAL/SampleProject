package com.ecommerce.practiceproject.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ecommerce.practiceproject.database.entities.UserEntities

@Dao
interface UserDao
{
    @Insert
    suspend fun addUser(user : UserEntities) : Long

    @Query("SELECT * FROM tbl_user")
    suspend fun getUserList() : List<UserEntities>
}