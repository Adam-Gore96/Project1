object main {

  def main(args: Array[String]): Unit = {

    println("                   Welcome to the Smithsonian Exhibit Buddy")
    var home: String = "Press H to return home"
    var I1: String = "Existing Exhibits"
    var I2: String = "Upcoming Exhibits"
    var I3: String = "Sear Exhibits by name"
    var I4: String = "Find Local Transportation near exhibits"
    var I5: String = "Locations of Exhibits"
    var I6: String = "Guest Speakers"
    var quit: String = "Enter \"EX\" to Quit"

    var input = scala.io.StdIn.readLine("Welcome to the Smithsonian Exhibit Buddy" +
      "\n 0 )" + home +
      "\n 1 )" + I1 +
      "\n 2 )" + I2 +
      "\n 3 )" + I3 +
      "\n 4 )" + I4 +
      "\n 5 )" + I5 +
      "\n 6 )" + I6 +
      "\n 7 )" + quit)


    def contextMenu(userInput: Int): Int = userInput match {


      case 1 => userInput


    }
    {


    }

  }

}
