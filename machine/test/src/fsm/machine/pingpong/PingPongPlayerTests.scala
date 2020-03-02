package fsm.machine.pingpong

import fsm.machine.ContextPrefs._
import utest._

object PingPongPlayerTests extends TestSuite {

  // can specify 'ac' context explicitly. helpful since cask uses castor too.
  private val pp = new PingPongPlayer(java.time.Duration.ofMillis(20))//(ContextPrefs.ac)

  val tests = Tests {
    test("pingpong") {
      assert(pp.initialState == pp.Idle())

      pp.send(Ping())
      Thread.sleep(200)
      assert(pp.state == pp.Waiting()) // straight away?? NO!!

      // state machine hasn't finished yet, running in the background
      ac.waitForInactivity()
      // now state machine has finished

      // final state?? after return from remote player??

    } // test.pingpong

  } // tests
} // PingPongPlayerTests