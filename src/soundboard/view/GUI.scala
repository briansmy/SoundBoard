package soundboard.view

import javafx.event.{ActionEvent, EventHandler}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.ObjectProperty
import scalafx.scene.Scene
import scalafx.scene.control.{CustomMenuItem, Menu, MenuBar, MenuItem}
import scalafx.scene.layout.{BorderPane, GridPane, StackPane}
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import soundboard.model.{Board, PlaySound}


object GUI extends JFXApp {

  val board: Board = new Board()

  val sound1: SoundButton = new SoundButton("1", new PlaySound(board, filename = "vine_boom.wav"))
  val sound2: SoundButton = new SoundButton("2", new PlaySound(board, filename = "Bruh Sound Effect #2.wav"))
  val sound3: SoundButton = new SoundButton("3", new PlaySound(board, filename = "tiktok_snore.wav"))

  //--- Menus and Menu Items ---
  val newItem: MenuItem = new MenuItem("New") {

  }
  val addItem: MenuItem = new MenuItem("Add Clip") {
    //TODO add file to Sounds directory
  }
  val closeItem: MenuItem = new MenuItem("Close") {
    //TODO close window on click
  }
  val fileMenu: Menu = new Menu("File") {
    items = List(newItem, addItem, closeItem)
  }

  val preferencesItem: MenuItem = new MenuItem("Preferences") {
    //TODO open and edit a preferences file
  }
  val editMenu: Menu = new Menu("Edit") {
    items = List(preferencesItem)
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
          menus.add(editMenu)
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
