package com.nextBaseCRM.tests.fatih;

import com.nextBaseCRM.tests.Bektemir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory6 {

    public void sleep(long seconds){
        try{
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e){
            System.out.println("Thread got interrupted unexpectedly");
        }
    }


    WebDriver driver;
    @BeforeClass
    public void setupClass(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/stream/?login=yes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String id = "helpdesk33@cybertekschool.com";
        String password = "UserUser";
        driver.findElement(By.xpath("//body//input[@name = 'USER_LOGIN']")).sendKeys(id);
        driver.findElement(By.xpath("//body//input[@name = 'USER_PASSWORD']")).sendKeys(password + Keys.ENTER);
    }



    //Checking for help desk
    @Test
    public void testCase1(){

        //Click clock in button at the top on the right side
        WebElement workHoursMenu = driver.findElement(By.xpath("//body//span[@id ='timeman-block']"));
        workHoursMenu.click();

        //Click the clock in button in the window popped up
        WebElement clockInButton =  driver.findElement(By.xpath("//body//span[@class='webform-small-button tm-popup-main-button webform-small-button-accept']"));
        clockInButton.click();


        //WebElement workTimeCloseButton = driver.findElement(By.xpath("//body//div[@class='popup-window'][2]//div[@class='popup-window-buttons']//span[.='Close']"));

    }


    @Test
    public void testCase2(){
        WebElement clockOutButton = driver.findElement(By.xpath("//body//span[@class ='webform-small-button tm-popup-main-button webform-small-button-decline']"));
        clockOutButton.click();

    }

    @Test
    public void testCase3(){
        //Type the name of the task in the text area under Today's Task Section in Daily Plan tab
        WebElement taskTextArea = driver.findElement(By.xpath("//body//input[@class = 'tm-popup-task-form-textbox']"));
        taskTextArea.sendKeys("Hello hello is there anybody in there?");


        //Click the button with plus symbol next to the text area in the same section
        WebElement taskPlusButton = driver.findElement(By.xpath("//body//span[@class = 'tm-popup-task-form-submit']"));
        taskPlusButton.click();


    }

    @Test
    public void testCase4(){
        WebElement eventStartTime = driver.findElement(By.xpath("//body//input[@class = 'tm-popup-event-start-time-textbox_am_pm']"));
        sleep(1);
        eventStartTime.click();

        WebElement eventStartTimeHour = driver.findElement(By.xpath("//body//input[@title='Hours']"));
        eventStartTimeHour.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,"11");

        WebElement eventStartTimeMinute = driver.findElement(By.xpath("//body//input[@title='Minutes']"));
        eventStartTimeMinute.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,"0");

        WebElement startTimeSelect = driver.findElement(By.xpath("//body//span[@class='popup-window-button popup-window-button-create']"));
        startTimeSelect.click();

//        WebElement eventEndTime = driver.findElement(By.xpath("//body//input[@class = 'tm-popup-event-end-time-textbox_am_pm']"));
//        eventEndTime.click();

        WebElement eventEndTimeHour = driver.findElement(By.xpath("//body//input[@title='Hours']"));
        eventEndTimeHour.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,"11");

        WebElement eventEndTimeMinute = driver.findElement(By.xpath("//body//input[@title='Minutes']"));
        eventEndTimeMinute.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,"15");

        WebElement endTimeSelect = driver.findElement(By.xpath("//body//span[@class='popup-window-button popup-window-button-create']"));
        endTimeSelect.click();

        WebElement eventTextArea = driver.findElement(By.xpath("//body//input[@class = 'tm-popup-event-form-textbox_am_pm']"));
        eventTextArea.sendKeys("Daily Stand-Up Meeting");

        WebElement eventPlusButton = driver.findElement(By.xpath("//body//span[@class = 'tm-popup-event-form-submit']"));
        eventPlusButton.click();

    }
    @Test
    public void testCase5(){
        sleep(2);
        WebElement pencilIcon = driver.findElement(By.xpath("//body//span[@class = 'tm-popup-notice-pencil']"));
        pencilIcon.click();



        WebElement workStartTimeHour = driver.findElement(By.xpath("//body//td[@class='tm-double-clock-table-row tm-double-clock-table-first']//td[@rowspan='2']/input[@title='Hours']"));
        workStartTimeHour.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,"8");

        WebElement workStartMinute = driver.findElement(By.xpath("//body//td[@class='tm-double-clock-table-row tm-double-clock-table-first']//td[@rowspan='2']/input[@title='Minutes']"));
        workStartMinute.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,"0");




        WebElement workEndTimeHour = driver.findElement(By.xpath("//body//td[@class='tm-double-clock-table-row tm-double-clock-table-second']//td[@rowspan='2']/input[@title='Hours']"));
        workEndTimeHour.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,"12");

        WebElement workEndTimeMinute = driver.findElement(By.xpath("//body//td[@class='tm-double-clock-table-row tm-double-clock-table-second']//td[@rowspan='2']/input[@title='Minutes']"));
        workEndTimeMinute.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,"0");

        WebElement reasonTextArea = driver.findElement(By.xpath("//body//div[@class='popup-window'][2]//div[@class='bx-tm-popup-clock-wnd-report'][2]//textarea"));
        reasonTextArea.sendKeys("I'm done");


        WebElement workTimeSaveButton = driver.findElement(By.xpath("//body//div[@class='popup-window'][2]//div[@class='popup-window-buttons']//span[.='Save']"));
        workTimeSaveButton.click();


    }
}
