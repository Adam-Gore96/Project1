package Yondel
import Yondel.Convo_Input_Output
//import net.minidev.json.parser.JSONParser

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import java.sql.DriverManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException

import scala.util.parsing.json.JSONObject

import scala.io.Source._

object main {
  def main(args: Array[String]): Unit = {


    var c = new Convo_Input_Output


    c.ConvoPart1()

    c.ConvoPart2()

   c.ConvoPart3()

    c.ConvoPart4()






  }


}
