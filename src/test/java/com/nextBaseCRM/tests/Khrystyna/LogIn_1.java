package com.nextBaseCRM.tests.Khrystyna;

import com.nextBaseCRM.tests.Khrystyna.utilities.SensitiveData;
import com.nextBaseCRM.tests.Khrystyna.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import java.util.concurrent.TimeUnit;

public class LogIn_1 {

    WebDriver driver;


    @BeforeClass
    public void driverSetup(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       driver.get("https://login2.nextbasecrm.com/stream/");

    }

    @Test
    public void test_case_G17_90(){
        //Verify HELPDESK USER can login

        //========================================================================================================//
        //importing email & password INFO
        SensitiveData sensitiveData = new SensitiveData();

        //locating login & password fields
        WebElement loginField = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));

        //adding email/password
        loginField.sendKeys(sensitiveData.getHelpDeskEmail());
        passwordField.sendKeys(sensitiveData.getPassword());

        //locating "Remember me on this computer" button
        WebElement RememberMeButton = driver.findElement(By.id("USER_REMEMBER"));
        RememberMeButton.click();

        //locating login button & login to WebSite
        WebElement LoginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        LoginButton.click();

        //Comparing expectedURL with actualURL
        String expectedURL = "https://login2.nextbasecrm.com/stream/?login=yes";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL, "Actual URL is different from expectedURL, TEST FAILED!!! ");

        //===========================================================================================================//

    }
    @AfterMethod
    public void logOutMethod(){
        //================================================================================================//
        //locating dropdown to logOut
        WebElement LogoutDropdown = driver.findElement(By.cssSelector("div[class='user-block']"));
        LogoutDropdown.click();

        //locating logOut button >>> log out
        WebElement LogOutButton = driver.findElement(By.xpath("//span[.='Log out']"));
        LogOutButton.click();

        //==================================================================================================//
    }

    public void test_case_G17_91(){
        //Verify HELPDESK USER can login
    }

    @AfterClass
    public void tearDownClass(){
  //      driver.quit();
    }
}
