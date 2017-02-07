package org.ua.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.hibernate.internal.util.ConfigHelper.getResourceAsStream;

/**
 * Created by u0100 on 04.07.2016.
 */
public class PropertiesReader {


    public static String pathToApartament(){
        InputStream inputStream;
        Properties properties = new Properties();
        String propFile = "application.properties";
        inputStream = getResourceAsStream(propFile);

        if (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new FileNotFoundException("property file '" + propFile + "' not found in the classpath");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        String patch = properties.getProperty("APARTAMENTS_URL");
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patch;
    }

}
