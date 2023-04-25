package com.example.koinspike

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class LocalRandomNumberDataSource :RandomNumberDataSource{
    override suspend fun getRandomNumber(): Flow<Int> = flow {
        emit(Random.nextInt(1,10))
    }
}