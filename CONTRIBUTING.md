# Contributing

**Please keep in mind that this is a work in progress. Sections will be added over time.**

## Contributions

All contributions to this project are **very welcome**. By contributing, you accept to give the terms and conditions of
the **GNU GENERAL PUBLIC LICENSE v3**, as explained in [LICENSE](LICENSE).

The licenses for most software and other practical works are designed to take away your freedom to share and change the
works. By contrast, the GNU General Public License is intended to guarantee your freedom to share and change all
versions of a program -- to make sure it remains free software for all its users.

### Development Rules

- Each implemented piece of code must **not have any external dependency**
- Implemented algorithms are allowed to use only data structures contained inside the library
- Each algorithm should be applicable (if possible) to all the data structures inside the library
- Every piece of code produced here will be released under the [GNU General Public License v3.0](LICENSE)

These Scala HacktoberFest Scala _exercises_ assume an [SBT][sbt-intro] project scheme.

* The solution to each issue should be placed within
  the `project-directory/src/main/scala/io/github/sentenza/hacktoberfest/`.
* The exercise unit tests can be found within the `project-directory/src/test/io/github/sentenza/hacktoberfest/`.

### How to contribute

* Fork this repository (Click the Fork button in the top right of this page, click your Profile Image)
* Clone your fork down to your local
  machine `git clone https://github.com/{your-username}/hacktoberfest-scala-algorithms`
* Execute the code launching `sbt` and then running `compile`, `test` and `run`
* Create a branch for a new feature `git checkout -b feat/branch-name`
  ** Or if it's a bugfix to a file

```markdown
git checkout -b fix/branch-name
```

* Code your files in the proper directory based on the instructions you'll find in CONTRIBUTING
* Add your name to the [CONTRIBUTORS.md][CONTRIBUTORS.md] file using following model

* Commit and Push

```markdown
git add . git commit -m "feat: whatever you did here, e.g. created linkedlist class in Scala"
git push origin {your-branch-name}
```

* Create a New Pull Request from your forked repository (Click the New Pull Request button located at the top of your
  repo) targeting the master branch
* Wait for your PR review and merge approval!
* __Star this repository__ if you had fun!

### Notes

* the style is subject to change as we learn or need to refine
* new code must follow this standard
* older code should be refactored as it gets worked on
* tools (e.g. scalariform) could help and that's the goal, but it's not there yet

[sbt-intro]: https://torre.me.uk/2017/08/19/scala-with-sbt-and-emacs/
