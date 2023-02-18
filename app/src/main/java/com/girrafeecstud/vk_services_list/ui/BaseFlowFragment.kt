package com.girrafeecstud.vk_services_list.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

abstract class BaseFlowFragment constructor(
    @IdRes private val navHostFragmentId: Int
) : Fragment() {

    private var _navController: NavController? = null

    protected val navController get() = _navController!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment

        _navController = navHostFragment.navController

        setUpNavigation()
        setListeners()
    }

    protected open fun setUpNavigation() {}

    protected open fun setListeners() {}
}