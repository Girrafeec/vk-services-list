package com.girrafeecstud.vk_services_list.data.network.dto

import com.google.gson.annotations.SerializedName

data class VkServiceDto(
    @SerializedName("name")
    val serviceName: String,
    @SerializedName("description")
    val serviceDescription: String,
    @SerializedName("icon_url")
    val serviceIconUrl: String,
    @SerializedName("service_url")
    val serviceUrl: String
)
