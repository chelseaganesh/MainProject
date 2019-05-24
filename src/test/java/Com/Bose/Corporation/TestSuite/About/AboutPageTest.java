/*
 * Developed by Karthika
 * Copyright (c) 2019. Bose Corporation. All rights reserved.
 */

package Com.Bose.Corporation.TestSuite.About;

import Com.Bose.Corporation.Base.TestBase;
import Com.Bose.Corporation.PageObjects.About.AboutPage;
import Com.Bose.Corporation.PageObjects.HomePage.HomePage;
import Com.Bose.Corporation.Utilities.Listener.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListener.class)
@Feature("AboutPage Test")
public class AboutPageTest extends TestBase {

    //public static AppiumDriver driver;
    HomePage home;
    AboutPage about;

    public AboutPageTest(){

        super(driver);
    }

    @BeforeClass
    public void listen() throws InterruptedException {
        startServer();
        Thread.sleep(20000);

    }
    @BeforeMethod
    public void setup() throws InterruptedException {
        initializeAutomation();
        about = new AboutPage(driver);
        home = new HomePage(driver);
    }


    @Test (priority = 1, testName = "117939")
    @Description("Tap on the About button from the scanning screen")
    /*Tap on the About button from the scanning screen*/
    public void AB001_C117939() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.clickAboutIcon();
        Assert.assertEquals(about.buttonProductSupport.getText(), "Product Support");
    }

    @Test (priority = 2, testName = "117941")
    @Description("Tap on the 'x' button on the top right corner of the About page")
    /*Tap on the 'x' button on the top right corner of the About page*/
    public void AB002_C117941() throws InterruptedException {
        home.setupBoseSleepBuds();

        about.clickAboutIcon();
        about.waitForSometime(5000);

        about.clickCloseButton();
        about.waitForSometime(5000);

    }

    @Test (priority = 3, testName = "117942")
    @Description("Android]Select the Back button on the Android Phone, when user is on About page")
    /*[Android]Select the Back button on the Android Phone, when user is on About page*/
    public void AB003_C117942() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.waitForSometime(5000);

        about.clickAboutIcon();
        about.waitForSometime(5000);

        about.navigateBack();

    }

    @Test (priority = 4, enabled = true, testName = "117943")
    @Description("Bringing the App from background to foreground when app is on the About screen")
    /*Bringing the App from background to foreground when app is on the About screen*/
    public void AB004_C117943() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.waitForSometime(5000);

        about.clickAboutIcon();
        about.waitForSometime(5000);

        driver.runAppInBackground(Duration.ofSeconds(10));

        /*String s = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s, "com.bose.corporation.bosesleep.screens.about.AboutActivity");

        about.waitForSometime(5000);*/
    }

    @Test (priority = 5, enabled = true, testName = "117945")
    @Description("Tap on Feedback button from About list page")
    /*Tap on Feedback button from About list page*/
    public void AB005_C117945() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.waitForSometime(5000);

        about.clickAboutIcon();
        about.waitForSometime(5000);

        about.clickFeebbackOption();
        /*String s = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s, "com.bose.corporation.bosesleep.screens.about.feedback.FeedbackActivity");*/
        Assert.assertEquals(about.titleFeedbackt.isDisplayed(),true);

    }

    @Test (priority = 6, enabled = true, testName = "117953")
    @Description("Tap on the Bose.com from the About list page")
    /*Tap on the Bose.com from the About list page*/
    public void AB006_C117953() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.waitForSometime(5000);

        about.clickAboutIcon();
        about.waitForSometime(5000);

        about.clickBosedotcom();

        about.waitForSometime(5000);
    }

    @Test (priority = 7, enabled = true, testName = "117954")
    @Description("Tap on the Back button to navigate to Hypno About list from Bose.com")
    /*Tap on the Back button to navigate to Hypno About list from Bose.com*/
    public void AB007_C117954() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.waitForSometime(5000);

        about.clickAboutIcon();
        about.waitForSometime(5000);

        about.clickBosedotcom();
        about.waitForSometime(5000);

        //about.navigateBack();
        about.tap_backtoAPP();
        about.waitForSometime(5000);

        /*String s = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s, "com.bose.corporation.bosesleep.screens.about.AboutActivity");*/

    }

    @Test (priority = 8, enabled = true, testName = "117957")
    @Description("Tap on the Privacy Policy & Settings button on the About list page")
    /*Tap on the Privacy Policy & Settings button on the About list page*/
    public void AB008_C117957() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.waitForSometime(5000);

        about.clickAboutIcon();
        about.waitForSometime(5000);

        about.clickPrivacyPolicyOption();
        about.waitForSometime(5000);

        Assert.assertEquals(about.privacyPolicyHyperlink.getText(), "https://worldwide.bose.com/privacypolicy");
    }

    @Test (priority = 9, enabled = true, testName = "117958")
    @Description("Tap on the back button to navigate from the Privacy Policy page to Hypno About list")
    /*Tap on the back button to navigate from the Privacy Policy page to Hypno About list*/
    public void AB009_C117958() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.waitForSometime(5000);

        about.clickAboutIcon();
        about.waitForSometime(5000);

        about.clickPrivacyPolicyOption();
        about.waitForSometime(5000);

        about.clickPrivacyPolicyBackButton();
        about.waitForSometime(5000);

        Assert.assertEquals(about.buttonPrivacyPolicy.isDisplayed(),true);

        /*String s = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s, "com.bose.corporation.bosesleep.screens.about.AboutActivity");*/
    }

    @Test (priority = 10, enabled = true, testName = "117960")
    @Description("Tap on the close button to navigate from the Privacy Policy page to Hypno About list")
    /*Tap on the close button to navigate from the Privacy Policy page to Hypno About list*/
    public void AB010_C117960() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.waitForSometime(5000);

        about.clickAboutIcon();
        about.waitForSometime(5000);

        about.clickPrivacyPolicyOption();
        about.waitForSometime(5000);

        about.clickPrivacyPolicyCloseButton();
        about.waitForSometime(5000);

        /*String s = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s, "com.bose.corporation.bosesleep.screens.search.SearchingActivity ");*/

        Assert.assertEquals(about.buttonAbout.isDisplayed(),true);
    }

    @Test (priority = 11, enabled = true, testName = "117959")
    @Description("Verification of License agreement in 'LEGAL' screen of the about list page")
    /*Verification of License agreement in 'LEGAL' screen of the about list page*/
    public void AB010_C117959() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.waitForSometime(5000);

        about.clickAboutIcon();
        about.waitForSometime(5000);

        about.clickLegalOption();
        about.waitForSometime(5000);

        about.clickLicenseAgreement();
        about.waitForSometime(5000);
        about.waitForSometime(5000);
        about.waitForSometime(5000);

        /*String s = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s, "com.bose.corporation.boselegal.activity.HtmlEulaActivity");*/

        Assert.assertEquals(about.titleLicenseAgreement.isDisplayed(),true);
    }

    @Test (priority = 12, enabled = true, testName = "117964")
    @Description("Tap on the back button to navigate back to the 'LEGAL' page from 'License agreement' page")
    /*Tap on the back button to navigate back to the 'LEGAL' page from 'License agreement' page*/
    public void AB011_C117964() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.waitForSometime(5000);

        about.clickAboutIcon();
        about.waitForSometime(5000);

        about.clickLegalOption();
        about.waitForSometime(5000);

        about.clickLicenseAgreement();
        about.waitForSometime(5000);

        about.licenseAgreementBackButton();
        about.waitForSometime(5000);


        Assert.assertEquals(about.buttonLicenseAgreement.isDisplayed(),true);

        /*String s = ((StartsActivity) driver).currentActivity();


        Assert.assertEquals(s, "com.bose.corporation.boselegal.activity.HtmlLegalActivity");*/
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
