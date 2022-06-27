package soundboard.model

import javafx.event.{ActionEvent, EventHandler}
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import soundboard.model.Board

class PlaySound(board: Board, filename: String) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    board.soundPressed(filename)
  }
}
