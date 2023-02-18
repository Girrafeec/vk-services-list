package com.girrafeecstud.vk_services_list.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.girrafeecstud.vk_services_list.R
import com.girrafeecstud.vk_services_list.databinding.ActivityMainBinding
import com.girrafeecstud.vk_services_list.navigation.DefaultServicesFlowScreen
import com.girrafeecstud.vk_services_list.navigation.FlowNavigator
import com.girrafeecstud.vk_services_list.navigation.ToFlowNavigable
import com.girrafeecstud.vk_services_list.navigation.destination.FlowDestination

class MainActivity : AppCompatActivity(), ToFlowNavigable {

    private lateinit var binding: ActivityMainBinding

    private val navigator = FlowNavigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        val navController = navHostFragment.navController

        navigator.setNavController(navController)

        navigator.setStartDestination(
            destination = FlowDestination.ServicesFlow(
                _defaultScreen = DefaultServicesFlowScreen.SERVICES_SCREEN
            )
        )
    }

    override fun navigateToScreen(destination: FlowDestination) {
        navigator.navigateToDestination(destination = destination)
    }
}