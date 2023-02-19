package com.girrafeecstud.vk_services_list.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel : ViewModel() {

    private var _state = MutableStateFlow<UiState>(UiState.IsLoading(isLoading = true))

    val state = _state.asStateFlow()

    protected fun setLoading() {
        _state.update {
            UiState.IsLoading(isLoading = true)
        }
    }

    protected fun hideLoading() {
        _state.update {
            UiState.IsLoading(isLoading = false)
        }
    }

    protected fun setError(data: Any?) {
        _state.update {
            UiState.Error(data = data)
        }
    }

    protected open fun destroyComponent() {}

    protected open fun closeConnection() {}

}