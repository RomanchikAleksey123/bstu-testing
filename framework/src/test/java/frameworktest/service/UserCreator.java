package frameworktest.service;

import frameworktest.model.User;

public class UserCreator {
    public static final String USER_NAME = "Ivan123";
    public static final  String USER_SURNAME = "Ivanovich";
    public static final String USER_PHONE_NUMBER = "336025325";
    public static final String USER_PASSWORD = "12345678";

    public  static  User createUserFromProperties(){
        return new User(USER_NAME, USER_SURNAME,
                USER_PHONE_NUMBER, USER_PASSWORD);
    }

    public  static  User createEmptyUser(){
        return  new User("","","","");
    }
}
