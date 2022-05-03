package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import org.jetbrains.compose.web.css.px
import utils.handleIterator

@Composable
fun SnapshotStateList<Boolean>.animatedItems() = repeat(size) {
    remember { mutableStateOf(false) }.apply {
        image(
            handleIterator((0 until 100), get(it).also { e -> if (!e) value = false }).px,
            handleIterator((0 until 50), value).px
        )
    }
}

