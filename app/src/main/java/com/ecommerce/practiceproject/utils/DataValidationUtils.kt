package com.ecommerce.practiceproject.utils

fun String.isEmptyString() : Boolean
{
    return this.isNotEmpty()
}

fun String.phoneNumberValidation() : Boolean
{
    return if(this.length == 11 || this.length == 14)
        this.startsWith("+88") || this.startsWith("0")
    else false
}