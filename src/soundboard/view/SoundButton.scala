package soundboard.view

import javafx.event.{ActionEvent, EventHandler}
import scalafx.scene.control.Button

class SoundButton(name: String,
                  action: EventHandler[ActionEvent],
                  xScale: Double = 1.0,
                  yScale: Double = 1.0,
                  textSize: Double = 12.0) extends Button {
  val baseWidth = 90
  val baseHeight = 60

  this.minWidth = baseWidth * xScale
  this.minHeight = baseHeight * yScale
  this.onAction = action
  this.text = name
  this.style = "-fx-font: " + textSize.toString + " arial;"
}
