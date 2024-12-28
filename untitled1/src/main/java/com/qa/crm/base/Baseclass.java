package com.qa.crm.base;
import com.qa.crm.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Baseclass {
    public static WebDriver driver;
    public static Properties prop;
    public Baseclass(){
        //created a constructor to initalise the object
        try {
            prop = new Properties();
            //System.out.println( "com/qa/crm/config/config.properties"+ "/qa/config/config.properties");
            FileInputStream ip = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\untitled1\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
            prop.load(ip);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void initialization(){
        //creating a method
        String browserName = prop.getProperty("browser");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();



//        e_driver = new EventFiringWebDriver(driver);
//        // Now create object of EventListerHandler to register it with EventFiringWebDriver
//        eventListener = new WebEventListener();
//        e_driver.register(eventListener);
//        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, java.util.concurrent.TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}
