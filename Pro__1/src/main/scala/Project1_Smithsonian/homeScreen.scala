package Project1_Smithsonian

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession



import java.io.FileNotFoundException

class homeScreen {
  Logger.getLogger("org").setLevel(Level.ERROR)
  System.setProperty("hadoop.home.dir", "C:\\hadoop")
  val spark = SparkSession
    .builder
    .appName("hello hive")
    .config("spark.master", "local[*]")
    .enableHiveSupport()
    .getOrCreate()

  println("created spark session")
  spark.sparkContext.setLogLevel("ERROR")

  object homeScreen{

    //if(spark.sql("IF EXISTS "))




    val loginText:String = "Login"
    val registerText:String = "Register"

    val errorString:String = "Please enter either: "

    var Count: Int = 0
    var Username = new String
    var Password = new String
    var Name = new String
    var LoginStatement = new String
    var InsertUserStatement = new String

    spark.sql("DROP TABLE IF EXISTS users")
    spark.sql("create table users(id Int, username String, password String, fname String, " +
      "lname String, adminlevel String)row format delimited fields terminated by ',' stored as textfile")

    spark.sql("LOAD DATA LOCAL INPATH 'Users.txt' OVERWRITE INTO TABLE users")
    spark.sql("select * from users")
    var Input:String = scala.io.StdIn.readLine(s"\n1 ) $loginText \n2 ) $registerText\n")


def startScreen(): Unit = {
  /**spark.sql("DROP TABLE IF EXISTS users")
  spark.sql("create table users(id Int, username String, password String, fname String, " +
    "lname String, adminlevel String)row format delimited fields terminated by ',' stored as textfile")

  spark.sql("LOAD DATA LOCAL INPATH 'Users.txt' OVERWRITE INTO TABLE users")
  spark.sql("select * from users").show()
**/
  var permString = new String;
  while (Count < 1) {

    if (Input == "1") {
      println("User Login\n ------------------------------------\n")

      try{
      Username = scala.io.StdIn.readLine("\n Enter you Username: ")
      Password = scala.io.StdIn.readLine("\n Enter your Password: ")

      println(spark.sql("SELECT * FROM USERS"))
      LoginStatement = login(Username, Password)
      val permcheck = spark.sql(LoginStatement)
        var user = new users()
      permString = permcheck.head().getString(0)
        println(s"Checking the perm level : $permString")

        if(permString == "B")
          {
            user.basicUser
          }
        else if( permString == "A")
          {
            user.adminUser
          }


      println(s"Checking admin level: $permString")
      Count = Count + 1
      }
      catch
        {
          case e: java.util.NoSuchElementException => println("Username or Password is wrong. Try again.")
        }
    }
    else if (Input == "2") {
      println("Register new User\n ------------------------------------\n")
      var counterInputRegister: Int = 0

      while (counterInputRegister < 1) {
        try {
          Name = scala.io.StdIn.readLine("\n Enter Your Name: ")
          Username = scala.io.StdIn.readLine("\n Enter you Username: ")
          Password = scala.io.StdIn.readLine("\n Enter your Password: ")
          InsertUserStatement = newUser(Name, Username, Password)

        }
        catch {
          case e: FileNotFoundException => "Print User already exists"

        }
      }
    }
    else {

      println(s"$errorString 1 or 2")


    }


  }

  // End of the first section

}




def login(username:String, password:String): String =
  {
    var SelectStatment: String = s"Select adminlevel from users where username = '$username' and password = '$password'"
    (

    )

    println(SelectStatment)
    return SelectStatment
  }

def newUser(name:String,username:String, password:String): String =
    {
      var InsertStatement: String = s"INSERT INTO USERS VALUES(0, $name, $username, $password)"
      println(InsertStatement)
      return InsertStatement
    }

  }


}
