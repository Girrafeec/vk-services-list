package com.girrafeecstud.vk_services_list.data.network.dto

import com.google.gson.annotations.SerializedName

data class VkServiceListDto(
    @SerializedName("items")
    val services: List<VkServiceDto>
)