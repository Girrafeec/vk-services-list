package com.girrafeecstud.vk_services_list.di

import com.girrafeecstud.vk_services_list.BuildConfig
import com.girrafeecstud.vk_services_list.data.network.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGsonConverterFactory() = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        networkConnectionInterceptor: NetworkConnectionInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(networkConnectionInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()


}