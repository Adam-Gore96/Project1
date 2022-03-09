object Characters {

  class Characters(var name:String, var job:String)
  {
    var Char_name:String = this.name
    var Char_job:String = this.job
    var Level: Int = 0
    var Inventory =new Array[String](5)
    var Weapon: String = new String
    var Health: Int =100

    //Getter and Setters for Character Name
    def getName():String =
    {

      return this.Char_name
    }
    def setName(s:String): Unit=
    {
      this.Char_name = s
    }

    //Getter and setters for Character Job
    def getJob():String =
    {
        return this.Char_job
    }
    def setJob(s:String): Unit=
    {
      this.Char_job = s
    }
    //Getter and Setters for Character level

    def getLevel(): Int=
    {
     return this.Level
    }
    def setLevel(s:Int): Unit=
    {
      this.Level=s
    }
    //Getter and Setter for character Inventory
    def getInventory():Array[String]=
    {
     return this.Inventory
    }

    def setInventory(i:Int, s:String): Unit=
    {
      this.Inventory(i) = s
    }
    //Getter and Setter for character Weapon
    def getWeapon(): String=
    {
       return this.Weapon
    }
    def setWeapon(s:String): Unit=
    {
      this.Weapon= s
    }
//Getter and Setter for character Health
    def getHealth(): Int =
    {
      return this.Health
    }
    def setHealth(s:Int): Unit=
    {
      this.Health = s
    }


  }

}


