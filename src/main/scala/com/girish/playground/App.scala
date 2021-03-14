package com.girish.playground

import scala.collection.mutable.ArrayBuffer
import com.typesafe.scalalogging._

/**
 * @author girish
 */
object MainClass extends App {

  val logger = Logger(MainClass.getClass)
  /** Says Hello to the name given as input.
   *
   * @param name
   */
  def sayHello(name: String): Unit = {
    logger.debug(s"Say hello to $name")
    println(s"Hello, $name")
    logger.info("Said hello to {}", name)
  }

  sayHello("John")
  logger.trace(
    "This log won't appear unless we have set the log level to accept trace in logback.xml")
}
