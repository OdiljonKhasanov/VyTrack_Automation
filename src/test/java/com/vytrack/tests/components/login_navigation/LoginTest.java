package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    String userNameIdLocator = "prependedInput";
    String passwordIdLocator = "prependedInput2";
    String loginIdLocator = "_submit";
    String userDropDownCSSLocator = "#user-menu>.dropdown-toggle";
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void LogInTestPositive(){

        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id(userNameIdLocator)).sendKeys("storemanager51");
        driver.findElement(By.id(passwordIdLocator)).sendKeys("UserUser123");
        driver.findElement(By.id(loginIdLocator)).click();
        SeleniumUtils.sleep(4);
        String expectedName = "Edd Turner";
        String actualName = driver.findElement(By.cssSelector(userDropDownCSSLocator)).getText();
        System.out.println(actualName);
        Assert.assertEquals(actualName, expectedName);
        driver.findElement(By.cssSelector(userDropDownCSSLocator)).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.id(loginIdLocator)).clear();
        driver.findElement(By.id(loginIdLocator)).sendKeys("user1");



    }

}


















