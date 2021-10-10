package com.ecommerce.practiceproject.data

import com.google.gson.annotations.SerializedName

class ItemModel
{
    @SerializedName("name") lateinit var nameInfo : NameInfoModel
    @SerializedName("gender") lateinit var gender : String
    @SerializedName("phone") lateinit var phone : String
    @SerializedName("email") lateinit var email : String
    @SerializedName("location") lateinit var location : LocationInfoModel
}