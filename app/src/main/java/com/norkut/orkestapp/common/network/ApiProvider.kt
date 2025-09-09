package com.norkut.orkestapp.common.network

import javax.inject.Inject


class ApiProvider @Inject constructor(
    private val apiFactory: ApiServiceFactory
){
    fun <Api> getService(apiClass: Class<Api>, isProduction: Boolean): Api {
        val cfg = ServiceConstants.findApi(apiClass, isProduction)
        val baseUrl = "http://10.0.2.2:${cfg.port}/${cfg.suffix}"
        return apiFactory.create(apiClass, baseUrl)
    }
}