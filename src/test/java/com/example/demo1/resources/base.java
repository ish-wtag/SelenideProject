package com.example.demo1.resources;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class base {

    public static Properties prop;
    public static void setUpAll() throws IOException {
        prop= new Properties();
        FileInputStream fis= new FileInputStream("src/test/java/com/example/demo1/resources/data.properties");
        prop.load(fis);
        Configuration.browser= prop.getProperty("browser");
        Configuration.browserSize = prop.getProperty("browserSize");
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}