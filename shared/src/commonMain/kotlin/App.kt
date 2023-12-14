import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.RootComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import screens.HomeScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        val childStack by rootComponent.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when (val instance = child.instance) {
                is RootComponent.Child.ScreenLogin -> LoginScreen(instance.component)
                is RootComponent.Child.ScreenHome -> HomeScreen(instance.component)
            }
        }
    }
}


expect fun getPlatformName(): String