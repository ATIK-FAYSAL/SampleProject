package com.ecommerce.practiceproject.data

import com.google.gson.annotations.SerializedName

class NameInfoModel
{
    @SerializedName("title") lateinit var title : String
    @SerializedName("first") lateinit var firstName : String
    @SerializedName("last") lateinit var lastName : String
}