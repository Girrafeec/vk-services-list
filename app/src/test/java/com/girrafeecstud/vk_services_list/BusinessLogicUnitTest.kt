package com.girrafeecstud.vk_services_list

import com.girrafeecstud.vk_services_list.domain.base.BusinessResult
import com.girrafeecstud.vk_services_list.domain.entity.VkService
import com.girrafeecstud.vk_services_list.domain.repository.ServicesRepository
import com.girrafeecstud.vk_services_list.domain.usecase.GetServicesListUseCase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class BusinessLogicUnitTest {

    private lateinit var getServicesListUseCase: GetServicesListUseCase

    private lateinit var repository: ServicesRepository

    @Before
    fun setUp() {
        repository = mock()
        getServicesListUseCase = GetServicesListUseCase(
            repository = repository
        )
    }

    @Test
    fun `WHEN call getServicesListUseCase() EXPECT VkService entities list`() =
        runBlocking {
            val expextedResult = TestData.services

            var actualResult: List<VkService>? = null

            whenever(
                repository.getServices()
            ).thenReturn(
                flow {
                    emit(BusinessResult.Success(_data = TestData.services))
                }
            )

            getServicesListUseCase()
                .collect { result ->
                    when(result) {
                        is BusinessResult.Success -> {
                            actualResult = result._data
                        }
                        is BusinessResult.Error -> {

                        }
                        is BusinessResult.Exception -> {

                        }
                    }
                }

            assertEquals(expextedResult, actualResult)
        }

}