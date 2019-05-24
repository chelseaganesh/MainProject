/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */

package Com.Bose.Corporation.Utilities.ExtentReports;

import Com.Bose.Corporation.Base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Report implements IReporter {

    public static ExtentReports extent;
    public static ExtentTest test;

    //@Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String outPutDirectory) {

        DateFormat dtft = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        //ExtentManager.getReporter();
        extent = new ExtentReports(outPutDirectory + File.separator + "Extent" + dtft.format(new Date()) + ".html" );

        for (ISuite suite : list1) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult result1 : result.values()) {
                ITestContext context = result1.getTestContext();

                //builtTestNodes(context.getPassedTests(), LogStatus.INFO);
                builtTestNodes(context.getPassedTests(),LogStatus.PASS);
                builtTestNodes(context.getFailedTests(), LogStatus.FAIL);
                builtTestNodes(context.getSkippedTests(), LogStatus.SKIP);
               // builtTestNodes(context.getFailedButWithinSuccessPercentageTests(), LogStatus.WARNING);
               // builtTestNodes(context.getFailedConfigurations(), LogStatus.FATAL);

            }
        }

        for (String s : Reporter.getOutput()){
             extent.setTestRunnerOutput(s);
        }
        
        extent.flush();
        extent.close();
    }

    private void builtTestNodes(IResultMap tests, LogStatus status) {
       // ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());
                test.assignAuthor("Divij");
                //test.log(LogStatus.INFO);
                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                    /*if (result.getThrowable() != null) {
                        test.log(status, result.getThrowable())
                    } else {
                        test.log(status, "Test" + status.toString().toLowerCase() + "ed");
                    }*/

                    screenCapture(result, status);

                    extent.endTest(test);

            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public void screenCapture(ITestResult result, LogStatus status){
        Object testClass = result.getInstance();
        AppiumDriver driver = ((TestBase) testClass).getDriver();
        String screenShot = "date:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
       // String screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);


        if (result.getThrowable() != null) {
            test.log(status, String.valueOf(result.getThrowable()), test.addBase64ScreenShot(screenShot));

        } else {
            test.log(status, "Test" + status.toString().toLowerCase() + "ed", test.addBase64ScreenShot(screenShot));
        }
    }

}
