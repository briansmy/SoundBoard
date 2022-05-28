package soundboard.model

import javafx.event.{ActionEvent, EventHandler}
import soundboard.model.Board

class PlayAction(board: Board, filename: String) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    board.soundPressed(filename)
  }
}
