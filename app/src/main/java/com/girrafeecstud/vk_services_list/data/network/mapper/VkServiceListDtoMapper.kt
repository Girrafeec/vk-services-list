package com.girrafeecstud.vk_services_list.data.network.mapper

import com.girrafeecstud.vk_services_list.base.ListMapper
import com.girrafeecstud.vk_services_list.data.network.dto.VkServiceDto
import com.girrafeecstud.vk_services_list.data.network.dto.VkServiceListDto
import com.girrafeecstud.vk_services_list.domain.entity.VkService

class VkServiceListDtoMapper : ListMapper<VkServiceDto, VkService> {
    override fun map(input: List<VkServiceDto>): List<VkService> =
        input.map { dto ->
            VkService(
                dto.serviceName,
                dto.serviceDescription,
                dto.serviceIconUrl,
                dto.serviceUrl
            )
        }
}