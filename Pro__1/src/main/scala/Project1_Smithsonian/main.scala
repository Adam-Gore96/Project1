package Project1_Smithsonian

import org.apache.spark.sql._


object main {
  def main(args: Array[String]): Unit = {


    /**
     *

    System.setProperty("hadoop.home.dir", "C:\\hadoop")
    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark = SparkSession
      .builder
      .appName("hello hive")
      .config("spark.master", "local[*]")
      .enableHiveSupport()
      .getOrCreate()

    println("created spark session")
    spark.sparkContext.setLogLevel("ERROR")
    val jsonData_1 = spark.sqlContext.read.json("C:\\Users\\AdamG\\Desktop\\Pro__1\\Input\\0f.json")
    //Dataframe jasonData_1 = spark.read.option("multiline","true").json("C:\\Users\\AdamG\\Desktop\\Pro__1\\Input\\0f.json").toDF().show()
    //val content = jsonData_1.select(explode(df("content")))
    jsonData_1.printSchema()
   // print(jasonData_1)
    jsonData_1.show(false)
    jsonData_1.explain()

     */


    var home = new homeScreen
   home.homeScreen.startScreen()





    //jsonData_1.show()


  }

}
