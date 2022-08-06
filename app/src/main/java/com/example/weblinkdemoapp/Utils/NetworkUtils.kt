package com.example.weblinkdemoapp.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import java.text.SimpleDateFormat
import java.util.*

class NetworkUtils {

    companion object{

        fun isInternetAvailable(context: Context): Boolean {
            (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    return this.getNetworkCapabilities(this.activeNetwork)?.hasCapability(
                        NetworkCapabilities.NET_CAPABILITY_INTERNET
                    ) ?: false
                } else {
                    (@Suppress("DEPRECATION")
                    return this.activeNetworkInfo?.isConnected ?: false)
                }
            }
        }

        fun changeTime(_24HourTime: String?) : String{

            val _24HourSDF = SimpleDateFormat("HH:mm")
            val _12HourSDF = SimpleDateFormat("hh:mm a")
            val _24HourDt: Date = _24HourSDF.parse(_24HourTime)
            return _12HourSDF.format(_24HourDt)
        }
    }
}