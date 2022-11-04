import androidx.compose.ui.window.Window
import com.seanproctor.common.data.WebResourceReader
import com.seanproctor.crew.common.App
import com.seanproctor.crew.common.data.CardDataSource
import com.seanproctor.crew.common.data.CardRepository
import kotlinx.coroutines.Dispatchers
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        val cardDataSource = CardDataSource(WebResourceReader(Dispatchers.Default))
        val cardRepository = CardRepository(cardDataSource)
        Window("Demo") {
            App(cardRepository)
        }
    }
}
