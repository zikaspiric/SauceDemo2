package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.Strings;

public class SortingTest extends BaseTest{

    @Test

    public void sortItemByPriceAscending(){

        ChromeDriver driver = openChromeDriver();

        try {
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            String firstItemPriceUnsorted = inventoryPage.getFirstItemPrice();
            float priceUnsorted = Float.valueOf(firstItemPriceUnsorted.substring(1));
            inventoryPage.sortItemsByText(Strings.DROPDOWN_SORT_BY_PRICE_ACS);

            String firstItemPriceSorted = inventoryPage.getFirstItemPrice();
            //substring je da bi se izbacio prvi karakter $, da bi mogla cena, koja je string, da se pretvori u broj
            float priceSorted = Float.valueOf(firstItemPriceSorted.substring(1));

            assert priceSorted<priceUnsorted : "Error: Prices are not sorted in ascending order";


        }finally {
            driver.quit();

        }
    }
}
