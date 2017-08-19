import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

// EXAMPLE 1: open the SBT console and type:
// Example.image.draw

// object Example {
//  val image = circle(10).fillColor(Color.red) on circle(20) on circle(30)

//  def main(args: Array[String]): Unit = {
//    image.draw
//  }
// }


// EXAMPLE 4.2 Coding Outside the Console

// object Example {
//  (circle(100) fillColor Color.paleGoldenrod lineColor Color.indianRed).draw
// }

// EXAMPLE 4.5 Packages and Imports
package example {

object One {
  val one = 1
}

object Two {
  val two = 2
}

object Three {
  val three = 3
}
}