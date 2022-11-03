import androidx.compose.ui.window.Window
import com.seanproctor.crew.common.App
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        Window("Demo") {
            App()
        }
    }
}
