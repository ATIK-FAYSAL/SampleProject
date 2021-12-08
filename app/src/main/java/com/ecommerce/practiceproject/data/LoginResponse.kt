package com.ecommerce.practiceproject.data

import com.google.gson.annotations.SerializedName

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * @Created 11/18/2021 at 12:58 PM
 */
class LoginResponse
{
    @SerializedName("success") val isSuccess = false
    @SerializedName("code") var responseCode = 0
    @SerializedName("message") lateinit var message : String
}