package ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthState
import data.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepo: AuthRepository): ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState


    sealed class AuthState {
        object Idle: AuthState()
        object Loading: AuthState()
        data class Success(val userId: String): AuthState()
        data class Error(val message: String): AuthState()
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            when (val result = authRepo.login(email, password)) {
                is AuthRepository.AuthResult.Success -> {
                    _authState.value = AuthState.Success(result.data)
                }
                is AuthRepository.AuthResult.Error -> {
                    _authState.value = AuthState.Error(result.exception.message ?: "Errror desconocido.")
                }
            }
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            when (val result = authRepo.register(email, password)) {
                is AuthRepository.AuthResult.Success -> {
                    _authState.value = AuthState.Success(result.data)
                }

                is AuthRepository.AuthResult.Error -> {
                    _authState.value = AuthState.Error(result.exception.message ?: "Error al registrarse.")
                }
            }
        }
    }
}