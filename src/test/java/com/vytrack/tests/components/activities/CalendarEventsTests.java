package com.vytrack.tests.components.activities;

import com.vytrack.pages.activities.CalendarEventsPage;
import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarEventsTests extends TestBase {

    @Test
    public void verifyTitleColumn(){

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarPage = new CalendarEventsPage();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        //login
        loginPage.login(username, password);
        //go to Calendar Events page
        VYTrackUtils.navigateToModule(Driver.getDriver(),"Activities", "Calendar Events");
        // deselect title option from grid settings
        VYTrackUtils.waitUntilLoaderScreenDisappear(Driver.getDriver());
        calendarPage.selectGridSetting("Title", false);
        SeleniumUtils.sleep(4);

        //Verify that title column name is not visible anymore
        Assert.assertTrue(calendarPage.verifyHeaderExists("Title"));
    }

}
