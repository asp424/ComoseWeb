package ui

import androidx.compose.runtime.Composable
import data.fetchJoke
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
fun CoroutineScope.fetchButton(response: (String) -> Unit) = Button({
    style { marginRight(5.px) }
    onClick { launch { fetchJoke.collect { response(it) } } }
}) { Text("Fetch") }