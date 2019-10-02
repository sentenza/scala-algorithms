**Please keep in mind that this is a work in progress. Sections will be added over time.**

## Contributions

All contributions to this project are **very welcome**. By contributing, you accept to give the
terms and conditions of the GNU GENERAL PUBLIC LICENSE v3, as explained
in [LICENSE](LICENSE). 

The licenses for most software and other practical works are designed
to take away your freedom to share and change the works.  By contrast,
the GNU General Public License is intended to guarantee your freedom to
share and change all versions of a program--to make sure it remains free
software for all its users.

## Semantic Git commit messages
Please use following commit message format.

* chore (boring tasks etc; no production code change) -> ```git test -m 'chore: commit-message-here'```
* docs (changes to documentation) -> ```git commit -m 'docs: commit-message-here'```
* feat (new feature) -> ```git commit -m 'feat: commit-message-here'```
* fix (bug fix) -> ```git commit -m 'fix: commit-message-here'```
* refactor (refactoring production code) -> ```git commit -m 'refactor: commit-message-here'```
* style (formatting, missing semi colons, etc; no code change) -> ```git commit -m 'style: commit-message-here'```
* test (adding missing tests, refactoring tests; no production code change) -> ```git test -m 'refactor: commit-message-here'```

Inspired by Sparkbox's awesome article on [semantic commit messages](http://seesparkbox.com/foundry/semantic_commit_messages). 

### Commit contents guidelines

+ First, try to use `git commit` instead of `git commit -m`, which will open a new editor
+ Put a title to explain what you are doing in this commit
+ Put more descriptions in the new paragraph

Example:
```
[#55] Live and let die :gun: =>

* feat: [NG] add quantity of items per product removed.
* feat: [NG] add support for asynchronous events for GTM.
* feat: [SCALA] handle clicks with event delegation.
* docs: add some documentation.
* fix: `list` properties for enhancements in listing packages pages.
* fix: asynchronous event for removeFromCart.
* fix: structure of the products property.
* feat: handle cart update.
* refactor: rename `$recommend` to `$jpid` in `productRecommend()`.
* refactor: rename `JW.addToCart` to `JW.updateCart`.
* refactor: rename `npd_packages` to `developer_packages` in config.
```

We could also squash commits together whenever this makes sense. For more information, please ref to https://git-scm.com/book/en/v2/Git-Tools-Rewriting-History#Squashing-Commits


## Style guide

Your code must look like that:

```scala
package io.github.sentenza.hacktoberfest
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

## Branch naming conventions
 1. Use grouping tokens (words) at the beginning of your branch names.
 2. Define and use short lead tokens to differentiate branches in a way that is meaningful to your workflow.
 2. Use slashes to separate parts of your branch names.
 3. Do not use bare numbers as leading parts.
 5. Avoid long descriptive names for long-lived branches.

### Notes

* the style is subject to change as we learn or need to refine
* new code must follow this standard
* older code should be refactored as it gets worked on
* tools (e.g. scalariform) could help and that's the goal, but it's not there yet

### Credits and inspiration

* http://docs.scala-lang.org/style/
* unwritten shapeless coding style e.g. [generic.scala](https://github.com/milessabin/shapeless/blob/master/core/src/main/scala/shapeless/generic.scala)
* [Banana RDF](https://github.com/banana-rdf/banana-rdf/)
