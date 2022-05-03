package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Img
import utils.PHOTO_URL

@Composable
fun MutableState<Boolean>.image(addPx: CSSpxValue, size: CSSpxValue)
= Img(PHOTO_URL,
    attrs = {
        style {
            width(size + addPx)
            height(size + addPx)
            marginLeft(5.px)
        }; onClick { value = !value }
    })