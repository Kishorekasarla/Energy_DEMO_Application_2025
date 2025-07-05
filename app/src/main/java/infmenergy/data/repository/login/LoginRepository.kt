package com.infmenergy.data.repository.login

import com.infmenergy.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepository  @Inject constructor() : LoginRepositoryInterface {

    override suspend fun login(userName: String, password: String): Flow<DataState<Boolean>> = flow{
          emit(DataState.Loading)
            try {
                delay(2000)
                emit(DataState.Success(true))

            } catch (e: Exception) {
                emit(DataState.Error(e))
            }


    }
}