import org.apache.spark.sql.SparkSession

object main {

  def main(args: Array[String]): Unit = {


  //Runtime.getRuntime().loadLibrary()

    System.setProperty("hadoop.home.dir", "C:\\hadoop")
    val spark = SparkSession
      .builder
      .appName("hello hive")
      .config("spark.master", "local")
      .enableHiveSupport()
      .getOrCreate()

    println("created spark session")
    spark.sparkContext.setLogLevel("ERROR")
    spark.sql("Set hive.exec.dynamic.partition.mode=nonstrict")
    spark.sql("DROP TABLE IF EXISTS dem").show()
    //spark.sql("create table dem(id INT,age INT, state STRING) partitioned by (gender STRING) row format delimited fields terminated by ',' stored as textfile").show()
    spark.sql("create table dem(id INT, age Int, state String)").show
    //var c = new ContextMenu()

    //c.homeMenu()


  }

}


