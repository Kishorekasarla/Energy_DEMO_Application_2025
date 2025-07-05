package com.infmenergy.ui.screens.login

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infmenergy.data.repository.login.LoginRepository
import com.infmenergy.navigation.Screen
import com.infmenergy.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginScreenViewModel @Inject constructor(private val repo: LoginRepository) : ViewModel() {

    private val loginStatus: MutableState<DataState<Boolean>?> = mutableStateOf(null)

    fun login(userName: String, password: String) {

        val emailValid = isEmailValid(userName)
        val passwordValid = isPasswordValid(password)

        if (emailValid && passwordValid) {
            viewModelScope.launch {
                delay(2000)

            }
        } else {
            if (!emailValid) {
                // Show an error message for invalid email format
                Log.d("TAG", "Invalid email");
            }
            if (!passwordValid) {
                // Show an error message for invalid password format
                Log.d("TAG", "Invalid password");
            }
        }



        viewModelScope.launch {
            repo.login(userName, password).onEach {

                loginStatus.value = it

            }.launchIn(viewModelScope)
        }
    }

    fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
        return emailRegex.matches(email)
    }

    fun isPasswordValid(password: String): Boolean {

        val passwordRegex = Regex("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\S+\$).{8,}")
        return passwordRegex.matches(password)


    }

}


