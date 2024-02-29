import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.seanproctor.common.data.WebResourceReader
import com.seanproctor.crew.common.App
import com.seanproctor.crew.common.data.CardDataSource
import com.seanproctor.crew.common.data.CardRepository
import kotlinx.coroutines.Dispatchers
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        val cardDataSource = CardDataSource(WebResourceReader(Dispatchers.Default))
        val cardRepository = CardRepository(cardDataSource)
        CanvasBasedWindow("Demo") {
            App(cardRepository)
        }
    }
}
