package com.norkut.orkestapp.domain.repository

import com.norkut.orkestapp.domain.model.DeviceType

interface IDeviceTypeRepository {
    suspend fun getAllDeviceTypes(): List<DeviceType>
}