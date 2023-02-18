package com.girrafeecstud.vk_services_list.data.datasource

import com.girrafeecstud.vk_services_list.base.ExceptionType
import com.girrafeecstud.vk_services_list.data.network.api.ServicesApi
import com.girrafeecstud.vk_services_list.data.network.mapper.VkServiceListDtoMapper
import com.girrafeecstud.vk_services_list.domain.base.BusinessErrorType
import com.girrafeecstud.vk_services_list.domain.base.BusinessResult
import com.girrafeecstud.vk_services_list.domain.entity.VkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class ServicesDataSourceImpl @Inject constructor(
    private val api: ServicesApi,
    private val mapper: VkServiceListDtoMapper
) : ServicesDataSource {

    override fun getServices(): Flow<BusinessResult<List<VkService>>> =
        flow {

            try {
                val response = api.getServices()

                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    val resList = mapper.map(input = responseBody.services)
                    emit(BusinessResult.Success(_data = resList))
                    return@flow
                }
                emit(BusinessResult.Error(errorType = BusinessErrorType.WRONG_DATA))
            } catch (e: SocketTimeoutException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            } catch (exception: IOException) {
                exception.printStackTrace()
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }

        }.flowOn(Dispatchers.IO)
}