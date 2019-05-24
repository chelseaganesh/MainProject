/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */

package Com.Bose.Corporation.Utilities.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IReporter;
import com.relevantcodes.extentreports.model.Test;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    static Map extentTestMap = new HashMap<Integer, ExtentTest>();
    static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest(){
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static  synchronized void endTest(){
        extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized  ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        test.assignAuthor("Divij");
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}
