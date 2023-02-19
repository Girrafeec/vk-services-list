package com.girrafeecstud.vk_services_list.presentation

sealed class UiState {
    class IsLoading(val isLoading: Boolean): UiState()
    class Error(val data: Any?): UiState()
}