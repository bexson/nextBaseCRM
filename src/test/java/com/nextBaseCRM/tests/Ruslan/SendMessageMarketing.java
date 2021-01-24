package com.nextBaseCRM.tests.Ruslan;

import com.github.javafaker.Faker;
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

public class SendMessageMarketing {
    WebDriver driver;
    Faker faker = new Faker();

    @BeforeClass
    public void setupDriverAndLogin() {
        //setup
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        WebDriverFactory.manageWebDriver(driver);
        driver.get("https://login2.nextbasecrm.com/stream/");
        WebDriverFactory.sleep(1);

        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //login
        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing33@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.className("login-btn")).click();

        String expectedURL = "https://login2.nextbasecrm.com/stream/?login=yes";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);
    }

    @AfterClass
    public void closeDriver() {
        WebDriverFactory.sleep(3);
        driver.close();
    }


    @Test
    //Verify users can send message by clicking "MESSAGE" tab
    public void testCase1() {
        WebDriverFactory.sleep(1);
        driver.findElement(By.id("feed-add-post-form-tab-message")).click();
        WebDriverFactory.sleep(1);


        driver.switchTo().frame(0);

        String msg = faker.book().author();
        driver.findElement(By.xpath("//body[@contenteditable='true'] ")).clear();
        driver.findElement(By.xpath("//body[@contenteditable='true'] ")).sendKeys(msg);
        driver.switchTo().defaultContent();
        WebDriverFactory.sleep(1);

        driver.findElement(By.xpath("//*[@id=\"blog-submit-button-save\"]")).click();
        WebDriverFactory.sleep(1);

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+msg+"']")).isDisplayed(),"Test failed");


    }

    @Test
    //Verify users can cancel message.
    public void testCase2(){
        WebDriverFactory.sleep(1);
        driver.findElement(By.id("feed-add-post-form-tab-message")).click();
        WebDriverFactory.sleep(1);



        WebElement checkCancelButton = driver.findElement(By.xpath("//*[@id=\"blog-submit-button-cancel\"]"));
        checkCancelButton.click();
        WebDriverFactory.sleep(1);

        boolean result = checkCancelButton.isDisplayed(); //should be false
        if(result==false){
            System.out.println("Cancel button is not Displayed");
        }
    }

    @Test
    //3. Verify users can attach link by clicking on the link icon.
    public void testCase3(){
        WebDriverFactory.sleep(1);
        driver.findElement(By.id("feed-add-post-form-tab-message")).click();
        WebDriverFactory.sleep(1);

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//body[@contenteditable='true'] ")).clear();
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[@id=\"bx-b-link-blogPostForm\"]/span/i")).click();

        driver.findElement(By.xpath("//*[@id='linkidPostFormLHE_blogPostForm-href']")).sendKeys("youtube.com");
        WebDriverFactory.sleep(1);

        driver.findElement(By.className("adm-btn-save")).click();

        driver.switchTo().frame(0);

        WebElement checkLink = driver.findElement(By.linkText("youtube.com"));

        checkLink.isDisplayed();



    }

}
