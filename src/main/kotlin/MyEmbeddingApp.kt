import tornadofx.App
import tornadofx.View
import tornadofx.borderpane
import tornadofx.label
import tornadofx.launch


class TopView : View() {
    override val root = label("Top View")
}

class BottomView : View() {
    override val root = label("Bottom View")
}

class MasterView: View() {
    override val root = borderpane {
        top<TopView>()
        bottom<BottomView>()
    }
}

class MyEmbeddingApp : App(MasterView::class)

fun main(args: Array<String>) {
    launch<MyEmbeddingApp>(args)
}