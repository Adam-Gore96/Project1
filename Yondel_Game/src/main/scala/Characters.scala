object Characters {

  class Characters(var name:String, var job:String)
  {
    var Char_name:String = this.name
    var Char_job:String = this.job
    var Level: Int = 0
    var Inventory =new Array[String](5)
    var Weapon: String = new String
    var health: Int =100

    var damn: String = "cool"
  }

}


