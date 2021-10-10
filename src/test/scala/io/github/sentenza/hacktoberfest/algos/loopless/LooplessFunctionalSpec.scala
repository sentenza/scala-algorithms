package io.github.sentenza.hacktoberfest.algos.loopless

import io.github.sentenza.hacktoberfest.algos.loopless.LooplessFunctional._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class LooplessFunctionalSpec extends AnyWordSpec with Matchers {

  "Loopless Functional algorithms" should {

    "concatenate nested lists" in {
      val nested       = List(List(1, 2), List(3), List(4, 5, 6), List.empty, List(7, 8))
      val concatenated = (1 to 8).toList

      concat(nested) shouldBe concatenated

    }

  }

}
