package com.girrafeecstud.vk_services_list.data.network.api

import com.girrafeecstud.vk_services_list.data.network.config.ServiceApiConfig
import com.girrafeecstud.vk_services_list.data.network.dto.VkServiceListDto
import retrofit2.Response
import retrofit2.http.GET

interface ServicesApi {

    @GET(ServiceApiConfig.servicesUrl)
    suspend fun getServices(): Response<VkServiceListDto>

}