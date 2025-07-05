package com.infmenergy.data.repository.login

import com.infmenergy.utils.DataState
import kotlinx.coroutines.flow.Flow

interface LoginRepositoryInterface {
    suspend fun login(userName : String, password : String): Flow<DataState<Boolean>>
}