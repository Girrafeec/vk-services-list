package com.girrafeecstud.vk_services_list.data.datasource

import com.girrafeecstud.vk_services_list.domain.base.BusinessResult
import com.girrafeecstud.vk_services_list.domain.entity.VkService
import kotlinx.coroutines.flow.Flow

interface ServicesDataSource {
    fun getServices(): Flow<BusinessResult<List<VkService>>>
}