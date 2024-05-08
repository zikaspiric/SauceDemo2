package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage extends BasePage {




    //webelementi stranice

    @FindBy(xpath = "//img[@alt = 'Sauce Labs Backpack']")
    WebElement backPackImageLocator;

    @FindBy(xpath = "//select[@class = 'product_sort_container']")
    WebElement dropDownButton;

    @FindBy(xpath = "//button[@id = 'add-to-cart-sauce-labs-backpack']")
    WebElement addToCartBackPackButton;

    @FindBy(xpath = "//button[@id = 'add-to-cart-sauce-labs-onesie']")
    WebElement addToCartOnesieButton;

    @FindBy(xpath = "//span[@class = 'shopping_cart_badge']")
    WebElement shoppingCartBadge;

    @FindBy(xpath = "//*[@data-test = 'add-to-cart-sauce-labs-bike-light']")
    WebElement addToCartBikeLight;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeFromCartBackPackButton;




    //konstruktori

    public InventoryPage(ChromeDriver driver) {
        super(driver);
        print(Strings.INVENTORY_PAGE_URL);
    }

    //metode

    public void clickBackPackImage() {
        waitForElement(backPackImageLocator);
        backPackImageLocator.click();
    }

    public void clickAddToCartBackPackButton() {
        print("clickAddToCartBackPackButton");
        addToCartBackPackButton.click();
    }

    public void clickAddToCartOnesieButton() {
        print("clickAddToCartOnesieButton");
        addToCartOnesieButton.click();
    }

    public String getNumberFromShoppingCart() {
        print("getNumberFromShoppingCart");

        String number = shoppingCartBadge.getText();
        return number;
        //return shoppingCartBadge.getText();
    }

    public void sortItemsByText(String text) {
        //print("sortItemsByText ( " + sortType + " )");
        Select dropdown = new Select(dropDownButton);
        dropdown.selectByVisibleText(text);
    }

    public void clickRemoveFromBackpackButton(){
        print("clickRemoveFromBackpackButton");
        removeFromCartBackPackButton.click();
    }

    //methods
    //   public void clickAddToCartBikeLight() {
    //       print("clickAddToCartBikeLight");
    //       waitForElement(addToCartBikeLight);
    //     addToCartBikeLight.click();
//}

 //   public boolean isDropDownPresent() {
     //   return isElementPresent(dropDownButton);





    //ova metoda dohvata sve iteme na stranici i vraca cenu prvog
    public String getFirstItemPrice() {

        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        WebElement firstItem = items.get(0);
        WebElement firstItemPrice = firstItem.findElement(By.xpath("//div[@class = 'inventory_item_price']"));
        return firstItemPrice.getText();


    }

}

