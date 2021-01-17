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

    @BeforeClass
    public void setupDriver(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();

       WebDriverFactory.manageWebDriver(driver);
       driver.get("https://login2.nextbasecrm.com/stream/");
      WebDriverFactory.sleep(2);
    }

    @AfterClass
    public void closeDriver(){
        WebDriverFactory.sleep(2);
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
//==================================FINISHED WITH MY PRE-CONDITION======================================================
    }

   @Test
    public void test_execution_forUS4(){
//==================================DOING STEP 1 IN MY TEST EXECUTION====================================================
        driver.findElement(By.id("feed-add-post-form-tab-vote")).click();
       WebDriverFactory.sleep(2);
//==================================DOING STEP 2 IN MY TEST EXECUTION====================================================
     driver.switchTo().frame(0);
     WebElement mainField = driver.findElement(By.xpath("//body[@contenteditable='true']"));
     mainField.sendKeys("Testing My Poll");
     driver.switchTo().defaultContent();
       WebDriverFactory.sleep(5);
//==================================DOING STEP 3 IN MY TEST EXECUTION====================================================
   WebElement addMoreElement = driver.findElement(By.xpath("//a[.='Add more']"));
   addMoreElement.click();
       WebDriverFactory.sleep(3);
   driver.findElement(By.xpath("//div[.='Sevara Isroilova']/div")).click();
       WebDriverFactory.sleep(3);
   driver.findElement(By.xpath("//span[@class='popup-window-close-icon']")).click();
       WebDriverFactory.sleep(3);
//==================================DOING STEP 4 IN MY TEST EXECUTION====================================================
       WebElement questionFIeld = driver.findElement(By.cssSelector("input#question_0"));
       questionFIeld.sendKeys("Who is the best soccer player in 2020?");
       WebDriverFactory.sleep(3);
//==//===============================DOING STEP 5 IN MY TEST EXECUTION====================================================
     WebElement answerField = driver.findElement(By.id("answer_0__0_"));
     answerField.sendKeys("Cristiano Ronaldo");
       WebDriverFactory.sleep(4);
//==//===============================DOING STEP 6 IN MY TEST EXECUTION====================================================
         WebElement checkbox = driver.findElement(By.id("multi_0"));
         checkbox.click();
       WebDriverFactory.sleep(3);
//==//===============================DOING STEP 7 IN MY TEST EXECUTION====================================================
      WebElement addQuestion = driver.findElement(By.xpath("//a[.='Add question']"));
      addQuestion.click();
       WebDriverFactory.sleep(4);
//==//===============================DOING STEP 8 IN MY TEST EXECUTION====================================================
      WebElement sendButton = driver.findElement(By.cssSelector("button#blog-submit-button-save"));
      sendButton.click();
       WebDriverFactory.sleep(5);
//==================================DOING STEP 9 IN MY TEST EXECUTION====================================================
   // WebElement cancelButton = driver.findElement(By.xpath("//*[@class='ui-btn ui-btn-lg ui-btn-link']"));
   // cancelButton.click();
    }



}
