package io.github.sentenza.hacktoberfest.algos.strings

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class StringUtilSpec extends AnyWordSpec with Matchers {

  "String util functions" should {
    "solve anagrams" when {
      case class Case(first: String, second: String, result: Boolean)
      val cases =
        // list from https://en.wikipedia.org/wiki/Anagram
        Case("evil", "vile", result = true) ::
          Case("a gentleman", "elegant man", result = true) ::
          Case("eleven plus two", "twelve plus one", result = true) ::
          Case("restful", "fluster", result = true) ::
          Case("funeral", "real fun", result = false) :: // additional whitespaces are not ignored
          Case("funeral", "realfun", result = true) ::
          Case("forty five", "over fifty", result = true) ::
          Case("Santa", "Satan", result = true) ::
          Case("listen", "silent", result = true) ::
          Case("listen", "silen", result = false) ::  // missing char
          Case("listen", "silenx", result = false) :: // changed char
          Case("listen", "silenn", result = false) :: // changed char but appearing
          Nil

      cases.foreach { c =>
        val testText = if (c.result) s"${c.first} = ${c.second}" else s"${c.first} != ${c.second}"
        testText in {
          StringUtil.checkAnagrams(c.first, c.second) shouldBe c.result
        }
      }
    }
  }
}
