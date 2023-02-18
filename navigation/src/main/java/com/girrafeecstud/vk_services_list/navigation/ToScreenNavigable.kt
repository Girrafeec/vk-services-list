package com.girrafeecstud.vk_services_list.navigation

interface ToScreenNavigable <in NavigationDestination> {
    fun navigateToScreen(destination: NavigationDestination)
}