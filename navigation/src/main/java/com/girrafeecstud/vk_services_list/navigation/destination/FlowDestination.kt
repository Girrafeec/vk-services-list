package com.girrafeecstud.vk_services_list.navigation.destination

import com.girrafeecstud.vk_services_list.navigation.DefaultServicesFlowScreen
import com.girrafeecstud.vk_services_list.navigation.DefaultFlowScreen
import com.girrafeecstud.vk_services_list.navigation.R

sealed class FlowDestination(
    private val _destinationId: Int,
    val defaultScreen: DefaultFlowScreen? = null
) : NavigationDestination {

    override val destinationId: Int
        get() = _destinationId

    class ServicesFlow(
        _defaultScreen: DefaultServicesFlowScreen =
            DefaultServicesFlowScreen.SERVICES_SCREEN
    ) : FlowDestination(
        _destinationId = R.id.services_flow,
        defaultScreen = _defaultScreen
    )

}
