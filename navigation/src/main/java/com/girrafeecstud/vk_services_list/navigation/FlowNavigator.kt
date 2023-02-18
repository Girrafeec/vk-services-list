package com.girrafeecstud.vk_services_list.navigation

import androidx.navigation.NavController
import com.girrafeecstud.vk_services_list.navigation.destination.FlowDestination
import com.girrafeecstud.vk_services_list.navigation.extensions.NavControllerExtensions.setStartDestination

class FlowNavigator : Navigator<FlowDestination> {

    // TODO Inject navController to FlowNavigator
    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun navigateToDestination(destination: FlowDestination) {
        when (destination) {
            is FlowDestination.ServicesFlow -> {
                navController?.navigate(
                    MainNavFlowDirections
                        .actionGlobalServicesFlow()
//                        .setDefaultScreen(destination.defaultScreen as DefaultMapsFlowScreen)
                )
            }
        }
    }

    override fun setStartDestination(destination: FlowDestination) {
        navController?.setStartDestination(
            destination = destination, graphId = R.navigation.main_nav_flow
        )
    }

}