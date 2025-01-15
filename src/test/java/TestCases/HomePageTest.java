package TestCases;

import Base.BaseTest;
import Pages.HomePage;
import Utils.ExcelHandler;
import Utils.ScreenshotsManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, enabled = true)
    public void Testcase1_verifyHomePageMainElementsAreExists() {
        // Start Extent Report for this test
        startTest("Verify Home Page Main Elements");

        HomePage homePage = new HomePage(driver);

        // Initialize ExcelHandler to read test data
        ExcelHandler excelHandler = new ExcelHandler("C:/22550712_AutomationScripts/22550712/ExcelResources/TestData.xlsx", "HomePageElements");

        try {
            // Loop through rows in Excel to dynamically verify elements
            int rowCount = excelHandler.getRowCount();
            for (int i = 1; i < rowCount; i++) { // Assuming first row is headers
                String elementName = excelHandler.getCellData(i, 0); // Element name in the first column
                String expectedVisibility = excelHandler.getCellData(i, 1); // Expected visibility in second column

                boolean isElementVisible = false;

                // Verify element visibility based on the element name in Excel
                if (elementName.equalsIgnoreCase("SignInLink")) {
                    isElementVisible = homePage.isSignInLinkVisible();
                } else if (elementName.equalsIgnoreCase("RegisterLink")) {
                    isElementVisible = homePage.isRegisterLinkVisible();
                } else if (elementName.equalsIgnoreCase("SearchBox")) {
                    isElementVisible = homePage.isSearchBoxVisible();
                } else if (elementName.equalsIgnoreCase("SearchButton")) {
                    isElementVisible = homePage.isSearchButtonVisible();
                } else if (elementName.equalsIgnoreCase("EbayLogo")) {
                    isElementVisible = homePage.isEbayLogoVisible();
                }

                // Check if the visibility matches the expected result
                if (expectedVisibility.equalsIgnoreCase("visible")) {
                    Assert.assertTrue(isElementVisible, elementName + " is not visible on the homepage.");
                    test.pass(elementName + " is visible on the homepage.");
                } else {
                    Assert.assertFalse(isElementVisible, elementName + " is visible on the homepage, but it shouldn't be.");
                    test.fail(elementName + " should not be visible on the homepage.");
                }
            }
        } catch (AssertionError e) {
            // Capture screenshot on failure
            String screenshotPath = ScreenshotsManager.takeScreenshot(driver, "verifyHomePageMainElements");
            System.out.println("Screenshot path: " + screenshotPath); // Log the screenshot path

            // Attach the screenshot to the Extent Report
            test.fail("Test failed: " + e.getMessage(),
                    com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            throw e; // Re-throw to mark the test as failed
        } finally {
            // Close Excel handler after test
            excelHandler.closeWorkbook();
        }
    }



    @Test(priority = 2, enabled = true)
    public void Testcase2_VerifySearchingFunctionalityFromHome() {
        // Start Extent Report for this test
        startTest("Verify Searching Functionality from Home");

        try {
            // Navigate to eBay
            driver.get("https://www.ebay.com/");
            test.info("Navigated to eBay homepage.");

            // Initialize HomePage object
            HomePage homePage = new HomePage(driver);

            // Perform search
            homePage.searchFor("blouse");
            test.pass("Search for 'blouse' was successful.");
        } catch (Exception e) {
            String screenshotPath = ScreenshotsManager.takeScreenshot(driver, "VerifySearchingFunctionalityFromHome");
            test.fail("Test failed: " + e.getMessage(),
                    com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            throw e; // Re-throw to mark the test as failed
        }


    }

}
