package com.girrafeecstud.vk_services_list.presentation

import androidx.lifecycle.viewModelScope
import com.girrafeecstud.vk_services_list.domain.usecase.GetServicesListUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ServicesViewModel @Inject constructor(
    private val getServicesListUseCase: GetServicesListUseCase
) : BaseViewModel() {

    val services = getServicesListUseCase()
        .onStart {
            setLoading()
        }
        .onCompletion {
            hideLoading()
        }
        .shareIn(scope = viewModelScope, started = SharingStarted.Lazily, replay = 1)

}