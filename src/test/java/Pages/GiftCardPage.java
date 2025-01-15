package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static java.lang.Thread.sleep;


public class GiftCardPage {
    WebDriver driver;

    // Locators using @FindBy

    @FindBy(xpath ="//a[text()='Gift Cards']")
    WebElement LnK_GiftCardLink;

    @FindBy(xpath ="//a[@href='https://www.ebayinc.com']")
    WebElement lnk_AboutEbay;

    @FindBy(xpath = "//h5[text()='eBay eGift Cards']")
    WebElement txt_Gift;



    // Constructor to initialize elements
    public GiftCardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to GiftCard Page Navigation
    public void GiftCardPageNavigation() {

        //Click on the Gift Card link
        LnK_GiftCardLink.click();

        // Verify the text
        String actualText = txt_Gift.getText();
        String expectedText = "eBay eGift Cards";

        if (actualText.equals(expectedText)) {
            System.out.println("Test Passed: Text is as expected - " + actualText);
        } else {
            System.out.println("Test Failed: Expected '" + expectedText + "' but got '" + actualText + "'");
        }
        //Wait
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Scroll down by 1000 pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    }
    // Method to AboutEbay Page NavigationFromGiftUI
    public void AboutEbayFromGiftCardPage() {
        //Click on the Gift Card link
        lnk_AboutEbay.click();

    }





    }


