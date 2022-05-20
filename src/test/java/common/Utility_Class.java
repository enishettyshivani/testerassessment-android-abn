package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import static apps.abn_assessment.driver;

public class Utility_Class {

    public void Screenshot() throws IOException
    {
        //Getting the date of present day
        Date date = new Date();
        //Getting the time and date in a format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        //Capturing the screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        //Adding the filepath and saving the screenshot in jpg format
        File file = new File(dateFormat.format(date) + ".jpg");
        //Getting the captured screenshot file
        File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
        System.out.println("ScreenShot:" + "Screenshot." +file);
        //Saving the screenshot in the specified path
        FileUtils.copyFile(screenshotAs, new File("Screenshot."+file));
    }
}
