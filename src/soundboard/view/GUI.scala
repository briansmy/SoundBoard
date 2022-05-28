package soundboard.view

import javafx.event.{ActionEvent, EventHandler}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.ObjectProperty
import scalafx.scene.Scene
import scalafx.scene.control.{Menu, MenuBar, MenuItem}
import scalafx.scene.layout.{BorderPane, GridPane, StackPane}
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import soundboard.model.{Board, PlayAction}


object GUI extends JFXApp {

  val board: Board = new Board()

  val sound1: SoundButton = new SoundButton("1", new PlayAction(board, filename = "airhorn.wav"))
  val sound2: SoundButton = new SoundButton("2", new PlayAction(board, filename = "Bruh Sound Effect #2.wav"))
  val sound3: SoundButton = new SoundButton("3", new PlayAction(board, filename = "child_yay.wav"))

  //--- Menus and Menu Items ---
  val closeItem: MenuItem = new MenuItem("Close") {

  }

  val fileMenu: Menu = new Menu("File") {
    items = List(closeItem)
  }
  //----- End Menu Section -----

  stage = new PrimaryStage {
    title.value = "Sound Board"
    scene = new Scene() {
      fill = LightGreen
      root = new BorderPane {
        top = new MenuBar {
          useSystemMenuBar = true
          minWidth = 100
          menus.add(fileMenu)
          menus.add(new Menu("Edit"))
          menus.add(new Menu("View"))
        }
        center = new GridPane {
          add(sound1, 0, 0)
          add(sound2, 1, 0)
          add(sound3, 2, 0)
        }
      }
    }
  }

}