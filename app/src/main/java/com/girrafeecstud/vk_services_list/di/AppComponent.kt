package com.girrafeecstud.vk_services_list.di

import com.girrafeecstud.vk_services_list.presentation.MainViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        AppModule::class
    ]
)
interface AppComponent {

    fun viewModelFactory(): MainViewModelFactory

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

    }

    companion object {
        private var _appComponent: AppComponent? = null

        val appComponent get() = _appComponent!!

        fun init() {
            if (_appComponent == null) {
                _appComponent = DaggerAppComponent
                    .builder()
                    .build()
            }
        }

        fun reset() {
            _appComponent = null
        }
    }

}