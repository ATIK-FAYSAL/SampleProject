package com.ecommerce.practiceproject.config

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context


/**
 * Date 12/23/2020.
 * Created by Md Atik Faysal(Android Developer)
 *
 */
class BaseApplication : Application()
{
    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
    }

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var mContext : Context
    }
}