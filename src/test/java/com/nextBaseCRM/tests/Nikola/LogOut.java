package com.nextBaseCRM.tests.Nikola;

import com.nextBaseCRM.tests.Nikola.utilities.SensitiveData;
import com.nextBaseCRM.tests.Nikola.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogOut {

    WebDriver driver;
    SensitiveData sensitiveData;

    @BeforeClass
    public void DriverSetUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/stream/");
        sensitiveData = new SensitiveData();

    }

    @Test
    public void Pre_Conditions_G17_83() {
                                //Creating the pre-condition for HELP DESK user (Login In)
        //========================================================================================
        //Locating Log In field
        WebElement LoginField = driver.findElement(By.name("USER_LOGIN"));
        LoginField.sendKeys(sensitiveData.getHelpDeskEmail());

        //Locating the password field
        WebElement PasswordField = driver.findElement(By.xpath("//input[@type='password']"));
        PasswordField.sendKeys(sensitiveData.getPassword());

        //Locating Log In button
        WebElement LogInButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        LogInButton.click();
    }

    @Test
    public void Test_Case_G17_83() {
                                //Verify HELP DESK user can log out
        //==========================================================================================
        // Locating Drop Down menu button
        WebElement DropDownButton = driver.findElement(By.cssSelector("div[id='user-block']"));
        DropDownButton.click();

        //Locating Log Out button
        WebElement LogOutButton = driver.findElement(By.xpath("//span[.='Log out']"));
        LogOutButton.click();

    }

    @Test
    public void Pre_Conditions_G17_84() {
                                 //Creating the pre-condition for HR user (Login In)
        //========================================================================================
        //Locating Log In field
        WebElement LoginField = driver.findElement(By.name("USER_LOGIN"));
        LoginField.sendKeys(sensitiveData.getHrEmail());

        //Locating the password field
        WebElement PasswordField = driver.findElement(By.xpath("//input[@type='password']"));
        PasswordField.sendKeys(sensitiveData.getPassword());

        //Locating Log In button
        WebElement LogInButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        LogInButton.click();
    }

    @Test
    public void Test_Case_G17_84() {
                                //Verify HELP DESK user can log out
        //==========================================================================================
        //Locating Drop Down menu button
        WebElement DropDownButton = driver.findElement(By.cssSelector("div[id='user-block']"));
        DropDownButton.click();

        //Locating Log Out button
        WebElement LogOutButton = driver.findElement(By.xpath("//span[.='Log out']"));
        LogOutButton.click();


    }

    @Test
    public void Pre_Conditions_G17_85() {
        //Creating the pre-condition for HR user (Login In)
        //========================================================================================
        //Locating Log In field
        WebElement LoginField = driver.findElement(By.name("USER_LOGIN"));
        LoginField.sendKeys(sensitiveData.getHrEmail());

        //Locating the password field
        WebElement PasswordField = driver.findElement(By.xpath("//input[@type='password']"));
        PasswordField.sendKeys(sensitiveData.getPassword());

        //Locating Log In button
        WebElement LogInButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        LogInButton.click();
    }

    @Test
    public void Test_Case_G17_85() {
        //Verify HELP DESK user can log out
        //==========================================================================================
        //Locating Drop Down menu button
        WebElement DropDownButton = driver.findElement(By.cssSelector("div[id='user-block']"));
        DropDownButton.click();

        //Locating Log Out button
        WebElement LogOutButton = driver.findElement(By.xpath("//span[.='Log out']"));
        LogOutButton.click();


    }

}

