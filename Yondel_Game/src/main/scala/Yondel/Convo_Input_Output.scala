package Yondel
import Yondel.Characters
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar
//import Yondel.JDBC1
import java.sql.DriverManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException
import scala.util.parsing.json
import scala.util.Random


class Convo_Input_Output() {




  var input1 = new String
  var output1 = new String
  var c = new Characters
  var saveState:Int=0
  var charid: Int = 0

  def sqlPrintTable(s: String): Unit = {
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/project1_yondel"
    val username = "root"
    val password = "Belynadron1!"
    val tablename = s
    var connection: Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM " + tablename + ";")
    val resultSetMetaData = resultSet.getMetaData
    var colcount: Int = resultSetMetaData.getColumnCount
    var count: Int = 1

    while (resultSet.next()) {
      for (i <- 1 until colcount) {
        print(resultSet.getString(i) + " ")
      }
      // println(resultSet.getString(1)+", " +resultSet.getString(2) +", " +resultSet.getString(3))
      //count = count + 1
      println(" ")
    }
    connection.close()
  }

  def SQLNewCharBuild(name: String, job: Int): Unit = {
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/project1_yondel"
    val username = "root"
    val password = "Belynadron1!"
    val level: Int = 1;

    var connection: Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    val charidcrt = statement.executeQuery("SELECT COUNT(*) FROM CHARACTERS;")
    val resultSetMetaData = charidcrt.getMetaData
    var colcount: Int = resultSetMetaData.getColumnCount
    var rowCount: Int = 0


    val statement3 = connection.createStatement()
    val invqcount = statement3.executeQuery("SELECT Count(*) FROM INVENTORY;")
    //var invCount : Int = 0
    var invrowcount: Int = 0

    //println("This is the jobID " + job)

    //var charname = name

    val statement2 = connection.createStatement()

    /** val jobadd = statement2.executeQuery("SELECT CLASS_NAME FROM JOB WHERE JOB_ID = " + job_id + ";")
     *
     * while(jobadd.next())
     * {
     * println("This is the job: " + jobadd.getString(1))
     * }
     * */


    while (charidcrt.next()) {

      //println("Testing 0: " + charidcrt.getString(1))

      rowCount = charidcrt.getString(1).toInt

      charid = rowCount + 1


    }

    while (invqcount.next()) {

      //println("Testing inv row count: " + invqcount.getString(1))

      invrowcount = invqcount.getString(1).toInt + 1

    }

    val InsertInventoryStatement = connection.createStatement()
    val InsertCharactersStatement = connection.createStatement()

    var sqlInsertInvString = new String


    sqlInsertInvString = "INSERT INTO INVENTORY VALUES(" + invrowcount + ", null, null, null, null, null, null, null)"
   // println("INSERT INTO INVENTORY VALUES(" + invrowcount + ", null, null, null, null, null, null, null)")
    InsertInventoryStatement.executeUpdate(sqlInsertInvString)

    var sqlInsertCharString = new String

    sqlInsertCharString = "INSERT INTO CHARACTERS VALUES(" + charid + ", '" + name + "'," + level + ", " + job + ", " + "100, " + invrowcount + "0, 'Alive'); "
    //println("INSERT INTO CHARACTERS VALUES(" + charid + ", '" + name + "', " + level + ", " + job + ", " + "100, " + invrowcount + " ,0, 'Alive') ")
    InsertCharactersStatement.executeUpdate("INSERT INTO CHARACTERS VALUES(" + charid + ", '" + name + "', " + level + ", " + job + ", " + "100, " + invrowcount + " ,0, 'Alive') ")






    //println("Testing for num rows: " + charidcrt)
   // println("Row Count:" + rowCount)
    //println("This is the inventory row count: " + invrowcount)
    connection.close()
  }

  def CallCharacterSheet(name: String, characterId: Int): Unit = {

    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/project1_yondel"
    val username = "root"
    val password = "Belynadron1!"
    val level: Int = 1;
    var colCount: Int = 0


    var connection: Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()

    val charidcrt = statement.executeQuery("SELECT CHARACTERS.ET_ID AS ID, " +
      "CHARACTERS.NAME AS NAME, CHARACTERS.LEVEL AS LEVEL, JOB.CLASS_NAME AS CLASS, ITEMS.ITEM_NAME AS WEAPON\nFROM" +
      " CHARACTERS\nLEFT JOIN JOB ON JOB.JOB_ID = CHARACTERS.JOB_ID\nLEFT JOIN INVENTORY ON INVENTORY.INVENTORY_ID = " +
      "CHARACTERS.INVENTORY_ID\nLEFT JOIN ITEMS ON ITEMS.ITEM_ID = INVENTORY.EQUIPED_WEAPON \nWHERE CHARACTERS.ET_ID = " + characterId)

    val resultSetMetaData = charidcrt.getMetaData
    colCount = resultSetMetaData.getColumnCount


    while (charidcrt.next()) {
      for (i <- 1 until colCount) {
        print(charidcrt.getString(i) + " ")
      }
    }

  }

