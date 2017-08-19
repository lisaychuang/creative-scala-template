import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

// To use this example, open the SBT console and type:
//
// Example.image.draw
object Example {
  val image = circle(10).fillColor(Color.red) on circle(20) on circle(30)

  def main(args: Array[String]): Unit = {
    image.draw
  }
}


// ANOTHER EXAMPLE, REMOVE THE // BEFORE THE CODE

// object Example {
//  (circle(100) fillColor Color.paleGoldenrod lineColor Color.indianRed).draw
// }
