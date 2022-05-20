package apps;

import common.Utility_Class;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import PageObject.PageObject;

public class abn_assessment {
    public static AndroidDriver driver;
    static Utility_Class strUtil = new Utility_Class();
    static Logger LOG = Logger.getLogger(String.valueOf(abn_assessment.class));
    public static void main(String[] args) throws IOException {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
            capabilities.setCapability("appPackage", "com.abnamro.apps.referenceandroid");
            capabilities.setCapability("appActivity", "com.abnamro.apps.referenceandroid.MainActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // page Object class is invoked here
            PageObject refAndroid = new PageObject(driver);
            //Verifying if Hello World is displayed
            refAndroid.hello().isDisplayed();
            //Tapping on mail option present at the bottom corner of the screen
            refAndroid.mail().click();
            //After tapping on mail - Verifying if mail text displayed
            String mail_text = refAndroid.mail_Text().getText();
            if ("Replace with your own action".contains(mail_text)) {
                System.out.println("'Replace with your own action' text message is displayed");
            } else {
                System.out.println("'Replace with your own action' text message is not displayed");
            }
            //Verifying if Title is displayed
            String refandroid_text = refAndroid.title_Text().getText();
            if ("ReferenceAndroid".contains(refandroid_text)) {
                System.out.println("ReferenceAndroid text message is displayed");
            } else {
                System.out.println("ReferenceAndroid text message is not displayed");
            }
            //Verifying if More Options button is clickable
            refAndroid.more_Options().click();
            //After tapping on more option - verifying if Settings is displayed on the label correctly or not
            String setting = refAndroid.setting().getText();
            if ("Settings".contains(setting)) {
                System.out.println("'Settings' text message is displayed");
            } else {
                System.out.println("'Settings' text message is not displayed");
            }
            //Tapping on Settings button
            refAndroid.setting().click();
            //Closing the app
            driver.closeApp();
            //making the app run in the background
            try{driver.runAppInBackground(Duration.ofSeconds(10));}catch (Exception e) {}
            //relaunching the app
            driver.launchApp();
            //After reopening the app - checking if modules are working or not, so verifying by tapping on more options button
            refAndroid.more_Options().click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //After tapping on more option - verifying if Settings is displayed on the label correctly or not
            refAndroid.setting().getText();
            if ("Settings".contains(setting)) {
                System.out.println("'Settings' text message is displayed");
            } else {
                System.out.println("'Settings' text message is not displayed");
            }
            refAndroid.setting().click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // Verifying the text by using the List method.
            List<WebElement> text = refAndroid.text();
            for(int x=0; x<text.size();x++)
            {
                if (text.get(x).getText().contains(refAndroid.hello().getText()))
                {
                    System.out.println("Hello World is displayed in the Screen");
                }
                else if (text.get(x).getText().contains(refAndroid.title_Text().getText()))
                {
                    System.out.println("Title is displayed in the Screen");
                }
                else
                {
                    System.out.println("Text is not displayed Correctly");
                }
            }
        } catch (Exception e) {
            //Taking a screenshot if the app throws an error
            strUtil.Screenshot();
            //Printing the error message so that it will be easy to know why the app failed.
            LOG.info("Exception || Error Message: "+e.getMessage());
        }
    }
}


