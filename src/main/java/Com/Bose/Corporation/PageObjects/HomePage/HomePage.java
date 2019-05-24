/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */

package Com.Bose.Corporation.PageObjects.HomePage;

import Com.Bose.Corporation.Base.CommomnFunctions;
import Com.Bose.Corporation.Base.TestBase;
import Com.Bose.Corporation.PageObjects.OnBoarding.OnBoarding;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class HomePage extends TestBase {

    CommomnFunctions commomnFunctions = new CommomnFunctions();
    OnBoarding onBoarding = new OnBoarding();

    /**
     * PageFactory
     * @param driver
     */
     public HomePage (AppiumDriver driver){
         super(driver);
         PageFactory.initElements(new AppiumFieldDecorator(driver), this);
     }

    public static TouchAction action;

    /**
     * ios/Android
     * Mobile Elements
     */
     @iOSFindBy (accessibility = "Got It")
     @AndroidFindBy (uiAutomator = "text(\"Got It\")")
     public  MobileElement buttonGotIt;

     @iOSFindBy (xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeOther[1]")
     //@iOSFindBy (xpath = "//XCUIElementTypeOther[@name=\"testBuds\"]")
     @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/name_text")
     public MobileElement sleepbudsText;

     @AndroidFindBy ( uiAutomator = "text(\"Manage Later in Settings\")")
     public MobileElement buttonManageLaterSoundLibrary;

     @iOSFindBy(xpath = "/XCUIElementTypeStaticText[@name=\"“Bose Sleep QA” Would Like to Send You Notifications\"]")
     public MobileElement pushNotifyText;

     @iOSFindBy (id = "Don’t Allow")
     public MobileElement buttonDontAllow;

     @iOSFindBy (id = "Allow")
     public MobileElement buttonAllow;


    @Step
    public void tap_gotIt(){
        commomnFunctions.elementtoClick(buttonGotIt, 10);
    }

    /**
     * Common method to initiate setup Sleepbuds
     * Android/IOS
     * TC_SetupBoseSleepbuds
     * @throws InterruptedException
     */
    public void setupBoseSleepBuds() throws InterruptedException {
        onBoarding.tap_checkBox();
        onBoarding.tap_Agree();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("We need some access.")){
            onBoarding.tap_GrantLocationAccesss();
            onBoarding.tap_Allow();
            onBoarding.tap_skipForNow();
            onBoarding.connectSleepbuds();
        } else {
            System.out.println(driver.getPageSource());
            onBoarding.connectSleepbuds();
        }
        onBoarding.tap_startLearning();
        commomnFunctions.swipeRightToPage("Great job!");
        onBoarding.tap_Next();
        commomnFunctions.swipeRightToPage("Charging your sleepbuds");
        onBoarding.tap_Next();
        onBoarding.tap_IUnderstand();
        tap_gotIt();
        Thread.sleep(2000);
        if (driver.getPageSource().contains("“Bose Sleep QA” Would Like to Send You Notifications")){
            commomnFunctions.acceptAlert(2);
        }

    }

}
