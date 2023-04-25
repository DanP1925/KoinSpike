package com.example.koinspike

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEmpty
import java.lang.Exception

class RandomNumberRepository(
    private val remoteDataSource: RandomNumberDataSource,
    private val localDataSource: RandomNumberDataSource,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getRandomNumber(): Flow<Int> = flow {
        remoteDataSource.getRandomNumber().collect { remoteNumber  ->
            if (remoteNumber> 10) {
                localDataSource.getRandomNumber().collect {
                    emit(it)
                }
            }
        }
    }.flowOn(ioDispatcher)

}