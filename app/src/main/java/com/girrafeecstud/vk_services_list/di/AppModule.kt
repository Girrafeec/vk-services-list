package com.girrafeecstud.vk_services_list.di

import androidx.lifecycle.ViewModel
import com.girrafeecstud.vk_services_list.base.ListMapper
import com.girrafeecstud.vk_services_list.data.datasource.ServicesDataSource
import com.girrafeecstud.vk_services_list.data.datasource.ServicesDataSourceImpl
import com.girrafeecstud.vk_services_list.data.network.api.ServicesApi
import com.girrafeecstud.vk_services_list.data.network.dto.VkServiceDto
import com.girrafeecstud.vk_services_list.data.network.mapper.VkServiceListDtoMapper
import com.girrafeecstud.vk_services_list.data.repository.ServicesRepositoryImpl
import com.girrafeecstud.vk_services_list.di.annotation.ViewModelKey
import com.girrafeecstud.vk_services_list.domain.entity.VkService
import com.girrafeecstud.vk_services_list.domain.repository.ServicesRepository
import com.girrafeecstud.vk_services_list.domain.usecase.GetServicesListUseCase
import com.girrafeecstud.vk_services_list.presentation.ServicesViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [AppModule.AppBindModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideServicesApi(retrofit: Retrofit): ServicesApi = retrofit.create(ServicesApi::class.java)

    @Singleton
    @Provides
    fun provideGetServicesUseCase(repository: ServicesRepository) =
        GetServicesListUseCase(repository = repository)

    @Module
    interface AppBindModule {

        @Singleton
        @Binds
        fun bindVkServiceListDtoMapper(impl: VkServiceListDtoMapper): ListMapper<VkServiceDto, VkService>

        @Singleton
        @Binds
        fun bindServicesDataSourceImpl(impl: ServicesDataSourceImpl): ServicesDataSource

        @Singleton
        @Binds
        fun bindServicesRepositoryImpl(impl: ServicesRepositoryImpl): ServicesRepository

        @Singleton
        @Binds
        @ViewModelKey(ServicesViewModel::class)
        @IntoMap
        fun bindServicesViewModel(impl: ServicesViewModel): ViewModel
    }

}