import javafx.beans.property.SimpleStringProperty
import tornadofx.App
import tornadofx.Controller
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.fieldset
import tornadofx.form
import tornadofx.field
import tornadofx.launch
import tornadofx.textfield

class MyController : Controller() {
    fun writeToDb(inputValue: String) {
        println("Writing $inputValue to database.")
    }
}

class MyView2 : View() {
    val controller: MyController by inject()
    val input = SimpleStringProperty()

    override val root = form {
        fieldset {
            field("Input") {
                textfield(input)
            }

            button("Save") {
                action {
                    controller.writeToDb(input.value)
                    input.value = ""
                }
            }
        }
    }
}

class MyApp2 : App(MyView2::class)

fun main(args: Array<String>) {
    launch<MyApp2>(args)
}