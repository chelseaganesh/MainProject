
/*
 * Developed by Rajesh.
 * Copyright (c) 2019. Bose corporation. All rights reserved.
 */

package Com.Bose.Corporation.TestSuite.Settings;

import Com.Bose.Corporation.Base.TestBase;
import Com.Bose.Corporation.PageObjects.HomePage.HomePage;
import Com.Bose.Corporation.PageObjects.Settings.SettingsPage;
import Com.Bose.Corporation.Utilities.Listener.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners({TestListener.class})
@Feature("SettingsPage Test")
public class SettingsPageTest extends TestBase {

    HomePage homePage;
    SettingsPage settingsPage;
    /**
     * Appium Driver
     */
    public SettingsPageTest() {
        super(driver);
    }

    @BeforeClass
    public void listen() throws InterruptedException {
        startServer();
        Thread.sleep(20000);
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initializeAutomation();
        homePage = new HomePage(driver);
        settingsPage = new SettingsPage(driver);
    }

    @Test(priority = 1, description = "Navigating to settings page and validation", testName = "116985")
    @Description("Navigating to settings page and validation")
    public void TC_Settings_C116985() throws Exception {
        homePage.setupBoseSleepBuds();
        settingsPage.Settings_Test();
    }

    @Test(priority = 2, description = "Nickname it page", testName = "116985")
    @Description("Nickname it page")
    public void TC_Settings_C116986() throws InterruptedException {
        homePage.setupBoseSleepBuds();
        settingsPage.tap_Settings_Gear();
        settingsPage.tap_Name();
        String header = settingsPage.edit_headphone_title.getText();

        /**
         * Validation
         */
        Assert.assertEquals(header, "Nickname It");
    }

    @Test(priority = 3, description = "Battery Page", testName = "")
    @Description("Battery Page")
    public void TC_Settings_C() throws InterruptedException {
        homePage.setupBoseSleepBuds();
        settingsPage.tap_Settings_Gear();
        settingsPage.tap_Battery();
        String header = settingsPage.screen_title.getText();

        /**
         * Validation
         */
        Assert.assertEquals(header, "Battery");
    }

    @Test(priority = 4, description = "Product Info", testName = "")
    @Description("Product Info")
    public void TC_Settings_C1() throws InterruptedException {
        homePage.setupBoseSleepBuds();
        settingsPage.tap_Settings_Gear();
        settingsPage.tap_ProductInfo();
        String header = settingsPage.productTitle.getText();

        Assert.assertEquals(header, "Product Info");
    }

    @Test(priority = 5, description = "Sleep Timer", testName = "")
    @Description("Sleep Timer")
    public void TC_Settings() throws InterruptedException {
        homePage.setupBoseSleepBuds();
        settingsPage.tap_Settings_Gear();
        settingsPage.tap_SleepTimer();
        String header = settingsPage.sleeptimer_Header.getText();

        Assert.assertEquals(header, "Sleep Timer");
    }

    @AfterMethod
    public void tearDown() {
        driver.closeApp();
    }

    @AfterClass
    public void kill() throws InterruptedException {
        Thread.sleep(20000);
        stopServer();
    }
}
