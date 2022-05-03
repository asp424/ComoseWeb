package utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import org.jetbrains.compose.web.css.px

@Composable
fun Boolean.counter(min: Int, max: Int) = remember { mutableStateOf(min) }.apply {
    LaunchedEffect(this@counter) {
        (min until max).asFlow().flowOn(Dispatchers.Default).onEach { delay(5) }.collect {
            if (this@counter) {
                if (value < max) value += 2
            } else if (value > min) {
                value -= 2
            }
        }
    }
}.value