/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */
package Com.Bose.Corporation.TestSuite.Onboarding;

import Com.Bose.Corporation.Base.CommomnFunctions;
import Com.Bose.Corporation.Base.TestBase;
import Com.Bose.Corporation.PageObjects.HomePage.HomePage;
import Com.Bose.Corporation.PageObjects.OnBoarding.OnBoarding;
import Com.Bose.Corporation.Utilities.Listener.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;


import static org.junit.Assert.assertThat;

@Listeners({TestListener.class})
@Feature("Onboarding Test")
public class OnboardingTest extends TestBase {

    HomePage homePage ;
    CommomnFunctions commomnFunctions;
    OnBoarding onBoarding;

    /**
     * Appium Driver
     */
    public OnboardingTest() {
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
        commomnFunctions = new CommomnFunctions();
        onBoarding = new OnBoarding();

    }


    @Test(priority = 1, description = "We Need Some Access Screen", enabled = true, testName = "116884")
    @Description("We Need Some Access Screen")
    public void OB_TC_C116884(){
        commomnFunctions.elmenttoVisible(onBoarding.checkBoxAccept, 10);
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        commomnFunctions.elmenttoVisible(onBoarding.weNeedAccessHeader, 10);
        String text1 = onBoarding.weNeedAccessHeader.getText();
        String text2 = onBoarding.weNeedAccessBody.getText();


        /**
         * Validation
         */
        Assert.assertEquals(text1, "We need some access.");
        Assert.assertEquals(text2, "Apps using Bluetooth Low Energy are now required to have location access enabled. We don't like it either, but don't worry: we only need BLE to make our magic work. We're not using your GPS, tracking you or saving any of your location data.");
    }

    @Test(priority = 2, description = "Disable Doze screen", enabled = true, testName = "116906")
    @Description("Disable Doze screen")
    public void OB_TC_C116906() {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        onBoarding.tap_GrantLocationAccesss();
        onBoarding.tap_Allow();
        commomnFunctions.elmenttoVisible(onBoarding.dozeHeaderText, 10);
        String text1 = onBoarding.dozeHeaderText.getText();
        String text2 = onBoarding.dozeBodytext.getText();

        /**
         * Validation
         */
        Assert.assertEquals(text1, "Pulling an all-nighter.");
        Assert.assertEquals(text2, "While you sleep, the app needs to stay awake to make sure your sleepbuds play masking sounds all night and your alarm wakes you up on time. Turn off battery optimizations for this app so you can rest easy.");
    }

    @Test(priority = 3, description = "Welcome screen", enabled = true, testName = "116915")
    @Description("Welcome Screen")
    public void OB_TC_C116915() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        /*onBoarding.tap_GrantLocationAccesss();
        onBoarding.tap_Allow();
        onBoarding.tap_skipForNow();
        onBoarding.connectSleepbuds();*/
        commomnFunctions.elmenttoVisible(onBoarding.welcomeHeaderText, 10);
        String text1 = onBoarding.welcomeHeaderText.getText();
        System.out.println(driver.getPageSource());
        String text2 = onBoarding.welcomeBodyText.getText();

