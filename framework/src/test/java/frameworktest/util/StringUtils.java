package frameworktest.util;

public class StringUtils {
    public  static  final int MAX_POSTFIX_LENGTH = 100000;
    public  static  String getRandomUserName(){
        String name = "Ivan";
        int postfix = (int) ( Math.random() *  MAX_POSTFIX_LENGTH);
        return  name + postfix;
    }
}
