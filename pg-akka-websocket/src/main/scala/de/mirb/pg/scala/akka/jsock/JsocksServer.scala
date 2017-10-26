package de.mirb.pg.scala.akka.jsock

import java.io._
import java.net._

object JsocksServer extends App {
  try {
    val server = new ServerSocket(19999)
    println("Serve initialized, waiting for connection:")
    val client = server.accept
    println("Client connected:")

    val in = new BufferedReader(new InputStreamReader(client.getInputStream)).readLine
    val out = new PrintStream(client.getOutputStream)

    println("Server received:" + in)
    out.println("Message received")
    out.flush()

    if (in.equals("Disconnect")) client.close()
    server.close()
    println("Server closing:")
  }

  catch {
    case e: Exception => println(e.getStackTrace); System.exit(1)
  }
}
