package fsm.machine

// *qu:* single context for multiple state machine actors??
object ContextPrefs {
  implicit val ac = new castor.Context.Test()
}