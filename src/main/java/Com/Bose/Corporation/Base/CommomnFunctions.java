/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */
package Com.Bose.Corporation.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.imagecomparison.FeatureDetector;
import io.appium.java_client.imagecomparison.FeaturesMatchingOptions;
import io.appium.java_client.imagecomparison.FeaturesMatchingResult;
import io.appium.java_client.imagecomparison.MatchingFunction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static io.appium.java_client.touch.offset.PointOption.point;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.bytedeco.javacpp.opencv_core.greaterThan;
import static org.junit.Assert.assertThat;


import java.awt.*;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
//import java.util.Base64;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertFalse;


public class CommomnFunctions extends TestBase {

    //private AppiumDriver driver;
    public static TouchAction action;
    //public static TouchActions touch;
    public static int[] data1;
    public static int[] data2;
    public static WebDriverWait wait;
    /**
     * Appium Driver
     * @param
     * @param //driver
     */
    /*public CommomnFunctions(AppiumDriver driver) {
        super(driver);
        //this.driver = driver;
    }*/

    public CommomnFunctions() {
        super(driver);
    }

    /**
     * android back button
     */
    public void androidBackButton() {
        driver.navigate().back();
    }

    /**
     * Accept or dismiss Alert
     * @param element
     */
    public void alert(MobileElement element, int waitTimeInSec) {
        wait = new WebDriverWait(driver, waitTimeInSec);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            element.click();
        }catch (Exception e) {
            System.err.println("   no alert visible after "+waitTimeInSec+" sec.");
        }
    }

    /**
     * accepts alerts notifications
     * @param waitTimeInSec
     * @return
     */
    public boolean acceptAlert(int waitTimeInSec) {
        System.out.println("   wait to dismiss dialog");
        wait = new WebDriverWait(driver, waitTimeInSec);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("   no alert visible after "+waitTimeInSec+" sec.");
            return false;
        }
    }

    /**
     * click action using Webdriver wait
     * @param element
     */
    public void elementtoClick(MobileElement element, int waitTimeInSec){
        //wait = new WebDriverWait(driver, 10);
        try {
            wait = new WebDriverWait(driver, waitTimeInSec);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.err.println(element + "Not found after waiting for" + waitTimeInSec) ;
        }
    }

    /**
     * wait for element to be visible
     * @param element
     */
    public void elmenttoVisible(MobileElement element, int waiTimeInSec) {
        //wait = new WebDriverWait(driver, 10);
        try {
            wait = new WebDriverWait(driver, waiTimeInSec);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (ElementNotVisibleException e){
            e.printStackTrace();
            System.err.println(element + "Not Visible after waiting for" + waiTimeInSec);
        }

    }

    /**
     *
     * @param text
     */
    public void swipeRightToPage(String text){
        do {
            swipeHorizontal(0.9, 2, 0.20, 5);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!driver.getPageSource().contains(text));

    }

    public void swipeLeftToPage(String text){
        do {
            swipeHorizontal(0.2, 2, 0.9, 5);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!driver.getPageSource().contains(text));
    }

    /**
     * Implicit wait
     * @param seconds
     */
    public void waitTime_Impicit(long seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    /**
     * Fluent wait     (need to fix)
     * @param element
     */
    /*public void typeFluentWait(MobileElement element){
        Wait wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

    }*/

    /**
     *  Swipe Function (Right/Left)
     * @param startxPercent
     * @param startyPercent
     * @param endxPercent
     */
    public void swipeHorizontal(double startxPercent, long startyPercent, double endxPercent, int waitTimeInSec) {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * startxPercent);
        int endx = (int) (size.width * endxPercent);
        int starty = (int) (size.height / startyPercent);
        new TouchAction(driver)
                .press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(waitTimeInSec))) //5
                .moveTo(PointOption.point(endx, starty))
                .release()
                .perform();

    }

    /**
     * Swipe function (up/down)
     * @param startxPercent
     * @param startyPercent
     * @param endxPercent
     */
    public void swipeVertical(double startxPercent, long startyPercent, double endxPercent, int waitTimeInSec) {
        Dimension size = driver.manage().window().getSize();  //
        int starty = (int) (size.height * startxPercent);  // 0.8
        int endy = (int) (size.height * endxPercent);     //  0.2
        int startx = (int) (size.width / startyPercent); //   2
        new TouchAction(driver)
                .press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(waitTimeInSec)))  // 5
                .moveTo(PointOption.point(startx, endy))
                .release()
                .perform();
    }

    public void scrollMethod(MobileElement element){
         new TouchActions(driver)
                .scroll(element, 10, 100)
                .perform();

    }

    public enum DIRECTION {
        DOWN, UP, LEFT, RIGHT
    }

    public void swipe1(DIRECTION direction) {

        int startX;
        int endX;
        int startY;
        int endY;

        Dimension size = driver.manage().window().getSize();
        switch (direction) {
            case RIGHT:
                startX = (int) (size.width * 0.90);
                endX = (int) (size.width * 0.05);
                startY = (size.height / 2);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                        .moveTo(PointOption.point(endX, startY))
                        .release().perform();
                break;
            case LEFT:
                startX = (int) (size.width * 0.05);
                endX = (int) (size.width * 0.90);
                startY = (size.height / 2);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                        .moveTo(PointOption.point(endX, startY))
                        .release().perform();
                break;
            case UP:
                startX = (size.width / 2);
                endY = (int) (size.height * 0.70);
                startY = (int) (size.height * 0.30);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                        .moveTo(PointOption.point(endY, startY))
                        .release().perform();
                break;
            case DOWN:
                startX = (size.width / 2);
                endY = (int) (size.height * 0.30);
                startY = (int) (size.height * 0.70);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                        .moveTo(PointOption.point(startX, endY))
                        .release().perform();
                break;
        }
    }


    /**
     * validate by comparing images using openCV
     * @param originalImg
     */
    public void imageComparison(byte[] originalImg){
        byte[] screenShot = Base64.encodeBase64(driver.getScreenshotAs(OutputType.BYTES));
        FeaturesMatchingResult result = driver.matchImagesFeatures(screenShot, originalImg, new FeaturesMatchingOptions()
                                               .withDetectorName(FeatureDetector.ORB)
                                                .withGoodMatchesFactor(40)
                                                 .withMatchFunc(MatchingFunction.BRUTE_FORCE_HAMMING)
                                                  .withEnabledVisualization());

        //assertThat(result.getVisualization().length, is(greaterThan(0)));
        //assertThat(result.getCount(), is(greaterThan(0)));
        //assertThat(result.getTotalCount(), is(greaterThan(0)));
        assertFalse(result.getPoints1().isEmpty());
        assertNotNull(result.getRect1());
        assertFalse(result.getPoints2().isEmpty());
        assertNotNull(result.getRect2());

    }

    /**
     * validate screens by comparing images with pixels
     * @param file
     */
    public void validate_by_Imagecomparison(String file){
        byte[] screenShot = Base64.encodeBase64(driver.getScreenshotAs(OutputType.BYTES));
        Image image1 = Toolkit.getDefaultToolkit().getImage(String.valueOf(screenShot));
        Image image2 = Toolkit.getDefaultToolkit().getImage(file);

        try {

            PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);

            //int[]
            data1 = null;
            if (grab1.grabPixels()){
                int width = grab1.getWidth();
                int height  = grab1.getHeight();
                data1 = new int[width * height];
                data1 = (int[])grab1.getPixels();
            }

            //int[]
            data2 = null;
            if (grab2.grabPixels()) {
                int width = grab2.getWidth();
                int height = grab2.getHeight();
                data2 = new int[width * height];
                data2 = (int[])grab2.getPixels();
            }

            System.out.println("pixels equal:" + java.util.Arrays.equals(data1, data2));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
