package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import pages.Strings;

public class InventoryTests extends BaseTest {
    /*Adding one item and verifying cart icon
    1. Login with valid user.
    2. Click on one item e.g. BackPack

    Expected result:
    2. Verify that the shopping cart icon shows number 1
    */

    @Test
    public void addOneItemInShoppingCart() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Login with valid user");
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. Click on one item e.g. BackPack");
            inventoryPage.clickAddToCartBackPackButton();

            print("2. Verify that the shopping cart icon shows number 1");
            String actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("1") : "Wrong number in shopping cart. Expected: 1 . Actual :" + actualNumberFromCart;
        } finally {
            driver.quit();
        }
    }
    /*Adding one item and verifying cart icon
    1. Login with valid user.
    2. Click on one item e.g. BackPack
    3. Click on second item e.g. Onesie

    Expected result:
    3. Verify that the shopping cart icon shows number 2
    */
    @Test
    public void addTwoItemsInShoppingCart() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Login with valid user");
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. Click on one item e.g. BackPack");
            inventoryPage.clickAddToCartBackPackButton();

            print("3. Click on second item e.g. Onesie");
            inventoryPage.clickAddToCartOnesieButton();

            print("2. Verify that the shopping cart icon shows number 2");
            String actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("2") : "Wrong number in shopping cart. Expected: 2 . Actual :" + actualNumberFromCart;
        } finally {
            driver.quit();
        }
    }

    @Test
    public void addTwoItemsAndRemoveOneFromShoppingCart() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Login with valid user");
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. Click on one item e.g. BackPack");
            inventoryPage.clickAddToCartBackPackButton();

            print("3. Click on second item e.g. Onesie");
            inventoryPage.clickAddToCartOnesieButton();

            print("3. Verify that the shopping cart icon shows number 2");
            String actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("2") : "Wrong number in shopping cart. Expected: 2 . Actual :" + actualNumberFromCart;

            print("4. Remove one item from shopping cart");
            inventoryPage.clickRemoveFromBackpackButton();

            print("4. Verify that the shopping cart icon shows number 1");
            actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("1") : "Wrong number in shopping cart. Expected: 2 . Actual :" + actualNumberFromCart;


        } finally {

            driver.quit();
        }

    }
}
