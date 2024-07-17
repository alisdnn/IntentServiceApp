package com.alisdn.intentserviceapp

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun stopService(){
            Log.d("MyIntentService", "stopService: Service is stopping!")
            isRunning=false
            instance.stopSelf()
        }

    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning=true
            while (isRunning){
                Log.d("MyIntentService", "onHandleIntent: my service is runnig")
                Thread.sleep(1000)
            }
        }catch (e:InterruptedException){
            Thread.currentThread().interrupt()
        }
    }

}