  def ConvoPart1(): Unit = {

    println("\nWhen first there was nothing, then so came something." +
      "\nWith that thought your eyes began to open. " +
      "You blink away a fuzzy haze and take in your surroundings. You realize quite quickly you don’t know \n" +
      "where you are, or if you can even call this a where. \nAround you, the harsh light of an endless " +
      "white void surrounds your being. No matter which way you look, you see nothing.")

    input1 = scala.io.StdIn.readLine("How do you proceed? \n 1 ) Walk fowards \n 2 ) Walk Backwards \n 3 ) Walk to the sides \n 4 ) Sit down \n ")

    var count: Int = 0
    while (count < 4) {

      if (input1 == "1") {
        //println("In 1")
        output1 = "You look foward and begin walking. After some time It feels as if you’ve walked for an eternity, but still," +
          " you remain in the void, \n" +
          "unable to understand if you’ve made any sort of progress."
        count = count + 1
        println(output1)
      }

      else if (input1 == "2") {
        // println("In 2")
        output1 = "You look backwards and begin walking. After some time It feels as if you’ve walked for an eternity, but still," +
          " you remain in the void, \n" +
          "unable to understand if you’ve made any sort of progress."

        count = count + 1
        println(output1)

      }
      else if (input1 == "3") {
        // println("In 3")
        output1 = "You look to your side and begin walking. After some time It feels as if you’ve walked for an eternity, but still," +
          " you remain in the void, \n" +
          "unable to understand if you’ve made any sort of progress."
        count = count + 1
        println(output1)
      }
      else if (input1 == "4") {
        // println("In 4")
        output1 = "You sit for what feels like an eternity, but nothing changes. You stand and reassess your options."
        count = count + 1
        println(output1)
      }
      else {
        // println("In 5")
        println("Please type either 1, 2, 3, or 4 \n")
        println(output1)
      }

      input1 = scala.io.StdIn.readLine("How do you proceed? \n 1 ) Walk fowards \n 2 ) Walk Backwards \n 3 ) Walk to the sides \n 4 ) Sit down \n ")
      println("This is getting you no where.")
      saveState = 1
    }
  }

  var input2 = new String
  var nameInput = new String
  var nameInput2 = new String
  var input3 = new String
  var output2 = new String
  var output3 = new String
  var output4 = new String
  var output5 = new String
  var output6 = new String

  def ConvoPart2(): Unit = {
    input2 = scala.io.StdIn.readLine("Exasperated you yell out ")
    println("'"+input2 + "!' you yell out.")
    output2 = "'Would' you be so kind as to stop yelling'? \n A voice sounds behind you," +
      "and you spin to confront the newcomer. \nNo more than 5 paces from you sit a pale black-haired " +
      "woman behind a large wooden desk, and behind her stands a door with a small brass handle. \n You begin to think, " +
      "had that been there the entire time? No, it couldn’t be; there’s no way you’d have missed it. \n "
    println(output2)
    output3 = "'Name.' She says, her face burried deep in a thick ledger."
    println(output3)
    nameInput = scala.io.StdIn.readLine("Enter your name: ")

    output4 = nameInput + " 'huh? Let me see.'\n " + "As she flips through the ledger a frown creeps up on her face. \n" + nameInput +
      ", 'and that's your real name?' "
    println(output4)

    var input3count: Int = 0

    input3 = scala.io.StdIn.readLine("1 ) Yes \n2 ) No \n")
    println(input3)
    while (input3count < 1) {
      if (input3 == "1") {
        output5 = "She frowns again, flips, now more frantically than before, through the pages." +
          "\n she stands so suddenly that she'd nearly knocked over the desk. 'One moment,' she says and quickly" +
          "\n disapeared behind the brass-handled door."
        input3count = input3count + 1
        saveState = 2
      }
      else if (input3 == "2") {
        output6 = "'It would really help if you gave me the your real name.' \n "
        println(output5)
        nameInput2 = scala.io.StdIn.readLine("Enter your name... again: \n")

        if (nameInput2 == nameInput) {
          //println(nameInput2)
          //println(nameInput)
          println("'I've just met you and I already hate you'")
          input3count = input3count + 1

        }
        else {
          nameInput = nameInput2
          input3count = input3count + 1
        }

        saveState = 2
      }
      else {
        println("Please Enter 1 or 2.")
        output4 = nameInput + " huh? Let me see.\n " + "As she flips through the ledger a frown creeps up on her face. \n" + nameInput +
          ", and that's your real name? "
        println(output4)
        input3 = scala.io.StdIn.readLine("1 ) Yes \n2 ) No \n")
      }

    }
    output5 =
      "She frowns again, flips, now more frantically than before, through the pages." +
        "\n she stands so suddenly that she'd nearly knocked over the desk. One moment, she says and quickly" +
        "\n disapeared behind the brass-handled door."
    println(output5)


  }

