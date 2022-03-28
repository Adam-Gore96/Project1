class ContextMenu {

  println("                Welcome to the Smithsonian Exhibit Buddy")


  private[this] var _home: String = "Press H to return home"

  def home: String = _home

  def home_=(value: String): Unit = {
    _home = value
  }

  private[this] var _I1: String = "Existing Exhibits"

  def I1: String = _I1

  def I1_=(value: String): Unit = {
    _I1 = value
  }

  private[this] var _I2: String = "Upcoming Exhibits"

  def I2: String = _I2

  def I2_=(value: String): Unit = {
    _I2 = value
  }

  private[this] var _I3: String = "Sear Exhibits by name"

  def I3: String = _I3

  def I3_=(value: String): Unit = {
    _I3 = value
  }

  private[this] var _I4: String = "Find Local Transportation near exhibits"

  def I4: String = _I4

  def I4_=(value: String): Unit = {
    _I4 = value
  }

  private[this] var _I5: String = "Locations of Exhibits"

  def I5: String = _I5

  def I5_=(value: String): Unit = {
    _I5 = value
  }

  private[this] var _I6: String = "Guest Speakers"

  def I6: String = _I6

  def I6_=(value: String): Unit = {
    _I6 = value
  }

  private[this] var _quit: String = "Enter \"EX\" to Quit"

  def quit: String = _quit

  def quit_=(value: String): Unit = {
    _quit = value
  }


  def homeMenu():Int = {
    var output:Int = 0


    var input = scala.io.StdIn.readLine("\n            Please enter the corresponding number from the menu below\n" +


      "                           \n                      ( 0 )" + home +
      "                           \n                      ( 1 )" + I1 +
      "                           \n                      ( 2 )" + I2 +
      "                           \n                      ( 4 )" + I4 +
      "                           \n                      ( 5 )" + I5 +
      "                           \n                      ( 6 )" + I6 +
      "                           \n                      ( 7 )" + quit + "\n" )

    return output
  }





}