        /**
         * Validation
         */
        Assert.assertEquals(text1, "Welcome!");
        Assert.assertEquals(text2, "The Bose® Sleep app lets you control your masking sounds, alarms, and more.\n" +
                "\n" +
                "Before we get started, let’s take a few minutes to take a tour of your new sleepbuds.");

    }

    //need to update with new screen
    @Test(priority = 4, description = "Find your size screen", enabled = true, testName = "116916")
    @Description("Find your Size screen")
    public void OB_TC_C116916() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.elmenttoVisible(onBoarding.findSizeHeaderText, 10);
        String text1 = onBoarding.findSizeHeaderText.getText();
        String text2 = onBoarding.findSizeBodyText.getText();

        /**
         * Validation
         */
        Assert.assertEquals(text1, "Find your size");
        Assert.assertEquals(text2, "First, we need to make sure we find an eartip size that’s secure and comfortable for you.");
    }

    @Test(priority = 5, description = "Try on Sleepbud Screen", enabled = true, testName = "116917")
    @Description("Try on Sleepbud Screen")
    public void OB_TC_C116917() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Try on a sleepbud");
        commomnFunctions.elmenttoVisible(onBoarding.trySleepbudHeaderText, 10);
        String text1 = onBoarding.trySleepbudHeaderText.getText();
        String text2 = onBoarding.trySleepbudbodyText.getText();

        /**
         * Validation
         */
        Assert.assertEquals(text1, "Try on a sleepbud");
        Assert.assertEquals(text2, "Rotate the sleepbud back, locking it in place. Then, press the eartip wing to tuck it underneath your ear ridge.\n" +
                "\n" +
                "Make sure the side with the Bose® logo faces outwards.");
    }

    @Test(priority = 6, description = "Too small screen", enabled = true, testName = "116918")
    @Description ("Too small screen")
    public void TC_OB_C116918() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Too small");
        String header = onBoarding.screenThreeHeader.getText();
        String body = onBoarding.screenThreeBody.getText();

        /**
         * Validation
         */
        Assert.assertEquals(header, "Too small");
        Assert.assertEquals(body, "If the sleepbuds look like this in your ear and feel loose, try a larger eartip size.");

    }

    @Test(priority = 7, description = "Too Large screen", enabled = true, testName = "116919")
    @Description ("Too Large screen")
    public void TC_OB_C116919() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Too large");
        String header = onBoarding.screenfourHeader.getText();
        String body = onBoarding.screenFourBody.getText();

        /**
         * Validation
         */
        Assert.assertEquals(header, "Too large");
        Assert.assertEquals(body, "If the sleepbuds look like this in your ear or feel too compressed or tight, try a smaller eartip size.");
    }

    @Test(priority = 8, description = "Perfect fit screen", enabled = true, testName = "116920")
    @Description ("Perfect fit screen")
    public void TC_OB_C116920() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Perfect fit");
        String header = onBoarding.screenFiveHead.getText();
        String body = onBoarding.screenFiveBody.getText();

        /**
         * Validation
         */
        Assert.assertEquals(header, "Perfect fit");
        Assert.assertEquals(body, "If the sleepbuds look like this in your ear, you’re good to go!");
    }

    @Test(priority = 9, description = "let's check a few things screen", enabled = true, testName = "116921")
    @Description ("let's check a few things screen")
    public void TC_OB_C116921() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Let’s check a few things");
        String header = onBoarding.screenSixHead.getText();
        String bodyTextOne = onBoarding.screenSixBodyTextOne.getText();
        String bodyTextTwo = onBoarding.screenSixBodyTexttwo.getText();
        String bodyTextThree = onBoarding.screenSixBodyTextThree.getText();

        /**
         * Validation
         */
        Assert.assertEquals(header, "Let’s check a few things");
        Assert.assertEquals(bodyTextOne, "Try speaking aloud. Your voice should sound muffled.");
        Assert.assertEquals(bodyTextTwo, "Shake your head. The sleepbuds should stay secure.");
        Assert.assertEquals(bodyTextThree, "Use a mirror or ask a friend to see if your sleepbuds look like this.");
    }

    @Test(priority = 10, description = "great job screen", enabled = true, testName = "116925")
    @Description("great job screen")
    public void TC_OB_C116925() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Great job!");
        String header = onBoarding.screenSevenHead.getText();
        String body = onBoarding.screenSevenBody.getText();

        /**
         * Validation
         */
        Assert.assertEquals(header, "Great job!");
        Assert.assertEquals(body, "You can always access this product tour again later from the Settings menu.");
    }

    @Test(priority = 11, description = "Power and charging screen", enabled = true, testName = "116927")
    @Description("Power and charging screen")
    public void TC_OB_C116927() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Great job!");
        onBoarding.tap_Next();
        String header = onBoarding.chargeScreenOneHead.getText();
        String body = onBoarding.chargeScreenOneBody.getText();

        /**
         * Validation
         */
        Assert.assertEquals(header, "Power and charging");
        Assert.assertEquals(body, "Next, let's learn how to charge your sleepbuds and charging case.\n" +
                "\n" +
                "Both have rechargeable batteries. You can use the case battery to charge your sleepbuds on the go.");
    }

    @Test(priority = 12, description = "charging your case screen", enabled = true, testName = "116928")
    @Description("charging your case screen")
    public void TC_OB_C116928() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Great job!");
        onBoarding.tap_Next();
        commomnFunctions.swipeRightToPage("Charging your case");
        String header = onBoarding.chargeScreenTwoHead.getText();
        String body = onBoarding.chargeScreenTwoBody.getText();

        /**
         * Validation
         */
        Assert.assertEquals(header, "Charging your case");
        Assert.assertEquals(body, "These five lights show you the case battery level. When all five are lit, the case battery is fully charged.");
    }

    @Test(priority = 13, description = "charging your sleepbuds screen", enabled = true, testName = "116930")
    @Description("charging your sleepbuds screen")
    public void TC_OB_C116930() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Great job!");
        onBoarding.tap_Next();
        commomnFunctions.swipeRightToPage("Charging your sleepbuds");
        String header = onBoarding.chargeScreenThreeHead.getText();
        String body = onBoarding.chargeScreenThreeBody.getText();

        /**
         * Validation
         */
        Assert.assertEquals(header, "Charging your sleepbuds");
        Assert.assertEquals(body, "Your sleepbuds power on automatically when you remove them from the case. To power off and charge them, put them back in the case.");
    }

    @Test(priority = 14, description = "your safety screen", enabled = true, testName = "116931")
    @Description("your safety screen")
    public void TC_OB_C116931() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Great job!");
        onBoarding.tap_Next();
        commomnFunctions.swipeRightToPage("Charging your sleepbuds");
        onBoarding.tap_Next();
        String text = onBoarding.safetyScreenText.getText();
        String header = onBoarding.safetyScreenHead.getText();
        String body = onBoarding.safetyScreenBody.getText();

        /**
         * Validation
         */
        Assert.assertEquals(text, "Your Safety");
        Assert.assertEquals(header, "Staying aware");
        Assert.assertEquals(body, "Your sleepbuds are designed to mask noise. This means they can also make it harder to hear other sounds you want to hear.\n" +
                "\n" +
                "To balance the levels of noise masking and awareness you want, set an appropriate volume level for your needs.");

    }

    @Test(priority = 15, description = "All done Screen", enabled = true, testName = "116934")
    @Description("All done Screen")
    public void TC_OB_C116934() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Great job!");
        onBoarding.tap_Next();
        commomnFunctions.swipeRightToPage("Charging your sleepbuds");
        onBoarding.tap_Next();
        onBoarding.tap_IUnderstand();
        String header = onBoarding.alldoneTitle.getText();
        String body = onBoarding.allDoneContent.getText();
        String textSl = onBoarding.SLText.getText();
        String textPFM = onBoarding.PFMText.getText();
        //String textLM = onBoarding.LMText.getText();
        String textST = onBoarding.sleepTimerText.getText();
        String textSBSetup = onBoarding.sleepBudSetupText.getText();
        String textUm = onBoarding.userManualText.getText();


        /**
         * Validation
         */
        Assert.assertEquals(header, "All done!");
        Assert.assertEquals(body, "If you want to discover more about your product, check out the Settings menu.");
        Assert.assertEquals(textSl, "Sound Library");
        Assert.assertEquals(textPFM, "Phone-Free Mode");
       //Assert.assertEquals(textLM, "Light Mode");
        Assert.assertEquals(textST, "Sleep Timer");
        Assert.assertEquals(textSBSetup, "Sleepbud setup");
        Assert.assertEquals(textUm, "User Manual");
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
