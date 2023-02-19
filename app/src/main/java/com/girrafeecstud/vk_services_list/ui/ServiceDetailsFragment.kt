package com.girrafeecstud.vk_services_list.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.girrafeecstud.vk_services_list.databinding.ServiceDetailsFragmentBinding
import com.girrafeecstud.vk_services_list.navigation.ServicesFlowDestination
import com.girrafeecstud.vk_services_list.navigation.ToServiceScreenNavigable
import com.girrafeecstud.vk_services_list.ui.extension.loadAndSetImage

class ServiceDetailsFragment : BaseFragment() {

    private val args: ServiceDetailsFragmentArgs by navArgs()

    private var _binding: ServiceDetailsFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ServiceDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadServiceDetails()
    }

    override fun setListeners() {

        binding.serviceLinkBtn.setOnClickListener { openUrl(url = args.serviceDetails.serviceUrl) }

        val backPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                (parentFragment?.parentFragment as ToServiceScreenNavigable)
                    .navigateToScreen(destination = ServicesFlowDestination.ServicesFragment())
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, backPressedCallback)
        binding.returnBack.setOnClickListener { requireActivity().onBackPressed() }
    }

    private fun loadServiceDetails() {
        args.serviceDetails.let { service ->
            binding.serviceName.text = service.serviceName
            binding.serviceDescription.text = service.serviceDescription
            binding.serviceImage.loadAndSetImage(url = service.serviceIconUrl)
        }
    }

    private fun openUrl(url: String) {
        val uri = Uri.parse(url)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
}