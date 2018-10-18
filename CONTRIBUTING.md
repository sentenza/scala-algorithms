**Please keep in mind that this is a work in progress. Sections will be added over time.**

## Contributions

All contributions are welcome. By contributing, you accept to give the
terms and conditions of the GNU GENERAL PUBLIC LICENSE v3, as explained
in [LICENSE](LICENSE). 

The licenses for most software and other practical works are designed
to take away your freedom to share and change the works.  By contrast,
the GNU General Public License is intended to guarantee your freedom to
share and change all versions of a program--to make sure it remains free
software for all its users.

## Style guide

Your code must look like that:

```scala
package io.github.sentenza.hacktoberfest18
package mypackage

import scala.util.{ Try, Success, Failure }
// do not be afraid of wildcards
import scala.collection.immutable._

/**
 * First sentence ending with a period.
 *
 * Then next paragraph.
 * And a second line.
 *
 * And so on.
 */
class Foo[Cool <: Bar](
  foo: String,
  bar: String
) extends WordSpec with Matchers {

  val longList = List(
    1,
    "foo"
  )

  val list: List[Any] = List(1, "foo")

  def baz(toto: Int, titi: String = "bazinga")(implicit ev: Show[Int]): Unit = {
    ???
  }

  list.filter(! _.isEmpty).map(s => s.toString.toUppercase).flatMap { s => ??? }

  // that's an inline comment helpful when reading the code
  // there could be several lines too!
  // TODO no really, do it some day
  list
    .filter(! _.isEmpty)
    .map(s => s.toString.toUppercase)
    .flatMap { s =>
      ???
    }
    .collect {
      case somethingMuchLongerThatDidntFitPreviousLine if ??? =>
        // notice the indentation
        ???
    }

  // that's a more general comment, not really attached to the very
  // next line of code, more like a section of code

  list.foldLeft(0) { (acc, i) => acc + i }

  list.foldLeft(0)(_ + _)
  
  list.collect { case Blah("blah", x) if x.isEmpty => ??? }

}

/** A much shorter comment, just one line. */
class Foo2[Bar <: Baz](foo: String, bar: String)(implicit someth: AnyTh[Int]) {

}

/** If you need more that one line, all parameters go on their own line. */
class Foo3[Sweet <: Cool](
  foo: String,
  bar: String,
  baz: String
)(implicit
  someth: AnyTh[String]
) {

}

/** Extending classes and traits */
class Foo4[Sweet <: Cool](foo: String, bar: String)(implicit someth: Anyth[MyClass])
extends Class1 with Trait2 {

}
```

### Notes

* the style is subject to change as we learn or need to refine
* new code must follow this standard
* older code should be refactored as it gets worked on
* tools (e.g. scalariform) could help and that's the goal, but it's not there yet

### Credits and inspiration

* http://docs.scala-lang.org/style/
* unwritten shapeless coding style e.g. [generic.scala](https://github.com/milessabin/shapeless/blob/master/core/src/main/scala/shapeless/generic.scala)
* [Banana RDF](https://github.com/banana-rdf/banana-rdf/)
