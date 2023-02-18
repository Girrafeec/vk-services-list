package com.girrafeecstud.vk_services_list.ui

import androidx.recyclerview.widget.RecyclerView
import com.girrafeecstud.vk_services_list.databinding.ServiceItemBinding
import com.girrafeecstud.vk_services_list.domain.entity.VkService
import com.girrafeecstud.vk_services_list.ui.extension.loadAndSetImage

class ServicesViewHolder(
    private val binding: ServiceItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    private fun bindServiceItem(service: VkService, listener: OnServiceItemClickListener) {
        binding.serviceImage.loadAndSetImage(url = service.serviceIconUrl)
        binding.serviceName.text = service.serviceName

        binding.serviceItem.setOnClickListener {
            listener.onServiceItemClickListener(service = service)
        }
    }

    fun bind(service: VkService, listener: OnServiceItemClickListener) {
        bindServiceItem(service = service, listener = listener)
    }

    interface OnServiceItemClickListener {
        fun onServiceItemClickListener(service: VkService)
    }

}