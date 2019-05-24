/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */
package Com.Bose.Corporation.PageObjects.OnBoarding;

import Com.Bose.Corporation.Base.CommomnFunctions;
import Com.Bose.Corporation.Base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class OnBoarding extends TestBase {

    CommomnFunctions commomnFunctions = new CommomnFunctions();

    /**
     * Appium Driver
     * //@param driver
     */
   /* public OnBoarding(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }*/

    public OnBoarding() {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Mobile Elements of onboarding page
     */
    @iOSFindBy (xpath = "//XCUIElementTypeApplication[@name=\"Bose Sleep QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(className = "android.widget.CheckBox")
    public MobileElement checkBoxAccept;

    @iOSFindBy (accessibility = "I Agree")
    @AndroidFindBy (className = "android.widget.Button" )
    public MobileElement buttonAgree;

    @AndroidFindBy (uiAutomator = "text(\"Grant Location Access\")")
    //@AndroidFindBy (xpath = "android.widget.Button[@text='I Agree']")
    public MobileElement buttonGrantLocationAccess;

    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/permissions_body_header")
    public MobileElement weNeedAccessHeader;

    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/permissions_body_text")
    public MobileElement weNeedAccessBody;

    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/dialog_title_text")
    public MobileElement dozeHeaderText;

    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/dialog_default_content_text")
    public MobileElement dozeBodytext;

    @AndroidFindBy (id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement androidButtonAllow;

    @AndroidFindBy (uiAutomator = "text(\"Disable Doze\")")
    public MobileElement buttonDisableDoze;

    @AndroidFindBy (uiAutomator = "text(\"Skip for now\")")
    public MobileElement buttonSkipforNow;

    //@iOSFindBy (accessibility = "hamburgerMenu")
    @iOSFindBy (xpath = "//XCUIElementTypeButton[@name=\"hamburgerMenu\"]")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/drowsy_icons")
    public MobileElement hamburgerIcon;

    //@AndroidFindBy (className = "android.widget.TextView")
    //@AndroidFindBy (xpath = "//android.widget.FrameLayout[@index='0']/android.widget.TextView[@index='1']")
    //@iOSFindBy (xpath = "/AppiumAUT/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")
    @iOSFindBy (accessibility = "Lucky Star")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/carousel_headphone_name")
    public MobileElement headPhoneName;

    @iOSFindBy (xpath = "//XCUIElementTypeButton[@name=\"Add Sleepbuds\" and @visible='true']")
    //@iOSFindBy (xpath = "//XCUIElementTypeButton[@name=\"Add Sleepbuds\"]")
    //@iOSFindBy (accessibility = "Add Sleepbuds")
    @AndroidFindBy (uiAutomator = "text(\"Add Sleepbuds\")")
    public MobileElement buttonAddSleepBuds;

    @iOSFindBy (accessibility = "Welcome!")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/welcome_title")
    public MobileElement welcomeHeaderText;


    @iOSFindBy (xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    /*@iOSFindBy (accessibility = "The Bose® Sleep app lets you control your masking sounds, alarms, and more.\n" +
            "\n" +
            "Before we get started, let’s take a few minutes to take a tour of your new sleepbuds.")*/
    //@iOSFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"The Bose® Sleep app lets you control your masking sounds, alarms, and more. Before we get started, let’s take a few minutes to take a tour of your new sleepbuds.\"]")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/welcome_text")
    public MobileElement welcomeBodyText;

    @iOSFindBy (accessibility = "Start Learning")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/startLearningButton")
    public MobileElement buttonStartLearning;

    @iOSFindBy (accessibility = "Find your size")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public MobileElement findSizeHeaderText;

    @iOSFindBy (accessibility = "First, we need to make sure we find an eartip size that’s secure and comfortable for you.")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='3']")
    //@AndroidFindBy (uiAutomator = "text(\"First, we need to make sure we find an eartip size that’s secure and comfortable for you.\")")
    public MobileElement findSizeBodyText;

    /*@AndroidFindBy (xpath = "//android.support.v4.view.ViewPager[@index='0']/android.widget.TextView[@index='0']")
    public MobileElement headerTextOnboardingscreens;


    @AndroidFindBy (xpath = "//android.support.v4.view.ViewPager[@index='0']/android.widget.TextView[@index='1']")
    public MobileElement bodyTextOnboardingscreens;*/

    @iOSFindBy (accessibility = "Try on a sleepbud")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public  MobileElement trySleepbudHeaderText;

    @iOSFindBy (xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    //@iOSFindBy (accessibility = "Rotate the sleepbud back, locking it in place. Then, press the eartip wing to tuck it underneath your ear ridge. Make sure the side with the Bose® logo faces outwards.")
    //@AndroidFindBy (uiAutomator = "text(\"Rotate the sleepbud back, locking it in place. Then, press the eartip wing to tuck it underneath your ear ridge. Make sure the side with the Bose® logo faces outwards.\")")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='3']")
    public MobileElement trySleepbudbodyText;

    @iOSFindBy (accessibility = "Too small")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public MobileElement screenThreeHeader;

    @iOSFindBy (accessibility = "If the sleepbuds look like this in your ear and feel loose, try a larger eartip size.")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/tooSmallTextView")
    public  MobileElement screenThreeBody;

    @iOSFindBy (accessibility = "Too large")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public MobileElement screenfourHeader;

    @iOSFindBy (accessibility = "If the sleepbuds look like this in your ear or feel too compressed or tight, try a smaller eartip size.")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/tooLargeTextView")
    public MobileElement screenFourBody;

    @iOSFindBy (accessibility = "Perfect fit")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public MobileElement screenFiveHead;

    @iOSFindBy (accessibility = "If the sleepbuds look like this in your ear, you’re good to go!")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='4']")
    //@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")
    public MobileElement screenFiveBody;

    @iOSFindBy (accessibility = "Let’s check a few things")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public MobileElement screenSixHead;

    @iOSFindBy (accessibility = "Try speaking aloud. Your voice should sound muffled.")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/entry_one_text")
    public MobileElement screenSixBodyTextOne;

    @iOSFindBy (accessibility = "Shake your head. The sleepbuds should stay secure.")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/entry_two_text")
    public MobileElement screenSixBodyTexttwo;

    @iOSFindBy (accessibility = "Use a mirror or ask a friend to see if your sleepbuds look like this.")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/entry_three_text")
    public MobileElement  screenSixBodyTextThree;

    @iOSFindBy (accessibility = "Great job!")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public MobileElement screenSevenHead;

    @iOSFindBy (accessibility = "You can view the product tutorials again later in Settings.")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageText")
    public MobileElement screenSevenBody;

    @iOSFindBy (accessibility = "Next")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/nextButton")
    public MobileElement buttonNext;

    @iOSFindBy (accessibility = "Power and charging")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public MobileElement chargeScreenOneHead;

    @iOSFindBy (xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    //@AndroidFindBy (uiAutomator = "text(\"Next, let's learn how to charge your sleepbuds and charging case.\")")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='3']")
    public MobileElement chargeScreenOneBody;

    @iOSFindBy (accessibility = "Charging your case")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public MobileElement chargeScreenTwoHead;

    @iOSFindBy (accessibility = "These five lights show you the case battery level. When all five are lit, the case battery is fully charged.")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='3']")
    public MobileElement chargeScreenTwoBody;

    @iOSFindBy (accessibility = "Charging your sleepbuds")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public MobileElement chargeScreenThreeHead;

    @iOSFindBy (xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    //@iOSFindBy (accessibility = "Your sleepbuds power on automatically when you remove them from the case. To power off and charge them, put them back in the case.")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='3']")
    public MobileElement chargeScreenThreeBody;

    @iOSFindBy (accessibility = "Your Safety")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='0']")
    public MobileElement safetyScreenText;

    @iOSFindBy (accessibility = "Staying aware")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/pageLabel")
    public MobileElement safetyScreenHead;

    @iOSFindBy (xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='3']")
    public MobileElement safetyScreenBody;

    @iOSFindBy (accessibility = "I Understand")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/nextButton")
    public MobileElement buttonIUnderstand;

    @iOSFindBy (accessibility = "All done!")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/all_done_title")
    public MobileElement alldoneTitle;

    @iOSFindBy (accessibility = "If you want to discover more about your product, check out the Settings menu.")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/all_done_content")
    public MobileElement allDoneContent;

    @iOSFindBy (accessibility = "Sound Library")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='4']")
    public MobileElement SLText;

    @iOSFindBy (accessibility = "Phone-Free Mode")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='6']")
    public MobileElement PFMText;

    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='8']")
    public MobileElement LMText;

    @iOSFindBy (accessibility = "Sleep Timer")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='10']")
    public MobileElement sleepTimerText;

    @iOSFindBy (accessibility = "Sleepbud setup")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='12']")
    public MobileElement sleepBudSetupText;

    @iOSFindBy (accessibility = "User Manual")
    @AndroidFindBy (xpath = "//*[@class='android.widget.TextView' and @index='14']")
    public MobileElement userManualText;

    @iOSFindBy (accessibility = "Got It")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/nextButton")
    public MobileElement buttonGotIt;

    /**
     * common Methods to Run Test for onboarding
     */


    /**
     * connecting with bose sleep buds
     * @param element
     */
    public void tapToConnect(MobileElement element) {
        propFile();
        String budsName = prop.getProperty("sleepBuds");
        /*commomnFunctions.elmenttoVisible(headPhoneName);
        String title = headPhoneName.getText();
        System.out.println("page title is" + " " + title);*/

       /* do {
            commomnFunctions.swipeHorizontal(0.9, 2, 0.20);

            if (title.equalsIgnoreCase("testBUds")){
                commomnFunctions.elementtoClick(element);
            }
        }while (!title.equals("testBuds"));*/
        try {
            Thread.sleep(15000);
            /*if (driver.getPageSource().contains("testBuds")){
                commomnFunctions.elementtoClick(element);
            }else if (driver.getPageSource().contains("Add Sleepbuds")){
                commomnFunctions.swipeRightToPage("testBuds");
                commomnFunctions.elementtoClick(element);
            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       /* do {
           commomnFunctions.swipeHorizontal(0.9, 2, 0.20);
        } while (!title.equals("testBuds"));
        commomnFunctions.elementtoClick(element);*/

       // String title = headPhoneName.getText();
      //  System.out.println("page title is" + " " + title);
        //if (title.equals("Lucky Star")){
        if (driver.getPageSource().contains(budsName)){
           commomnFunctions.elementtoClick(element, 10);
       }else {
           commomnFunctions.swipeRightToPage(budsName);
           commomnFunctions.elementtoClick(element, 10);
       }
        /*
          //if (driver.getPageSource().contains("Add Sleepbuds"))
        else if (driver.getPageSource().contains("We’re still looking for your sleepbuds…")) {
           commomnFunctions.swipeLeftToPage("Lucky Star");
           commomnFunctions.elementtoClick(element);
       }*/
    }


    /**
     * created methods for each Test steps
     */
    @Step
    public void tap_checkBox(){
        commomnFunctions.elementtoClick(checkBoxAccept, 10);
    }

    @Step
    public void tap_Agree() {
        //buttonAgree.click();
        commomnFunctions.elementtoClick(buttonAgree, 10);
    }

    @Step
    public void tap_GrantLocationAccesss() {
        //buttonGrantLocationAccess.click();
        commomnFunctions.elementtoClick(buttonGrantLocationAccess, 10);
    }


    @Step
    public void tap_Allow() {
        //androidButtonAllow.click();
        commomnFunctions.elementtoClick(androidButtonAllow, 10);

    }

    @Step
    public void tap_skipForNow() {
        //buttonSkipforNow.click();
        commomnFunctions.elementtoClick(buttonSkipforNow, 10);
    }

    /**
     * Connect /Disconnect in TestRail
     * C117685
     * Connect sleepbuds
     */
    @Step
    public void connectSleepbuds() {
        tapToConnect(buttonAddSleepBuds);
    }

    @Step
    public void tap_startLearning() {
        commomnFunctions.elementtoClick(buttonStartLearning, 10);
    }

    @Step
    public void tap_Next(){
        commomnFunctions.elementtoClick(buttonNext, 10);
    }

    @Step
    public void tap_IUnderstand(){
        commomnFunctions.elementtoClick(buttonIUnderstand, 10);
    }

    @Step
    public void tap_GotIt(){
        commomnFunctions.elementtoClick(buttonGotIt, 10);
    }


    /**
     * Test Cases  //need to figure out
     */

    /**
     * We need some Access screen test
     */
    public void OB_C116884() {
        tap_checkBox();
        tap_Agree();

    }

    /**
     * Doze Screen Test
     */
    public void OB_C116906() {
        tap_GrantLocationAccesss();
        tap_Allow();
    }



    /**
     * Welcome Screen
     */
    public void OB_C116915() {
        OB_C116884();
        OB_C116906();
        connectSleepbuds();
    }
}
