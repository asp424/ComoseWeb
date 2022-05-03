package ui

import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
fun CoroutineScope.expandButton(size: Int, collector: (Int) -> Unit) =
    Button({
        var state = false
        onClick {
            launch {
                (0..size).asFlow().onEach { i -> if (i != 0) delay(50) }
                    .collect { i ->
                        collector(if (state) i else size - i)
                        if (i == size) state = !state
                    }
            }
        }
    }) { Text("Expand") }