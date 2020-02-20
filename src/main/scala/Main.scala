import fsm.machine.pingpong._
import fsm.machine.ContextPrefs._
 
object Main {
  def main(args: Array[String]): Unit = {
    val pp = new PingPongPlayer(java.time.Duration.ofMillis(20))
  }
}