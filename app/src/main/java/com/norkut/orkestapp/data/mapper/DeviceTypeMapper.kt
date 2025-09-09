package com.norkut.orkestapp.data.mapper

import com.norkut.orkestapp.data.dto.DeviceTypeDto
import com.norkut.orkestapp.domain.model.DeviceType

fun DeviceTypeDto.toDomain(): DeviceType =
    DeviceType(idDeviceType = idDeviceType,
               deviceTypeName = deviceTypeName,
                abreviature = abreviature,
               indActive = indActive)