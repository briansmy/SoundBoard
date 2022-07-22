package tests

import org.scalatest.FunSuite
import org.tsers.zeison.Zeison.JValue
import soundboard.model.Board

class json extends FunSuite {

  test("getPreferences") {
    val board: Board = new Board()
    val layout: String = board.getPreferences.layout.toStr
    assert(layout == "default")
  }

  test("getLayout") {
    val board: Board = new Board()
    val lname: String = "default"
    val layout: JValue = board.getLayout(lname)
    assert(layout.name.toStr == "default")
  }

}
