package com.girrafeecstud.vk_services_list.navigation

import com.girrafeecstud.vk_services_list.navigation.destination.FlowDestination

interface ToFlowNavigable : ToScreenNavigable<FlowDestination> {
    override fun navigateToScreen(destination: FlowDestination)
}