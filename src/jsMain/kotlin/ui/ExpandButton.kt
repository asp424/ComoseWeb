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
    type: Int = 1,
    collector: (Int) -> Unit
) = with(mutableStateOf(false)) {
    Button({
        onClick {
            iterator(if(type == 0) (0 .. size) else (0 until size), 50) { i ->
                collector(if (value) i else size - i)
                if (i == size) value = !value
            }
        }
    }) { Text("Expand") }
}
