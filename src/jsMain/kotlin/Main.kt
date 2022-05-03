import androidx.compose.runtime.*
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
    val items = 5
    val map = mutableStateListOf<Boolean>().apply { (0..items).onEach { add(false) } }
    renderComposable("root") {
        val coroutine = rememberCoroutineScope()
        var responseText by remember { mutableStateOf("responseHolder") }

        Div({ style { paddingTop(200.px); paddingLeft(100.px); } }) {

            P {
                coroutine.expandButton(items - 1) { map[it] = !map[it] }
                map.photosRow()
            }

            P {
                coroutine.fetchButton { responseText = it }
                Text(responseText)
            }

        }
    }
}












