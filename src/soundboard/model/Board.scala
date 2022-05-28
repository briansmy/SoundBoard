package soundboard.model

import java.io.File
import javax.sound.sampled.Clip
import javax.sound.sampled.{AudioInputStream, AudioSystem}

class Board {

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
