package com.example.koinspike

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel(){

    private var _uiState = MutableStateFlow(MainState(4))
    val uiState: StateFlow<MainState> = _uiState.asStateFlow()

}