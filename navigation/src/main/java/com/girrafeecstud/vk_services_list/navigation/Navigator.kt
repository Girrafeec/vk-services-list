package com.girrafeecstud.vk_services_list.navigation

interface Navigator<in NavigationDestination> {

    fun navigateToDestination(destination: NavigationDestination)

    fun setStartDestination(destination: NavigationDestination)

}