  var input4 = new String
  var input5 = new String
  var input6 = new String
  var input7 = new String
  var input8 = new String
  var input9 = new String


  def ConvoPart3(): Unit = {
    input4 = scala.io.StdIn.readLine("You're left alone in the void, what do you do? \n 1 ) Approach the desk and read the ledger. \n 2 ) Stay put and patiently wait your turn \n")
    println(input4)
    var inputCount4: Int = 0
    while (inputCount4 < 1) {
      if (input4 == "1") {
        println("Silently, while keeping an eye on the door you approach the ledger. \n You can see what looks like a list of some sort, but where they should be words you only see the markings or some strange language."
          + "\n the door creeps open and you back away from the ledger, all while hoping that the woman didn't catch your snooping.")
        inputCount4 = inputCount4 + 1
        saveState = 3
      }
      else if (input4 == "2") {
        println("You stay where you are, patiernly rocking back and forth on your heels. \n Not too long after waiting the door creeps open.")
        inputCount4 = inputCount4 + 1
        saveState = 3
      }
      else {
        println("Please enter either 1 or 2")
        input4 = scala.io.StdIn.readLine("You're left alone in the void, what do you do? \n 1 ) Approach the desk and read the ledger. \n 2 ) Stay put and patiently wait your turn \n")
      }

    }

    println("The woman appears for the open doorway followed by another... \n You're quite sure that the second woman is a carbon copy of the first." +
      "\n From the hair, to the height, and skin, to the placement of a mole on her cheek. \n Two of the exact same woman stand before you. ")

    println("'Hi'. The second woman started. 'I've just been told by my employee that we've had some trouble finding our name in our ledger. \n I'm sure it's a problem on our end " +
      "So if you would be so kind, give me you name again and I'll check. \n" + nameInput + " you say once more, and just like the first woman she flips through the page. 'See, I told you so.' the first woman whispered \n" +
      "Not a single " + nameInput + " to be found")

    println("The woman stands. 'It seems that we need to upgrade this issue to severity level 1-Urgent.' \n The 2 women made a quick bow and disappered behind that door once more. in no later than a minute the door opens once more and"
      + "and women re-emerge, but now instead of two carbon copies there's a third. \n 'Hi,'" + "I've been told that we have a slight issue... so If i could get you name once more. \n " +
      "for the third time do you tell them your name and just like the other two this woman begins to flip through the ledger. \n 'Ah ha!' She exlaimes. 'The two copies look over he shoulder and give a simultaneous, oh")
    input5 = scala.io.StdIn.readLine("\n 1 ) Ask for an explanation.  \n 2 ) Stay silent\n")
    var inputCount5: Int = 0
    while (inputCount5 < 1) {
      if (input5 == "1") {
        println("You ask the women what's wrong. \n 'Well you see,' the lead starts, this is a place where people go after they...' the woman pauses and a look for concern.' \n 'It's were you go when you day.' One of the" +
          "other women finishes for her. \n The lead gives a look at the interrupter, then turns back to you. 'Yes, as my cohot says, this is where one of your kind goes when they... die' ")
        input6 = scala.io.StdIn.readLine("\n1 ) Interrupt. \n2 ) Stay silent \n")
        if (input6 == "1") {
          println("I'm dead?!?")
          println("'Well....yes, but do you want the good or bad new first?'")
          input7 = scala.io.StdIn.readLine("\n1 ) Good news \n2 ) Bad news \n")


        }
        else if (input6 == "2") {
          println("I thought you'd have more of a reaction to that.")
          inputCount5 = inputCount5 + 1
        }
        else {
          println("Please enter 1 or 2: ")
          input6 = scala.io.StdIn.readLine("\n1 ) Interrupt. \n2 ) Stay silent \n")
        }
      }
      else if (input5 == "2") {
        println("'Not one for words is he?'")

      }
      else {
        println("Please enter 1 or 2: ")
        input5 = scala.io.StdIn.readLine("\n 1 ) Ask to be let in on the information.  \n 2 ) Stay silent. \n ")
      }
      saveState = 4


      if (input7 == "2") {
        println("'Bad news first, huh?' Well bad news is that you're stuck here... or I should say... I can't send you back.")
        input8 = scala.io.StdIn.readLine("\n1 )What do you mean I'm stuck here? \n2 ) Stay silent.\n")
        if (input8 == "1") {
          println("One of the women behind her spoke up. 'See that doesn't make much sense, should have asked for the good news first.'")
          println("The lead gave her another scowl but continued. 'Yes, well so technicall... you're not dead.'\n" +
            "or at the very least you're not supposed to be dead, not for another... 67 years 9 months 18 days 21 hours 13 minutes and.... 17 seconds... 16 seconds\" +\n        \"...15 seconds\\" +
            "\n 'I think he gets it.' One of the other women whispered. ")
          inputCount5 = inputCount5 + 1
          saveState = 5
        }

        else if (input8 == "2") {
          println(" One of the women behind her spoke up. 'Look at them, they're so confused that they can't speak. Should have asked for the good new first.'")

          inputCount5 = inputCount5 + 1
          saveState = 5
        }
      }
      else {
        println("So good news first, Technically, you're not dead... or at the very least you're not supposed to be dead, not for another... 67 years 9 months 18 days 21 hours 13 minutes and.... 17 seconds... 16 seconds" +
          "...15 seconds-\n'I think he gets it.'  One of the other women whispered.")
        println("Hmm... I think you're quite right, well that bad news then is that you're kind of... stuck here. or I should say I can't send you back.")
        inputCount5 = inputCount5 + 1
        saveState = 5
      }

    }


    var inputCount9: Int = 0

    input9 = scala.io.StdIn.readLine("\n1 ) What do you mean? \n2 ) I think understand, where do we go from here? \n3 ) Stay Silent\n")

    while (inputCount9 < 1) {
      if (input9 == "1") {

        println("'Okay so, like I said, this is the place your kind goes when they die. no so much the underworld, but more like another world.'")
        inputCount9 = inputCount9 + 1
        saveState = 6
      }
      else if (input9 == "2") {
        println("'Oh look at him, so smart and everything.' The first woman said only to be smacked by the second \n'Would you shut up, the boss is trying to speak'" +
          "\n'You didn't need to hit me so hard...' the first said, rubbing her face.' \nYou know what? Both of you can shut up. " +
          "\n Suddenly there was a blast of white light and curls of smoke wound around the three woman. " +
          "You're not sure how, but the... melted into one. \n" +
          "'Sorry about all that. You give them a little a free time and they just don't know what to do with themselves. Where was i?'")
        inputCount9 = inputCount9 + 1
        saveState = 6
      }
      else if (input9 == "3") {
        println("'He is a bit slow isn't he 'The first woman said only to be smacked by the second " +
          "\n'Would you shut up, the boss is trying to speak'" +
          "\n'You didn't need to hit me so hard...' the first said, rubbing her face." +
          "\n 'You know what? Both of you can shut up.' Suddenly there was a blast of white light and curls of smoke wound around the three woman." +
          "\nYou're not sure how, but the... melted into one." +
          "\n'Sorry about all that. You give them a little a free time and they just don't know what to do with themselves. Where was i?'")
        inputCount9 = inputCount9 + 1
        saveState = 6
      }
      else {
        println("Please enter 1, 2, or 3")
        input9 = scala.io.StdIn.readLine("\n1 ) What do you mean? \n2 ) I understand, where do we go from here? \n3 ) Stay Silent\n")
      }

    }


  }


