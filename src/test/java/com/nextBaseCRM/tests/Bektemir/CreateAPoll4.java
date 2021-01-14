package com.nextBaseCRM.tests.Bektemir;

import com.nextBaseCRM.tests.Bektemir.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateAPoll4 {
    WebDriver driver;

    public void manageWebDriver(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    public void findElementXpath(String stringXpath, WebDriver driver){
        driver.findElement(By.xpath(stringXpath));
    }
    public void sleep(long seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            System.out.println("Can't handle with Interrupted exception");
        }
    }

    @BeforeClass
    public void setupDriver(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();

       manageWebDriver(driver);
       driver.get("https://login2.nextbasecrm.com/stream/");
      sleep(2);
    }

    @AfterClass
    public void closeDriver(){
        sleep(2);
        driver.close();
    }

    @Test
    public void pre_condition_for_US4(){
//==================================PRE-CONDITION FOR MY USER STORY4====================================================
         String expectedTitle = "Authorization";
         String actualTitle = driver.getTitle();
         Assert.assertEquals(expectedTitle,actualTitle);

        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk33@cybertekschool.com"); //username
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");//password

       driver.findElement(By.className("login-btn")).click();//click login button
         String expectedURL = "https://login2.nextbasecrm.com/stream/?login=yes";
         String actualURL = driver.getCurrentUrl();
         Assert.assertEquals(expectedURL,actualURL);
//==================================FINISHED WITH MY PRE-CONDITION====================================================
    }

    @Test
    public void test_execution_forUS4(){
//==================================DOING STEP 1 IN MY TEST EXECUTION====================================================
        driver.findElement(By.id("feed-add-post-form-tab-vote")).click();
        sleep(2);

//==================================DOING STEP 2 IN MY TEST EXECUTION====================================================
        driver.switchTo().frame(0);
        WebElement mainField = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        mainField.sendKeys("Testing My Poll");
        driver.switchTo().defaultContent();
//==================================DOING STEP 3 IN MY TEST EXECUTION====================================================
        WebElement addMoreElement = driver.findElement(By.xpath("//a[.='Add more']"));
        addMoreElement.click();
        driver.findElement(By.xpath("//div[.='Sevara Isroilova']/div")).click();
        driver.findElement(By.xpath("//span[@class='popup-window-close-icon']")).click();
//==================================DOING STEP 4 IN MY TEST EXECUTION====================================================
        WebElement questionFIeld = driver.findElement(By.cssSelector("input#question_0"));
        questionFIeld.sendKeys("Who is the best soccer player in 2020?");
//==================================DOING STEP 4 IN MY TEST EXECUTION====================================================
        WebElement answerField = driver.findElement(By.id("answer_0__0_"));
        answerField.sendKeys("Cristiano Ronaldo");

    }



}
