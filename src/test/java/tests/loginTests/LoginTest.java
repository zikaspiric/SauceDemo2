package tests.loginTests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.Strings;
import tests.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("Navigate to login page");
            LoginPage loginPage = new LoginPage(driver);

            print("Enter username");
            loginPage.enterUsername(Strings.VALID_USERNAME);
            loginPage.enterPassword(Strings.VALID_PASSWORD);
            loginPage.clickLoginButton();

            print("Verify that the url is correct");
            assert driver.getCurrentUrl().equals(Strings.INVENTORY_PAGE_URL) : "Error";

        } finally {
            driver.quit();
        }
    }

    @Test
    public void loginWithInvalidUsernameAndValidPass() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("Navigate to login page");
            LoginPage loginPage = new LoginPage(driver);

            print("Enter username");
            loginPage.enterUsername(Strings.INVALID_USERNAME);
            loginPage.enterPassword(Strings.VALID_PASSWORD);
            loginPage.clickLoginButton();

            print("Verify that the url is correct");
            assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL) : "Wrong URL. Expected: " + Strings.LOGIN_PAGE_URL
                    + " . Actual: " + driver.getCurrentUrl();
            String actualErrorMessage = loginPage.getTextFromErrorMessage();
            assert actualErrorMessage.equals(Strings.LOGIN_ERROR_MESSAGE) : "Wrong error message. Expected: " + Strings.LOGIN_ERROR_MESSAGE
                    + " . Actual:" + actualErrorMessage;

        } finally {
            driver.quit();

        }
    }
// ako je ocekivani rezultat "false" onda se koristi ova metoda kako test ne bi pao
    @Test
    public void handlingExceptions() {
        ChromeDriver driver =  openChromeDriver();
        try {
            print("Navigate to login page");
            LoginPage loginPage = new LoginPage(driver);

            print("Enter username");
            loginPage.enterUsername(Strings.VALID_USERNAME);
            loginPage.enterPassword(Strings.VALID_PASSWORD);

            assert loginPage.isLoginButtonPresent() : "Login button should be present, but it is NOT";

            loginPage.clickLoginButton();
//            loginPage.clickEnter();

            assert !loginPage.isLoginButtonPresent() : "Login button should not be present, but IT IS";



        } finally {
            driver.close();
        }
    }
}
