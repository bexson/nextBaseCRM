package com.nextBaseCRM.tests.Khrystyna;

import com.nextBaseCRM.tests.Khrystyna.utilities.SensitiveData;
import com.nextBaseCRM.tests.Khrystyna.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class LogIn_1 {

    WebDriver driver;
    SensitiveData sensitiveData;


    @BeforeClass
    public void driverSetup(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       driver.get("https://login2.nextbasecrm.com/stream/");

    }

    @BeforeTest
    public void setup(){
        sensitiveData = new SensitiveData();
    }


    @Test(priority = 1 )
    public void test_case_G17_90() throws InterruptedException {
        //                              Verify HELPDESK USER can login
        //========================================================================================================//
        //locating login & password fields
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(sensitiveData.getHelpDeskEmail());;
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(sensitiveData.getPassword());

        //locating "Remember me on this computer" button
        driver.findElement(By.id("USER_REMEMBER")).click();

        //locating login button & login to WebSite
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        //Comparing expectedURL with actualURL
        String expectedURL = "https://login2.nextbasecrm.com/stream/?login=yes";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);
        //------------------------------------------------------------------------------------------------------------//
        //                                          log out
        //locating dropdown to logOut
        driver.findElement(By.cssSelector("div[class='user-block']")).click();

        //locating logOut button >>> log out
        driver.findElement(By.xpath("//span[.='Log out']")).click();
        WebDriverFactory.sleep(5);

        //===========================================================================================================//

    }


    @Test(priority = 2)
    public void test_case_G17_89(){
        //                              Verify HELPDESK USER can save email
        //============================================================================================================//

        //locating login & password fields
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(sensitiveData.getHelpDeskEmail());;
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(sensitiveData.getPassword());

        //locating "Remember me on this computer" button
        driver.findElement(By.id("USER_REMEMBER")).click();

        //locating login button & login to WebSite
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        //logout
        driver.findElement(By.cssSelector("div[class='user-block']")).click();

        //locating logOut button >>> log out
        driver.findElement(By.xpath("//span[.='Log out']")).click();
        //locating logIn field to see if our email is saved
        String ActualResult = driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).getAttribute("value");
        String ExpectedResult = sensitiveData.getHelpDeskEmail();

        Assert.assertEquals(ExpectedResult, ActualResult, "LogIn information is not saved or wrong");

        //============================================================================================================//

}

    @Test(priority = 3)
    public void test_case_G17_91(){

        //              Verify HELPDESK USER can access to "FORGOT YOUR PASSWORD?"
        //===================================================================================================//

        //locating FORGET YOUR PASSWORD? button
        driver.findElement(By.className("login-link-forgot-pass")).click();

        //locating email field
        driver.findElement(By.className("login-inp")).clear();
        driver.findElement(By.name("USER_EMAIL")).sendKeys(sensitiveData.getHelpDeskEmail());

        //Locating RESET PASSWORD button
        driver.findElement(By.xpath("//button[.='Reset password']")).click();

        //creating actual and expected result
        String expectedResult ="A code to reset your password and your registration information has just been " +
                "sent to your e-mail address. Please check your e-mail. Note that the reset code is " +
                "re-generated on each request.";

        String actualResult = driver.findElement(By.className("notetext")).getText();

        Assert.assertEquals(expectedResult, actualResult, "Reset password confirmation FAILED!!!");

        //====================================================================================================//

    }

    @AfterClass
    public void tearDownClass(){
        WebDriverFactory.sleep(3);
        driver.close();
    }








}
