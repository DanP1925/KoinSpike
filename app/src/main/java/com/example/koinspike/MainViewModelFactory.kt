package com.example.koinspike

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers

class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                GetRandomNumberUseCase(
                    RandomNumberRepository(
                        RemoteRandomNumberDataSource(),
                        LocalRandomNumberDataSource(),
                        Dispatchers.IO
                    )
                )
            ) as T
        } else {
            throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
        }
    }

}