/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */
package Com.Bose.Corporation.Utilities.Listener;

import Com.Bose.Corporation.Base.TestBase;
import Com.Bose.Corporation.Utilities.TestRailIntegration.TestRail;
import Com.Bose.Corporation.Utilities.ExtentReports.ExtentManager;
import Com.Bose.Corporation.Utilities.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.model.Test;
import io.appium.java_client.AppiumDriver;
//import javafx.scene.input.DataFormat;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static Com.Bose.Corporation.Utilities.TestRailIntegration.TestRail.StatusResult.*;

public class TestListener extends TestBase implements ITestListener {

    /**
     * Appium Driver
     * @param
     */
    public TestListener() {
        super(driver);
    }

    /**
     *
     * @param iTestResult
     * @return
     */
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment (value = "Page Screenshot", type = "image/png")
    public byte [] saveScreenshotPng(AppiumDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment (value = "(0)", type = "text/plain")
    public static String saveTextLog (String message){
        return message;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(" Test Method " + getTestMethodName(iTestResult) + "started");
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(" Test Execution of " + getTestMethodName(iTestResult) + "success");
        captureScreenShot(iTestResult, "pass");
        //ExtentTestManager.getTest().log(LogStatus.PASS, "Passed");
        extentReportScreenShot(iTestResult, "pass");
        allureScreenShot(iTestResult);
        saveTextLog(getTestMethodName(iTestResult) + "Passed and screenshot taken");
        tesRailResult(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(" Test Execution of " + getTestMethodName(iTestResult) + "Failed");
        captureScreenShot(iTestResult, "fail");
        extentReportScreenShot(iTestResult, "fail");
        allureScreenShot(iTestResult);
        saveTextLog(getTestMethodName(iTestResult) + "failed and screenshot taken");
        tesRailResult(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(" Test Execution of " + getTestMethodName(iTestResult) + "skipped");
        extentReportScreenShot(iTestResult, "skipped");
        allureScreenShot(iTestResult);
        saveTextLog(getTestMethodName(iTestResult) + "skipped and screenshot taken");
        tesRailResult(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println(" Test Execution of  " + getTestMethodName(iTestResult) + "passed with in success percentage");

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println(" Started Test Suite" + iTestContext.getName());
        iTestContext.setAttribute("AppiumDriver", this.driver);

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println(" Finished Test Suite " + iTestContext.getName());
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    /**
     * Screen shot on Pass/Fail
     * @param result
     * @param status
     */
    public void captureScreenShot(ITestResult result, String status) {
        String destinationDir = "";
        String methodPassFail = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();

        //capture screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        if (status.equalsIgnoreCase("fail")) {
            destinationDir = "screenshots/Failure";
        }
        else if (status.equalsIgnoreCase("pass")){
            destinationDir = "screenshots/Success";
        }
        new File(destinationDir).mkdirs();
        //set FileName
         String destinationFile = methodPassFail + " - " + dateFormat.format(new Date()) + ".png";
        //String destinationFile = String.format(methodPassFail + " - " + dateFormat, new Date()) + ".png";

        try{
            FileUtils.copyFile(scrFile, new File(destinationDir + "/" + destinationFile));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * screen shot on reports
     * @param result
     * @param status
     */
    public void extentReportScreenShot(ITestResult result, String status) {
        Object testClass = result.getInstance();
        AppiumDriver driver = ((TestBase) testClass).getDriver();
        String screenShot = "date:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        if (status.equalsIgnoreCase("pass")){
            ExtentTestManager.getTest().log(LogStatus.PASS, "Passed", ExtentTestManager.getTest().addBase64ScreenShot(screenShot));
        }else if (status.equalsIgnoreCase("fail")){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed", ExtentTestManager.getTest().addBase64ScreenShot(screenShot));
        }else if (status.equalsIgnoreCase("skipped")){
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Skipped", ExtentTestManager.getTest().addBase64ScreenShot(screenShot));
        }
    }

    public void allureScreenShot(ITestResult result) {
        Object testClass = result.getInstance();
        AppiumDriver driver = ((TestBase) testClass).getDriver();
        if (driver instanceof AppiumDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(result));
            saveScreenshotPng(driver);
        }
    }

    public void tesRailResult(ITestResult result) {

        propFile();
        testrailrun = prop.getProperty("testrailrunID");
        TestRail apiCall = new TestRail();
        String[] caseIds = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName().split(",");

        if (ITestResult.FAILURE == result.getStatus()) {
            String resultName = result.getName();
            apiCall.setResult(caseIds, testrailrun, ifResultFail);
        } else if (ITestResult.SUCCESS == result.getStatus()) {
            String resultName = result.getName();
            apiCall.setResult(caseIds, testrailrun, ifResultPassed);
        } else if (ITestResult.SKIP == result.getStatus()) {
            String resultName = result.getName();
            apiCall.setResult(caseIds, testrailrun, ifResultSkipped);
        }

    }
}
