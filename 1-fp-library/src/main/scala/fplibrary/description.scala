package io.github.sentenza.hacktoberfest.fplibrary

object Description {
    def create[A](a: => A): Description[A] = 
        () => a
}