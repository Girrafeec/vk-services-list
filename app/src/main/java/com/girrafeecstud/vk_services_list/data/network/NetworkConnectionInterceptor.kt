package com.girrafeecstud.vk_services_list.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.girrafeecstud.vk_services_list.base.NoNetworkConnectionException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkConnectionInterceptor @Inject constructor(
    private val context: Context
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isNetworkAvailable())
            throw NoNetworkConnectionException()

        return chain.proceed(chain.request())
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.activeNetworkInfo.also {
            return it != null && it.isConnected
        }
    }

}