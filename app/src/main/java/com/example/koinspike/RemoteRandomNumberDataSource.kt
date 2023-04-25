package com.example.koinspike

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class RemoteRandomNumberDataSource : RandomNumberDataSource{

    override suspend fun getRandomNumber(): Flow<Int> = flow {
        emit(15)
    }

}