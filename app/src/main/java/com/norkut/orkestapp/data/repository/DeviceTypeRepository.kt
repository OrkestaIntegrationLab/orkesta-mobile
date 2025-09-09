package com.norkut.orkestapp.data.repository

import com.norkut.orkestapp.common.network.ApiProvider
import com.norkut.orkestapp.data.api.DeviceTypeService
import com.norkut.orkestapp.data.mapper.toDomain
import com.norkut.orkestapp.domain.model.DeviceType
import com.norkut.orkestapp.domain.repository.IDeviceTypeRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeviceTypeRepository @Inject constructor(apiProvider: ApiProvider) : IDeviceTypeRepository {
    private val api = apiProvider.getService(DeviceTypeService::class.java, isProduction = false)

    override suspend fun getAllDeviceTypes(): List<DeviceType> = withContext(Dispatchers.IO) {
        val response = api.getDeviceTypes(
            idDeviceType = -1,
            deviceType = "",
            abreviature = "",
            indActive = -1
        )
        response.map { it.toDomain() }
    }

}