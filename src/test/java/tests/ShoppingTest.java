package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.*;

public class ShoppingTest extends BaseTest {

    /*
    Shopping items and logout
    1.login with valid username and pass
    2.Click on one item e.g. BackPack
    3.Click on second item e.g. Onesie
    4.enter name,lastname and zip code
    5.click on finish button
    6.click on backHome button
    7.logout

    Expected result:
    5. Verify that user is on overview page
    7.Verify that user is logged out
     */

     @Test
    public void shoppingItemAndLogout(){
         ChromeDriver driver = openChromeDriver();

         try {
             print("1. Login with valid user");
             loginWithValidCreds(driver);
             InventoryPage inventoryPage = new InventoryPage(driver);

             print("2. Click on one item e.g. BackPack");
             inventoryPage.clickAddToCartBackPackButton();

             print("3. Click on second item e.g. Onesie");
             inventoryPage.clickAddToCartOnesieButton();

             print("Verify that the shopping cart icon shows number 2");
             String actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
             assert actualNumberFromCart.equals("2") : "Wrong number in shopping cart. Expected: 2 . Actual :" + actualNumberFromCart;

             print("4. Click on cart icon");
             inventoryPage.clickShoppingCartIcon();

             YourCartPage yourCartPage = new YourCartPage(driver);
             print("5. Click on checkout button");
             yourCartPage.clickCheckoutButton();

             assert driver.getCurrentUrl().equals(Strings.CHECKOUT_PAGE_URL) : "Error";

             CheckoutPage checkoutPage = new CheckoutPage(driver);
             print("6. Click on continue button");

             checkoutPage.inputFirstName(Strings.FIRST_NAME);
             checkoutPage.inputLastName(Strings.LAST_NAME);
             checkoutPage.inputZipCode(Strings.ZIP_CODE);
             checkoutPage.clickContinueButton();
             assert driver.getCurrentUrl().equals(Strings.OVERVIEW_PAGE) : "Error";

             OverviewPage overviewPage = new OverviewPage(driver);
             print("7. Click on finish button");
             overviewPage.clickfinishButton();
             assert driver.getCurrentUrl().equals(Strings.COMPLETE_PAGE) : "Error";

             CompletePage completePage = new CompletePage(driver);
             print("8. Click on backHome button");
             completePage.clickBackHomeButton();
             assert driver.getCurrentUrl().equals(Strings.INVENTORY_PAGE_URL) : "Error";

//             BasePage basePage = new BasePage(driver);
//             basePage.clickHamburgerMenu();
//             basePage.clickLogout();
             inventoryPage.clickHamburgerMenu();
             inventoryPage.clickLogout();
             print("9. Verify that the url is correct");
             assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL) : "Error";

         }finally {
             driver.quit();
         }
     }

}
