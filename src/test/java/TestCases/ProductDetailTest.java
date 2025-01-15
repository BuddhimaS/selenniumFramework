package TestCases;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.ProductPage;
import Utils.ExcelHandler;
import Utils.ScreenshotsManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailTest extends BaseTest {

    @Test(priority = 1, enabled = true)
    public void Testcase4_VerifySelectedProductDetailSelection() {
        // Start Extent Report for this test
        startTest("Verify Product Detail Selection");


        // Initialize Page Objects
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);

        // Perform Search for a Product
        homePage.searchFor("blouse");
        test.info("Searched for 'blouse'.");
        productPage.BasicSelectionForProducts();
        productDetailPage.DetailSelectionForProductsDetailPage();
        productDetailPage.BuyNowDetailPage();

    }


    }
