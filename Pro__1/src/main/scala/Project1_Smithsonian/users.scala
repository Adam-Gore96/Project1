package Project1_Smithsonian

import org.apache.commons.io.FileUtils
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

import java.io.{File, FileWriter}
import java.util.Scanner

class users() {
  Logger.getLogger("org").setLevel(Level.ERROR)
  System.setProperty("hadoop.home.dir", "C:\\hadoop")
  val spark = SparkSession
    .builder
    .appName("hello hive")
    .config("spark.master", "local[*]")
    .enableHiveSupport()
    .getOrCreate()

  //println("created spark session")
  spark.sparkContext.setLogLevel("ERROR")


  object basicUser
  {
    var contextMenu = new String
    var count:Int = 0

    contextMenu = "\n|   ( 1 ) Browse Records           |"+
                  "\n|   ( 2 ) See Total Records        |"+
                  "\n|   ( 3 ) Search for Records       |"+
                  "\n|   ( 4 ) Current Exhibits          |"+
                  "\n|   ( 5 ) Records pre 2000 C.E.    |"+
                  "\n|   ( 6 ) Records post 2000 C.E.   |"+
      "\n"

    while(count < 1)
    {
      var input = scala.io.StdIn.readLine("Welcome to the Smithsonian Record Finder" +
        "\n------------------------------------------\n " +
        s"$contextMenu")
    }
    //println(s"Testing the context Menu \n $contextMenu")
  }
  object adminUser {

    var outString = new String
    var changeTo = new String
    var changefrom = new String
    var contextMenu = new String
    var count:Int = 0
    contextMenu = "\n|   ( 1 ) Browse Records           |"+
      "\n|   ( 2 ) See Total Records        |"+
      "\n|   ( 3 ) Search for Records       |"+
      "\n|   ( 4 ) Current Exhibits         |"+
      "\n|   ( 5 ) Records pre 2000 C.E.    |"+
      "\n|   ( 6 ) Records post 2000 C.E.   |"+
      "\n|   ( 7 ) Alter Databases          |"+
      "\n|   ( 8 ) Update User              |"+
      "\n|            (q)Quit               |"+
      "\n"


    while(count < 1)
      {
        var inputMain = scala.io.StdIn.readLine("Welcome to the Smithsonian Record Finder(Admin View)" +
                                          "\n------------------------------------------\n " +
                                            s"$contextMenu \n" +"\n         Entry: ")
        if(inputMain == "1")
          {
            var Output:String= "Pseudo select // SELECT * FROM MUSEUMS . THIS SHOULD GIVE YOU ANOTHER CONTEXT WINDOW WHERE YOU CAN GO AND LOOK THROUG WHAT IS INSIDE EACH MUSEUM. MAYBE MAKE A CASE CLASS OF SOME SORT"

            spark.sql("Select * from Museums").show(false)


            println(s"$Output")
            var inputMuseums= scala.io.StdIn.readLine("Pick a museum ID")

            inputMuseums match{
              case "1" =>
              case "2" =>
              case "3" =>
              case "4" =>
              case "6" =>
              case "7" =>
              case "8" =>
              case "9" =>
              case "10" =>
              case "11" =>
              case "12" =>
              case "13" =>
              case "14" =>
              case "15" =>
              case "16" =>
              case "17" =>
              case "18" =>
              case "19" =>
              case "20" =>
              case "21" =>
              case "22" =>
              case "23" =>
            }


            count = count + 1
          }
        else if(inputMain == "2")
          {

            count = count + 1
          }
        else if(inputMain == "3")
          {
            count = count + 1
          }
        else if(inputMain == "4")
          {
            count = count + 1
          }
        else if(inputMain == "5")
          {
            count = count + 1
          }
        else if(inputMain == "6")
          {
            count = count + 1
          }
        else if(inputMain == "7")
          {

          }
        else if(inputMain == "8")
          {
            val output = spark.sql("Select * from Users").show(false)

            var input1= scala.io.StdIn.readLine("Choose a row to update: ")
            updateTableUsers(input1.toInt)
            updateCSV()
            delUpdateDB()

          }
        else
          {
            println("Enter either (1) (2) (3) (4) (5) (6) (7)")
          }
      }

