/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */
package Com.Bose.Corporation.Utilities.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    private static String reportFileName = "DrowsyQAReport" + ".html";
    private static Date date;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            date = new Date();
            DateFormat dtft = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
            String TodaysDate = dtft.format(date);
            String workingDirectory = System.getProperty("user.dir");
            extent = new ExtentReports(workingDirectory + "/ExtentReports/Drowsy" + TodaysDate + ".html", true);
        }
        return extent;
    }
}
