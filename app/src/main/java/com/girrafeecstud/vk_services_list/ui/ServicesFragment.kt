package com.girrafeecstud.vk_services_list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.girrafeecstud.vk_services_list.databinding.ServicesFragmentBinding
import com.girrafeecstud.vk_services_list.di.AppComponent
import com.girrafeecstud.vk_services_list.domain.base.BusinessResult
import com.girrafeecstud.vk_services_list.domain.entity.VkService
import com.girrafeecstud.vk_services_list.navigation.ServicesFlowDestination
import com.girrafeecstud.vk_services_list.navigation.ToServiceScreenNavigable
import com.girrafeecstud.vk_services_list.presentation.ServicesViewModel
import com.girrafeecstud.vk_services_list.presentation.UiState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ServicesFragment :
    BaseFragment(),
    ServicesViewHolder.OnServiceItemClickListener {

    private var _binding: ServicesFragmentBinding? = null

    private val binding get() = _binding!!

    private val servicesViewModel: ServicesViewModel by viewModels {
        AppComponent.appComponent.viewModelFactory()
    }

    private val servicesAdapter = ServicesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ServicesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecView()
    }

    override fun registerObservers() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                servicesViewModel.state
                    .onEach { state ->
                        when (state) {
                            is UiState.IsLoading -> {
                                handleLoading(isLoading = state.isLoading)
                            }
                            is UiState.Error -> {}
                        }
                    }
                    .launchIn(lifecycleScope)
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                servicesViewModel.services
                    .onEach { result ->
                        when (result) {
                            is BusinessResult.Success -> {
                                result._data?.let { services ->
                                    servicesAdapter.refreshServices(services = services)
                                }
                            }
                            is BusinessResult.Error -> {
                                Toast.makeText(requireActivity().applicationContext, result.errorType.name, Toast.LENGTH_SHORT).show()
                            }
                            is BusinessResult.Exception -> {
                                Toast.makeText(requireActivity().applicationContext, result.exceptionType.name, Toast.LENGTH_SHORT).show()
                            }
                        }

                    }
                    .launchIn(lifecycleScope)
            }
        }
    }

    override fun handleLoading(isLoading: Boolean) {
        when (isLoading) {
            true -> {
                binding.servicesRecView.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            }
            false -> {
                binding.servicesRecView.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    override fun handleError(any: Any?) {

    }

    override fun onServiceItemClickListener(service: VkService, serviceImage: View) {
        (parentFragment?.parentFragment as ToServiceScreenNavigable)
            .navigateToScreen(destination = ServicesFlowDestination.ServiceDetailsFragment(serviceDetails = service))
    }

    private fun initRecView() {
        binding.servicesRecView.let { services ->
            services.adapter = servicesAdapter
            services.layoutManager = LinearLayoutManager(
                requireActivity().applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }

}