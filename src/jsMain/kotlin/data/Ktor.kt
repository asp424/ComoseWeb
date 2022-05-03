package data

import utils.JOKE_URL
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.flow.flow

private val client by lazy { HttpClient() }

val fetchJoke get() = flow {
    runCatching { client.get(JOKE_URL).bodyAsText() }
        .onSuccess { emit(it) }.onFailure { emit(it.message ?: "Error") }
}