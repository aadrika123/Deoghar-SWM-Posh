package com.frontendapp

import com.BH-solution-sdk-2.2.BhTxnHandler;
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Callback

class MyModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String {
        return "MyModule"
    }

    @ReactMethod
    fun myMethod(callback: Callback) {
        val message = "Hello from Kotlin!"
        callback.invoke(message)
    }

    @ReactMethod 
    fun doSale(activity:Activity,transactionId: String,amount: String,remoteAppID:String,callback:lbhTxnListener) {
        try {
            BhTxnHandler bhTxnHandler = new BhTxnHandler();
            String result = bhTxnHandler.doSale(activity,transactionId,amount,remoteAppID,callback);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject("Error", e);
        }
    }

}