    def updateTableUsers(Id: Int): Unit = {
      var id = Id
      val table = "users"
      //var update = UpdateItem
      //var column = UpdateCol
      var newInsert = new String

      var originalUsername = spark.sql(s"Select username from $table where id =$id").head().getString(0)
      var originalFName = spark.sql(s"Select fname from $table where id = $id").head().getString(0)
      var originalPassword = spark.sql(s"Select password from $table where id = $id").head().getString(0)
      var originalLName = spark.sql(s"Select lname from $table where id = $id").head().getString(0)
      var originalAdminLevel = spark.sql(s"Select adminlevel from $table where id = $id" + s"").head().getString(0)
      println(s"Originial Username: $originalUsername, original Password: $originalPassword, original FirstName: $originalFName, original lastname: $originalLName original adminlevel: $originalAdminLevel")

      changefrom = s"$id,$originalUsername,$originalPassword,$originalFName,$originalLName,$originalAdminLevel"

      var transferUsername = new String
      var transferPassword = new String
      var transferFName = new String
      var transferLName = new String
      var transferAdminLevel = new String




      //Logic so I want to delete then re-insert to table. I need to keep track of table's values then change what is
      //needed then pass back into table. This one will be for the users table, but can work with any table that has 5 cols + an ID

      // We get the ID for the row we want
      //Then we get the name of the table -users in this case
      //then we get what we want changed
      //then the change based on a system of numbered rows
      //Change the portion of the table based on a numbering system. 1 == Username 2 == Password 3 == Fname 4 == Lname 5 == Admin Level

      var counter1: Int = 0
      //var input = new String
      var conf = new String

      while (counter1 < 1) {
        var column = scala.io.StdIn.readLine("\nWhich column would you like to input? \n1 ) Username  \n2 ) Password \n3 ) Fname \n4 ) Lname \n5 ) Admin Level\n Entry:")
        var newUsername = new String
        var newPassword = new String
        var newFName = new String
        var newLName = new String
        var newAdminLevel = new String


        if (column == "1") {
          var counter2: Int = 0

          // changes only the username
          while (counter2 < 1) {
            newUsername = scala.io.StdIn.readLine("Changing the 'Username' in users table: \n Please enter a new username: ")
            //println(s"This is the counter2: $counter2")

            conf = scala.io.StdIn.readLine(s"Changing the Username from: $originalUsername to $newUsername -------\n Are you sure? \n1 ) Yes \n2 ) No \n3 ) return ")
            if (conf == "1") {
              transferUsername = newUsername
              transferPassword = originalPassword
              transferFName = originalFName
              transferLName = originalLName
              transferAdminLevel = originalAdminLevel
              //originalUsername = newUsername
              counter1 = counter1 + 1
              counter2 = counter2 + 1
            }
            else if (conf == "2") {
              println("Okay!")
            }
            else if (conf == "3") {
              println("Returning to update menu\n")
              //counter1 = counter1 +1
              counter2 = counter2 + 1
            }
            else {
              println("Please choose 1 or 2")
            }

          }
        }
        else if (column == "2") {
          //changes only the password
          var counter2: Int = 0

          // changes only the username
          while (counter2 < 1) {
            //println(s"This is the counter2: $counter2")
            newPassword = scala.io.StdIn.readLine("Changing the 'Password' in users table: \n Please enter a new Password: ")
            conf = scala.io.StdIn.readLine(s"Changing the Password from: $originalPassword $newPassword -------\n Are you sure? \n1 ) Yes \n2 ) No \n3 ) return ")
            if (conf == "1") {
              transferUsername = originalUsername
              transferPassword = newPassword
              transferFName = originalFName
              transferLName = originalLName
              transferAdminLevel = originalAdminLevel
              //originalUsername = newUsername
              counter1 = counter1 + 1
              counter2 = counter2 + 1
            }
            else if (conf == "2") {
              println("Okay!")
            }
            else if (conf == "3") {
              println("Returning to update menu\n")
              //counter1 = counter1 +1
              counter2 = counter2 + 1
            }
            else {
              println("Please choose 1 or 2")
            }
          }
        }
        else if (column == "3") {
          // changes only the Firstname
          var counter2: Int = 0

          // changes only the First Name
          while (counter2 < 1) {
            newFName = scala.io.StdIn.readLine("Changing the 'Firstname' in users table: \n Please enter a new First Name: ")
            //println(s"This is the counter2: $counter2")


            conf = scala.io.StdIn.readLine(s"Changing the First Name from: $originalFName to $newFName -------\n Are you sure? \n1 ) Yes \n2 ) No \n3 ) return ")

            if (conf == "1") {
              transferUsername = originalUsername
              transferPassword = originalPassword
              transferFName = newFName
              transferLName = originalLName
              transferAdminLevel = originalAdminLevel
              //originalUsername = newUsername
              counter1 = counter1 + 1
              counter2 = counter2 + 1
            }
            else if (conf == "2") {
              println("Okay!")


            }
            else if (conf == "3") {
              println("Returning to update menu\n")
              //counter1 = counter1 +1
              counter2 = counter2 + 1
            }
            else {
              println("Please choose 1 or 2")
            }
          }
        }
        else if (column == "4") {
          var counter2: Int = 0

          // changes only the username
          while (counter2 < 1) {
            //println(s"This is the counter2: $counter2")
            newLName = scala.io.StdIn.readLine("Changing the 'LastName' in users table: \n Please enter a new Last Name : ")
            conf = scala.io.StdIn.readLine(s"Changing the $originalLName to $newLName -------\n Are you sure? \n1 ) Yes \n2 ) No \n3 ) return ")
            if (conf == "1") {
              transferUsername = originalUsername
              transferPassword = originalPassword
              transferFName = originalFName
              transferLName = newFName
              transferAdminLevel = originalAdminLevel
              //originalUsername = newUsername
              counter1 = counter1 + 1
              counter2 = counter2 + 1
            }
            else if (conf == "2") {
              println("Okay!")
            }
            else if (conf == "3") {
              println("Returning to update menu\n")
              //counter1 = counter1 +1
              counter2 = counter2 + 1
            }
            else {
              println("Please choose 1 or 2")
            }
          }
        }
        //changes only the LastName
        else if (column == "5") {
          var counter2: Int = 0

          // changes only the username
          while (counter2 < 1) {
            newAdminLevel = scala.io.StdIn.readLine("Changing the 'Admin' in users table: \n Please enter a new AdminLevel only 'A' or 'B' :")
            //println(s"This is the counter2: $counter2")

            conf = scala.io.StdIn.readLine(s"Changing the Admin Level: $originalAdminLevel to $newAdminLevel -------\n Are you sure? \n1 ) Yes \n2 ) No \n3 ) return ")
            if (conf == "1") {
              transferUsername = originalUsername
              transferPassword = originalPassword
              transferFName = originalFName
              transferLName = originalLName
              transferAdminLevel = newAdminLevel
              //originalUsername = newUsername
              counter1 = counter1 + 1
              counter2 = counter2 + 1
            }
            else if (conf == "2") {
              println("Okay!")
            }
            else if (conf == "3") {
              println("Returning to update menu\n")
              //counter1 = counter1 +1
              counter2 = counter2 + 1
            }
            else {
              println("Please choose 1 or 2")
            }
          }
        }
        //changes only eh AdminLevel
        else {
          println("Choose either 1, 2, 3, 4, or 5\n")
        }

      }


      //newInsert = s"Insert into users values($Id,'$transferUsername', '$transferPassword', '$transferFName', '$transferLName', '$transferAdminLevel')"

      changeTo = s"$id,$transferUsername,$transferPassword,$transferFName,$transferLName,$transferAdminLevel"

      println()
      println(s"This is you new insert Statement: $newInsert")


    }

