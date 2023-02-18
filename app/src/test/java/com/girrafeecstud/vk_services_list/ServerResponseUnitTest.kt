package com.girrafeecstud.vk_services_list

import com.girrafeecstud.vk_services_list.data.datasource.ServicesDataSource
import com.girrafeecstud.vk_services_list.data.datasource.ServicesDataSourceImpl
import com.girrafeecstud.vk_services_list.data.network.api.ServicesApi
import com.girrafeecstud.vk_services_list.data.network.mapper.VkServiceListDtoMapper
import com.girrafeecstud.vk_services_list.domain.base.BusinessResult
import com.girrafeecstud.vk_services_list.domain.entity.VkService
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader

class ServerResponseUnitTest {

    private lateinit var servicesDataSource: ServicesDataSource

    private lateinit var servicesApi: ServicesApi

    private lateinit var mapper: VkServiceListDtoMapper

    private lateinit var mockWebServer: MockWebServer

    private lateinit var okHttpClient: OkHttpClient

    @Before
    fun setUp() {
        okHttpClient = OkHttpClient.Builder().build()
        mockWebServer = MockWebServer()
        servicesApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ServicesApi::class.java)

        mapper = VkServiceListDtoMapper()
        servicesDataSource = ServicesDataSourceImpl(
            api = servicesApi,
            mapper = mapper
        )
    }

    @Test
    fun `WHEN services request is 200 OK EXPECT service entities list`() =
        runBlocking {
            mockWebServer.enqueueResponse(
                fileName = "ServicesListJson.json",
                code = 200
            )
            val expectedResult = TestData.services

            var actualResult: List<VkService>? = null

            servicesDataSource.getServices()
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

            //Request received by the mock server
            mockWebServer.takeRequest()

            assertEquals(expectedResult, actualResult)
        }

    @After
    fun shutDown() {
        mockWebServer.shutdown()
    }

}