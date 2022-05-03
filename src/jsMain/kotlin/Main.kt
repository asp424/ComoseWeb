import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import ui.expandButton
import ui.fetchButton
import ui.photosRow

fun main() {
    val items = 8
    renderComposable("root") {
        rememberCoroutineScope().apply {
            Div({ style { paddingTop(200.px); paddingLeft(100.px); } }) {

                with(remember {
                    mutableStateListOf<Boolean>().apply { (0..items).onEach { add(false) } }
                }) {
                    P {
                        expandButton(items) { this@with[it] = !this@with[it] }
                        photosRow()
                    }
                }

                remember { mutableStateOf("responseHolder") }.apply {
                    P {
                        fetchButton { value = it }
                        Text(value)
                    }
                }
            }
        }
    }
}













