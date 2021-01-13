package com.nextBaseCRM.tests.Bektemir;

import com.nextBaseCRM.tests.Bektemir.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateAPoll4 {
    WebDriver driver;

    public static void manageWebDriver(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    public static void findElementXpath(String stringXpath, WebDriver driver){
        driver.findElement(By.xpath(stringXpath));
    }
    public static void sleep(long seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            System.out.println("Can't handle with Interrupted exception");
        }
    }

    @BeforeClass
    public void setupDriver(){
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();

       manageWebDriver(driver);
       driver.get("https://login2.nextbasecrm.com/stream/");
      sleep(2);

    }



}
