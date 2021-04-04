import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.App
import tornadofx.Controller
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.field
import tornadofx.fieldset
import tornadofx.form
import tornadofx.label
import tornadofx.launch
import tornadofx.listview
import tornadofx.textfield
import tornadofx.vbox

class MyItensController : Controller() {
    val values = FXCollections.observableArrayList("Alpha", "Beta", "Gamma", "Delta")
    fun addToList(value: String) = run { values.add(value) }
}

class MyItensBindView : View() {
    val controller: MyItensController by inject()
    val input = SimpleStringProperty()

    override val root = vbox {
        form {
            fieldset {
                field("Input") {
                    textfield(input)
                }

                button("Add") {
                    action {
                        controller.addToList(input.value)
                        input.value = ""
                    }
                }
            }
        }
        label("My itens")
        listview(controller.values)
    }
}

class MyItensBindApp : App(MyItensBindView::class)

fun main(args: Array<String>) {
    launch<MyItensBindApp>(args)
}