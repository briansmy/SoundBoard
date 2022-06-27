package soundboard.view

import javafx.event.{ActionEvent, EventHandler}
import javafx.scene.control
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.{Alert, Button, ButtonType, ContextMenu, MenuItem}

class SoundButton(name: String,
              action: EventHandler[ActionEvent],
              xScale: Double = 1.0,
              yScale: Double = 1.0,
              textSize: Double = 12.0) extends Button {
  val baseWidth = 90
  val baseHeight = 60

  this.minWidth = baseWidth * xScale
  this.minHeight = baseHeight * yScale
  this.text = name
  this.style = "-fx-font: " + textSize.toString + " arial;"

  this.onAction = action

  val editItem: MenuItem = new MenuItem("Edit") {
    onAction = (t: ActionEvent) => {
      new Alert(AlertType.Information) {
        title = "Edit Button"
        headerText = "Hello"
        contentText = "Hello Again"
      }.showAndWait()
    }
  }
  val deleteItem: MenuItem = new MenuItem("Delete") {
    onAction = (t: ActionEvent) => {
      val result = new Alert(AlertType.Confirmation) {
        title = "Delete Button"
        headerText = "Are you sure you would like to delete this button?"
        buttonTypes = Seq(ButtonType.Yes, ButtonType.No)
      }.showAndWait()
      result match {
        case Some(ButtonType.Yes) => null //Remove sound from button
        case Some(ButtonType.No)  => null
      }
    }
  }

  this.contextMenu = new ContextMenu(editItem) {
    items ++= ObservableBuffer(deleteItem)
  }
}
