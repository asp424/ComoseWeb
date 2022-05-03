package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import utils.iterator

@Composable
fun CoroutineScope.expandButton(
    size: Int,
    collector: (Int) -> Unit
) = with(mutableStateOf(false)) {
    Button({
        onClick {
            iterator((0..size), 50) { i ->
                collector(if (value) i else size - i)
                if (i == size) value = !value
            }
        }
    }) { Text("Expand") }
}
