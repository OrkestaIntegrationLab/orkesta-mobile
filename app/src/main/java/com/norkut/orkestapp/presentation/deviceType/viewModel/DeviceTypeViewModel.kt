package com.norkut.orkestapp.presentation.deviceType.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.norkut.orkestapp.domain.model.DeviceType
import com.norkut.orkestapp.domain.repository.IDeviceTypeRepository
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeviceTypeViewModel @Inject constructor(

    private val repository: IDeviceTypeRepository
) : ViewModel()  {

    private val _deviceTypes = MutableStateFlow<List<DeviceType>>(emptyList())
    val deviceTypes: StateFlow<List<DeviceType>> = _deviceTypes

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchDeviceTypes()
    }

    private fun fetchDeviceTypes() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val result = repository.getAllDeviceTypes()
                _deviceTypes.value = result
            } catch (e: Exception) {
                _error.value = e.message ?: "Error desconocido"
            } finally {
                _isLoading.value = false
            }
        }
    }

}