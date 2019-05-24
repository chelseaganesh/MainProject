/*
 * Developed by Karthika
 * Copyright (c) 2019. Bose Corporation. All rights reserved.
 */

package Com.Bose.Corporation.PageObjects.About;

import Com.Bose.Corporation.Base.CommomnFunctions;
import Com.Bose.Corporation.Base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class AboutPage extends TestBase {

    CommomnFunctions commonfunctions = new CommomnFunctions();

    /**
     * PageFactory
     *
     * @param driver
     */
    public AboutPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static TouchAction action;

    /**
     * ios/Android
     * Mobile Elements
     */


    /*about icon*/
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"hamburgerMenu\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/drowsy_icon")
    public MobileElement buttonAbout;

    /*Product Support*/

    @iOSFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Product Support\"]")
    @AndroidFindBy(uiAutomator = "text(\"Product Support\")")
    public MobileElement buttonProductSupport;

    /*Feedback*/

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Feedback\"]")
    @AndroidFindBy(uiAutomator = "text(\"Feedback\")")
    public MobileElement buttonFeedback;

    /*Bose.com*/

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bose.com\"]")
    @AndroidFindBy(uiAutomator = "text(\"Bose.com\")")
    public MobileElement buttonBoseWebpage;

    /*Privacy Policy & Settings*/

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Privacy Policy & Settings\"]")
    @AndroidFindBy(uiAutomator = "text(\"Privacy Policy & Settings\")")
    public MobileElement buttonPrivacyPolicy;


    /*Legal*/
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Legal\"]")
    @AndroidFindBy(uiAutomator = "text(\"Legal\")")
    public MobileElement buttonLegal;

    /*Close Button*/

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"close\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/close_button")
    public MobileElement buttonClose;

    /*Feedback Title*/
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Feedback\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/screen_title")
    public MobileElement titleFeedbackt;

    /*Feedback Screen back button*/
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/back_button")
    public MobileElement feedbackPageBackButton;

    /*Feedback Screen close button*/
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"close\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/close_button")
    public MobileElement feedbackPageCloseButton;

    /*Privacy Policy Screen Title*/
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Privacy Policy\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/titleText")
    public MobileElement titlePrivacyPolicy;

    /*Privacy Policy Screen Back button*/
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/backButton")
    public MobileElement privacyPolicyBackButton;

    /*Privacy Policy Screen Close button*/
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"close\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/closeButton")
    public MobileElement privacyPolicyCloseButton;

    /*Privacy Policy Hyperlink*/
    @iOSFindBy(xpath = "//XCUIElementTypeLink[@name=\"https://worldwide.bose.com/privacypolicy\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/optOutPrivacyPolicyLink")
    public MobileElement privacyPolicyHyperlink;

    /*Privacy Policy Text Diagnostic & Usage*/
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Diagnostic & Usage\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/optOutTitle")
    public MobileElement privacyPolicyDU;

    /*Privacy Policy Content*/
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bose Sleep collects diagnostic and usage data to improve our products and services and troubleshoot errors. If you do not want us to collect this data, you can opt out below. Crash reporting may stay active until your device is restarted.\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/optOutContent")
    public MobileElement privacyPolicyContent;

    /*Privacy Policy text 'share date with bose'*/
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Share data with Bose\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/optOutSwitchText")
    public MobileElement privacyPolicySwitchText;

    /*Privacy Policy hyperlink header*/
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bose Privacy Policy\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/optOutPrivacyPolicyHeader")
    public MobileElement privacyPolicyHyperlinkHeader;

    /*Privacy Policy hyperlink subcontent*/
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Bose Sleep QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextView")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/optOutPrivacyPolicyContent")
    public MobileElement privacyPolicyHyperlinkSubContent;

    /*Toggle button in Privacy Policy Screen*/
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Bose Sleep QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSwitch")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/optOutSwitch")
    public MobileElement privacyPolicySwitch;


    /*Legal Screen*/
    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Legal\"])[1]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/titleText")
    public MobileElement titleLegal;

    /*Legal Screen Back button*/
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/backButton")
    public MobileElement legalBackbutton;

    /*Legal Screen close button*/
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"close\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/closeButton")
    public MobileElement legalClosebutton;

    /*License Agreement*/
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"License Agreement\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.TextView")
    public MobileElement buttonLicenseAgreement;

    /*Terms of Use*/
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Terms of Use\"]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[3]/android.widget.TextView")
    public MobileElement buttonTermsOfUse;

    /*License Agreement Screen*/
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"License Agreement\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/titleText")
    public MobileElement titleLicenseAgreement;

    /*License Agreement Back button*/
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"back\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/backButton")
    public MobileElement licenseAgreementBackButton;

    /*License Agreement Close button*/
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"close\"]")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/closeButton")
    public MobileElement licenseAgreementCloseButton;

    @iOSFindBy (accessibility = "breadcrumb")
    @AndroidFindBy(id = "com.android.chrome:id/close_button")
    public MobileElement backToApp;

    /**
     * To click an element if visible
     * @throws InterruptedException
     */

  public void elementClick (MobileElement mobileelement){


        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);


        if (mobileelement.isDisplayed()) {
            mobileelement.click();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        } else {
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
            try {

                mobileelement.click();
                driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                //return;

            }

        }

    }



    public void clickElement(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    /**
     * To navigate to previous screen with the android back
     * @throws InterruptedException
     */
    public void navigateBack(){
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    }


    /**
     * To wait for an element
     * @throws InterruptedException
     */
    public void waitForSometime (Integer timeval){
        driver.manage().timeouts().implicitlyWait(timeval, TimeUnit.SECONDS);
    }

    /** Individual Methods **/

    /**
     * About Icon
     **/
    @Step
    public void clickAboutIcon() throws InterruptedException {
        clickElement(buttonAbout);
    }

    /**
     * --------Close button---------
     **/
    @Step
    public void clickCloseButton() throws InterruptedException {
        clickElement(buttonClose);

    }

    /**
     * --------Product Support---------
     **/
    @Step
    public void clickProductSupportOption() throws InterruptedException {
       clickElement(buttonProductSupport);

    }

    /**
     * ------------Feedback-----------------
     **/
    @Step
    public void clickFeebbackOption() throws InterruptedException {
        clickElement(buttonFeedback);
    }

    /**
     * --------------Bose.com--------------------
     **/
    @Step
    public void clickBosedotcom() throws InterruptedException {
        clickElement(buttonBoseWebpage);
    }

    @Step
    public void tap_backtoAPP() {
        commonfunctions.elementtoClick(backToApp, 10);
    }

    /**
     * ---------------Privacy Policy--------------
     **/
    @Step
    public void clickPrivacyPolicyOption() throws InterruptedException {
            clickElement(buttonPrivacyPolicy);
    }

    @Step
    public void clickPrivacyPolicyBackButton() throws InterruptedException{
        clickElement(privacyPolicyBackButton);
    }
    @Step
    public void clickPrivacyPolicyCloseButton() throws InterruptedException{
        clickElement(privacyPolicyCloseButton);

    }
    @Step
    public void clickPrivacyPolicyHyperlink() throws InterruptedException{
        clickElement(privacyPolicyHyperlink);

    }


    /**
     * ------------------Legal--------------------
     **/
    @Step
    public void clickLegalOption() throws InterruptedException {
        clickElement(buttonLegal);
    }
    @Step
    public void clickLegalBack() throws InterruptedException {
        clickElement(legalBackbutton);
    }
    @Step
    public void clickLegalClose() throws InterruptedException{
        clickElement(legalClosebutton);
    }

    /**
     * ------------------License Agreement--------------------
     **/
    @Step
    public void clickLicenseAgreement() throws InterruptedException{
        clickElement(buttonLicenseAgreement);
    }
    @Step
    public void licenseAgreementBackButton() throws InterruptedException{
        clickElement(licenseAgreementBackButton);
    }
    @Step
    public void licenseAgreementCloseButton() throws InterruptedException{
        clickElement(licenseAgreementCloseButton);
    }



    /**Common Methods**/

    /**
     * -------------- About Page Flow --------------------
     **/

    public void navigateAboutPage() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        /*To click on the about icon*/
        clickAboutIcon();
        waitForSometime(5000);

        /*To click on Product Support Option*/
        clickProductSupportOption();
        waitForSometime(5000);
        navigateBack();
        waitForSometime(5000);

        /*To click on Feedback Option*/
        clickFeebbackOption();
        waitForSometime(5000);
        navigateBack();
        waitForSometime(5000);

        /*To click on Bose.com*/
        clickBosedotcom();
        waitForSometime(5000);
        navigateBack();
        waitForSometime(5000);

        /*To click on Privacy Policy & Settings*/
        clickPrivacyPolicyOption();
        waitForSometime(5000);
        navigateBack();
        waitForSometime(5000);

        /*To click on the Legal option*/
        clickLegalOption();
        waitForSometime(5000);
        navigateBack();
        waitForSometime(5000);

    }
}
