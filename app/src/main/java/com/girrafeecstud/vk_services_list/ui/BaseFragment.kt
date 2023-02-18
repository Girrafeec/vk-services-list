package com.girrafeecstud.vk_services_list.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        registerObservers()
    }

    protected open fun registerObservers() {}

    protected open fun handleLoading(isLoading: Boolean) {}

    protected open fun handleSuccess(any: Any?) {}

    protected open fun handleError(any: Any?) {}

    protected open fun setListeners() {}

}