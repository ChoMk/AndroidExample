package com.example.androidexample

import android.app.Application
import android.content.Context

/**
 * @author MyeongKi
 */
class SampleApp : Application() {

    init {
        instance = this
    }


    companion object {
        private var instance: SampleApp? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}