package com.girrafeecstud.vk_services_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.girrafeecstud.vk_services_list.domain.base.BusinessResult
import com.girrafeecstud.vk_services_list.domain.usecase.GetServicesListUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

class ServicesViewModel @Inject constructor(
    private val getServicesListUseCase: GetServicesListUseCase
) : ViewModel() {

    val services = getServicesListUseCase()
        .shareIn(scope = viewModelScope, started = SharingStarted.Lazily, replay = 1)

}