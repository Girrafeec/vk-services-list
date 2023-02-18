package com.girrafeecstud.vk_services_list.navigation

import com.girrafeecstud.vk_services_list.R
import com.girrafeecstud.vk_services_list.domain.entity.VkService
import com.girrafeecstud.vk_services_list.navigation.destination.NavigationDestination

sealed class ServicesFlowDestination(
    private val _destinationId: Int
) : NavigationDestination {

    override val destinationId: Int
        get() = _destinationId

    class ServicesFragment(
    ) : ServicesFlowDestination(_destinationId = R.id.services_fragment)

    class ServiceDetailsFragment(
        val serviceDetails: VkService
    ) : ServicesFlowDestination(_destinationId = R.id.service_details_fragment)

}
