package com.example.koinspike

import kotlinx.coroutines.flow.Flow

interface RandomNumberDataSource {

    suspend fun getRandomNumber() : Flow<Int>
}