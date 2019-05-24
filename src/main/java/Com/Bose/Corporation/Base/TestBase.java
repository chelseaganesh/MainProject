/*
 * Developed by Divij
 * Copyright (c) 2019 Bose Corporation. All rights reserved.
 */
package Com.Bose.Corporation.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.annotations.Parameters;
import sun.security.jca.GetInstance;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static sun.print.CUPSPrinter.getServer;

public class TestBase {

    protected static  Logger logger = LoggerFactory.getLogger(TestBase.class);
    public static Properties prop;
    public static InputStream input;
    public static File f;
    public static File androidFile;
    public static File iosFile;
    public static DesiredCapabilities capabilities;
    protected static AppiumDriver driver;

    public static FileExtension fileExtension = new FileExtension();

    /**
     * Appium Driver
     * @param driver
     */
    public TestBase(AppiumDriver driver) {

        this.driver = driver;
    }



    /**
     *
     * @return driver
     */
    public AppiumDriver getDriver(){
        return  driver;
    }

    /**
     * property File
     */
    public static void propFile(){

        String fileName = "Config.properties";
        String filePath = "";
        try{
            prop = new Properties();
            input = TestBase.class.getClassLoader().getResourceAsStream(fileName);
                if(input==null){
                System.out.println("Sorry, unable to find " + fileName);
                return;
            }
            prop.load(input);
            filePath = prop.getProperty("ResourcesPath");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input!=null){
                try{
                    input.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * File path (apk/ipa)
     */
    public static void filePath(){
        propFile();
        String File_Path = prop.getProperty("ResourcesPath");
        String Android_File_Name = prop.getProperty("androidfilename");
        String Ios_File_Name  = prop.getProperty("iosfilename");

        f = new File(File_Path);
        androidFile = new File(f, Android_File_Name);
        iosFile = new File(f,Ios_File_Name);

    }

    /**
     * start appium
     */
    public void startServer(){
        CommandLine commandline = new CommandLine("/usr/local/bin/node");
        commandline.addArgument("/usr/local/bin/appium",false);
        //commandline.addArgument("/usr/local/lib/node_modules/appium/build/lib/appium", false);
        commandline.addArgument("--address", false);
        commandline.addArgument("127.0.0.1");
        commandline.addArgument("--port", false);
        commandline.addArgument("4723");

        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();

        try {
            executor.execute(commandline, resultHandler);
            System.out.println("Appium Server Started");

        } catch (ExecuteException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    /**
     * Stop Appium Server
     */
    public void stopServer(){
        String[] command = {"/usr/bin/killall", "-KILL", "node"};
        try{
            Runtime.getRuntime().exec(command);
            System.out.println("Appium Server Stopped");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     *  checking Appium Server port
     * @param port
     * @return
     */
    public boolean checkAppiumServerRunning(int port){
        boolean isserverrunning = false;
        ServerSocket serverSocket;
        try{

            serverSocket = new ServerSocket(port);
            serverSocket.close();
        }catch (IOException e){
            e.printStackTrace();
            isserverrunning = true;
        }
        return isserverrunning;
    }

    /**
     *  start server with finalising port in use
     */
    public void appiumserver() throws InterruptedException {

        propFile();
        String port = prop.getProperty("appiumport");
        int portValue = Integer.parseInt(port);
        if (!checkAppiumServerRunning(portValue)){
            startServer();
        }else {
            System.out.println("Appium Server is already running on port -" + portValue);
            stopServer();
            Thread.sleep(2000);
            startServer();
        }
    }

    /**
     * Android Capabilities
     * @return
     */
    public AppiumDriver androidCapabilities() throws InterruptedException {
        propFile();
        //filePath();
        fileExtension.buildPath();

        String Device_Name = prop.getProperty("DeviceName");
        String platformVersion = prop.getProperty("platformversion");
        String platform_Name = prop.getProperty("platformname");
        String Automation_Name = prop.getProperty("automationName");
        String Locale_ID = prop.getProperty("localeid_android");
        String Language_ID = prop.getProperty("languageid_android");

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,Device_Name);
        //capabilities.setCapability(MobileCapabilityType.APP,androidFile.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.APP,fileExtension.environmentFile.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_Name);
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Automation_Name);
        capabilities.setCapability(MobileCapabilityType.LANGUAGE, Language_ID);
        capabilities.setCapability(MobileCapabilityType.LOCALE, Locale_ID);
        /**
         * Android  Driver
         */
        try{
            driver = new AndroidDriver(new
                    URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    /**
     * IOS Capabilities
     * @return
     */
    public AppiumDriver iosCapabilities() throws InterruptedException {
        propFile();
        //filePath();
        fileExtension.buildPath();

        String Device_Name = prop.getProperty("Device_Name");
        String platformVersion = prop.getProperty("platform_version");
        String platform_Name = prop.getProperty("platform_name");
        String Automation_Name = prop.getProperty("Automation_Name");
        String UDID = prop.getProperty("Ios_id");
        String Team_Id = prop.getProperty("team_id");
        String Developer_Id = prop.getProperty("developerid");
        String timeout = prop.getProperty("timeout");
        String Bundle_ID = prop.getProperty("bundleId");
        String Locale_ID = prop.getProperty("localeid_ios");
        String Language_ID = prop.getProperty("languageid_ios");


        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,Device_Name);
        //capabilities.setCapability(MobileCapabilityType.APP,iosFile.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.APP, fileExtension.environmentFile.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_Name);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Automation_Name);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        capabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, Team_Id);
        capabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, Developer_Id);
        capabilities.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT, timeout);
        capabilities.setCapability(IOSMobileCapabilityType.WDA_CONNECTION_TIMEOUT,timeout);
        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, Bundle_ID );
        capabilities.setCapability(IOSMobileCapabilityType.SHOW_IOS_LOG, true);
        //capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, );
        capabilities.setCapability(IOSMobileCapabilityType.USE_NEW_WDA, true );
        //capabilities.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG, true );
        capabilities.setCapability(MobileCapabilityType.LOCALE, Locale_ID);
        capabilities.setCapability(MobileCapabilityType.LANGUAGE, Language_ID);


        /**
         * IOS Driver
         */
        try{
            driver = new IOSDriver(new
                    URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    /**
     * wait time
     * @param wait
     * @param timeout
     */
    public void setWaitTimeOut(long wait, long timeout ){
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }

    /**
     * Automation
     *  initaialize automation environmemnt android or Ios
     * @throws InterruptedException
     */
    public void initializeAutomation() throws InterruptedException {

        propFile();
        String Automation_Environment = prop.getProperty("Environment");

        //startServer();
        if(Automation_Environment.equals("android"))
        {
            androidCapabilities();
        }
        else if (Automation_Environment.equals("ios"))
        {
            iosCapabilities();
            setWaitTimeOut(30,20);
        }
        log("Creating Appium session, this may take couple minutes..");

    }

    /**
     * get TestRail RunID
     * @return
     */
    public String getTestrailRun() {
        propFile();
        testrailrun = prop.getProperty("testrailrunID");
        return testrailrun;
    }

    /**
     * set TestRail RunID
     * @param testrailrun
     */
    public void setTestrailRun(String testrailrun) {
        this.testrailrun = testrailrun;
    }

    /**
     * teat rail
     */
    public static String testrailrun;
    protected static String testrailUserID;
    protected static String testrailUserPassword;
    protected static String testrailAssignID;

    /**
     * TesRail
     * user ID
     * @return
     */
    private String getTestrailUserID(){
        propFile();
        testrailUserID = prop.getProperty("");
        return testrailUserID;
    }

    /**
     * TestRail
     * user  Password
     * @return
     */
    private String getTestrailUserPassword(){
        propFile();
        testrailUserPassword = prop.getProperty("");
        return testrailUserPassword;
    }

    /**
     * TestRail
     * Assign ID
     * @return
     */
    private String getTestrailAssignID(){
        propFile();
        testrailAssignID = prop.getProperty("");
        return testrailAssignID;
    }

    public void log(String message) {
        logger.info(message);
    }


}
