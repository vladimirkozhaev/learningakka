package com.akkademy



import akka.actor.Actor
import akka.actor.Status

class ScalaPongActor extends Actor {
  override def receive:Receive={
    case "Ping" => sender()! "Pong"
    case _ => sender()! Status.Failure(new Exception("Uknown message"))
  }
  
}