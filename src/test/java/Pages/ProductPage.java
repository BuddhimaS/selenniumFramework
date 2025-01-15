package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {
    WebDriver driver;

    // Locators using @FindBy
    @FindBy(xpath = "//div[text()='Regular']")
    WebElement btnRegularSize;

    @FindBy(xpath = "//span[text()='Buy It Now']")
    WebElement btnBuyItNow;

    @FindBy(xpath = "//span[@class='checkbox']//input[@type='checkbox']")
    WebElement chkIncludeDescription;


    // Constructor to initialize elements
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method for basic selections in the product page
    public void BasicSelectionForProducts() {

        //Select the size as Regular
        btnRegularSize.click();
        //Click on Buy it now
        btnBuyItNow.click();
    }
}
