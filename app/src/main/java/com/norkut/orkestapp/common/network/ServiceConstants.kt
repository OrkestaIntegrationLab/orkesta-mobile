package com.norkut.orkestapp.common.network

import com.norkut.orkestapp.data.api.DeviceTypeService
import kotlin.jvm.java

object ServiceConstants {

    fun<Api> findApi(api: Class<Api>, isProduction: Boolean): ServiceConfig {
        return if (isProduction) productionApis(api) else devApis(api)
    }

    private fun productionApis(api: Class<*>): ServiceConfig {
        return when (api) {
            DeviceTypeService::class.java -> ServiceConfig("24025", "sec-authe/")
            else -> throw ClassNotFoundException("Must be a declared class")
        }
    }

    private fun devApis(api: Class<*>): ServiceConfig {
        return when (api) {
            DeviceTypeService::class.java -> ServiceConfig("5227")
            else -> throw ClassNotFoundException("Must be a declared class")
        }
    }


}

data class ServiceConfig(
    val port: String,
    val suffix: String = ""
)