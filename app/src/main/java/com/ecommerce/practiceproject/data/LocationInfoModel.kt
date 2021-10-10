package com.ecommerce.practiceproject.data

import com.google.gson.annotations.SerializedName

class LocationInfoModel
{
    @SerializedName("city") lateinit var city : String
    @SerializedName("state") lateinit var state : String
    @SerializedName("country") lateinit var country : String
    @SerializedName("postcode") lateinit var postcode : String
}