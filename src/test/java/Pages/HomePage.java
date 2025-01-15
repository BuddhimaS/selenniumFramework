package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    // Locators using @FindBy
    @FindBy(id = "gh-logo")
    WebElement ebayLogo;

    @FindBy(linkText = "Sign in")
    WebElement signInLink;

    @FindBy(linkText = "register")
    WebElement registerLink;

    @FindBy(id = "gh-ac")
    WebElement searchBox;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;

    // Constructor to initialize elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // Methods to check visibility of Home elements
    public boolean isSignInLinkVisible() {
        return signInLink.isDisplayed();
    }

    public boolean isRegisterLinkVisible() {
        return registerLink.isDisplayed();
    }

    public boolean isSearchBoxVisible() {
        return searchBox.isDisplayed();
    }

    public boolean isSearchButtonVisible() {
        return searchButton.isDisplayed();
    }

    public boolean isEbayLogoVisible() {
        return ebayLogo.isDisplayed();
    }

    // Method to search for an item
    public void searchFor(String searchingItemName) {
        searchBox.clear(); // Clear any pre-filled text
        searchBox.sendKeys(searchingItemName); // Enter the search item
        searchButton.click(); // Click the search button
    }
}
