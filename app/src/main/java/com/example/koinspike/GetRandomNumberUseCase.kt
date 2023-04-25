package com.example.koinspike

import kotlinx.coroutines.flow.Flow

class GetRandomNumberUseCase(
    private val randomNumberRepository: RandomNumberRepository
) {

    suspend fun getRandomNumber(): Flow<Int> =  randomNumberRepository.getRandomNumber()

}