package tests;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BasePage;
import pages.LoginPage;
import pages.Strings;

public class BaseTest {
    ChromeDriver driver;

        public ChromeDriver openChromeDriver() {
            //print("Opening Chrome Driver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--start-maximized"});
            options.addArguments(new String[]{"--ignore-certificate-errors"});
            options.addArguments(new String[]{"--disable-popup-blocking"});
            options.addArguments(new String[]{"--incognito"});
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            ChromeDriver driver = new ChromeDriver(options);
            //ovo dole sluzi za setovanje dimenzija browsera
//        driver.manage().window().setSize(new Dimension(600,768));
            return driver;

        }
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e) {
            print(e.getMessage());
        }
    }

    public void scrollIntoView(WebElement element) {

        //primer JavaScript Executora koji vam sluzi za skrolovanje do elementa koji nije prikazan na stranici,
        // nego nize dole
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);" ,element);

    }
    public static void print(String s) {
        System.out.println(s);
    }

    public void loginWithValidCreds(ChromeDriver driver) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(Strings.VALID_USERNAME);
        loginPage.enterPassword(Strings.VALID_PASSWORD);
        loginPage.clickLoginButton();
        print("Verify that the url is correct");
        assert driver.getCurrentUrl().equals(Strings.INVENTORY_PAGE_URL) : "Error";

    }
}
