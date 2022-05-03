package ui

import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Img
import utils.counter
import utils.PHOTO_URL

@Composable
fun SnapshotStateList<Boolean>.photosRow() = onEachIndexed { i, _ ->
    remember { mutableStateOf(50.px) }.apply {
        var resize by remember { mutableStateOf(false) }
        value = resize.counter(0, 50).px
        if (!get(i)) resize = false
        get(i).counter(0, 100).also { int ->
            Img(PHOTO_URL, attrs = {
                style { width(int.px + value); height(int.px + value); marginLeft(5.px) }
                onClick { resize = !resize }
            })
        }
    }
}