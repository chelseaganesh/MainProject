/*
 * Developed by Rajesh.
 * Copyright (c) 2019. Bose corporation. All rights reserved.
 */

package Com.Bose.Corporation.PageObjects.Settings;

import Com.Bose.Corporation.Base.CommomnFunctions;
import Com.Bose.Corporation.Base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import Com.Bose.Corporation.Base.CommomnFunctions.DIRECTION.*;

import java.util.HashMap;

public class SettingsPage extends TestBase {

    CommomnFunctions commomnFunctions = new CommomnFunctions();

    /**
     * Appium Driver
     * @param driver
     */
    public SettingsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "settings")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/settings_btn")
    public MobileElement settings_btn;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Settings\"]")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/screen_title")
    public MobileElement screentitle;

    //Name edit
    @iOSFindBy(accessibility = "Name")
    @AndroidFindBy (xpath = "//*[@text='Name']")
    public MobileElement Name;

    @iOSFindBy(accessibility = "Name")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/device_name_text")
    public MobileElement DeviceName;

    @iOSFindBy(accessibility = "Nickname It")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/edit_headphone_title")
    public MobileElement edit_headphone_title;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Bose Sleep QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/edit_name")
    public MobileElement EditNickName;

    @iOSFindBy(accessibility = "Continue")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/done_btn")
    public MobileElement Name_Continue;

    @iOSFindBy(accessibility = "Battery")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/battery_button")
    public MobileElement Battery;

    @iOSFindBy(accessibility = "Battery")
    @AndroidFindBy (id="com.bose.corporation.hypno.qa:id/screen_title")
    public MobileElement screen_title;


    @iOSFindBy(accessibility = "back")
    @AndroidFindBy(id = "com.bose.corporation.hypno.qa:id/back_button")
    public MobileElement buttonBack;

    @iOSFindBy(accessibility = "Product Info")
    @AndroidFindBy (id="com.bose.corporation.hypno.qa:id/screen_title")
    public MobileElement productTitle;

    @iOSFindBy(accessibility = "Product Info")
    @AndroidFindBy (id="com.bose.corporation.hypno.qa:id/product_info_container")
    public MobileElement Product_info_container;

    @iOSFindBy (id = "Sleep Timer")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/sleep_timer_container")
    public MobileElement sleepTimerContainer;

    @iOSFindBy (id = "Sleep Timer")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/screen_title")
    public MobileElement sleeptimer_Header;

    @iOSFindBy (id = "Forget Sleepbuds")
    @AndroidFindBy (id = "com.bose.corporation.hypno.qa:id/disconnect_btn")
    //@AndroidFindBy (uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(“Forget Sleepbuds”))")
    public MobileElement disconnect_btn;




    @Step
    public void tap_Settings_Gear(){
        settings_btn.click();
    }

    @Step
    public void tap_Name(){
        Name.click();
    }

    @Step
    public void tap_button_Continue(){
        Name_Continue.click();
    }

    @Step
    public void tap_Battery(){
        Battery.click();
    }

    @Step
    public void tap_button_Back(){
        buttonBack.click();
    }

    @Step
    public void tap_ProductInfo(){
        Product_info_container.click();
    }

    @Step
    public void tap_SleepTimer(){
        sleepTimerContainer.click();
    }

    @Step
    public void Settings_Test() throws Exception {
        settings_btn.click();
        //driver.findElement(org.openqa.selenium.By.id(""));


        Thread.sleep(Long.parseLong("3000"));

        if(screentitle.getText().equalsIgnoreCase("Settings"))
        {
            System.out.println("User is in settings screen");
        }

        Name.isDisplayed();

        DeviceName.click();

        edit_headphone_title.isDisplayed();
        if(edit_headphone_title.getText().equalsIgnoreCase("Nickname It")) {
            System.out.println("User is able to see the Nickname title in the page");
        }else {
            System.out.println("User is unable to see the Nickname title in the page");
        }

        EditNickName.isDisplayed();
        System.out.println("NickName for the buds is "+EditNickName.getText());

        Name_Continue.click();

        Battery.click();

        screen_title.isDisplayed();

        if(screen_title.getText().equalsIgnoreCase("Battery")) {
            System.out.println("user is able to see Battery tilte");

        }else {
            System.out.println("user is not able to see Battery title");

        }

        //driver.navigate().back();
        buttonBack.click();

        Product_info_container.click();

        screen_title.isDisplayed();

        if(productTitle.getText().equalsIgnoreCase("Product Info")) {
            System.out.println("user is able to see product tilte");

        }else {
            System.out.println("user is not able to see product title");

        }

        buttonBack.click();
        //driver.navigate().back();

//		product tutorial
//		product_tutorials_button.click();
//		screen_title.isDisplayed();
//		driver.navigate().back();
//

//		alerts_button.click();





//		TouchActions action = new TouchActions(driver);
//		action.down(0, 96);
//		action.move(0, 2170);
//		action.perform();

//        driver.swipe(start x start y )
//                start x
//                        endy


//        commomnFunctions.swipeVertical(0.5, 2, 0.3);

        /*try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("direction", "up");
            js.executeScript("mobile: scrollTo", map);
            System.out.println("scroll successfull");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("scroll not successfull");
        }*/
        //commomnFunctions.scroll(disconnect_btn);
        /*((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", disconnect_btn);
        disconnect_btn.click();

        Thread.sleep(Long.parseLong("3000"));*/

        if(screentitle.getText().equalsIgnoreCase("Settings"))
        {
            System.out.println("User is in settings screen");
        }
    }
}
