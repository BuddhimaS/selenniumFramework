package TestCases;

import Base.BaseTest;
import Pages.GiftCardPage;
import Pages.HomePage;
import Utils.ExcelHandler;
import Utils.ScreenshotsManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class GiftCardPageTest extends BaseTest {

    @Test(priority = 1, enabled = true)
    public void Testcase5_VerifyGiftSectionByScrollThePage() {
        WebDriver driver = this.driver;

        // Initialize pages
        HomePage homePage = new HomePage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);

        try {
            // Navigate to GiftCard Page
            giftCardPage.GiftCardPageNavigation();
            giftCardPage.AboutEbayFromGiftCardPage();

            // Capture screenshot after navigating to GiftCard page
            String screenshotPath = ScreenshotsManager.takeScreenshot(driver, "GiftCardPageNavigation");
            System.out.println("Screenshot taken: " + screenshotPath);

        } catch (Exception e) {
            // In case of failure, capture a screenshot
            String screenshotPath = ScreenshotsManager.takeScreenshot(driver, "Testcase5_Failure");
            System.out.println("Test failed, screenshot captured at: " + screenshotPath);

        }
    }
}
