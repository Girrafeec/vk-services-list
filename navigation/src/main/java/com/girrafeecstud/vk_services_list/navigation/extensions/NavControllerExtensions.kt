package com.girrafeecstud.vk_services_list.navigation.extensions

import androidx.navigation.NavController
import com.girrafeecstud.vk_services_list.navigation.destination.NavigationDestination

object NavControllerExtensions {

    fun NavController.setStartDestination(
        destination: NavigationDestination,
        graphId: Int
    ) {
        val graph = this.navInflater.inflate(graphId)
        graph.setStartDestination(destination.destinationId)
        this.graph = graph
    }

}