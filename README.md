![Scala Logo]()
<!-- Title: -->
  <a href="https://www.scala-lang.org/">
    <img src="https://eventil.s3.amazonaws.com/uploads/group/avatar/682/medium_scala-logo.png">
  </a>

# Hacktoberfest - Algorithms and Data Structures

  <a href="https://github.com/sentenza/hacktoberfest-scala-algorithms/blob/master/CONTRIBUTING.md">
    <img src="https://img.shields.io/static/v1.svg?label=Contributions&message=Welcome&color=0059b3&style=flat-square" height="20" alt="Contributions Welcome">
  </a>

**_The authors are not affiliated with DigitalOcean or Hacktoberfest_**

## List of Algorithms

This repository is essentially a **collection of programming exercises written in Scala** that will involve Algorithms
and Data Structures.

See our [directory](DIRECTORY.md) for easier navigation and better overview of the project.

## Getting Started

Read through our [Contribution Guidelines](CONTRIBUTING.md) before you contribute.

Anyone can contribute to this repo to make their contribution to open-source on [Github][github]

Celebrate <a href="https://hacktoberfest.digitalocean.com/" target="_blank">HacktoberFest</a> by getting involved in the
Open Source Community by completing some simple (or not so simple) tasks in this project.

This is a Public Repository **open to all members of the GitHub Community**. Any member of the community may contribute
to this project without being a collaborator.

## What is Hacktoberfest?

Hacktoberfest is a month long celebration of open source software held in the month of October to get people involved
in **open-source**.

### The Rules of the HacktoberFest

To get a T-shirt, you must make five pull requests between October 1–31 in any timezone. Pull requests can be to any
public repo on GitHub, not just the ones we’ve highlighted. The pull request must contain commits you made yourself.

You can check your progress of HacktoberFest <a target="_blank" href="https://hacktoberfest.digitalocean.com/stats/">
here</a>.

<strong>Please also note that pull requests marked as spam will not be entitled for a T-shirt</strong>

### Development Rules

- Each implemented piece of code must **not have any external dependency**
- Implemented algorithms are allowed to use only data structures contained inside the library
- Each algorithm should be applicable (if possible) to all the structures inside the library
- Every piece of code produced here will be released under the [GNU General Public License v3.0](LICENSE)

These Scala HacktoberFest Scala _excercises_ assume an [SBT][sbt-intro] project scheme. The solution to
each [issue][issues] should be placed within the `project-directory/src/main/scala/io/github/sentenza/hacktoberfest18/`.
The exercise unit tests can be found within the `project-directory/src/test/io/github/sentenza/hacktoberfest18/`.

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

```markdown
- Name: [YOUR NICKNAME](Github Link)
    - Place: city you belong to (optional)
    - About: Short Intro (optional)
    - Programming Language: Which programming language do you know?
    - Twitter: (optional)
    - Website: (optional)
```

* Commit and Push

```markdown
git add . git commit -m "feat: whatever you did here, e.g. created linkedlist class in Scala"
git push origin {your-branch-name}
```

* Create a New Pull Request from your forked repository (Click the New Pull Request button located at the top of your
  repo) targeting the master branch
* Wait for your PR review and merge approval!
* __Star this repository__ if you had fun!

# How to start programming in Scala

- Feel free to contribute to our [learning resources](docs/learning_resources.md)

[github]: https://github.com

[sbt-intro]: http://torre.me.uk/programming/2017/08/19/scala-with-sbt-and-emacs
