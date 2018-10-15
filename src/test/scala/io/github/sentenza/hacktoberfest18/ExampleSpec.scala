package io.github.sentenza.hacktoberfest18

import org.scalatest.{Assertion, Matchers, WordSpec}

class  ExampleSpec extends WordSpec with Matchers {
  "The Example class" should {
    "return 42 when asking for meaning()" in {
      Example.meaning() shouldEqual 42
    }
  }
}