  var input10 = new String
  var input11 = new String
  var input12 = new String
  var input13 = new String
  var jobInput: Int = 0

  def ConvoPart4(): Unit = {

    println("Testing This is the name-Id " + nameInput)

    println("'So, after all that where do we go from here? Well, while you're technically not dead you're technically not alive either' The woman scratched her head." +
      "\n'No I mean, your obviously still alive, just not alive here. All that basically means you're a clean slate so to speak.' \n" +
      "'While everyone else has their fate handed to them, you can be basically anyone you want to be.'")
    input10 = scala.io.StdIn.readLine("So... who do you want to be? \n1 ) Warrior \n2 ) Mage \n3 ) Rogue \n4 ) Priest\n")


    var inputCount10: Int = 0
    1
    var inputCount11: Int = 0
    1
    while (inputCount10 < 1) {
      if (input10 == "1") {
        if (inputCount11 == 1) {
          inputCount11 = inputCount11 - 1
        }
        input11 = scala.io.StdIn.readLine("Ah the legendary Warrior, one whose legend is build upon the strength of their backs \n forever steadfast they offer" +
          "both protection and defense to those they protect\n Are you sure? \n1) Yes, I'm sure \n2 ) No I need more time to think.\n")
        while (inputCount11 < 1) {
          if (input11 == "1") {
            println("There you have it then. Welcome to Yondel, Warrior")
            //  jobInput = 1
            SQLNewCharBuild(nameInput, 1)
            inputCount11 = inputCount11 + 1
            inputCount10 = inputCount10 + 1

          }
          else if (input11 == "2") {
            input10 = scala.io.StdIn.readLine("So... who do you want to be? \n1 ) Warrior \n2 ) Mage \n3 ) Rogue \n4 ) Priest\n")
            ("There you have it then. Welcome to Yondel, Warrior")
            inputCount11 = inputCount11 + 1
            println("Inputcount 11" + inputCount11)
          }
          else {
            println("Please choose 1 or 2")
          }

        }
      }
      else if (input10 == "2") {
        input11 = scala.io.StdIn.readLine("Ah, the wondrous Mage. The only limits to your powers will be your imagination. You existence will make sky tremble in anticipation and fear" +
          "\n Are you sure? \n1) Yes, I'm sure \n2 ) No I need more time to think.\n")
        if (inputCount11 == 1) {
          inputCount11 = inputCount11 - 1
        }
        while (inputCount11 < 1) {
          if (input11 == "1") {
            println("There you have it then. Welcome to Yondel, Mage")
            SQLNewCharBuild(nameInput, 2)
            // jobInput = 2
            inputCount11 = inputCount11 + 1
            inputCount10 = inputCount10 + 1
          }
          else if (input11 == "2") {
            input10 = scala.io.StdIn.readLine("So... who do you want to be? \n1 ) Warrior \n2 ) Mage \n3 ) Rogue \n4 ) Priest\n")
            println("There you have it then. Welcome to Yondel, Mage")
            inputCount11 = inputCount11 + 1

          }
          else {
            println("Please choose 1 or 2")
          }

        }

      }
      else if (input10 == "3") {
        input11 = scala.io.StdIn.readLine("Ah the mischievous Rogue. The only think you need is you blade and somewhere to stick it. Your name will conjure fear in all those who dare speak it" +
          "\n Are you sure? \n1) Yes, I'm sure \n2 ) No I need more time to think.\n")
        if (inputCount11 == 1) {
          inputCount11 = inputCount11 - 1
        }
        while (inputCount11 < 1) {
          if (input11 == "1") {
            println("There you have it then. Welcome to Yondel, Rogue")
            // jobInput = 4
            SQLNewCharBuild(nameInput, 4)
            inputCount11 = inputCount11 + 1
            inputCount10 = inputCount10 + 1

          }
          else if (input11 == "2") {
            input10 = scala.io.StdIn.readLine("So... who do you want to be? \n1 ) Warrior \n2 ) Mage \n3 ) Rogue \n4 ) Priest\n")

            inputCount11 = inputCount11 + 1
          }
          else {
            println("Please choose 1 or 2")
            input10 = scala.io.StdIn.readLine("So... who do you want to be? \n1 ) Warrior \n2 ) Mage \n3 ) Rogue \n4 ) Priest\n")
            inputCount11 = inputCount11 + 1
          }

        }
      }
      else if (input10 == "4") {
        input11 = scala.io.StdIn.readLine("Ah the wise priest. Friend to those who walk in the light, and sworn enemy to those who don't. You'll bring peace to this world in one way or anothe" +
          "\n Are you sure? \n1) Yes, I'm sure \n2 ) No I need more time to think. \n")
        if (inputCount11 == 1) {
          inputCount11 = inputCount11 - 1
        }
        while (inputCount11 < 1) {
          if (input11 == "1") {
            println("There you have it then. Welcome to Yondel, Priest")
            // jobInput = 3
            SQLNewCharBuild(nameInput, 3)
            inputCount11 = inputCount11 + 1
            inputCount10 = inputCount10 + 1

          }
          else if (input11 == "2") {
            input10 = scala.io.StdIn.readLine("So... who do you want to be? \n1 ) Warrior \n2 ) Mage \n3 ) Rogue \n4 ) Priest\n")
            //println("There you have it then. Welcome to Yondel, Priest")
            inputCount11 = inputCount11 + 1

          }
          else {
            println("Please choose 1 or 2")
            input10 = scala.io.StdIn.readLine("So... who do you want to be? \n1 ) Warrior \n2 ) Mage \n3 ) Rogue \n4 ) Priest\n")

          }

        }
      }
      else {
        println("Please Choose 1, 2, 3, or 4")
        input10 = scala.io.StdIn.readLine("So... who do you want to be? \n1 ) Warrior \n2 ) Mage \n3 ) Rogue \n4 ) Priest\n")

      }
    }
    // SQLNewCharBuild(nameInput,jobInput)

    CallCharacterSheet(nameInput, charid)
    println("\n \n \n \n")

  }


def playerHealth(name:String):Int =
  {
    var totalHealth:Int =0
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/project1_yondel"
    //println("Connecting to database")
    val username = "root"
    val password = "Belynadron1!"
    var connection: Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()

    val inputget = statement.executeQuery("SELECT HEALTH FROM CHARACTER_SHEET WHERE NAME = '" +name+ "';")

    if(inputget.next())
    {
      totalHealth = inputget.getInt(1)
    }
  return totalHealth
  }
  def damageCalkPlayer(name: String, Ability:Int): Int =
  {
    //takes a string "name" and the ID for the ability that wants to be used.
    var totalDamage: Int = 100
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/project1_yondel"
    //println("Connecting to database")
    val username = "root"
    val password = "Belynadron1!"
    var colCount: Int = 1
    var connection: Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    val inputget =statement.executeQuery("Select DAMAGE FROM TOTAL_DAMAGE WHERE NAME= '" +name+"' and ID =" + Ability+";")
    // println("Select DAMAGE FROM TOTAL_DAMAGE WHERE NAME= '"+name +"' and ID = " + Ability+";")
    val resultSetMetaData = inputget.getMetaData

    if(inputget.next())
    {
      totalDamage = inputget.getInt(1)
    }

    connection.close()
    return totalDamage
  }
  def addEnemy(createFile: String, ID:Int): Unit =
  {
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/project1_yondel"
    val username = "root"
    val password = "Belynadron1!"

   // println(createFile+" : File")
    var connection: Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    //val enemycount = connection.createStatement()

    //pulls from a csv file

    var maptest = scala.io.Source.fromFile(createFile).mkString


    //testing the created string with a print
    //maptest.foreach(print)

    //formatting the query
    var inputString = new String
    inputString = s"INSERT INTO Enemies Values($ID,$maptest);"

    //test print for query format
    // println(inputString)

    //executing the query
    statement.executeUpdate(inputString)

    connection.close()


  }


