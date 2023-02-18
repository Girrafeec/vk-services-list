package com.girrafeecstud.vk_services_list.app

import android.app.Application
import com.girrafeecstud.vk_services_list.di.AppComponent
import com.girrafeecstud.vk_services_list.di.DaggerAppComponent

class VkServicesApplication : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .build()
    }

}