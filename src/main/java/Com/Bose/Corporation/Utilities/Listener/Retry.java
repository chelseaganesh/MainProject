/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */

package Com.Bose.Corporation.Utilities.Listener;

import Com.Bose.Corporation.Base.TestBase;
import Com.Bose.Corporation.Utilities.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {


    private int count = 0;
    private static int maxtry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()){
            if (count < maxtry){
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                extentReportsFailOrPassOperations(iTestResult, " fail");
                return true;
            }
        }else {
            iTestResult.setStatus(ITestResult.SUCCESS);
            extentReportsFailOrPassOperations(iTestResult, "pass");
        }
        return false;
    }

    public void extentReportsFailOrPassOperations(ITestResult iTestResult, String status) {

        Object testClass = iTestResult.getInstance();
        AppiumDriver driver = ((TestBase) testClass).getDriver();
        String screenShot = "date:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        if (status.equalsIgnoreCase("pass")) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Passed", ExtentTestManager.getTest().addBase64ScreenShot(screenShot));
        } else if (status.equalsIgnoreCase("fail")){
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed", ExtentTestManager.getTest().addBase64ScreenShot(screenShot));
        }
    }
}