  def enemyHealth(name:String, ID:Int): Int =
  {
    var totalHealth:Int=0


    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/project1_yondel"
    //println("Connecting to database")
    val username = "root"
    val password = "Belynadron1!"
    var connection: Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    val inputget =statement.executeQuery(s"Select HEALTH FROM ENEMIES WHERE NAME = '$name' and Enemy_ID = $ID " )


    if(inputget.next())
    {
      totalHealth = inputget.getInt(1)
    }

    connection.close()


    return totalHealth

  }

  def enemyDamage(name:String): Int=
  {
    var totalDamage: Int = 0
    // takes the name of an enemy and gets back their damage
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/project1_yondel"
   // println("Connecting to database")
    val username = "root"
    val password = "Belynadron1!"
    var connection: Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    val inputget =statement.executeQuery("Select Damage from EDamage WHERE NAME = '"+name+"';" )


    if(inputget.next())
    {
      totalDamage = inputget.getInt(1)
    }

    connection.close()
    return totalDamage
    //return totalDamage

  }


def getAbility(name:String,num:Int):String=
  {
    var abilityName = new String
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/project1_yondel"
    //println("Connecting to database")
    var IDs = new String
    IDs=num.toString
    val username = "root"
    val password = "Belynadron1!"
    var connection: Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    //println(s"SELECT ABILITY FROM TOTAL_DAMAGE WHERE NAME ='$name', and ID = $IDs")
    val inputget =statement.executeQuery(s"SELECT ABILITY FROM TOTAL_DAMAGE WHERE NAME ='$name' and ID = $IDs" )



    if(inputget.next())
    {
      abilityName = inputget.getString(1)
    }

    connection.close()


    return abilityName
  }
  def abilityDesc(name:String): String=
    {
      var descOut = new String
      val driver = "com.mysql.cj.jdbc.Driver"
      val url = "jdbc:mysql://localhost:3306/project1_yondel"
      //println("Connecting to database")

      val username = "root"
      val password = "Belynadron1!"
      var connection: Connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement()
      val inputget =statement.executeQuery(s"SELECT ABILITY_DESCRIPTOR FROM ABILITIES WHERE ABILITY_NAME='$name'" )

      if(inputget.next())
      {
        descOut = inputget.getString(1)
      }
      connection.close()
      return descOut
    }

