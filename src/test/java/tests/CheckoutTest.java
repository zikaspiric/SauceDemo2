package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.Strings;
import pages.YourCartPage;

public class CheckoutTest extends  BaseTest{
    /*
    Checkout:Your Information Page without last name creds and verify that dont continue on next page
    steps:
    1.login
    2.Click on one item e.g. BackPack
    3.click cart icon
    4.click Checkout button
    5.input First name
    6.input Zip code
    7.click continue button
    Expected result:
    7 . error message and dont continue on next page
     */

    @Test
    public void checkoutWithoutLastNamecred() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Login with valid user");
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. Click on one item e.g. BackPack");
            inventoryPage.clickAddToCartBackPackButton();

            print("3. Verify that the shopping cart icon shows number 1");
            String actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("1") : "Wrong number in shopping cart. Expected: 1 . Actual :" + actualNumberFromCart;

            print("4. Click on cart icon");
            inventoryPage.clickShoppingCartIcon();

            YourCartPage yourCartPage = new YourCartPage(driver);
            print("5. Click on checkout button");
            yourCartPage.clickCheckoutButton();

            assert driver.getCurrentUrl().equals(Strings.CHECKOUT_PAGE_URL) : "Error";

            CheckoutPage checkoutPage = new CheckoutPage(driver);
            print("6. Click on continue button");

            checkoutPage.inputFirstName(Strings.FIRST_NAME);
            checkoutPage.inputZipCode(Strings.ZIP_CODE);
            checkoutPage.clickContinueButton();

            String actualErrorMessage = checkoutPage.getTextFromErrorMessage();
            assert actualErrorMessage.equals(Strings.ERROR_LASTNAME_CHECKOUT_MESSAGE) : "Wrong error message. Expected: " + Strings.ERROR_LASTNAME_CHECKOUT_MESSAGE
                    + " . Actual:" + actualErrorMessage;

        }finally {
            driver.quit();
        }
    }
}
