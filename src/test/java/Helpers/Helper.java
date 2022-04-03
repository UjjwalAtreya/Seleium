package Helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.util.Strings;

import java.io.*;
import java.util.Properties;

public class Helper {
    public static Properties prop;
    static {
        prop = new Properties();
    }

    public static void readConfig() {
        String workingDir = System.getProperty("user.dir")+"/src/test/java/Resources/userData.xml";
        try {
            File file = new File(workingDir);
            FileInputStream fileInput = new FileInputStream(file);
            prop.loadFromXML(fileInput);
            fileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
