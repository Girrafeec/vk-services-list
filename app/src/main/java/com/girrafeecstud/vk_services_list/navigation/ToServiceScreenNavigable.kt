package com.girrafeecstud.vk_services_list.navigation

import com.girrafeecstud.vk_services_list.navigation.ToScreenNavigable

interface ToServiceScreenNavigable : ToScreenNavigable<ServicesFlowDestination> {
    override fun navigateToScreen(destination: ServicesFlowDestination)
}