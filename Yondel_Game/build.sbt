
version := "0.1"
scalaVersion := "2.12.10"

lazy val root = (project in file("."))
  .settings(
    name := "Yondel_Game"
  )
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.1.2"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "3.1.2"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.25"
libraryDependencies += "com.lihaoyi" %% "upickle" % "0.9.5"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.2"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.2.2"