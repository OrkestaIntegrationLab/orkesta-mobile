package com.norkut.orkestapp.data.api

import com.norkut.orkestapp.data.dto.DeviceTypeDto
import retrofit2.http.GET
import retrofit2.http.Query

interface DeviceTypeService {
    @GET("DeviceType")
    suspend fun getDeviceTypes(
        @Query("idDeviceType") idDeviceType: Int,
        @Query("deviceType") deviceType: String,
        @Query("abreviature") abreviature: String,
        @Query("indActive") indActive: Int
    ): List<DeviceTypeDto>
}