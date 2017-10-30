package ru.company.autotests.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Иванка on 29.10.2017.
 */
public class TestProperties {
    private final Properties properties= new Properties();
    private static TestProperties INSTANCE = null;

    private TestProperties() {
        try {
            properties.load(new FileInputStream(new File("./" + "application.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new  TestProperties();
        }
        return INSTANCE;
    }
}
