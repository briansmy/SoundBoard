package soundboard.model

import org.tsers.zeison.Zeison

import java.io.{File, FileInputStream, InputStream}
import javax.sound.sampled.Clip
import javax.sound.sampled.{AudioInputStream, AudioSystem}
import org.tsers.zeison.Zeison._
import play.api.libs.json.JsValue
import soundboard.view.SoundButton

import scala.io.Source

class Board {

  var boardName: String = "Blank"
  var boardSize: (Int, Int) = (0, 0)
  var boardSounds = List.empty[SoundButton]

  // TODO make change to this.boardSize
  def init(): Unit = {
    val preferences: JValue = getPreferences
    val layout: JValue = getLayout(preferences.layout.toStr)
    this.boardName = layout.name.toStr
    //this.boardSounds = getSounds(this.boardName)
  }

  // Gets preferences as a JValue
  def getPreferences: JValue = {
    val file: File = new File("Settings/preferences.json")
    val inputStream: InputStream = new FileInputStream(file)
    val preferences: JValue = parse(inputStream)
    preferences
  }

  //
  def getLayout(lname: String): JValue = {
    val path: String = "Settings/Layouts/" + lname + ".json"
    val file: File = new File(path)
    val inputStream: InputStream = new FileInputStream(file)
    val layout: JValue = parse(inputStream)
    layout
  }

  // Create SoundButton objects from this.layout
  def layoutButtons(layout: JValue): Unit = {
    ???
  }

  def soundPressed(filename: String): Unit = {
    val path = "Sounds/" + filename
    val file: File = new File(path).getAbsoluteFile
    val audioInputStream: AudioInputStream = AudioSystem.getAudioInputStream(file)
    val clip: Clip = AudioSystem.getClip()
    clip.open(audioInputStream)
    clip.stop()
    clip.start()
  }


}
