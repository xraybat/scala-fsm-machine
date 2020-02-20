import fsm.machine.pingpong._
import fsm.machine._
 
object Main {
  def main(args: Array[String]): Unit = {
    // can specify 'ac' context specifically. helpful since cask uses castor too.
    val pp = new PingPongPlayer(java.time.Duration.ofMillis(20))(ContextPrefs.ac)
  }
}