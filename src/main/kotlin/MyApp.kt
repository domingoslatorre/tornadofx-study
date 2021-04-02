import tornadofx.App
import tornadofx.View
import tornadofx.button
import tornadofx.label
import tornadofx.launch
import tornadofx.vbox

class MyView : View() {
    override val root = vbox {
        button("Press me")
        label("Waiting")
    }
}

class MyApp : App(MyView::class)

fun main(args: Array<String>) {
    launch<MyApp>(args)
}