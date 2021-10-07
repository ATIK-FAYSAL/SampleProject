package com.ecommerce.practiceproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ecommerce.practiceproject.database.dao.UserDao
import com.ecommerce.practiceproject.database.entities.UserEntities

@Database(
    entities = [UserEntities::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun userDao() : UserDao
}