import javafx.collections.FXCollections
import tornadofx.App
import tornadofx.Controller
import tornadofx.View
import tornadofx.label
import tornadofx.launch
import tornadofx.listview
import tornadofx.vbox

class MyItensController : Controller() {
    val values = FXCollections.observableArrayList("Alpha", "Beta", "Gamma", "Delta")
}

class MyItensBindView : View() {
    val controller: MyItensController by inject()

    override val root = vbox {
        label("My itens")
        listview(controller.values)
    }
}

class MyItensBindApp : App(MyItensBindView::class)

fun main(args: Array<String>) {
    launch<MyItensBindApp>(args)
}