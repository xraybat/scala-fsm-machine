package fsm.machine.pingpong

import fsm.machine.ContextPrefs._
import utest._

object PingPongTests extends TestSuite {

  private val pp = new PingPong(java.time.Duration.ofMillis(20))

  val tests = Tests {
    test("pingpong") {
      assert(pp.initialState == pp.Server())

      pp.send(Ping())
      Thread.sleep(200)
      assert(pp.state == pp.Server())

      pp.send(Ping())
      Thread.sleep(200)

      // state machine hasn't finished yet, running in the background
      ac.waitForInactivity()
      // now state machine has finished

      // final state
      assert(pp.state == pp.Server())

    } // test.pingpong

  } // tests
} // PingPongTests