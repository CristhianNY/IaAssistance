package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class ScreenLoginComponent(
    componentContext: ComponentContext,
    private val onNavigateToScreenB: (String) -> Unit
) : ComponentContext by componentContext {

    private var _text = MutableValue("")
    val text: Value<String> = _text

    fun onEvent(event: ScreenLoginEvent) {
        when (event) {
            ScreenLoginEvent.ClickButtonLogin -> onNavigateToScreenB(text.value)
            is ScreenLoginEvent.UpdateText -> event.text
        }
    }
}