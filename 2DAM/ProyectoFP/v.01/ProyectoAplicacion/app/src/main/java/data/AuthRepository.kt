package data

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class AuthRepository {
    private val auth = Firebase.auth

    sealed class AuthResult<T> {
        data class Success<T>(val data: T): AuthResult<T>()
        data class Error<T>(val exception: Exception): AuthResult<T>()
    }

    suspend fun login(email: String, password: String): AuthResult<String> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            AuthResult.Success(result.user?.uid ?: "")
        } catch (e: Exception) {
            AuthResult.Error(e)
        }
    }

    suspend fun register(email: String, password: String): AuthResult<String> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            AuthResult.Success(result.user?.uid ?: "")
        } catch (e: Exception) {
            AuthResult.Error(e)
        }
    }
}

