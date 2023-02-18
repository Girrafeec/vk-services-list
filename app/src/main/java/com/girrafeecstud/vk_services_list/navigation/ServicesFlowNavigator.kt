package com.girrafeecstud.vk_services_list.navigation

import androidx.navigation.NavController
import com.girrafeecstud.vk_services_list.R
import com.girrafeecstud.vk_services_list.ServicesFlowDirections
import com.girrafeecstud.vk_services_list.navigation.extensions.NavControllerExtensions.setStartDestination

class ServicesFlowNavigator : Navigator<ServicesFlowDestination> {

    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun navigateToDestination(destination: ServicesFlowDestination) {
        when (destination) {
            is ServicesFlowDestination.ServicesFragment -> {
                navController?.navigate(
                    ServicesFlowDirections.actionServicesFragment()
                )
            }
            is ServicesFlowDestination.ServiceDetailsFragment -> {
                navController?.navigate(
                    ServicesFlowDirections.actionServiceDetailsFragment(destination.serviceDetails)
                )
            }
        }
    }

    override fun setStartDestination(destination: ServicesFlowDestination) {
        navController?.setStartDestination(
            destination = destination, graphId = R.navigation.services_flow
        )
    }
}