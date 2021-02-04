package com.nextBaseCRM.tests.Bayana;

import com.nextBaseCRM.tests.Bektemir.utilities.WebDriverFactory;
import com.nextBaseCRM.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SendAnEvent  {

    public WebDriver driver;


    @BeforeClass
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/stream/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public void close(){

    }

@Test
    public void preCondition(){

    driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing33@cybertekschool.com"); //username
    driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");//password
    driver.findElement(By.className("login-btn")).click();//click login button
    String expectedURL = "https://login2.nextbasecrm.com/stream/?login=yes";
    String actualURL = driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);

}
@Test
    public void test_case_1(){

    driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span")).click();
    driver.findElement(By.xpath("//input[@id='feed-cal-event-namecal_3Jcl']")).sendKeys("Test Event");
    driver.findElement(By.xpath("//button[@id='blog-submit-button-save']")).click();


}
@Test


    public void test_case_2() {
        preCondition();
       driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span")).click();
       driver.findElement(By.xpath("//input[@id='feed-cal-event-namecal_3Jcl']")).sendKeys("Test Event");
       WebDriverFactory.sleep(2);
       driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']")).click();
}


@Test
    public void test_case_3() {

        preCondition();

       driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span")).click();
       WebDriverFactory.sleep(2);
       driver.findElement(By.xpath("//input[@name='DATE_FROM']")).click();
       WebDriverFactory.sleep(2);
       driver.findElement(By.xpath("//a[@class='bx-calendar-cell'][@data-date='1614297600000']")).click();
       WebDriverFactory.sleep(2);
       driver.findElement(By.xpath("//input[@id='feed_cal_event_from_timecal_3Jcl']"));
       WebDriverFactory.sleep(2);
       driver.findElement(By.xpath("//input[@title='Hours']")).sendKeys("9");
       WebDriverFactory.sleep(2);
       driver.findElement(By.xpath("//input[@title='Minutes']")).sendKeys("00");









}





}
