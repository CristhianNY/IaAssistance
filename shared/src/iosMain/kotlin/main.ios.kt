import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import di.ShareModule
import navigation.RootComponent
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController {
    val root = remember { RootComponent(DefaultComponentContext(LifecycleRegistry())) }
    App(root)
}

fun initKoin() {
    startKoin {
        modules(ShareModule().module)
    }
}