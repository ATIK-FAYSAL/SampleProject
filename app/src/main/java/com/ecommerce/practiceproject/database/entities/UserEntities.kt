package com.ecommerce.practiceproject.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
class UserEntities
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id") var userId : Int = 0
    @ColumnInfo(name = "full_name") lateinit var fullName : String
    @ColumnInfo(name = "email") lateinit var email : String
    @ColumnInfo(name = "phone") lateinit var phone : String
    @ColumnInfo(name = "address") lateinit var address : String
}