package com.ecommerce.practiceproject.data

import com.google.gson.annotations.SerializedName

class DefaultResponse
{
    @SerializedName("info") lateinit var info : InfoResponseModel
    @SerializedName("results") lateinit var results : List<ItemModel>
}