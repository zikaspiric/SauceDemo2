package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryPage;
import tests.BaseTest;

import java.util.ArrayList;

public class SocialLinkTest extends BaseTest {
    @Test
    public void twitterTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.clickTwitterButton();

            // ova metoda dohvata sve tabove ili prozore na drajveru
            ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());
            // ovime se prebacujemo na drugi tab
            driver.switchTo().window(tabs.get(1));
            String actualUrl = driver.getCurrentUrl();
            // ovo ubija aktivni prozor ili tab
            driver.close();

            // ova vraca na stari tab
            driver.switchTo().window(tabs.get(0));
            actualUrl = driver.getCurrentUrl();

            // dalje nastavite sa facebookom i linkedinom
        } finally {
            driver.quit();
        }
    }

}
