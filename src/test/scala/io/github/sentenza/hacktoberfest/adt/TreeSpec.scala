package io.github.sentenza.hacktoberfest.adt

import org.scalatest.{Matchers, WordSpec}
import io.github.sentenza.hacktoberfest.adt.{Branch => B, Leaf => L}

class TreeSpec extends WordSpec with Matchers {
  "A Tree" should {
    "have a size() method to compute its size" in {
      val testTree = Branch(
        Branch(Leaf("a"), Leaf("b")),
        Branch(Leaf("c"), Leaf("d"))
      )
      Tree.size(testTree) shouldBe 7
    }

    "have a depth() method to compute its depth" in {
      val testTree = Branch(
        Branch(Leaf("a"), Leaf("b")),
        Branch(Leaf("c"), Leaf("d"))
      )
      Tree.depth(testTree) shouldBe 2
    }

    "have a map() method to replace the tree values" in {
      val testTree = Branch(
        Branch(Leaf(1), Leaf(3)),
        Branch(Leaf(2), Leaf(4))
      )
      Tree.map(testTree, (x: Int) => x + 1) shouldBe Branch(
        Branch(Leaf(2), Leaf(4)),
        Branch(Leaf(3), Leaf(5))
      )
    }
  }

  "Tree.depth()" should {
    val treeD1 = B(L("x"), L("y"))
    val treeD2 = B(L("z"), B(L("t"), L("r")))
    val treeD3 = B(L("zero"), treeD2)

    "be 1 when there's only a single branch" in {
      Tree.depth(treeD1) shouldBe 1
    }

    "be 2 when there is a root branch attached to another branch" in {
      Tree.depth(treeD2) shouldBe 2
    }

    "be 3 when the depth of Tree is Three" in {
      Tree.depth(treeD3) shouldBe 3
    }

    "be 0 for a Leaf" in {
      Tree.depth(L("leaf")) shouldBe 0
    }

    "return the sum of depths for a Tree of Trees" in {
      val t = B(
        L(1),
        treeD2
      )
      Tree.depth(t) shouldBe 3
    }

    "be 5 for a Tree with 5 Branches deep" in {
      val treeD5 = Branch( // 1
        L("left leaf == 0"),
        Branch( // 2
          treeD1,
          treeD3
        )
      )
      Tree.depth(treeD5) shouldBe 5
    }
  }

  "Tree.map()" should {
    "work when there's only a Leaf" in {
      Tree.map(Leaf(1), (x: Int) => x * 2) shouldBe Leaf(2)
    }

    "be independent of the tree depth" in {
      Tree.map(
        Branch(Branch(Branch(Leaf(1), Leaf(2)), Leaf(3)), Leaf(4)),
        (x: Int) => x - 1
      ) shouldBe Branch(Branch(Branch(Leaf(0), Leaf(1)), Leaf(2)), Leaf(3))
    }

    "work across types" in {
      Tree.map(
        Branch(Leaf(1), Branch(Leaf(2), Leaf(3))),
        (x: Int) => x * Math.PI
      ) shouldBe Branch(Leaf(Math.PI), Branch(Leaf(2 * Math.PI), Leaf(3 * Math.PI)))
    }
  }

  "A Tree" should {
    "have a map() method to compute applying an function to its values" in {
      val testTree = Branch[String](
        Branch[String](Leaf[String]("amazon"), Leaf[String]("blue")),
        Branch[String](Leaf[String]("cream"), Leaf[String]("dungeon"))
      )

      Tree.map(testTree, (v: String) => v.charAt(0)) shouldBe Branch[Char](
        Branch[Char](Leaf[Char]('a'), Leaf[Char]('b')),
        Branch[Char](Leaf[Char]('c'), Leaf[Char]('d'))
      )

      Tree.map(testTree, (v: String) => v.size) shouldBe Branch[Int](
        Branch[Int](Leaf[Int](6), Leaf[Int](4)),
        Branch[Int](Leaf[Int](5), Leaf[Int](7))
      )
    }
  }
}
