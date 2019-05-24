/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */

package Com.Bose.Corporation.Utilities.TestRailIntegration;
/*
 *
 */

import Com.Bose.Corporation.Base.TestBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRail {

    protected Map testResultData = new HashMap();
    private APIClient client;
    protected static String testRailURL;
    protected static String userId;
    protected static String userPassword;
    protected static String assignId;

    public TestRail() {

        TestBase.propFile();
        testRailURL = TestBase.prop.getProperty("testRailurl");
        userId = TestBase.prop.getProperty("userID");
        userPassword = TestBase.prop.getProperty("userPassword");
        assignId = TestBase.prop.getProperty("assignID");

        //client = new APIClient("https://boseqacoda.testrail.net");
        client = new APIClient(testRailURL);
        client.setUser(userId);
        client.setPassword(userPassword);

        testResultData .put("assignto_id", assignId);
        testResultData.put("comment", "Test Executed - Status Updated automatically by appium");
    }

    public void setCaseResult(String[] caseIds, String run, boolean isResultFail) {

        if (isResultFail) {
            testResultData.put("status_id", 5);
        } else {
            testResultData.put("status_id", 1);
        }

        for (int i=0; i<caseIds.length; i++ ) {
            try {
                client.sendPost("add_result_for_case/" + run + "/" +  caseIds[i], testResultData);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (APIException e) {
                e.printStackTrace();
            }
        }
    }

    public enum StatusResult {
         ifResultFail, ifResultSkipped, ifResultPassed
    }

    public void setResult(String[] caseIds, String run, StatusResult statusResult) {
        switch (statusResult) {
            case ifResultFail:
                testResultData.put("status_id", 5);
                break;
            case ifResultSkipped:
                testResultData.put("status_id", 4);
                break;
            case ifResultPassed:
                testResultData.put("status_id", 1);
                break;

        }

        for (int i=0; i<caseIds.length; i++ ) {
            try {
                client.sendPost("add_result_for_case/" + run + "/" + caseIds[i], testResultData);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (APIException e) {
                e.printStackTrace();
            }
        }

    }



}
