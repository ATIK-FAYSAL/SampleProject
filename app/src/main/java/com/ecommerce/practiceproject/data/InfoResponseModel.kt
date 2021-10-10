package com.ecommerce.practiceproject.data

import com.google.gson.annotations.SerializedName

class InfoResponseModel
{
    @SerializedName("seed") lateinit var seed : String
    @SerializedName("results") var results : Int = 0
    @SerializedName("page") var page : Int = 0
    @SerializedName("version") lateinit var version : String
}