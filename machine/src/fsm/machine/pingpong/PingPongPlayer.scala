package fsm.machine.pingpong

import pprint._

// *note:* message != state; msg -> state-machine -> state
// *note:* we control msg structure in full
sealed trait Msg
case class Ping() extends Msg
//case class Pong() extends Msg   // QU??: only do pings from local->remote??

class PingPongPlayer  // as fsm-actor
  (flightTime: java.time.Duration)
  (implicit ac: castor.Context)
    extends castor.StateMachineActor[Msg] {

  def initialState = Idle()         // *note:* not an override
  override def state = super.state  // for debugging only;

  case class Idle() extends State({
    case Ping() =>
      // now have to send a Ping() to remote fsm via remote-ip/ping
      // and schedule a state change here loclly
      //no: ac.scheduleMsg(this, Ping(), flightTime)
      //requests("remote-ip/ping")
      Waiting()

  }) // Idle
  
  case class Waiting() extends State({
    case Ping() =>
      // QU??: how much time did it take??
      Idle()
      
  }) // Waiting

  // for debugging only
  override def run(msg: Msg): Unit = {
    pprint.log(s"$state $msg", tag="pre:")
    super.run(msg)
    pprint.log(s"$state", tag="post:")
  }
} // PingPongPlayer