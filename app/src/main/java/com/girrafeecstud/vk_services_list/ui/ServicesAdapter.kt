package com.girrafeecstud.vk_services_list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.girrafeecstud.vk_services_list.databinding.ServiceItemBinding
import com.girrafeecstud.vk_services_list.domain.entity.VkService

class ServicesAdapter(
    private val listener: ServicesViewHolder.OnServiceItemClickListener
) : RecyclerView.Adapter<ServicesViewHolder>() {

    private var services = ArrayList<VkService>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val binding = ServiceItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ServicesViewHolder(binding)
    }

    override fun getItemCount() = services.size

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.bind(service = services.get(position), listener = listener)
    }

    fun refreshServices(services: List<VkService>) {
        this.services = ArrayList(services)
        notifyDataSetChanged()
    }

}