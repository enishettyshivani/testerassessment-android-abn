package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    public WebDriver driver;
    public PageObject(WebDriver driver) { PageFactory.initElements(driver, this);}

    //Checking if the Text Hello World is displayed
    @FindBy(xpath="//android.widget.TextView[@text='Hello World!']")
    WebElement hello;
    public WebElement hello() { return hello;}

    //tapping on mail button
    @FindBy(xpath="//android.widget.ImageButton[@resource-id='com.abnamro.apps.referenceandroid:id/fab']")
    WebElement mail;
    public WebElement mail() { return mail;}

    //checking the text message 'Replace with your own action' after tapping on mail option
    @FindBy(xpath="//android.widget.TextView[@text='Replace with your own action']")
    WebElement mail_Text;
    public WebElement mail_Text() { return mail_Text;}

    //checking the title message 'ReferenceAndroid' on the Screen
    @FindBy(xpath="//android.widget.TextView")
    WebElement title_Text;
    public WebElement title_Text() { return title_Text;}

    //tapping on 3 dots displayed in the corner of the screen the more options button
    @FindBy(xpath="//android.widget.ImageView[contains(@content-desc,'More options')]")
    WebElement more_Options;
    public WebElement more_Options() { return more_Options;}

    //after tapping on more options button - checking if the text of the button is displayed as Settings
    @FindBy(id="title")
    WebElement setting;
    public WebElement setting() { return setting;}
}
