package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import utils.counter

@Composable
fun CoroutineScope.expandButton(size: Int, collector: (Int) -> Unit) = with(mutableStateOf(false)) {
    Button({
        onClick {
            launch {
                (0..size).asFlow().onEach { i -> if (i != 0) delay(50) }
                    .collect { i ->
                        collector(if (value) i else size - i)
                        if (i == size) value = !value
                    }
            }
        }
    }) { Text("Expand") }
}


