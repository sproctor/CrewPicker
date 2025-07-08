import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.seanproctor.crew.common.App
import com.seanproctor.crew.common.data.CardDataSource
import com.seanproctor.crew.common.data.CardRepository
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val cardDataSource = CardDataSource()
    val cardRepository = CardRepository(cardDataSource)
    ComposeViewport(document.body!!) {
        App(cardRepository)
    }
}
