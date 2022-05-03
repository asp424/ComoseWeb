package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlinx.coroutines.CoroutineScope
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import utils.iterator

@Composable
fun SnapshotStateList<Boolean>.expandButton(
    size: Int,
    scope: CoroutineScope,
    type: Int = 1
) = with(mutableStateOf(false)) {
    Button({
        onClick {
            scope.iterator(if (type == 0) (0..size) else (0 until size), 50) { i ->
                if (value) this@expandButton[i] = !this@expandButton[i]
                else this@expandButton[size - i] = !this@expandButton[size - i]
                if (i == size) value = !value
            }
        }
    }) { Text("Expand") }
}
