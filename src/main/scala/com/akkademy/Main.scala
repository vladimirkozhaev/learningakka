package com.akkademy

import akka.actor.ActorSystem

object Main extends App {
  val s = ActorSystem("akkademy")
  s.actorOf(AkkademyDb.props, "akkademy-db")
}