  def enemyAbility(name:String):String =
    {


      var abilityName = new String
      val driver = "com.mysql.cj.jdbc.Driver"
      val url = "jdbc:mysql://localhost:3306/project1_yondel"
      //println("Connecting to database")
      val username = "root"
      val password = "Belynadron1!"
      var connection: Connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement()
      val inputget =statement.executeQuery(s"SELECT abilities.ABILITY_NAME FROM ENEMIES INNER JOIN ABILITIES ON ABILITIES.ABILITY_ID = ENEMIES.ABILITY WHERE ENEMIES.NAME='$name'" )

      if(inputget.next())
      {
        abilityName = inputget.getString(1)
      }

      connection.close()


      return abilityName



    }




  def battle(playerName:String,enemyName:String): Unit=
  {


    var pname = playerName
    var ename = enemyName
    var ename1 = "Demon Soldier"
    var EID = new Random().nextInt(1000)

    addEnemy("src/main/scala/Yondel/"+ename+".csv", EID)

    var ability1name = new String
    var ability2name = new String
    var ability3name = new String

    var ability1:Int=0
    var ability2:Int=0
    var ability3:Int=0

    var ability1Desc = new String
    var ability2Desc = new String
    var ability3Desc = new String

  ability1name = getAbility(pname,1)
  ability2name = getAbility(pname,2)
  ability3name = getAbility(pname, 3)

  ability1 = damageCalkPlayer(pname,1)
  ability2 = damageCalkPlayer(pname,2)
  ability3 = damageCalkPlayer(pname,3)

  ability1Desc = abilityDesc(ability1name)
  ability2Desc = abilityDesc(ability2name)
  ability3Desc = abilityDesc(ability3name)



  var playerinput=new String

    var ebility = enemyAbility(ename)
    var edamage = enemyDamage(ename)


    var phealth:Int = playerHealth(pname)
    var ehealth:Int = enemyHealth(ename, EID)
    var hitchance1 = Random.nextInt(100)
    println(s"You have been attacked by a $enemyName ")

    println(s"Enemy Health $ehealth")
    println(s"Player Health $phealth")
while(phealth > 1 && ehealth > 0)
  {
    //println("In the while Loop")

    playerinput = scala.io.StdIn.readLine(s"\nChoose an ability\n 1 ) $ability1name $ability1Desc for $ability1 points of damage \n 2 ) $ability2name $ability2Desc for $ability2 points of damage \n 3 ) $ability3name $ability3Desc for $ability3\n")
    if(playerinput == "1")
      {
        println(s"You used $ability1name")
        var hitchance1 = Random.nextInt(100)
        if(hitchance1 > 60)
          {
            println(s"You hit the $ename1 with $ability1name")
            ehealth = ehealth - ability1
            println(s"The $ename1 has ${ehealth.toString} hp left")
          }
        else
          {
            println(s"You missed you $ability1name")
          }



      }
    else if(playerinput == "2")
      {
        println(s"You hit the $ename1 with $ability2name")
        ehealth = ehealth - ability2
        println(s"The $ename1 has ${ehealth.toString} hp left!")
      }
    else if(playerinput == "3")
    {
      println(s"You hit the $ename1 with $ability3name")
      phealth = phealth + ability3
      println(s"You've gained + $ability3 for this fight only!")

    }

    println(s"The $ename1 used $ebility")
    var hitchance1 = Random.nextInt(100)
    if(hitchance1 >90)
      {
        println(s"The $ename1 hit you with $ebility for $edamage points of damage")
        phealth = phealth - edamage
        println(s"You have $phealth hp left")
      }
    else
      println(s"$ename1 missed their $ebility")


  }

    var abilityName = new String
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/project1_yondel"
    //println("Connecting to database")
    val username = "root"
    val password = "Belynadron1!"
    var connection: Connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    val inputget = statement.executeUpdate(s"UPDATE ENEMIES SET STATUS='DEAD' WHERE ENEMY_ID=$EID")


  }

