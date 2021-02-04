package com.nextBaseCRM.tests.base;

import com.nextBaseCRM.tests.Bektemir.utilities.ConfigurationReader;
import com.nextBaseCRM.tests.Bektemir.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public WebDriver driver;
    protected final String url = ConfigurationReader.getProperty("url");
    protected final String helpdesk = ConfigurationReader.getProperty("username1");
    protected final String hrUser = ConfigurationReader.getProperty("username3");
    protected final String marketing = ConfigurationReader.getProperty("username5");
    protected final String password = ConfigurationReader.getProperty("password");

    // please guys don't change here anything
    @BeforeClass // this will run 1 time only before class
    public void setupClass(){
        driver = WebDriverFactory.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass // this will run 1 time only after class
    public void closeClass(){
      driver.close();
    }
}
