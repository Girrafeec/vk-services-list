package com.girrafeecstud.vk_services_list.app

import android.app.Application
import android.content.Context
import com.girrafeecstud.vk_services_list.di.AppComponent
import com.girrafeecstud.vk_services_list.di.AppDependencies

class VkServicesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponent.init(AppDependenciesImpl())
    }

    private inner class AppDependenciesImpl : AppDependencies {
        override val applicationContext: Context = this@VkServicesApplication
    }

}