package com.girrafeecstud.vk_services_list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.girrafeecstud.vk_services_list.R
import com.girrafeecstud.vk_services_list.databinding.ServicesFlowFragmentBinding
import com.girrafeecstud.vk_services_list.navigation.ServicesFlowDestination
import com.girrafeecstud.vk_services_list.navigation.ServicesFlowNavigator
import com.girrafeecstud.vk_services_list.navigation.ToServiceScreenNavigable

class ServicesFlowFragment :
    BaseFlowFragment(R.id.nav_host_services_fragment_container),
    ToServiceScreenNavigable {

    private var _binding: ServicesFlowFragmentBinding? = null

    private val binding get() = _binding!!

    private val navigator = ServicesFlowNavigator()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ServicesFlowFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUpNavigation() {
        navigator.setNavController(navController = navController)
        navigator.setStartDestination(destination = ServicesFlowDestination.ServicesFragment())
    }

    override fun navigateToScreen(destination: ServicesFlowDestination) {
        navigator.navigateToDestination(destination = destination)
    }
}