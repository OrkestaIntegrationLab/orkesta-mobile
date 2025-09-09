package com.norkut.orkestapp.domain.model

data class DeviceTypeFilter(
    val idDeviceType: Int  = -1,
    val deviceTypeName: String = "",
    val abreviature: String= "" ,
    val indActive: Boolean = false
)
