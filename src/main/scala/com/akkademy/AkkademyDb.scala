package com.akkademy

import com.akkademy.messages.SetRequest
import akka.actor.Actor
import akka.event.Logging
import scala.collection.mutable.HashMap
import com.akkademy.messages.GetRequest
import akka.actor.Status.Status
import akka.actor.Status.Status
import akka.actor.Status

class AkkademyDb extends Actor {
  val map = new HashMap[String, String]
  val log = Logging(context.system, this)
  override def receive = {
    case SetRequest(key: String, value: String) => {
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
    }
    case GetRequest(key) =>
      log.info("received GetRequest - key: {}" + key)
      val responce: Option[String] = map.get(key);
      responce match {
        case Some(x) => sender() ! x
        case None    => sender() ! Status.Failure(new ClassNotFoundException)
      }
    case o => log.info("received unknown message: {}", o);
  }
}