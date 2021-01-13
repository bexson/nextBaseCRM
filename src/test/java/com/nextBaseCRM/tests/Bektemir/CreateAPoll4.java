package com.nextBaseCRM.tests.Bektemir;

import com.nextBaseCRM.tests.Bektemir.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class CreateAPoll4 {
    WebDriver driver;

    @BeforeClass
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeDriver(){
    WebDriverFactory.sleep(5);
    driver.close();
    }


}
