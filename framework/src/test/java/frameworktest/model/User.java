package frameworktest.model;

public class User {
    private String userName;
    private String userSurname;
    private String userPhoneNumber;
    private String userPassword;

    public User(String name, String  surname, String phone, String password){
        userName = name;
        userSurname = surname;
        userPhoneNumber = phone;
        userPassword = password;
    }

    public String getUserName() { return  userName; };
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserSurname() { return  userSurname; };
    public void setUserSurname(String userSurname) { this.userSurname = userSurname; }

    public String getUserPhoneNumber() { return  userPhoneNumber; };
    public void setUserPhoneNumber(String userPhoneNumber) { this.userPhoneNumber = userPhoneNumber; }

    public String getUserPassword() { return  userPassword; };
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    @Override
    public String toString() {
        return "User: " + userName + " " + userPhoneNumber  + " " + userPassword;
    }
}
