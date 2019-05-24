/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */
package Com.Bose.Corporation.TestSuite.Home;

import Com.Bose.Corporation.Base.CommomnFunctions;
import Com.Bose.Corporation.Base.TestBase;
import Com.Bose.Corporation.PageObjects.HomePage.HomePage;
import Com.Bose.Corporation.Utilities.Listener.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestListener.class})
@Feature(value = "HomePageTest")
public class HomePageTest extends TestBase {

    HomePage homePage;
    CommomnFunctions commomnFunctions ;

    public HomePageTest(){
        super(driver);
    }


    @BeforeClass
    public void listen() throws InterruptedException {
        appiumserver();
        Thread.sleep(20000);
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initializeAutomation();
        homePage = new HomePage(driver);
        commomnFunctions = new CommomnFunctions();
    }

    @Test (priority = 0, description = "user onboarding and connecting buds.", testName = "116935")
    @Severity(SeverityLevel.NORMAL)
    @Description("user onboarding and connecting buds.")
    public void TC_HP_C116935() throws InterruptedException {
        propFile();
        homePage.setupBoseSleepBuds();
        String title = homePage.sleepbudsText.getText();
        String  budsTitle = prop.getProperty("sleepBuds");

        /**
         * validation
         */
        Assert.assertEquals(title,budsTitle);

    }

    @AfterMethod
    public void tearDown() {
        driver.closeApp();

    }

    @AfterClass
    public void Kill() throws InterruptedException {
        Thread.sleep(2000);
        stopServer();

    }
}
