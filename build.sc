import mill._, scalalib._

object machine extends ScalaModule{
  def scalaVersion = "2.13.1"
  def ivyDeps = Agg(
    ivy"com.lihaoyi::castor:0.1.1",
    ivy"com.lihaoyi::pprint:0.5.9",
  )
  object test extends Tests{
    def testFrameworks = Seq("utest.runner.Framework")

    def ivyDeps = Agg(
      ivy"com.lihaoyi::utest::0.7.3",
    )
  }
}
