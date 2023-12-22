package io.github.sentenza.hacktoberfest.adt

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class QueueSpec extends AnyWordSpec with Matchers {
  val fiboQueue: Queue[Int] = Queue(13, 21, 34, 55, 89, 144, 233)
  "A Queue" should {
    "return its first element when using head()" in {
      fiboQueue.head shouldBe 13
      val q1 = Queue("x", "y", "z")
      q1.head shouldBe "x"
    }

    "return the amount of elements when using size()" in {
      fiboQueue.size shouldBe 7
    }

    "return a List of its elements when calling toList()" in {
      fiboQueue.toList shouldBe a[List[_]]
      fiboQueue.toList shouldBe List(13, 21, 34, 55, 89, 144, 233)
    }

    "have a tail method that returns a new Queue without its head" in {
      fiboQueue.tail shouldBe a[Queue[_]]
      fiboQueue.tail.equals(Queue(21, 34, 55, 89, 144, 233))
      fiboQueue.tail.tail.tail.tail.tail.tail.head shouldBe 233
    }

    "return a new Queue on enqueue()" in {
      val q1 = Queue(13)
      val q2 = q1.enqueue(21)
      val q3 = q2.enqueue(44).enqueue(77)
      q3 shouldBe a[Queue[_]]
      val qChar = Queue(Symbol("a")).enqueue(Symbol("b"))
      qChar shouldBe a[Queue[_]]
      q2.equals(Queue(13, 77, 21))
    }

    "test for emptiness using isEmpty" in {
      fiboQueue.isEmpty shouldBe false
      Queue().isEmpty shouldBe true
      Queue("x").isEmpty shouldBe false
    }

    "test for non-emptiness using nonEmpty" in {
      fiboQueue.nonEmpty shouldBe true
      Queue().nonEmpty shouldBe false
      val q1 = Queue(2, 3, 4)
      q1.tail.tail.nonEmpty shouldBe true
      q1.tail.tail.tail.nonEmpty shouldBe false
    }
  }
}
