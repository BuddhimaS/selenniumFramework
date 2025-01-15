package TestCases;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ProductPage;
import Utils.ExcelHandler;
import Utils.ScreenshotsManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    @Test(priority = 1, enabled = true)
    public void Testcase3_VerifyUserCanSetupBasicsForProducts() {
        // Start Extent Report for this test
        test = extent.createTest("Selected Basics for Products");

        try {
            // Initialize HomePage object
            HomePage homePage = new HomePage(driver);
            // Initialize ProductPage object
            ProductPage productPage = new ProductPage(driver);

            // Perform search action
            homePage.searchFor("blouse");
            String searchScreenshot = ScreenshotsManager.takeScreenshot(driver, "SearchForBlouse_Success");
            test.pass("Search action completed successfully.",
                    com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(searchScreenshot).build());

            // Perform basic product selection
            productPage.BasicSelectionForProducts();
            String selectionScreenshot = ScreenshotsManager.takeScreenshot(driver, "BasicSelectionForProducts_Success");
            test.pass("Product selection completed successfully.",
                    com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(selectionScreenshot).build());

        } catch (Exception e) {
            // Capture screenshot on failure
            String failureScreenshot = ScreenshotsManager.takeScreenshot(driver, "SelectedBasicsForProducts_Failure");
            test.fail("Test failed due to an exception: " + e.getMessage(),
                    com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(failureScreenshot).build());
            throw e; // Re-throw to mark the test as failed
        }
    }


}