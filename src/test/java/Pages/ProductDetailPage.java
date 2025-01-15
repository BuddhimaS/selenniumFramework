package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage {

    WebDriver driver;

    // Locators using @FindBy
    @FindBy(xpath = "//select[@id='color']")
    WebElement Dd_Colour;

    @FindBy(xpath = "//select[@id='size']")
    WebElement Dd_Size;

    @FindBy(xpath = "//ul[contains(@class, 'srp-results')]/li[contains(@class, 's-item')][1]")
    WebElement firstProduct;


    @FindBy(xpath ="//button[contains(text(), 'Buy it now')]" )
    WebElement btn_BuyNow;

    // Constructor to initialize elements
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method for set selections from product detail page
    public void DetailSelectionForProductsDetailPage() {
        //Click on First Product
        firstProduct.click();
        // Select the color as black from the dropdown
        Select colorSelect = new Select(Dd_Colour);
        colorSelect.selectByVisibleText("black");
        // Select the size as L from the dropdown
        Select sizeSelect = new Select(Dd_Size);
        sizeSelect.selectByVisibleText("L");

    }

    //Method for Buy Now functionality from product detail page

    public void BuyNowDetailPage() {
        //Click on Buy it Now button
        btn_BuyNow.click();


    }
}





