package com.girrafeecstud.vk_services_list.domain.usecase

import com.girrafeecstud.vk_services_list.domain.base.BusinessResult
import com.girrafeecstud.vk_services_list.domain.entity.VkService
import com.girrafeecstud.vk_services_list.domain.repository.ServicesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetServicesListUseCase @Inject constructor(
    private val repository: ServicesRepository
) {
    operator fun invoke(): Flow<BusinessResult<List<VkService>>> =
        repository.getServices().flowOn(Dispatchers.IO)
}