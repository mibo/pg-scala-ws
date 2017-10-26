package de.mirb.pg.scala.akka.jsock

import java.io.PrintStream
import java.net.{InetAddress, Socket}
import java.nio.charset.StandardCharsets

import scala.io.{BufferedSource, StdIn}

object JsocksClient extends App {
  val socket = new Socket(InetAddress.getByName("localhost"), 19999)
  var in = new BufferedSource(socket.getInputStream).getLines
  val out = new PrintStream(socket.getOutputStream)
  println("Client initialized, enter content:")

  var content:String = StdIn.readLine()
  while(content.length > 0) {
    out.write(content.getBytes(StandardCharsets.UTF_8))
    out.flush()
    socket.getOutputStream.flush()
    println("Send [" + content + "] enter content:")
    content = StdIn.readLine()
  }
  out.close()
}