  var input14 = new String
  var input15 = new String
  var input16 = new String
  var input17 = new String
  var input18 = new String
  var input19 = new String
  var input20 = new String

def Convo_part5(): Unit =
{

  val driver = "com.mysql.cj.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/project1_yondel"
  //println("Connecting to database")

  val username = "root"
  val password = "Belynadron1!"
  var connection: Connection = DriverManager.getConnection(url, username, password)
  val statement = connection.createStatement()


  println("A hole opens in the ground below you and you begin to fall. Soon, the white void is nothing but spec, but " +
    "still you fall further and further into darkness \n" +
    "Until the last of the fading light blinks out of existence." +
    "\n'From once there was something so came someone'" +
    "You slowly open your eyes. Night time already? Had the white void and the door and women... woman? Had all that been a dream?" +
    "some silly fantasies you made up in your mind for some contrived sense of excitement?\n Your eyes begin to focus in the low light. \n" +
    "You're in a forest of some kind... maybe it wasn't all a dream. In the distance you can see bobbing lights.")
  var counter5_1:Int =0
  input14 = scala.io.StdIn.readLine("1 ) Hide in the forest. \n2 ) Stay were you are \n3 ) Approach the lights\n")
  while(counter5_1<1) {
    if(input14 == "1")
      {
        println("You stand and sneak into the forest. You feel sluggish, and the thick foliage slows your speed. \nYou move slowly trying, but failing to make noise as you shuffle through the underbrush\n")
        println("The bouncing lights slowly fade and you let out a hesitant breath.\n You give yourself a moment to gather your thoughts")
        println("The feeling of a cold wave creeping through your body snaps you from your thoughts. \n" +
          "You shiver. Something is behind you, you can feel it. Turning you see it. To small lights, shining like miniature suns in the dark forest ")
        battle(nameInput,"demon_soldier")
        println(" You feel yourself fading as the demon's sword cuts deep into your body. The world goes dark. " +
          "\n you have gained 205exp" +
          "\n You've reached level 2" +
          "\n You've reached level 3" +
          "\n You've reached level 4")
          statement.executeUpdate(s"UPDATE CHARACTERS SET LEVEL = 4 WHERE ET_ID =$charid")
        println("\n \n \n")
        CallCharacterSheet(nameInput, charid)

        counter5_1 = counter5_1 + 1

      }
    else if(input14 == "2")
      {
        println("You slump close to the ground. Maybe if you can stay still enough you'll become invisible.")
        counter5_1 = counter5_1 + 1
      }
    else if(input14 == "3")
      {
        println("Why? you don't even have a weapon yet.\n Okay you stand to approach the intruders. \n Do you want to try to be stealthy or do you want them to find you?")
        input15 = scala.io.StdIn.readLine("\n1 ) Stealthy \n2 ) Not Stealthy\n")
        if(input15=="1")
          {
            println("oh wow you're being stealthy. I really didn't expect that.\n")

            counter5_1 = counter5_1 +1
          }
        else if(input15 == "2")
          {
            println("\nYou want to yell something while you do this don't you?")
            input16 = scala.io.StdIn.readLine("\n1 ) Yes \n2 ) N0 \n")
            if(input16 == "1")
              {
                input17 = scala.io.StdIn.readLine("\nOf course you do. \n What do you want to say? \n")
                println(input17 +" you well as you charge into the bushes.")
                counter5_1 = counter5_1 + 1

              }
            else if(input16 == "2")
              {
                println("Really? ")
                input18 = scala.io.StdIn.readLine("\n1 ) Okay   \n2 ) Yes you do.")
                input18 = scala.io.StdIn.readLine("\n Say it. \n")
                println("Incredible. \n" + input18+ ", you yell as you charge into the bushes." )

                counter5_1 = counter5_1 + 1
              }
            else
              {
                println("\nChoose 1 or 2")
                input16 = scala.io.StdIn.readLine("\n1 ) Yes \n2 ) N0 \n")
              }
          }
        else
          {
            println("Pick 1 or 2 ")
            input15 = scala.io.StdIn.readLine("\n1 ) Stealthy \n2 ) Not Stealthy\n")
          }


      }
    else
      {
        println("Please pick 1, 2 or 3\n")
        input14 = scala.io.StdIn.readLine("1 ) Hide in the forest. 2 ) Stay were you are 3 ) Approach the lights")
      }

  }

}


}
