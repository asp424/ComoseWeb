package utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

fun CoroutineScope.iterator(
    array: IntRange,
    delay: Long,
    result: (Int) -> Unit
) = launch(Dispatchers.Default) {
    array.asFlow()
        .flowOn(Dispatchers.Default)
        .onEach { delay(delay) }
        .collect { result(it) }
}

@Composable
fun handleIterator(
    array: IntRange,
    start: Boolean,
    delay: Long = 5,
    step: Int = 2
) = remember { mutableStateOf(array.first) }.apply {
    LaunchedEffect(start) {
        iterator(array, delay) {
            if (start) {
                if (value < array.last) value += step
            } else
                if (value > array.first) value -= step
        }
    }
}.value
