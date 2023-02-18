package com.girrafeecstud.vk_services_list.data.repository

import com.girrafeecstud.vk_services_list.data.datasource.ServicesDataSource
import com.girrafeecstud.vk_services_list.domain.base.BusinessResult
import com.girrafeecstud.vk_services_list.domain.entity.VkService
import com.girrafeecstud.vk_services_list.domain.repository.ServicesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ServicesRepositoryImpl @Inject constructor(
    private val dataSource: ServicesDataSource
) : ServicesRepository {

    override fun getServices(): Flow<BusinessResult<List<VkService>>> =
        dataSource.getServices().flowOn(Dispatchers.IO)

}