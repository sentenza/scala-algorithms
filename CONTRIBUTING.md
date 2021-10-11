# Contributing

* **the style is subject to change as we learn or need to refine**
* new code must follow this standard
* older code should be refactored as it gets worked on

## Development Rules

* Each implemented piece of code must **not have any external dependency**
* Implemented algorithms are allowed to use only data structures contained inside the library
* Each algorithm should be applicable (if possible) to all the data structures inside the library
* Every piece of code produced here will be released under the [GNU General Public License v3.0](LICENSE)
* **Your code must conform to the project [code style](docs/code_style.md)**
* The solution to each issue should be placed within
  `project-directory/src/main/scala/io/github/sentenza/hacktoberfest/`
* The exercise unit tests can be found within `project-directory/src/test/io/github/sentenza/hacktoberfest/`

These Scala HacktoberFest Scala _exercises_ assume an [SBT][sbt-intro] project scheme.

## How to contribute

* Please avoid opening issues asking to be _assigned_ to a particular algorithm.
  This merely creates unnecessary noise for maintainers. Instead, please submit
  your implementation in a pull request, and it will be evaluated by project maintainers.
* If you are unable to find an open issue referring to the same problem, depending on the type of
  issue follow the appropriate steps:

### Do you want to add a new algorithm?
* **Ensure the same issue was not already reported** in
  [Project Issues](https://github.com/sentenza/hacktoberfest-scala-algorithms/issues)
* You might want to look into our algorithms [DIRECTORY](DIRECTORY.md) to find something that needs to be implemented
- [Open a new issue](https://github.com/sentenza/hacktoberfest-scala-algorithms/issues/new).
  Be sure to include a **title and a clear description** and a **test case** demonstrating the new feature that you want
  to add to the project.
* Create a branch for a new feature `git checkout -b "<ISSUE-NUMBER>-branch-name`
* Add your name to the [CONTRIBUTORS.md][CONTRIBUTORS.md] file
* Wait for your PR review and merge approval!
* __Star this repository__ if you had fun!

### Do you want to contribute to the documentation?
* **Ensure the same issue was not already reported** in
  [Project Issues](https://github.com/sentenza/hacktoberfest-scala-algorithms/issues)
* Create a new PR describing in a clear and concise way what you're going to improve in our current docs

## NOTE

All contributions to this project are **very welcome**. By contributing, you accept to give the terms and conditions of
the **GNU GENERAL PUBLIC LICENSE v3**, as explained in [LICENSE](LICENSE).

The licenses for most software and other practical works are designed to take away your freedom to share and change the
works. By contrast, the GNU General Public License is intended to guarantee your freedom to share and change all
versions of a program -- to make sure it remains free software for all its users.

:+1::tada: That's all you need to know about the process now it's your turn to help us improve the repository, thank you again! :+1::tada:

[sbt-intro]: https://torre.me.uk/2017/08/19/scala-with-sbt-and-emacs/
