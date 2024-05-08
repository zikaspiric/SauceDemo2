package tests.loginTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.Strings;
import tests.BaseTest;

import java.util.concurrent.TimeUnit;


public class LogoutTest extends BaseTest {

    /*
    * Login with valid credentials and logout
    * Steps:
    * 1. Enter valid username
    * 2. Enter valid pass
    * 3. Click loginButton
    * 4. Click HamburgerMenu
    * 5. Click LogOutButton
    * Expected result:
    * Verify that user is Logged out
     */

    @Test

    public void logoutTest() {

        ChromeDriver driver = openChromeDriver();

        try {
            print("Navigate to login page");
            LoginPage loginPage = new LoginPage(driver);
            BasePage basePage = new BasePage(driver);


            print("Enter username");
            loginPage.enterUsername(Strings.VALID_USERNAME);
            loginPage.enterPassword(Strings.VALID_PASSWORD);
            loginPage.clickLoginButton();

            // ovo zakucava izvrsavanje koda, koristiti samo kada nista drugo ne pomaze
//            sleep(4);

            //implicit wait ceka da se sve ucita
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            basePage.clickHamburgerMenu();
            basePage.clickLogout();




            print("Verify that the url is correct");
            assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL) : "Error";

        } finally {
            driver.quit();
        }
    }
}
