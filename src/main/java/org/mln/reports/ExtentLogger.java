package org.mln.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.mln.utils.ScreenShotUtil;

/**
 * This class is used to log the test steps in the extent report
 */
public class ExtentLogger {

    private ExtentLogger() {
    }

    /**
     * If the value of the property "PASSEDSTEPSSCREENSHOT" is "YES", then the screenshot will be attached to the report
     *
     * @param loggerText The text that you want to log in the report.
     */
    public static void pass(String loggerText) {
        if (PropertyUtil.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("YES")) {

            ExtentReportManager.getExtentTest()
                    .pass(loggerText,
                            MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
        }
        else{
            ExtentReportManager.getExtentTest()
                    .pass(loggerText);
        }
    }

    /**
     * If the value of the property "FAILEDSTEPSSCREENSHOT" is "YES", then the screenshot will be attached to the report
     *
     * @param loggerText The text that you want to log in the report.
     */
    public static void fail(String loggerText) {
        if (PropertyUtil.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("YES")) {
            ExtentReportManager.getExtentTest()
                    .fail(loggerText,
                            MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
        }
        else{
            ExtentReportManager.getExtentTest()
                    .fail(loggerText);
        }
    }

    /**
     * If the value of the property SKIPPEDSTEPSSCREENSHOT is YES, then the screenshot will be attached to the report
     *
     * @param loggerText The text that you want to log in the report.
     */
    public static void skip(String loggerText){
        if (PropertyUtil.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("YES")) {
            ExtentReportManager.getExtentTest()
                    .skip(loggerText,
                            MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
        }
        else{
            ExtentReportManager.getExtentTest()
                    .skip(loggerText);
        }
    }



}