    def updateCSV(): Unit =
    {
      var f = new File("Users.txt")
      var s = new Scanner(f)
      println(s"This is the scanner:")



      var tester = new String
      var count4:Int = 0
      var finalString = new String

      if (s.hasNext()) {

        println("In the first If Statment")


        while(s.hasNext())
        {

          tester = s.nextLine()
          println(s"Testing String: $tester")
          println(s"ChangeFrom String: $changefrom")


          while(count4 < 1)
          {

            if (changefrom == tester) {
              println("Grabbed the right String")
              tester = changeTo
              count4 = count4 + 1
            }
            else {
              count4 = count4 + 1
            }
          }
          finalString= finalString + tester + "\n"
          println(s"Final while in the loop: \n $finalString")

        }
        println(s"This the new file input:$finalString")


      }

      var fw = new FileWriter(f)
      FileUtils.writeStringToFile(f, finalString, true)
      fw.close()
    }

    def delUpdateDB():Unit =
    {
      spark.sql("DROP TABLE IF EXISTS users")
      spark.sql("create table users(id Int, username String, password String, fname String, " +
        "lname String, adminlevel String)row format delimited fields terminated by ',' stored as textfile")

      spark.sql("LOAD DATA LOCAL INPATH 'Users.txt' OVERWRITE INTO TABLE users")
      spark.sql("select * from users").show()


    }

  }

}
