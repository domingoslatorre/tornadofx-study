import tornadofx.App
import tornadofx.View
import tornadofx.borderpane
import tornadofx.launch

class MasterViewInjectFind: View() {
    val topView = find(TopView::class)
    val bottomView: BottomView by inject()

    override val root = borderpane {
        top = topView.root
        bottom = bottomView.root
    }
}

class MyAppInjectFind : App(MasterView::class)

fun main(args: Array<String>) {
    launch<MyAppInjectFind>(args)
}