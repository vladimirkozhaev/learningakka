package com.akkademy

import org.scalatest._
import org.scalatest.{FunSpecLike, Matchers}
import scala.concurrent._
import scala.concurrent.duration._
import com.akkademy.SClient
import com.akkademy.messages.KeyNotFoundException



class SClientIntegrationSpec extends FunSpecLike with Matchers{
  val client = new SClient("127.0.0.1:2552")
  describe("akkademyDb Scala Client") {
        describe("set method") {
            it("should set a value") {
                client.set("123", new Integer(123))
                val futureResult = client.get("123")
                val result = Await.result(futureResult, 60 seconds)
                result should equal(123)
            }
        }
  }
}