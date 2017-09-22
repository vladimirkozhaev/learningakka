package com.akkademy

import akka.actor.{Actor, Props, Status}
import akka.event.Logging
import com.akkademy.messages.{GetRequest, RequestReceived, SetRequest}

import scala.collection.mutable.HashMap

class AkkademyDb extends Actor {
  val map = new HashMap[String, String]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key: String, value: Any) => {
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
      sender() ! RequestReceived()
    }
    case GetRequest(key) =>
      log.info("received GetRequest - key: {}" + key)
      val responce: Option[String] = map.get(key);
      responce match {
        case Some(x) => sender() ! x
        case None => sender() ! Status.Failure(new ClassNotFoundException)
      }
    case o => log.info("received unknown message: {}", o);
  }
}

object AkkademyDb {
  def props = Props(new AkkademyDb)
}