package com.example.koinspike

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getRandomNumberUseCase: GetRandomNumberUseCase) : ViewModel() {

    private var _uiState = MutableStateFlow(MainState(0))
    val uiState: StateFlow<MainState> = _uiState.asStateFlow()

    private var getNumberJob: Job? = null

    init {
        getNewNumber()
    }

    fun getNewNumber() {
        getNumberJob?.cancel()
        getNumberJob = viewModelScope.launch {
            getRandomNumberUseCase.getRandomNumber().collect {
                _uiState.value = MainState(it)
            }
        }
    }

}