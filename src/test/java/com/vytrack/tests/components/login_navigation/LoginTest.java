package com.vytrack.tests.components.login_navigation;

import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest1(){
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.clickRememberMe();
        loginPage.login(username,password);
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(VYTrackUtils.getPageSubTitle(), "Dashboard");
    }

    @Test
   public void negativeLoginTest1(){
        loginPage.login("wrongUsername","wrongpassword");
        Assert.assertEquals(loginPage.getErrorMessage(),"Invalid user name or password.");
   }

   public void rememberMeTest1(){

   }

   /* WebDriver driver;

    String userNameIdLocator = "prependedInput";
    String passwordIdLocator = "prependedInput2";
    String loginIdLocator = "_submit";
    String userDropDownCSSLocator = "#user-menu>.dropdown-toggle";
    String logoutCssLocator = "[href='/user/logout']";

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
//        String expectedName = "Edd Turner";
//        String actualName = driver.findElement(By.cssSelector(userDropDownCSSLocator)).getText();
//        System.out.println(actualName);
//        Assert.assertEquals(actualName, expectedName);
        Assert.assertTrue(driver.getCurrentUrl().equals("http://qa2.vytrack.com/"));

        driver.findElement(By.className("dropdown-toggle")).click();

        driver.findElement(By.cssSelector(logoutCssLocator)).click();

        Assert.assertTrue(driver.getCurrentUrl().equals("http://qa2.vytrack.com/user/login"));


        driver.findElement(By.id(userNameIdLocator)).sendKeys("user1");


        driver.findElement(By.id(passwordIdLocator)).sendKeys("UserUser123");
        driver.findElement(By.id(loginIdLocator)).click();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://qa2.vytrack.com/"));




    }*/

}


















