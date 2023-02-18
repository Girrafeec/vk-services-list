package com.girrafeecstud.vk_services_list.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VkService(
    val serviceName: String,
    val serviceDescription: String,
    val serviceIconUrl: String,
    val serviceUrl: String
) : Parcelable
