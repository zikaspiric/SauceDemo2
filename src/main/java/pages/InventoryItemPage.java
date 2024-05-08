package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryItemPage extends BasePage{

    @FindBy(xpath = "//div[@class = 'inventory_details_img_container']/img")
    WebElement imageLocator;

    public InventoryItemPage(ChromeDriver driver) {
        super(driver);
        print("Inventory item page");
    }

    public boolean isImagePresent() {
//        boolean isPresent =  isElementPresent(imageLocator);
//        return isPresent;
        waitForElement(imageLocator);
        return isElementPresent(imageLocator);
    }

    public String getAltAttribute() {
        return imageLocator.getAttribute("alt");
    };
}
