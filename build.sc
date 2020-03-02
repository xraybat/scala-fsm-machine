import mill._, scalalib._, publish._

object machine extends ScalaModule with PublishModule {
  def artifactName = "fsm-machine"
  def scalaVersion = "2.13.1"
  def publishVersion = "0.0.1"

  def ivyDeps = Agg(
    ivy"com.lihaoyi::castor:0.1.1",
    ivy"com.lihaoyi::pprint:0.5.9",
  )

  def pomSettings = PomSettings(
    description = "fsm-machine",
    organization = "au.com.carringbushsw",
    url = "https://github.com/xraybat/scala-fsm-machine",
    licenses = Seq(License.MIT),
    versionControl = VersionControl.github("xraybat", "scala-fsm-machine"),
    developers = Seq(
      Developer("xraybat", "xraybat","https://github.com/xraybat")
    )
  )

  object test extends Tests {
    def testFrameworks = Seq("utest.runner.Framework")

    def ivyDeps = Agg(
      ivy"com.lihaoyi::utest::0.7.3",
    )
  }
}
