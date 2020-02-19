import fsm.machine.pingpong._
import fsm.machine.ContextPrefs._
 
object Main {
  def main(args: Array[String]): Unit = {
    val pp = new PingPong(java.time.Duration.ofMillis(20))

    assert(pp.initialState == pp.Server())

    pp.send(Ping())
    Thread.sleep(200)

    // state machine hasn't finished yet, running in the background
    ac.waitForInactivity()
    // now state machine has finished

    assert(pp.state == pp.Server())

  } // main
} // Main