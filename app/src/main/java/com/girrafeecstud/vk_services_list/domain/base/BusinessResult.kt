package com.girrafeecstud.vk_services_list.domain.base

import com.girrafeecstud.vk_services_list.base.ExceptionType

sealed class BusinessResult<out T> {
    data class Success<out R> (val _data: R?): BusinessResult<R> ()
    data class Error (val errorType: BusinessErrorType): BusinessResult<Nothing> ()
    data class Exception (val exceptionType: ExceptionType): BusinessResult<Nothing> ()
}
