/*
 * Developed by Karthika
 * Copyright (c) 2019. Bose Corporation. All rights reserved.
 */
package Com.Bose.Corporation.TestSuite.About;

import Com.Bose.Corporation.Base.TestBase;
import Com.Bose.Corporation.PageObjects.About.AboutPage;
import Com.Bose.Corporation.PageObjects.HomePage.HomePage;
import io.appium.java_client.android.StartsActivity;
import org.testng.Assert;
import org.testng.annotations.*;


public class AboutPageMainTest extends TestBase{

    HomePage home;
    AboutPage about;

    public AboutPageMainTest(){

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

    @Test (priority = 1)
    /*Navigate to all the options in the about menu*/
    public void optionsAboutMenu() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.navigateAboutPage();

    }

    @Test (priority = 2)
    /*Navigate to all the options in the about menu*/
    public void optionsAboutMenuClose() throws InterruptedException {
        home.setupBoseSleepBuds();
        about.clickAboutIcon();
        about.waitForSometime(20000);

        about.clickCloseButton();
        about.waitForSometime(20000);

        String s = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s, "com.bose.corporation.bosesleep.screens.search.SearchingActivity");


    }
    @Test (priority = 3)
    /*Navigate to Product Support Page and return back to about page**/
     public void optionProductSupport() throws InterruptedException{
         home.setupBoseSleepBuds();
         about.waitForSometime(10000);

         about.clickAboutIcon();
         about.waitForSometime(10000);

         about.clickProductSupportOption();
         about.waitForSometime(20000);

        String s = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s, ".custom_tab.SeparateTaskCustomTabActivity");

         about.waitForSometime(15000);
         about.navigateBack();

         about.waitForSometime(10000);

        String s2 = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s2, "com.bose.corporation.bosesleep.screens.about.AboutActivity");

    }

    @Test (priority = 4)
    /*Navigate to Product Support Page and return back to about page**/
    public void optionBoseWebpage() throws InterruptedException{
        home.setupBoseSleepBuds();
        about.waitForSometime(10000);

        about.clickAboutIcon();
        about.waitForSometime(10000);

        about.clickBosedotcom();
        about.waitForSometime(20000);

        String s = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s, ".custom_tab.SeparateTaskCustomTabActivity");

        about.waitForSometime(15000);
        about.navigateBack();

        about.waitForSometime(10000);

        String s2 = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s2, "com.bose.corporation.bosesleep.screens.about.AboutActivity");

    }

    @Test (priority = 5)
    /*To navigate to Privacy Policy screen, validate its contents and return back to about screen*/
    public void optionPrivacyPolicy() throws InterruptedException{
        home.setupBoseSleepBuds();
        about.waitForSometime(1000);

        about.clickAboutIcon();
        about.waitForSometime(1000);

        about.clickPrivacyPolicyOption();
        about.waitForSometime(20000);

        /*Verify the header*/
        Assert.assertEquals(about.titlePrivacyPolicy.getText(), "Privacy Policy");

        /*Verify the presence of text Diagnostic & Usage an also if it is displayed*/

        Assert.assertEquals(about.privacyPolicyDU.isDisplayed(),true);

        Assert.assertEquals(about.privacyPolicyDU.getText(), "Diagnostic & Usage");



        /*Verify the presence of text Diagnostic & Usage an also if it is displayed*/

        Assert.assertEquals(about.privacyPolicyContent.isDisplayed(),true);

        Assert.assertEquals(about.privacyPolicyContent.getText(), "Bose Sleep QA collects diagnostic and usage data to improve our products and services and troubleshoot errors. If you do not want us to collect this data, you can opt out below. Crash reporting may stay active until your device is restarted.");

        /*Verify the presence of text 'share data with bose'*/

        Assert.assertEquals(about.privacyPolicySwitchText.isDisplayed(),true);

        Assert.assertEquals(about.privacyPolicySwitchText.getText(), "Share data with Bose");

        /*Verify the hyperlink header*/

        Assert.assertEquals(about.privacyPolicyHyperlinkHeader.isDisplayed(),true);

        Assert.assertEquals(about.privacyPolicyHyperlinkHeader.getText(), "Bose Privacy Policy");

        /*Verify the hyperlink sub content*/

        Assert.assertEquals(about.privacyPolicyHyperlinkSubContent.isDisplayed(),true);

        Assert.assertEquals(about.privacyPolicyHyperlinkSubContent.getText(), "Please view the Bose Privacy Policy on our website:");


        /*verify the hyperlink*/
        Assert.assertEquals(about.privacyPolicyHyperlink.getText(), "https://worldwide.bose.com/privacypolicy");

        /*Verify if the toggle button is turned ON*/
        Assert.assertEquals(about.privacyPolicySwitch.getText(), "ON");

        about.waitForSometime(15000);
        about.navigateBack();

        about.waitForSometime(10000);

        String s2 = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s2, "com.bose.corporation.bosesleep.screens.about.AboutActivity");

    }

        @Test (priority =  6)
        /*To click on the hyperlink in the Privacy Policy Screen*/
        public void privacyPolicyHyperlinkNavigation() throws InterruptedException{
            home.setupBoseSleepBuds();
            about.waitForSometime(1000);

            about.clickAboutIcon();
            about.waitForSometime(1000);

            about.clickPrivacyPolicyOption();
            about.waitForSometime(20000);

            about.clickPrivacyPolicyHyperlink();
            about.waitForSometime(20000);

            String s = ((StartsActivity) driver).currentActivity();

            Assert.assertEquals(s, ".SBrowserMainActivity");

        }

    @Test (priority =  7)
    /*To click on the back button in the Privacy Policy Screen*/
    public void privacyPolicyHyperBackButton() throws InterruptedException{
        home.setupBoseSleepBuds();
        about.waitForSometime(1000);

        about.clickAboutIcon();
        about.waitForSometime(1000);

        String s2 = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s2, "com.bose.corporation.bosesleep.screens.about.AboutActivity");

        about.clickPrivacyPolicyOption();
        about.waitForSometime(20000);

        about.clickPrivacyPolicyBackButton();
        about.waitForSometime(20000);


        String s3 = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s3, "com.bose.corporation.bosesleep.screens.about.AboutActivity");


    }

    @Test (priority =  8)
    /*To click on the close button in the Privacy Policy Screen*/
    public void privacyPolicyHyperCloseButton() throws InterruptedException{
        home.setupBoseSleepBuds();
        about.waitForSometime(1000);

        about.clickAboutIcon();
        about.waitForSometime(1000);

        String s2 = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s2, "com.bose.corporation.bosesleep.screens.about.AboutActivity");

        about.clickPrivacyPolicyOption();
        about.waitForSometime(20000);

        about.clickPrivacyPolicyCloseButton();
        about.waitForSometime(20000);


        String s3 = ((StartsActivity) driver).currentActivity();

        Assert.assertEquals(s2, "com.bose.corporation.bosesleep.screens.search.SearchingActivity ");

    }


    @Test (priority = 9)
        /*To navigate to Legal Screen and validate the contents*/
        public void optionLegalMain() throws InterruptedException{
            home.setupBoseSleepBuds();
            about.waitForSometime(10000);

            about.clickAboutIcon();
            about.waitForSometime(10000);

            about.clickLegalOption();
            about.waitForSometime(20000);

            /*Verify the header*/
            Assert.assertEquals(about.titleLegal.getText(), "Legal");

            /*Verify the presence of License Agreement*/
            boolean lg = about.buttonLicenseAgreement.isDisplayed();
            Assert.assertEquals(lg, true);

            /*Verify the presence of Terms Of Use*/
            boolean tu = about.buttonTermsOfUse.isDisplayed();
            Assert.assertEquals(tu, true);

            about.waitForSometime(15000);
            about.navigateBack();

            about.waitForSometime(10000);

            String s2 = ((StartsActivity) driver).currentActivity();

            Assert.assertEquals(s2, "com.bose.corporation.bosesleep.screens.about.AboutActivity");

        }

        @Test (priority = 10)
        /*To navigate to Legal Screen and click on the back button*/

        public void optionLegalBack() throws InterruptedException {

            home.setupBoseSleepBuds();
            about.waitForSometime(10000);

            about.clickAboutIcon();
            about.waitForSometime(10000);

            about.clickLegalOption();
            about.waitForSometime(20000);


            String s = ((StartsActivity) driver).currentActivity();

            Assert.assertEquals(s, "com.bose.corporation.boselegal.activity.HtmlLegalActivity");

            about.waitForSometime(15000);
            about.clickLegalBack();

            about.waitForSometime(10000);

            String s2 = ((StartsActivity) driver).currentActivity();

            Assert.assertEquals(s2, "com.bose.corporation.bosesleep.screens.about.AboutActivity");

        }

        @Test (priority = 11)
        /*To navigate to Legal screen and click on the close button to navigate to home screen*/

        public void optionLegalClose() throws InterruptedException{


            home.setupBoseSleepBuds();
            about.waitForSometime(10000);

            about.clickAboutIcon();
            about.waitForSometime(10000);

            about.clickLegalOption();
            about.waitForSometime(20000);


            String s = ((StartsActivity) driver).currentActivity();

            Assert.assertEquals(s, "com.bose.corporation.boselegal.activity.HtmlLegalActivity");

            about.waitForSometime(15000);
            about.clickLegalClose();

            about.waitForSometime(10000);

            String s2 = ((StartsActivity) driver).currentActivity();

            Assert.assertEquals(s, "com.bose.corporation.bosesleep.screens.search.SearchingActivity ");
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
