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


var start = scala.io.StdIn.readLine("Press any button to start")

if(start != null) {
  startGame();
}







  }

def startGame (Id:Int,characterName:String,save:Int): Unit =
  {

    var c = new Convo_Input_Output
    var saveState:Int = save



    while(saveState == 0)
    {
      c.ConvoPart1()
      saveState = saveState+1
    }
    while(saveState == 1)
    {
      c.ConvoPart2()
      saveState = saveState+1
    }
    while(saveState == 2)
    {
      c.ConvoPart3()
      saveState = saveState+1
    }

    while(saveState ==3)
    {
      c.ConvoPart4()
      saveState = saveState+1
    }
    while(saveState ==4)
    {
      c.Convo_part5()
      saveState = saveState + 1

    }
  }
  def startGame(): Unit =
    {
      var c= new Convo_Input_Output
      var saveState:Int = 0



      while(saveState == 0)
      {
        c.ConvoPart1()
        saveState = saveState+1
      }
      while(saveState == 1)
      {
        c.ConvoPart2()
        saveState = saveState+1
      }
      while(saveState == 2)
      {
        c.ConvoPart3()
        saveState = saveState+1
      }

      while(saveState ==3)
      {
        c.ConvoPart4()
        saveState = saveState+1
      }
      while(saveState ==4)
      {
        c.Convo_part5()
        saveState = saveState + 1

      }
    }
}
