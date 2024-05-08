package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryItemPage;
import pages.InventoryPage;
import tests.BaseTest;

public class InventoryItemTest extends BaseTest {


//    @Test(invocationCount = 10)
    @Test
    public void isImageShownForItem() {
        ChromeDriver driver = openChromeDriver();
        try {
            loginWithValidCreds(driver); //moze se i ovde komenatar
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.clickBackPackImage();
            InventoryItemPage inventoryItemPage = new InventoryItemPage(driver);
            assert inventoryItemPage.isImagePresent() : "Image is NOT present";
            assert inventoryItemPage.getAltAttribute().contains("Backpack") : "Error";
        }finally {
            driver.quit();
        }
    }
}
