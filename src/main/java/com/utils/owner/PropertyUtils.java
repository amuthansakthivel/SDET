package com.utils.owner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){}
    /*
    1. Explicit call to readPropertyFile
    2. Improper exception shown to user
    3. We are connecting to external file every time we fetch a value
    4. When there is an exception, we have to stop the program.
    5. Fetching integer, boolean or list values not possible
     */

    public static String readPropertyFile(String key){
        Properties properties = null;
        FileInputStream inputStream=null;
        try {
            inputStream = new FileInputStream(
                    System.getProperty("user.dir") +
                            "/src/test/resources/FrameworkConfig1.properties");
            properties = new Properties();
            properties.load(inputStream);
        }
        catch (FileNotFoundException e){
            //e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }

}
