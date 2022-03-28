class CreateNewUser {


  object CreateNewUser
  {
    private[this] var _userName: String = new String

    def userName: String = _userName

    def userName_=(value: String): Unit = {
      _userName = value
    }

    private[this] var _password: String = new String

    def password: String = _password

    def password_=(value: String): Unit = {
      _password = value
    }


  }

}
