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
    public void DriverSetUp (){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/stream/");
        sensitiveData = new SensitiveData();

    }

    @Test
    public void PreConditions (){
        //Creating the pre-condition to user story 13 (Login In)
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
    public void TestCaseG17_83(){

    }


}
