package com.akkademy

import akka.util.Timeout
import akka.actor.ActorSystem
import akka.pattern.ask
import scala.concurrent.duration._
import com.akkademy.messages._
import scala.util.{Success, Failure}


class SClient(remoteAddress: String){
    private implicit val system = ActorSystem("LocalSystem")
    private val remoteDb = system.actorSelection(s"akka.tcp://akkademy@$remoteAddress/user/akkademy-db")
    private implicit val timeout = Timeout(2 seconds)

    def set(key: String, value: Object) = {
        remoteDb ? SetRequest(key, value)
    }
    
    
    def get(key: String) = {
        remoteDb ? GetRequest(key)
    }
    
}