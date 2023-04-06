package com.perm.main;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PermMain {
    final static Logger logger = Logger.getLogger(PermMain.class);

    public static void main(String[] args) {

        try (InputStream input = PermMain.class.getClassLoader().getResourceAsStream("perm.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            // Java 8 , print key and values
            if(logger.isInfoEnabled()){
                prop.forEach((key, value) -> logger.info("Key : " + key + ", Value : " + value));
            }

        } catch (Exception ex) {
            logger.error("Unable to read properties file", ex);
        }

    }
}