package com.gyx.objectboxexample

import android.app.Application
import android.nfc.Tag
import android.util.Log
import io.objectbox.BoxStore
import io.objectbox.android.AndroidObjectBrowser



/**
 * Created by gyx on 2019-05-26.
 * ==============================
 * 功能描述：
 *
 *
 */
class MyApplication: Application() {



    companion object {
         lateinit var mBoxStore: BoxStore
        const val TAG = "ObjectBoxExample"

    }




    override fun onCreate() {
        super.onCreate()


        mBoxStore = MyObjectBox.builder().androidContext(this).build()


        if (BuildConfig.DEBUG) {
            val started = AndroidObjectBrowser(mBoxStore).start(this)
            Log.i("ObjectBrowser", "Started: $started")
        }
    }

}




