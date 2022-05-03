package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import org.jetbrains.compose.web.css.px
import utils.handleIterator

@Composable
fun SnapshotStateList<Boolean>.photosRow() = repeat(size) { i ->

    remember{ mutableStateOf(false) }.apply {

        handleIterator((0 until 50), value).px.also { addPx ->

            handleIterator((0 until 100), get(i)

                .apply { if (!this) value = false }).px

                .also { int -> image(addPx, int) }
        }
    }
}
