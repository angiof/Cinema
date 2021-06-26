package com.example.cine.comom

import android.app.Application

class MyApp :Application(){

    companion object{
        //instance del context
        lateinit var instance:MyApp
    }

    override fun onCreate() {
        super.onCreate()
        //instance dal on create app
        instance=this
    }


}