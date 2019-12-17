package frameworktest.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("review"));
    public  static String getTest(String key){return resourceBundle.getString(key);}
}
